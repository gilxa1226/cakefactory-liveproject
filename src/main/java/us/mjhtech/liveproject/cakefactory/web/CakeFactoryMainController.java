package us.mjhtech.liveproject.cakefactory.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import us.mjhtech.liveproject.cakefactory.model.Pastry;
import us.mjhtech.liveproject.cakefactory.repository.PastryRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CakeFactoryMainController {

    private final PastryRepository pastryRepo;

    public CakeFactoryMainController(PastryRepository pastryRepo) {
        this.pastryRepo = pastryRepo;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {

        List<Pastry> pastryList = new ArrayList<>();
        pastryRepo.findAll().forEach(pastryList::add);

        model.addAttribute("pastries", pastryList);
        model.addAttribute("name", "Mike");

        return "main";
    }
}
