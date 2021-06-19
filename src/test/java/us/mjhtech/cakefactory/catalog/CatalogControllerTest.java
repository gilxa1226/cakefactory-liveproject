package us.mjhtech.cakefactory.catalog;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import us.mjhtech.cakefactory.catalog.persistence.StaticCatalogService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CatalogController.class)
@AutoConfigureMockMvc
class CatalogControllerTest {

    private WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CatalogService catalogService;

    @BeforeEach
    void setUp() {
        this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
    }

    @Test
    @DisplayName("index page returns the landing page")
    void returnsLandingPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
    }

    @Test
    @DisplayName("Test the Get method for the index route")
    void testGetIndex() throws Exception {
        final String expectedTitle = "Red Velvet";
        final String expectedId = "rv";
        mockItems(expectedId, expectedTitle, 3);

        HtmlPage page = webClient.getPage("http://localhost/");

        assertThat(page.querySelectorAll(".link-button")).anyMatch(domElement -> expectedTitle.equals(domElement.asText()));
    }

    private void mockItems(String id, String title, double price) {
        when(catalogService.getPastryItems()).thenReturn(Collections.singletonList(new PastryItem(id, title, price)));
    }
}