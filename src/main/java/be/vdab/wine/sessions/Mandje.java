package be.vdab.wine.sessions;

import be.vdab.wine.dto.WijnEnAantal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Set<WijnEnAantal> wijnenTeBestellen = new LinkedHashSet<WijnEnAantal>();
    public Mandje() {
    }

    public void voegToe(WijnEnAantal wijnEnAantal) {
        wijnenTeBestellen.add(wijnEnAantal);

    }

    public void maaktHetMandjeLeeg() {
        wijnenTeBestellen.clear();
    }

    public Set<WijnEnAantal> getWijnenTeBestellen() {
        return wijnenTeBestellen;
    }
}
