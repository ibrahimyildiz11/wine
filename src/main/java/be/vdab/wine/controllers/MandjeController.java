package be.vdab.wine.controllers;

import be.vdab.wine.domain.Adres;
import be.vdab.wine.domain.Bestelbon;
import be.vdab.wine.domain.Bestelbonlijn;
import be.vdab.wine.domain.BestelbonlijnId;
import be.vdab.wine.dto.WijnEnAantal;
import be.vdab.wine.forms.AantalForm;
import be.vdab.wine.forms.BestelbonForm;
import be.vdab.wine.services.BestelbonService;
import be.vdab.wine.services.BestelbonlijnService;
import be.vdab.wine.services.WijnService;
import be.vdab.wine.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.RoundingMode;
import java.time.LocalDate;

@Controller
@RequestMapping("mandje")
class MandjeController {
    private final Mandje mandje;
    private final WijnService wijnService;
    private final BestelbonService bestelbonService;
    private final BestelbonlijnService bestelbonlijnService;

    MandjeController(Mandje mandje, WijnService wijnService, BestelbonService bestelbonService,
                     BestelbonlijnService bestelbonlijnService) {
        this.mandje = mandje;
        this.wijnService = wijnService;
        this.bestelbonService = bestelbonService;
        this.bestelbonlijnService = bestelbonlijnService;
    }

    @PostMapping("{id}")
    public String voegToe(@Valid AantalForm form, @PathVariable long id, RedirectAttributes redirect) {
        mandje.voegToe(new WijnEnAantal(
                id, wijnService.findById(id).get().getSoort().getLand().getNaam(),
                wijnService.findById(id).get().getSoort().getNaam(),
                wijnService.findById(id).get().getJaar(),
                form.getAantal(),
                wijnService.findById(id).get().getPrijs()
                ));
        return "redirect:/metMandje";
    }

    @GetMapping
    public ModelAndView toonMandje() {
        var modelAndView = new ModelAndView("mandje",
                "wijnenTeBestellen", mandje.getWijnenTeBestellen());
        modelAndView.addObject("bestelbonForm",
                new BestelbonForm("","","","","", 0, 1L));
        var totaal = mandje.getWijnenTeBestellen().stream().mapToDouble(wijn ->
                (double) (wijn.getPrijs().setScale(2, RoundingMode.HALF_UP).doubleValue()
                        * wijn.getAantal())).sum();
        modelAndView.addObject("totaal", totaal);
        return modelAndView;
    }

    @GetMapping({"/rapport/{id}"})
    public ModelAndView bestelling(Bestelbon bestelbon, @PathVariable long id) {
        /*mandje.maaktHetMandjeLeeg();*/
        return new ModelAndView("rapport","idNieuweBestelbon", id);
    }

    @PostMapping("/bestelling")
    public String toevoegen(@Valid BestelbonForm bestelbonForm, Errors errors, RedirectAttributes redirect) {
        if (errors.hasErrors()) {
            return "mandje";
        }
        var bestelbon = new Bestelbon(LocalDate.now(), bestelbonForm.getNaam(), new Adres(bestelbonForm.getStraat(),
                bestelbonForm.getHuisNr(), bestelbonForm.getPostCode(), bestelbonForm.getGemeente()),
                bestelbonForm.getBestelwijze());
        bestelbonService.create(bestelbon);
        var id = bestelbon.getId();

        redirect.addAttribute("idNieuweBestelbon", id);
        mandje.getWijnenTeBestellen().forEach(wijnTeBestel ->
                wijnService.verhoogInBestelling(wijnTeBestel.getId(), wijnTeBestel.getAantal()));

        var bestelbonLijn = mandje.getWijnenTeBestellen();
        mandje.getWijnenTeBestellen().forEach(wijnTeBestel ->
                bestelbonlijnService.create(
                        new Bestelbonlijn(new BestelbonlijnId(id, wijnTeBestel.getId()),
                                wijnTeBestel.getAantal(), wijnTeBestel.getPrijs())));

        mandje.maaktHetMandjeLeeg();

        return "redirect:/mandje/rapport/{idNieuweBestelbon}";
    }
}
