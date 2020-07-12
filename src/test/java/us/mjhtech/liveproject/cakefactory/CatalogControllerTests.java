package us.mjhtech.liveproject.cakefactory;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import us.mjhtech.liveproject.cakefactory.catalog.CatalogController;
import us.mjhtech.liveproject.cakefactory.catalog.CatalogService;
import us.mjhtech.liveproject.cakefactory.catalog.PastryItem;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(CatalogController.class)
@AutoConfigureMockMvc
public class CatalogControllerTests {

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
    @DisplayName("index page return a list of items from the database")
    void returnsListOfItemsFromDb() throws Exception {
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
