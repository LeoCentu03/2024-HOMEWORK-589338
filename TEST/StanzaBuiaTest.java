import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private static final String ATTREZZO_TEST = "attrezzoTest";
    private StanzaBuia stanzaBuia;

    private static final String DESCRIZIONE_STANZA = "StanzaBuia\n" + 
            "Uscite: \n" + 
            "Attrezzi nella stanza: attrezzoTest (1kg) ";

    @Before
    public void setUp() {
        this.stanzaBuia = new StanzaBuia("StanzaBuia", ATTREZZO_TEST);
    }

    @Test
    public void testGetDescrizioneSenzaLuce() {
        assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizioneConLuce() {
        this.stanzaBuia.addAttrezzo(new Attrezzo(ATTREZZO_TEST, 1));
        assertEquals(DESCRIZIONE_STANZA, this.stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetAttrezzoInesistente() {
        this.stanzaBuia.addAttrezzo(new Attrezzo(ATTREZZO_TEST, 1));
        assertNull(this.stanzaBuia.getAttrezzo("inesistente"));      
    }
    
    @Test
    public void testAddAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("lanterna", 2);
        assertTrue(this.stanzaBuia.addAttrezzo(attrezzo));
        assertEquals(attrezzo, this.stanzaBuia.getAttrezzo("lanterna"));
    }

    @Test
    public void testRemoveAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("lanterna", 2);
        this.stanzaBuia.addAttrezzo(attrezzo);
        assertTrue(this.stanzaBuia.removeAttrezzo(attrezzo));
        assertNull(this.stanzaBuia.getAttrezzo("lanterna"));
    }
}
