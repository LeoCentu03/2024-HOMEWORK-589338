import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.IO;

public class ComandoVaiTest {
    private Partita partita;
    private ComandoVai comandoVai;
    private TestIO testIO;

    @Before
    public void setUp() {
        Labirinto labirinto = new Labirinto();
        Stanza stanzaIniziale = new Stanza("Atrio");
        labirinto.setStanzaIniziale(stanzaIniziale);
        partita = new Partita(labirinto);
        comandoVai = new ComandoVai();
        testIO = new TestIO();
        comandoVai.setIO(testIO);
    }

    @Test
    public void testMovimentoDirezioneValida() {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Stanza nuovaStanza = new Stanza("Nuova Stanza");
        stanzaCorrente.impostaStanzaAdiacente("nord", nuovaStanza);
        comandoVai.setParametro("nord");
        comandoVai.esegui(partita);
        assertEquals(nuovaStanza.getNome(), partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testMovimentoDirezioneNonValida() {
        comandoVai.setParametro("sud");
        comandoVai.esegui(partita);
        assertEquals("Direzione inesistente", testIO.getUltimoMessaggioMostrato());
    }

    @Test
    public void testMancanzaParametro() {
        comandoVai.setParametro(null);
        comandoVai.esegui(partita);
        assertEquals("Dove vuoi andare? Devi specificare una direzione", testIO.getUltimoMessaggioMostrato());
    }
    
    @Test
    public void testMovimentoDirezioneNonAdiacente() {
        comandoVai.setParametro("nord");
        comandoVai.esegui(partita);
        assertEquals("Direzione inesistente", testIO.getUltimoMessaggioMostrato());
    }

    private class TestIO implements IO {
        private String ultimoMessaggioMostrato;

        @Override
        public void mostraMessaggio(String messaggio) {
            this.ultimoMessaggioMostrato = messaggio;
        }

        @Override
        public String leggiRiga() {
            return null;
        }

        public String getUltimoMessaggioMostrato() {
            return this.ultimoMessaggioMostrato;
        }
    }
}
