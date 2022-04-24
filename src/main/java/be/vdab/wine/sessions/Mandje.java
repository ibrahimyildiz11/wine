package be.vdab.wine.sessions;

import be.vdab.wine.domain.Bestelbonlijn;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Set<Bestelbonlijn> wijnenTeBestellen = new LinkedHashSet<>();
    public Mandje() {
    }

    public void voegToe(Bestelbonlijn bestelbonlijn) {
        wijnenTeBestellen.add(bestelbonlijn);
    }

    public void maaktHetMandjeLeeg() {
        wijnenTeBestellen.clear();
    }

    public Set<Bestelbonlijn> getWijnenTeBestellen() {
        return wijnenTeBestellen;
    }
}
