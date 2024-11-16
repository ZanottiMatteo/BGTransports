package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_PULLMAN_STOP {

	public static void main(String[] args) {
        // Dati JSON da scrivere nel file
		String jsonData = "[\n" +
                "  {\n" +
                "    \"name\": \"AEROPORTO Arrivi Nazionali\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALBANO via Cavour fr.10\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALBANO via Madonna delle Rose 4a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALBANO via Monte Grappa fr.3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALBANO via Santuario\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALME'\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALME via Campo dei Fiori 22\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALME via Torre d Oro\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALMENNO S.SALVATORE via Buttinoni Gabbio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO Burro via Bracc\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO Castello\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO GARIBALDI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO SOPRA via Piave TEB\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO via Busa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO via Europa 64 fr. Scuole\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO via Europa 83 Scuole\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO via IV novembre (parcheggio)\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO via Lacca\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Astino fermata 977\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"AZZANO S.PAOLO via Don Gonella 2a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"AZZANO S.PAOLO via Roma fr.44\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"AZZONICA via Broli 1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BIANZANA\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BORGO PALAZZO TEB\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BREMBO via Segantini\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BRIOLO via Paglia fr.7\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BRUNTINO via degli Alpini 57\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BUSA DI NESE via BUSA via Caprini\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CAMPAGNOLA via Campagnola 19/19a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CAPANNELLE via Traversa Capannelle orato\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CELADINA P.le Prealpi Orobiche\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Centro Commerciale Le due Torri\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CLEMENTINA via Gandhi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CLINICA Ponte S.Pietro via Forlanini\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"COLLE APERTO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"COLOGNOLA BELOTTI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"COLOGNOLA FILIBERTO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"COLOGNOLA VIA MUZIO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CROCE ROSSA VIA BROSETA\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CROCE ROSSA VIA CURIE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CROCETTE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CURNO largo Vittoria fr. Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CURNO Marigolda via Abruzzi 4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CURNO via Brembo fr.30\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CURNO via De Amicis 16\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CURNO via Emilia fr. scuole\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"CURNO via IV Novembre Scuole Medie\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE VIA LOCATELLI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE via Manzoni 66\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE via Marconi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE via Pesenti\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE via Pesenti fr.44\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE via Stella Alpina fr. via Genzia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DALMINE VIA VERDI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"DON ORIONE via Don Orione via Goisis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"FUNICOLARE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"FUNICOLARE COLLE APERTO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GAVARNO via Monte Misma\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GORLE via Bersaglieri Baio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GORLE via Don Mazza fr.11/13\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GORLE via Don Mazza via Carducci\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GORLE via Libertà scuole medie\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Grassobbio Matteotti 35\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Grassobbio Tonale 5a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GRASSOBBIO via Colombo capolinea\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GRASSOBBIO via XXV Aprile 11\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GRASSOBBIO viale Europa 25\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"GUZZANICA via Guzzanica 104\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"IPER SERIATE via Europa 21 fr. ITIS Majorana\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ITIS Majorana SERIATE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO via Aldo Moro fr.3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO via Europa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO via Mascagni fr.Banca\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO via Rossini fr. Oratorio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO via Sforzatica conf. comunale\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO via Sforzatica per Bg conf. comun\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LALLIO x Osio Sopra via Aldo Moro\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LOCATE via Don Foiadelli fr.1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LONGUELO ORATORIO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LONGUELO VIA MATTIOLI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LONGUELO via Puccini fr.34 Focasina\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"LORETO via Pasteur fr.1A\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MALPENSATA\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MALPENSATA via Carnovali 88\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MALPENSATA via Carnovali 95\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MALPENSATA via Don Bosco 17a Pesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MARIANO via Cimaripa 2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MARIANO via Cimaripa fr.4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Monte di Nese Parcheggio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MONTEROSSO viale G.Cesare via Tremana\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MOZZO via Dante Alighieri\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MOZZO VIA MOZZI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MOZZO via Mozzi capolinea\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MOZZO via Piatti fr.10\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MOZZO via Piatti fr.12 Comune\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"MOZZO via Todeschini fr.29\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Nembro Oratorio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO via Gavarno fr.25\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO via Gavarno fr.96\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO via Puccini 37\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO via Verdi edicola\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"OLERA piazza Fra Tommaso Acerbis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ORIO AL SERIO via Locatelli 18/18a Comun\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ORIO AL SERIO via Portico Orio Center\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"OSIO SOPRA via Monte Bianco 10\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"OSPEDALE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"OSPEDALE MARTIN LUTHER KING\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"OSTELLO via G.Ferraris\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"P.LE CIMITERO per Loreto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA GHIAIE via del Brembo\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA Sombreno via S.Fermo e Rustico\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Paladina SP Dalmine/Almè fr.4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA via Bolis 13\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA via Degli Alpini Cimitero\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA via Don Carminati 6\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA via Don Carminati fr.8\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA via G.Galilei 3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PALADINA via IV Novembre fr. Banca\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PEDRENGO via Kennedy\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PEDRENGO via Papa Giovanni XXIII 11\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PEDRENGO via Papa Giovanni XXIII 4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"piazza Libertà\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"piazza S. Anna fr.1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"piazza S.Anna via Ghislandi 2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"piazzale Cimitero per Clementina\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PIAZZALE LOVERINI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PIAZZALE OBERDAN\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTE S.PIETRO via Vittorio Emanuele 58\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTE S.PIETRO viale Italia 15\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Fustina 2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Fustina 41\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via IV Novembre 65\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Papa Giovanni XXIII 2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Ramera 4 Pontesecco\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Ramera fr. Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Valbona 44/46\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Valbona fr. 93\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Valbona fr.55 ex FVB\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PONTERANICA via Valbona fr.93\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PORTA NUOVA\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PORTA NUOVA NESSI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PORTA NUOVA TIRABOSCHI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PORTA NUOVA VIA CAMOZZI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RANICA piazza Europa 4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RANICA via Adelasio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RANICA via Marconi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RANICA via Marconi 57\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RANICA via Provinciale Arredamenti Sala\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RONCOLA via Ambrosioni fr. Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Roncola via Lungobrembo fr. 60\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"S. ANTONIO via Ruggeri da Stabello 53b\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"S. ANTONIO via Ruggeri da Stabello 72d\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"S.ANTONIO via Biava 26\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"S.ANTONIO via Ruggeri da Stabello 72d\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"S.COLOMBANO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SABBIO via Don Cortesi Scuole elementari\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SCANZO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SCANZO corso Europa 38\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SCANZO corso Europa, 74\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SCANZO Negrone via Piave fr.40\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SCANZO via Sporla 6\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE c.so Europa piscine\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE corso Roma 110\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE corso Roma 43a Quartiere Primave\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Seriate Paderno fr.55\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE piazza Caduti della Libertà\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE v.le Italia 51 Comune\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE via Brusaporto fr.34\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE via Decò e Canetta 120\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE via Europa 21 fr.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE via Europa 21 fr. ITIS Majorana\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE via Marconi 16/18\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE via Paderno\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE viale Italia 95 Legler\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SERIATE viale Lombardia mercato\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SORISOLE Azzonica via Don Carminati 12/1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SORISOLE Petosino via Martiri della Libe\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SORISOLE Petosino via Zambelli fr.3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SORISOLE Piazza Donatori del Sangue merc\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"SORISOLE via Madonna dei Campi fr. 25\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STAZIONE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STAZIONE SUPERIORE FUNICOLARE Piazza Mer\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STAZIONE via per Orio fr.56\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STEZZANO OVEST via Zanchi 5a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STEZZANO via Circ. Ovest 6\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STEZZANO via Papa Giovanni XXIII, 7\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STEZZANO via Rizzo fr. 7\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"STEZZANO via Santuario Banca\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE BOLDONE via Borghetto fr.28\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE BOLDONE via Della Colombera\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE BOLDONE via Lombardia fr.65/67\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE BOLDONE via Reich 15 Farmacia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE BOLDONE via S.Martino Vecchio fr.1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE DE ROVERI piazza Del Donatore\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE DE ROVERI Pitturello via Castello\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE DE ROVERI via Papa Giovanni XXIII\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE DEL GALGARIO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TREVIOLO Albegno via IV Novembre 6\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TREVIOLO via Ambrosioni via Amato\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TREVIOLO via dei Cedri 8\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TREVIOLO via Lega Lombarda via Gorizia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TREVIOLO via Marconi fr. via Rillosi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TRIBULINA via Monte Misma fr.3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"URBAN CENTER\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO CORNELLE corso Europa Unita 11\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO via A.Moro fr. parcheggio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO via Donizetti NECTA\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO via Matteotti parco\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO via Padre Murialdo 21 Padri Gi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO via Roma 12\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VALBREMBO via Sombreno 27/29 villino\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via A. Mai 32 Scuola Fantoni\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via A. Mai 35b Scuola Fantoni\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Berenson A.T.B. per Bergamo\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Berenson A.T.B. per Seriate\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VIA BERIZZI PONTE S.PIETRO\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Borgo Palazzo 100h/102 viale Pirovan\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Borgo Palazzo 163 fr.ASL\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Borgo Palazzo 230 Portone del diavol\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Borgo Palazzo 69 TEB\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Borgo Palazzo fr. Portone del Diavol\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Broseta 115 Piazza Risorgimento\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Camozzi 162 via Borgo Palazzo\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Canovine\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Carducci Auchan\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Cavalli\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Corridoni 73/75\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Corridoni 74c Pesa Parcheggio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Daste e Spalenga\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Dei Caniana fr.6 Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VIA DEI CANIANA UNIVERSITA'\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via dello Statuto - Accademia della Guardia di Finanza\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via dello Statuto - Piscine\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via dello Statuto 29\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Don Bosco via Zanica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Europa Quarenghi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via F.lli Vicentini (Navetta Mercato)\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via G.Cesare edicola stadio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via G.Rosa 20e farmacia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Gasparini fr.11a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Gavazzeni clinica\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Gleno C.F.P. Regione\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Isabello 1 Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Leonardo da Vinci\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Leonardo da Vinci Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Luzzatti 9\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Madonna del Bosco 54/56 Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Madonna del Bosco Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Maironi da Ponte 16/18\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Maironi da Ponte ponte Morla\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Mattioli fr. Chiesa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Mazzini 20 Clinica Castelli\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Moroni 234 Centro Studi L. da Vinci\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Paleocapa 1 Parcheggio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Pescaria 3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Petrarca fr.12/14 Banca d'Italia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Presolana Centro per l'Impiego\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Ruggeri da Stabello 1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via S.Ambrogio fr.18\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via S.Bernardino 116\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via S.Vigilio Belvedere\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Salvo D Acquisto 17\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Suardi 17a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Suardi 79\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Tremana Scuole\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via XXIV maggio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via XXIV Maggio 43\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Zambonate 60 Cinque Vie\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"via Zambonate 89 Cinque Vie\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"viale G.Cesare 18d Stadio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VILLA D'ALME via Ronco Basso fermata scu\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VILLA DI SERIO via A.Moro 21\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VILLA DI SERIO via Carrara piazza Mercat\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VILLA DI SERIO via Dosie fr. poste\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"VILLAGGIO SPOSI VIA CAVALLI\"\n" +
                "  }\n" +
                "]";

        // Creare il file JSON nella cartella "json"
        File file = new File(utility.Constant.JSON_PULLMAN_STOP);

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData);
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}