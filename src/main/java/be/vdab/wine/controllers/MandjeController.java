package be.vdab.wine.controllers;

import be.vdab.wine.domain.Bestelbon;
import be.vdab.wine.domain.Bestelbonlijn;
import be.vdab.wine.domain.Wijn;
import be.vdab.wine.dto.WijnEnAantal;
import be.vdab.wine.forms.AantalForm;
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

import java.time.LocalDate;

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
    public String voegToe(AantalForm form, @PathVariable long id, RedirectAttributes redirect) {
        mandje.voegToe(new WijnEnAantal(
                wijnService.findById(id).get().getJaar(),
                form.getAantal(),
                wijnService.findById(id).get().getPrijs()
                ));
        /*var bestelbonlijn = new Bestelbonlijn(form.getAantal(), wijn.getPrijs());*/
       /* wijnService.findById(id).ifPresent(wijn ->
                mandje.voegToe(new WijnEnAantal(
                        wijn.getSoort().getLand().getNaam(),
                        wijn.getSoort().getNaam(),
                        wijn.getJaar(),
                        form.getAantal(),
                        wijn.getPrijs())
                )
        );*/
        /*mandje.voegToe(new WijnEnAantal(
                wijnService.findById(id).get().getSoort().getLand().getNaam(),
                wijnService.findById(id).get().getSoort().getNaam(),
                wijnService.findById(id).get().getJaar(),
                form.getAantal(),
                wijnService.findById(id).get().getPrijs()));
        *//*bestelbonlijnService.create(bestelbonlijn);*/
        return "redirect:/mandje";
    }

    @GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje",
                "wijnenTeBestellen", mandje.getWijnenTeBestellen());
        modelAndView.addObject("bestelbon",
                new Bestelbon( LocalDate.now(),"","","","","",1,1));
        var totaal = mandje.getWijnenTeBestellen().stream().mapToInt(wijn ->
                (int) (wijn.getPrijs().longValue() * wijn.getAantal())).sum();
        modelAndView.addObject("totaal", totaal);
        return modelAndView;
    }
}
