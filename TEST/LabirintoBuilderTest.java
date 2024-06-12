import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;


public class LabirintoBuilderTest {
    
    private LabirintoBuilder builder;
    
    @Before
    public void setUp() {
        builder = new LabirintoBuilder();
    }
    
    @Test
    public void testMonolocale() {
        Labirinto labirinto = builder.addStanzaIniziale("Monolocale").getLabirinto();
        
        assertNotNull(labirinto.getStanzaIniziale());
        assertEquals("Monolocale", labirinto.getStanzaIniziale().getNome());
        assertNull(labirinto.getStanzaVincente());
    }

    @Test
    public void testBilocale() {
        Labirinto labirinto = builder.addStanzaIniziale("Stanza1")
                                      .addStanza("Stanza2")
                                      .addAdiacenza("Stanza1", "Stanza2", "nord")
                                      .getLabirinto();
        
        assertNotNull(labirinto.getStanzaIniziale());
        assertEquals("Stanza1", labirinto.getStanzaIniziale().getNome());
        assertNull(labirinto.getStanzaVincente());
        
        Stanza stanza1 = labirinto.getStanzaIniziale();
        Stanza stanza2 = stanza1.getStanzaAdiacente(Direzione.NORD);
        
        assertNotNull(stanza2);
        assertEquals("Stanza2", stanza2.getNome());
    }

    @Test
    public void testTrilocaleConVincente() {
        Labirinto labirinto = builder.addStanzaIniziale("Stanza1")
                                      .addStanza("Stanza2")
                                      .addStanzaVincente("Stanza3")
                                      .addAdiacenza("Stanza1", "Stanza2", "nord")
                                      .addAdiacenza("Stanza2", "Stanza3", "est")
                                      .getLabirinto();
        
        assertNotNull(labirinto.getStanzaIniziale());
        assertEquals("Stanza1", labirinto.getStanzaIniziale().getNome());
        assertNotNull(labirinto.getStanzaVincente());
        assertEquals("Stanza3", labirinto.getStanzaVincente().getNome());
        
        Stanza stanza1 = labirinto.getStanzaIniziale();
        Stanza stanza2 = stanza1.getStanzaAdiacente(Direzione.NORD);
        Stanza stanza3 = stanza2.getStanzaAdiacente(Direzione.EST);
        
        assertNotNull(stanza2);
        assertEquals("Stanza2", stanza2.getNome());
        
        assertNotNull(stanza3);
        assertEquals("Stanza3", stanza3.getNome());
    }
}
