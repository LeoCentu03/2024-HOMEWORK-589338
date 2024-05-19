import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestLabirinto {
    private Labirinto labirintoTest;

    @Before
    public void inizializzaLabirinto() {
        labirintoTest = new Labirinto();
    }

    @Test
    public void testGetStanzaVincente() {
        Stanza stanzaVincente = new Stanza("Biblioteca");
        labirintoTest.setStanzaVincente(stanzaVincente);
        assertNotNull(labirintoTest.getStanzaVincente());
        assertEquals("Biblioteca", labirintoTest.getStanzaVincente().getNome());
    }

    @Test
    public void testSetStanzaIniziale() {
        Stanza stanzaIniziale = new Stanza("Atrio");
        labirintoTest.setStanzaIniziale(stanzaIniziale);
        assertEquals(stanzaIniziale, labirintoTest.getStanzaIniziale());
    }

    @Test
    public void testGetStanzaIniziale() {
        Stanza stanzaIniziale = new Stanza("Atrio");
        labirintoTest.setStanzaIniziale(stanzaIniziale);
        assertNotNull(labirintoTest.getStanzaIniziale());
        assertEquals("Atrio", labirintoTest.getStanzaIniziale().getNome());
    }
}
