import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica stanzaMagica;
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    private Attrezzo attrezzo3;
    private Attrezzo attrezzo4;

    @Before
    public void setUp() {
        stanzaMagica = new StanzaMagica("Stanza Magica", 3);
        attrezzo1 = new Attrezzo("osso", 1);
        attrezzo2 = new Attrezzo("lanterna", 3);
        attrezzo3 = new Attrezzo("spada", 5);
        attrezzo4 = new Attrezzo("scudo", 4);
    }

    @Test
    public void testAggiungiAttrezziSottoSogliaMagica() {
        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo3));
        
        assertEquals(attrezzo1, stanzaMagica.getAttrezzo("osso"));
        assertEquals(attrezzo2, stanzaMagica.getAttrezzo("lanterna"));
        assertEquals(attrezzo3, stanzaMagica.getAttrezzo("spada"));
    }

    @Test
    public void testAggiungiAttrezzoOltreSogliaMagica() {
        stanzaMagica.addAttrezzo(attrezzo1);
        stanzaMagica.addAttrezzo(attrezzo2);
        stanzaMagica.addAttrezzo(attrezzo3);
        stanzaMagica.addAttrezzo(attrezzo4);

        Attrezzo attrezzoModificato = stanzaMagica.getAttrezzo("oducs");
        assertNotNull(attrezzoModificato);
        assertEquals(8, attrezzoModificato.getPeso());
    }

    @Test
    public void testModificaAttrezzoDirettamente() {
        Attrezzo attrezzoModificato = stanzaMagica.modificaAttrezzo(new Attrezzo("magia", 2));
        assertEquals("aigam", attrezzoModificato.getNome());
        assertEquals(4, attrezzoModificato.getPeso());
    }

    @Test
    public void testAggiungiAttrezzoAlLimiteSogliaMagica() {
        stanzaMagica.addAttrezzo(attrezzo1);
        stanzaMagica.addAttrezzo(attrezzo2);
        stanzaMagica.addAttrezzo(attrezzo3);

        assertTrue(stanzaMagica.addAttrezzo(attrezzo4));
        Attrezzo attrezzoModificato = stanzaMagica.getAttrezzo("oducs");
        assertNotNull(attrezzoModificato);
        assertEquals(8, attrezzoModificato.getPeso());
    }

    @Test
    public void testAggiungiAttrezzoDopoSogliaMagica() {
        stanzaMagica.addAttrezzo(attrezzo1);
        stanzaMagica.addAttrezzo(attrezzo2);
        stanzaMagica.addAttrezzo(attrezzo3);

        Attrezzo attrezzoSuperato = new Attrezzo("bacchetta", 2);
        stanzaMagica.addAttrezzo(attrezzoSuperato);

        Attrezzo attrezzoModificato = stanzaMagica.getAttrezzo("attehccab");
        assertNotNull(attrezzoModificato);
        assertEquals(4, attrezzoModificato.getPeso());
    }
}
