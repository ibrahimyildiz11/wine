package be.vdab.wine.controllers;

import be.vdab.wine.services.SoortService;
import be.vdab.wine.services.WijnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
    private final SoortService soortService;
    private final WijnService wijnService;

    IndexController(SoortService soortService, WijnService wijnService) {
        this.soortService = soortService;
        this.wijnService = wijnService;
    }

    @GetMapping("soorten/{id}")
    public ModelAndView soortenVanLand(@PathVariable long id) {
        var soorten = soortService.findByLandId(id);
        var modelAndView = new ModelAndView("soorten", "soorten", soorten);

        return modelAndView;
    }

    @GetMapping("wijnen/{id}")
    public ModelAndView wijnenVanSoort(@PathVariable long id) {
        var wijnen = wijnService.findBySoortId(id);
        var modelAndView = new ModelAndView("wijnen", "wijnen", wijnen);

        return modelAndView;
    }

    @GetMapping("toevoegenAanMaandje/{id}")
    public ModelAndView toevoegenAanMaandje(@PathVariable long id){
        var modelAndView = new ModelAndView("toevoegenAanMaandje");
        wijnService.findById(id).ifPresent(wijn ->
                modelAndView.addObject("wijn", wijn));
        return modelAndView;
    }
}
