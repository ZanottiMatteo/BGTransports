package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_PULLMAN_STOP {

	public static void main(String[] args) {
        // Dati JSON da scrivere nel file
		String jsonData = "[\n" +
		        "  {\n" +
		        "    \"name\": \"AEROPORTO Arrivi Nazionali\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Aeroporto partenze nazionali\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALBANO piazza Santuario\",\n" +
		        "    \"town\": \"Albano Sant'Alessandro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALBANO via Cavour fr.10\",\n" +
		        "    \"town\": \"Albano Sant'Alessandro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALBANO via Cavour fr.5\",\n" +
		        "    \"town\": \"Albano Sant'Alessandro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALBANO via Madonna delle Rose 4a\",\n" +
		        "    \"town\": \"Albano Sant'Alessandro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALBANO via Monte Grappa fr.3\",\n" +
		        "    \"town\": \"Albano Sant'Alessandro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALBANO via Santuario\",\n" +
		        "    \"town\": \"Albano Sant'Alessandro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALME'\",\n" +
		        "    \"town\": \"Almè\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALME via Campo dei Fiori 22\",\n" +
		        "    \"town\": \"Almè\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALME via Torre d Oro\",\n" +
		        "    \"town\": \"Almè\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALMENNO S.SALVATORE via Buttinoni Gabbio\",\n" +
		        "    \"town\": \"Almenno San Salvatore\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO Burro via Bracc\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO Castello\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO GARIBALDI\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO SOPRA via Piave TEB\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO via Busa\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO via Europa 64 fr. Scuole\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO via Europa 83 Scuole\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO via IV novembre (parcheggio)\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ALZANO via Lacca\",\n" +
		        "    \"town\": \"Alzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Astino fermata 977\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"AZZANO S.PAOLO via Don Gonella 2a\",\n" +
		        "    \"town\": \"Azzano San Paolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"AZZANO S.PAOLO via Roma fr.44\",\n" +
		        "    \"town\": \"Azzano San Paolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"AZZONICA via Broli 1\",\n" +
		        "    \"town\": \"Azzonica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"BIANZANA\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"BORGO PALAZZO TEB\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"BREMBO via Segantini\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"BRIOLO via Paglia fr.7\",\n" +
		        "    \"town\": \"Briolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"BRUNTINO via degli Alpini 57\",\n" +
		        "    \"town\": \"Villa d'almè\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"BUSA DI NESE via BUSA via Caprini\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CAMPAGNOLA via Campagnola 19/19a\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CAPANNELLE via Traversa Capannelle orato\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CELADINA P.le Prealpi Orobiche\",\n" +
		        "    \"town\": \"Celadina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Centro Commerciale Le due Torri\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CLEMENTINA via Gandhi\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CLINICA Ponte S.Pietro via Forlanini\",\n" +
		        "    \"town\": \"Ponte San Pietro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"COLLE APERTO\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"COLOGNOLA BELOTTI\",\n" +
		        "    \"town\": \"Colognola\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"COLOGNOLA FILIBERTO\",\n" +
		        "    \"town\": \"Colognola\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"COLOGNOLA VIA MUZIO\",\n" +
		        "    \"town\": \"Colognola\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CROCE ROSSA VIA BROSETA\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CROCE ROSSA VIA CURIE\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CROCETTE\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO largo Vittoria fr. Chiesa\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO Marigolda via Abruzzi 4\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO via Brembo fr.30\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO via De Amicis 16\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO via Emilia fr. scuole\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO via IV Novembre Scuole Medie\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"CURNO via Marconi fr.1/3 mercato\",\n" +
		        "    \"town\": \"Curno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE VIA LOCATELLI\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE via Manzoni 66\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE via Marconi\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE via Pesenti\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE via Pesenti fr.44\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE via Stella Alpina fr. via Genzia\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DALMINE VIA VERDI\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"DON ORIONE via Don Orione via Goisis\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"FUNICOLARE\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GAVARNO via Monte Misma\",\n" +
		        "    \"town\": \"Gavarno\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GORLE via Bersaglieri Baio\",\n" +
		        "    \"town\": \"Gorle\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GORLE via Don Mazza fr.11/13\",\n" +
		        "    \"town\": \"Gorle\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GORLE via Don Mazza via Carducci\",\n" +
		        "    \"town\": \"Gorle\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GORLE via Libertà scuole medie\",\n" +
		        "    \"town\": \"Gorle\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Grassobbio Matteotti 35\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Grassobbio Tonale 5a\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GRASSOBBIO via Colombo capolinea\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GRASSOBBIO via Epis 21\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GRASSOBBIO via Marconi 2\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GRASSOBBIO via XXV Aprile 11\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GRASSOBBIO viale Europa 25\",\n" +
		        "    \"town\": \"Grassobbio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"GUZZANICA via Guzzanica 104\",\n" +
		        "    \"town\": \"Guzzanica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO via Aldo Moro fr.3\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO via Europa\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO via Mascagni fr.Banca\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO via Rossini fr. Oratorio\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO via Sforzatica conf. comunale\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO via Sforzatica per Bg conf. comun\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LALLIO x Osio Sopra via Aldo Moro\",\n" +
		        "    \"town\": \"Lallio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LOCATE via Don Foiadelli fr.1\",\n" +
		        "    \"town\": \"Locate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LONGUELO ORATORIO\",\n" +
		        "    \"town\": \"Longuelo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LONGUELO VIA MATTIOLI\",\n" +
		        "    \"town\": \"Longuelo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LONGUELO via Puccini fr.34 Focasina\",\n" +
		        "    \"town\": \"Longuelo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"LORETO via Pasteur fr.1A\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MALPENSATA\",\n" +
		        "    \"town\": \"Loreto\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MALPENSATA via Carnovali 88\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MALPENSATA via Carnovali 95\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MALPENSATA via Don Bosco 17a Pesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MARIANO via Cimaripa 2\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MARIANO via Cimaripa fr.4\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Monte di Nese Parcheggio\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MONTEROSSO viale G.Cesare via Tremana\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MOZZO via Dante Alighieri\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MOZZO VIA MOZZI\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MOZZO via Mozzi capolinea\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MOZZO via Piatti fr.10\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MOZZO via Piatti fr.12 Comune\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"MOZZO via Todeschini fr.29\",\n" +
		        "    \"town\": \"Mozzo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Nembro Oratorio\",\n" +
		        "    \"town\": \"Nembro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"NEMBRO via Gavarno fr.25\",\n" +
		        "    \"town\": \"Nembro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"NEMBRO via Gavarno fr.96\",\n" +
		        "    \"town\": \"Nembro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"NEMBRO via Puccini 37\",\n" +
		        "    \"town\": \"Nembro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"NEMBRO via Verdi edicola\",\n" +
		        "    \"town\": \"Nembro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"OLERA piazza Fra Tommaso Acerbis\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ORIO AL SERIO via Locatelli 1\",\n" +
		        "    \"town\": \"Orio al Serio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ORIO AL SERIO via Locatelli 18/18a Comun\",\n" +
		        "    \"town\": \"Orio al Serio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"ORIO AL SERIO via Portico Orio Center\",\n" +
		        "    \"town\": \"Orio al Serio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"OSIO SOPRA via Monte Bianco 10\",\n" +
		        "    \"town\": \"Osio Sopra\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"OSPEDALE\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"OSPEDALE MARTIN LUTHER KING\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"OSTELLO via G.Ferraris\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"P.LE CIMITERO per Loreto\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA GHIAIE via del Brembo\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA Sombreno via S.Fermo e Rustico\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Paladina SP Dalmine/Almè fr.4\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via Bolis 13\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via Degli Alpini Cimitero\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via Degli Alpini oratorio\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via Don Carminati 6\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via Don Carminati fr.8\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via G.Galilei 3\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PALADINA via IV Novembre fr. Banca\",\n" +
		        "    \"town\": \"Paladina\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PEDRENGO via Frizzoni 7/9\",\n" +
		        "    \"town\": \"Pedrengo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PEDRENGO via Kennedy\",\n" +
		        "    \"town\": \"Pedrengo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PEDRENGO via Papa Giovanni XXIII 11\",\n" +
		        "    \"town\": \"Pedrengo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PEDRENGO via Papa Giovanni XXIII 4\",\n" +
		        "    \"town\": \"Pedrengo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"piazza Libertà\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"piazza S.Anna fr.1\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PIAZZA S.ANNA via Ghislandi 2\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"piazzale Cimitero per Clementina\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PIAZZALE LOVERINI\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PIAZZALE OBERDAN\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTE S.PIETRO via Vittorio Emanuele 58\",\n" +
		        "    \"town\": \"Ponte San Pietro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTE S.PIETRO viale Italia 15\",\n" +
		        "    \"town\": \"Ponte San Pietro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Fustina 2\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Fustina 41\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via IV Novembre 65\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Papa Giovanni XXIII 2\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Ramera 4 Pontesecco\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Ramera fr. Chiesa\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Valbona 44/46\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Valbona fr.55 ex FVB\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PONTERANICA via Valbona fr.93\",\n" +
		        "    \"town\": \"Ponteranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PORTA NUOVA\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PORTA NUOVA NESSI\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PORTA NUOVA TIRABOSCHI\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"PORTA NUOVA VIA CAMOZZI\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"RANICA piazza Europa 4\",\n" +
		        "    \"town\": \"Ranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"RANICA via Adelasio\",\n" +
		        "    \"town\": \"Ranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"RANICA via Marconi\",\n" +
		        "    \"town\": \"Ranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"RANICA via Marconi 57\",\n" +
		        "    \"town\": \"Ranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"RANICA via Provinciale Arredamenti Sala\",\n" +
		        "    \"town\": \"Ranica\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"RONCOLA via Ambrosioni fr. Chiesa\",\n" +
		        "    \"town\": \"Roncola\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Roncola via Lungobrembo fr. 60\",\n" +
		        "    \"town\": \"Roncola\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"S.ANTONIO via Biava 26\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"S.ANTONIO via Ruggeri da Stabello 53b\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"S.ANTONIO via Ruggeri da Stabello 72d\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"S.COLOMBANO\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SABBIO via Don Cortesi Scuole elementari\",\n" +
		        "    \"town\": \"Dalmine\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SCANZO\",\n" +
		        "    \"town\": \"Scanzorosciate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SCANZO corso Europa 38\",\n" +
		        "    \"town\": \"Scanzorosciate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SCANZO corso Europa, 74\",\n" +
		        "    \"town\": \"Scanzorosciate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SCANZO Negrone via Piave fr.40\",\n" +
		        "    \"town\": \"Scanzorosciate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SCANZO via Matteotti fr.6\",\n" +
		        "    \"town\": \"Scanzorosciate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SCANZO via Sporla 6\",\n" +
		        "    \"town\": \"Scanzorosciate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE c.so Europa piscine\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE corso Roma 110\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE corso Roma 43a Quartiere Primave\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"Seriate Paderno fr.55\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE piazza Caduti della Libertà\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE S. GIUSEPPE via Decò e Canetta\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE v.le Italia 51 Comune\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Brusaporto fr.34\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Brusaporto fr.34L/34a IPER\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Decò e Canetta 120\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Europa 21 fr. ITIS Majorana\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Europa ITIS Majorana\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Marconi 16/18\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE via Paderno\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE viale Italia 95 Legler\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SERIATE viale Lombardia mercato\",\n" +
		        "    \"town\": \"Seriate\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SORISOLE Azzonica via Don Carminati 12/1\",\n" +
		        "    \"town\": \"Sorisole\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SORISOLE Petosino via Martiri della Libe\",\n" +
		        "    \"town\": \"Sorisole\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SORISOLE Petosino via Zambelli fr.3\",\n" +
		        "    \"town\": \"Sorisole\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SORISOLE Piazza Donatori del Sangue merc\",\n" +
		        "    \"town\": \"Sorisole\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"SORISOLE via Madonna dei Campi fr.25\",\n" +
		        "    \"town\": \"Sorisole\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STAZIONE\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STAZIONE SUPERIORE FUNICOLARE Piazza Mer\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STEZZANO OVEST via Zanchi 5a\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STEZZANO via Circ. Ovest 6\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STEZZANO via Papa Giovanni XXIII fr. Sup\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STEZZANO via Papa Giovanni XXIII, 7\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STEZZANO via Rizzo fr. 7\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"STEZZANO via Santuario Banca\",\n" +
		        "    \"town\": \"Stezzano\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE BOLDONE via Borghetto fr.28\",\n" +
		        "    \"town\": \"Torre Boldone\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE BOLDONE via Della Colombera\",\n" +
		        "    \"town\": \"Torre Boldone\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE BOLDONE via Lombardia fr.65/67\",\n" +
		        "    \"town\": \"Torre Boldone\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE BOLDONE via Reich 15 Farmacia\",\n" +
		        "    \"town\": \"Torre Boldone\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE BOLDONE via S.Martino Vecchio fr.1\",\n" +
		        "    \"town\": \"Torre Boldone\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE DE ROVERI piazza Del Donatore\",\n" +
		        "    \"town\": \"Torre De Roveri\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE DE ROVERI Pitturello via Castello\",\n" +
		        "    \"town\": \"Torre De Roveri\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE DE ROVERI via Papa Giovanni XXIII\",\n" +
		        "    \"town\": \"Torre De Roveri\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TORRE DEL GALGARIO SOLO PER TABELLE DI M\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TREVIOLO Albegno via IV Novembre 6\",\n" +
		        "    \"town\": \"Treviolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TREVIOLO via Ambrosioni via Amato\",\n" +
		        "    \"town\": \"Treviolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TREVIOLO via dei Cedri 8\",\n" +
		        "    \"town\": \"Treviolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TREVIOLO via Lega Lombarda via Gorizia\",\n" +
		        "    \"town\": \"Treviolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TREVIOLO via Marconi fr. via Rillosi\",\n" +
		        "    \"town\": \"Treviolo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"TRIBULINA via Monte Misma fr.3\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"URBAN CENTER\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO c.so Europa Unita fr.11\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO CORNELLE corso Europa Unita 11\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO corso Europa Unita 18\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO via A.Moro fr. parcheggio\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO via Donizetti NECTA\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO via Matteotti parco\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO via Padre Murialdo 21 Padri Gi\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO via Roma 12\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VALBREMBO via Sombreno 27/29 villino\",\n" +
		        "    \"town\": \"Valbrembo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via A.Mai 32 Scuola Fantoni\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via A.Mai 35b Scuola Fantoni\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Berenson A.T.B. per Seriate\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Berenson A.T.B.per Bergamo\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VIA BERIZZI PONTE S.PIETRO\",\n" +
		        "    \"town\": \"Ponte San Pietro\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Borgo Palazzo 100h/102 viale Pirovan\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Borgo Palazzo 163 fr.ASL\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Borgo Palazzo 230 Portone del diavol\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Borgo Palazzo 69 TEB\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Borgo Palazzo fr. Portone del Diavol\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Broseta 115 Piazza Risorgimento\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Camozzi 162 via Borgo Palazzo\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Canovine\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Carducci Auchan\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Cavalli\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Corridoni 73/75\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Corridoni 74c Pesa Parcheggio\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Daste e Spalenga\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Dei Caniana fr.6 Chiesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VIA DEI CANIANA UNIVERSITA'\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via dello Statuto - Accademia della Guardia di Finanza\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via dello Statuto - Piscine\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via dello Statuto 29\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Don Bosco via Zanica\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Europa Quarenghi\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via F.lli Vicentini (Navetta Mercato)\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via G.Cesare edicola stadio\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via G.Rosa 20e farmacia\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Gasparini fr.11a\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Gavazzeni clinica\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Gleno C.F.P. Regione\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Isabello 1 Chiesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Leonardo da Vinci\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Leonardo da Vinci Chiesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Luzzatti 9\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Madonna del Bosco 54/56 Chiesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Madonna del Bosco Chiesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Maironi da Ponte 16/18\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Maironi da Ponte ponte Morla\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Mattioli fr. Chiesa\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Mazzini 20 Clinica Castelli\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Moroni 234 Centro Studi L. da Vinci\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Paleocapa 1 Parcheggio\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via per Orio fr.43\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via per Orio fr.56\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Pescaria 3\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Petrarca fr.12/14 Banca d Italia\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Presolana Centro per l impiego\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Ruggeri da Stabello 1\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via S.Ambrogio fr.18\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via S.Bernardino 116\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via S.Vigilio Belvedere\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Salvo D Acquisto 17\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Suardi 17a\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Suardi 79\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Tremana Scuole\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via XXIV maggio\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via XXIV Maggio 43\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Zambonate 60 Cinque Vie\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"via Zambonate 89 Cinque Vie\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"viale G.Cesare 18d Stadio\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VILLA D ALME via Ronco Basso fermata scu\",\n" +
		        "    \"town\": \"Villa d'almè\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VILLA DI SERIO via A.Moro 21\",\n" +
		        "    \"town\": \"Villa di Serio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VILLA DI SERIO via Carrara piazza Mercat\",\n" +
		        "    \"town\": \"Villa di Serio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VILLA DI SERIO via Dosie fr. poste\",\n" +
		        "    \"town\": \"Villa di Serio\",\n" +
		        "    \"province\": \"BG\"\n" +
		        "  },\n" +
		        "  {\n" +
		        "    \"name\": \"VILLAGGIO SPOSI VIA CAVALLI\",\n" +
		        "    \"town\": \"Bergamo\",\n" +
		        "    \"province\": \"BG\"\n" +
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