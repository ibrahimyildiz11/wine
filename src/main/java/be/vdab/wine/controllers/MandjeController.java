package be.vdab.wine.controllers;

import be.vdab.wine.domain.Bestelbonlijn;
import be.vdab.wine.services.BestelbonService;
import be.vdab.wine.services.BestelbonlijnService;
import be.vdab.wine.services.WijnService;
import be.vdab.wine.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("mandje")
class MandjeController {
    private final Mandje mandje;
    private final WijnService wijnService;
    private final BestelbonService bestelbonService;
    private final BestelbonlijnService bestelbonlijnService;

    MandjeController(Mandje mandje, WijnService wijnService, BestelbonService bestelbonService, BestelbonlijnService bestelbonlijnService) {
        this.mandje = mandje;
        this.wijnService = wijnService;
        this.bestelbonService = bestelbonService;
        this.bestelbonlijnService = bestelbonlijnService;
    }

    @PostMapping("{id}")
    public String voegToe(Bestelbonlijn bestelbonlijn, @PathVariable long id, RedirectAttributes redirect) {
        mandje.voegToe(new Bestelbonlijn(
                bestelbonlijnService.findById(id).get().getAantal(),
                bestelbonlijnService.findById(id).get().getPrijs()));
        return "redirect:/mandje";
    }

    /*@GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje",
                "bierenTeBestellen", mandje.getBierenTeBestellen());
        modelAndView.addObject("bestelbon",
                new BestelbonForm(0,"","", "",null,""));
        var totaal = mandje.getBierenTeBestellen().stream().mapToInt(bierEnAntal ->
                (int) (bierEnAntal.getPrijs().longValue() * bierEnAntal.getAantal())).sum();
        modelAndView.addObject("totaal", totaal);
        return modelAndView;
    }*/
}
