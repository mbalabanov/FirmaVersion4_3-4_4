/*
 * 
 * Firma V4.3 - 4.4 - Tests fuer Verwaltung
 * Marin Balabanov
 * 
 */

package at.bfi.projekt.firma_v4_3_4_4.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import at.bfi.projekt.firma_v4_3_4_4.complete.Angestellter;
import at.bfi.projekt.firma_v4_3_4_4.complete.Arbeiter;
import at.bfi.projekt.firma_v4_3_4_4.complete.Mitarbeiter;
import at.bfi.projekt.firma_v4_3_4_4.complete.Verwaltung;

class VerwaltungTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Test
	void testGetAnzahlDerArbeiterGesamt() {

		// Arrange
		Verwaltung ersteVerwaltung = new Verwaltung();

		List<Mitarbeiter> dieseMitarbeiterListe = ersteVerwaltung.getMitarbeiter_Liste();

		// Act
		int actualAnzArbeiter = ersteVerwaltung.getAnzArbeiterGesamt();
		int expectedAnzArbeiter = 6;

		// Assert
		assertEquals(expectedAnzArbeiter, actualAnzArbeiter);
	}

	@Test
	void testGetAnzahlDerAngestelltenGesamt() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();
		List<Mitarbeiter> dieseMitarbeiterListe = verwaltung.getMitarbeiter_Liste();

		// Act
		int actualAnzAngestellte = verwaltung.getAnzAngestellterGesamt();
		int expectedAnzAngestellte = 6;

		// Assert
		assertEquals(expectedAnzAngestellte, actualAnzAngestellte);
	}

	@Test
	void testBerechneSummeAllerGehaelter() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		double actualSummeGehaelter = verwaltung.berechneSummeAlleGehaelter();
		double expectedAnzAngestellte = 37626.74;

		// Assert
		assertEquals(expectedAnzAngestellte, actualSummeGehaelter);
	}

	@Test
	void testBerechneNettoArbeiter() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		final double ASSERTION_TAX_ARB = 0.15;

		// Act
		Arbeiter testArbeiter_0 = new Arbeiter(1, "Klemens", 10, 10, 10);
		Arbeiter testArbeiter_1 = new Arbeiter(2, "Karoline", 20, 20, 20);

		double nettoArbeiter_0 = verwaltung.berechneNettoGehalt(testArbeiter_0);
		double nettoArbeiter_1 = verwaltung.berechneNettoGehalt(testArbeiter_1);

		double assertionBruttoTemp = testArbeiter_0.berechneBrutto() + testArbeiter_1.berechneBrutto();
		double expectedNetto = assertionBruttoTemp - (assertionBruttoTemp * ASSERTION_TAX_ARB);

		// Assert
		assertEquals(expectedNetto, (nettoArbeiter_0 + nettoArbeiter_1));

	}

	@Test
	void testAusgabeMitarbeiterListe() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();
		List<Mitarbeiter> dieseAbteilungsMitarbeiter = verwaltung.getMitarbeiterListeVonAbteilung(4);

		// Act
		String actualOutput = verwaltung.ausgabeMitarbeiterListe(dieseAbteilungsMitarbeiter);
		String expectedOutput = "\nArbeiter\n========\nId: 4\nName: Eckehard\nStundenlohn: 27.80\nAnzahl der Stunden: 134\nSchichtzulage: 104.70\nBrutto: 3829.9";

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testAusgabeEmptyMitarbeiterListe() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();
		List<Mitarbeiter> dieseAbteilungsMitarbeiter = verwaltung.getMitarbeiterListeVonAbteilung(5);

		// Act
		String actualOutput = verwaltung.ausgabeMitarbeiterListe(dieseAbteilungsMitarbeiter);
		String expectedOutput = "";

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testAusgabeAlleAbteilungen() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		String actualOutput = verwaltung.ausgabe_AlleAbteilungen();
		String expectedOutput = "Abteilung mit ID 1\nName: PR\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 1\nName: Anneken\nStundenlohn: 29.10\nAnzahl der Stunden: 109\nSchichtzulage: 94.40\nBrutto: 3266.3\n\n\nArbeiter\n========\nId: 6\nName: Erna\nStundenlohn: 22.50\nAnzahl der Stunden: 123\nSchichtzulage: 111.80\nBrutto: 2879.3\n\n\nAngestellter\n============\nId: 7\nName: Mathis\nGrundgehalt: 2400.00\nZulage: 1211.30\nOrtszuschlag: 18.80\nBrutto: 3630.10\n\n\nAngestellter\n============\nId: 8\nName: Hardwin\nGrundgehalt: 2800.00\nZulage: 1309.80\nOrtszuschlag: 19.90\nBrutto: 4129.70\n\nAbteilung mit ID 2\nName: Sales\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 2\nName: Poldi\nStundenlohn: 31.70\nAnzahl der Stunden: 97\nSchichtzulage: 101.30\nBrutto: 3176.2000000000003\n\n\nArbeiter\n========\nId: 3\nName: Ottila\nStundenlohn: 17.20\nAnzahl der Stunden: 83\nSchichtzulage: 44.90\nBrutto: 1472.5\n\n\nAngestellter\n============\nId: 9\nName: Barthold\nGrundgehalt: 1812.23\nZulage: 992.20\nOrtszuschlag: 20.00\nBrutto: 2824.43\n\n\nAngestellter\n============\nId: 10\nName: Ortrun\nGrundgehalt: 1903.67\nZulage: 1489.10\nOrtszuschlag: 21.10\nBrutto: 3413.87\n\n\nAngestellter\n============\nId: 11\nName: Loreley\nGrundgehalt: 1407.95\nZulage: 1298.21\nOrtszuschlag: 22.20\nBrutto: 2728.36\n\nAbteilung mit ID 3\nName: IT\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 5\nName: Juliane\nStundenlohn: 23.70\nAnzahl der Stunden: 124\nSchichtzulage: 114.10\nBrutto: 3052.8999999999996\n\n\nArbeiter\n========\nId: 6\nName: Erna\nStundenlohn: 22.50\nAnzahl der Stunden: 123\nSchichtzulage: 111.80\nBrutto: 2879.3\n\n\nAngestellter\n============\nId: 12\nName: Wilmar\nGrundgehalt: 1703.67\nZulage: 1496.21\nOrtszuschlag: 23.30\nBrutto: 3223.18\n\nAbteilung mit ID 4\nName: HR\n\nListe der Mitarbeiter in der Abteilung: \n\nArbeiter\n========\nId: 4\nName: Eckehard\nStundenlohn: 27.80\nAnzahl der Stunden: 134\nSchichtzulage: 104.70\nBrutto: 3829.9\n\n";

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testSearchAbteilungSuccess() {
		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		boolean actualSearchResult = verwaltung.searchAbteilung(1);
		boolean expectedSearchResult = true;

		// Assert
		assertEquals(expectedSearchResult, actualSearchResult);
	}

	@Test
	void testSearchAbteilungFail() {
		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		boolean actualSearchResult = verwaltung.searchAbteilung(0);
		boolean expectedSearchResult = false;

		// Assert
		assertEquals(expectedSearchResult, actualSearchResult);
	}

	@Test
	void testGetMitarbeiterListeVonAbteilung() {
		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		List<Mitarbeiter> actualMitarbeiterListeVonAbteilung = verwaltung.getMitarbeiterListeVonAbteilung(4);
		List<Mitarbeiter> expectedMitarbeiterListeVonAbteilung = new ArrayList<Mitarbeiter>();
		expectedMitarbeiterListeVonAbteilung.add(verwaltung.getMitarbeiter_Liste().get(3));

		// Assert
		assertEquals(expectedMitarbeiterListeVonAbteilung, actualMitarbeiterListeVonAbteilung);
	}

	@Test
	void testBerechneNettoAngestellter() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		double ASSERTION_TAX_ANG = 0.20;

		// Act
		Angestellter angestellter_1 = new Angestellter(1, "Warinot", 100.0, 10.00, 1.0);

		double actualNetto = verwaltung.berechneNettoGehalt(angestellter_1);
		double expectedNetto = angestellter_1.berechneBrutto() - (angestellter_1.berechneBrutto() * ASSERTION_TAX_ANG);

		// Assert
		assertEquals(expectedNetto, actualNetto);

	}

	@Test
	void testSearchMitarbeiterAusFirma() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		Mitarbeiter gefundenerMitarbeiter = verwaltung.searchMitarbeiterAusFirma(4);
		String expectedName = "Eckehard";

		// Assert
		assertEquals(expectedName, gefundenerMitarbeiter.getName());
	}

	@Test
	void testSearchNullMitarbeiterAusFirma() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		Mitarbeiter gefundenerMitarbeiter = verwaltung.searchMitarbeiterAusFirma(13);

		// Assert
		assertNull(gefundenerMitarbeiter);
	}

	// Diese Methode macht genau das selbe wie die Methode
	// searchMitarbeiterAusFirma(). Lt. Angabe zu FirmaV4.3 - 4.4
	// muss diese neue Methode trotzdem umgesetzt werden.
	@Test
	void testSearchMitarbeiterInFirma() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		Mitarbeiter gefundenerMitarbeiter = verwaltung.searchMitarbeiterInFirma(4);
		String expectedName = "Eckehard";

		// Assert
		assertEquals(expectedName, gefundenerMitarbeiter.getName());
	}

	// Diese Methode macht genau das selbe wie die Methode
	// searchMitarbeiterAusFirma(). Lt. Angabe zu FirmaV4.3 - 4.4
	// muss diese neue Methode trotzdem umgesetzt werden.
	@Test
	void testSearchNullMitarbeiterInFirma() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		Mitarbeiter gefundenerMitarbeiter = verwaltung.searchMitarbeiterInFirma(13);

		// Assert
		assertNull(gefundenerMitarbeiter);
	}

	@Test
	void testAusgabeMitarbeiter() {

		// Arrange
		System.setOut(new PrintStream(outContent));
		Verwaltung verwaltung = new Verwaltung();
		Arbeiter testArbeiter_0 = new Arbeiter(1, "Klemens", 10, 10, 10);

		// Act
		verwaltung.ausgabe(testArbeiter_0);
		String actualOutput = outContent.toString();
		String expectedOutput = "\nArbeiter\n========\nId: 1\nName: Klemens\nStundenlohn: 10.00\nAnzahl der Stunden: 10\nSchichtzulage: 10.00\nBrutto: 110.0\nNetto: 93.50\n";
		System.setOut(originalOut);

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testSortMitarbeiterNachNamen() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		verwaltung.sortMitarbeiterNachNamen();
		String actualName = verwaltung.getMitarbeiter_Liste().get(1).getName();
		String expectedName = "Barthold";

		// Assert
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSortNullMitarbeiterNachNamenListe() {

		// Arrange
		System.setOut(new PrintStream(outContent));
		Verwaltung verwaltung = new Verwaltung();
		verwaltung.setMitarbeiter_Liste(new ArrayList<>());

		// Act
		verwaltung.sortMitarbeiterNachNamen();
		String actualOutput = outContent.toString();
		String expectedOutput = "Error: Ihre Mitarbeiterliste ist leer!\n";
		System.setOut(originalOut);

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	void testSortMitarbeiterNachGehalt() {

		// Arrange
		Verwaltung verwaltung = new Verwaltung();

		// Act
		verwaltung.sortMitarbeiterNachGehalt();
		String actualName = verwaltung.getMitarbeiter_Liste().get(1).getName();
		String expectedName = "Loreley";

		// Assert
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSortNullMitarbeiterNachGehalt() {

		// Arrange
		System.setOut(new PrintStream(outContent));
		Verwaltung verwaltung = new Verwaltung();
		verwaltung.setMitarbeiter_Liste(new ArrayList<>());

		// Act
		verwaltung.sortMitarbeiterNachGehalt();
		String actualOutput = outContent.toString();
		String expectedOutput = "Error: Ihre Mitarbeiterliste ist leer!\n";
		System.setOut(originalOut);

		// Assert
		assertEquals(expectedOutput, actualOutput);
	}

}
