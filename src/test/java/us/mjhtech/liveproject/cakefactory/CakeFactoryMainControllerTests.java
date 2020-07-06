package us.mjhtech.liveproject.cakefactory;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import us.mjhtech.liveproject.cakefactory.model.Pastry;
import us.mjhtech.liveproject.cakefactory.repository.PastryRepository;
import us.mjhtech.liveproject.cakefactory.web.CakeFactoryMainController;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CakeFactoryMainController.class)
@AutoConfigureMockMvc
public class CakeFactoryMainControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PastryRepository pastryRepository;

    private List<Pastry> pastries;

    @Before
    public void setup() {
        pastries = Arrays.asList(
            new Pastry("abcr", "All Butter Croissant", 0.75),
            new Pastry("ccr", "Chocolate Croissant", 0.95),
            new Pastry("b", "Fresh Baguette", 1.60),
            new Pastry("rv", "Red Velvet", 3.95),
            new Pastry("vs", "Victoria Sponge", 5.45),
            new Pastry("cc", "Carrot Cake", 3.45)
        );

        when(pastryRepository.findAll())
                .thenReturn(pastries);
    }

    @Test
    void testShowMainPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("main"))
                .andExpect(model().attribute("name", "Mike"))
                .andExpect(model().attribute("pastries", pastries));
    }
}
