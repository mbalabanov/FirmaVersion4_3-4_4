/*
 * 
 * Firma V4.3 - 4.4 - Verwaltung
 * Marin Balabanov
 * 
 */

package at.bfi.projekt.firma_v4_3_4_4.complete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Verwaltung implements Utility {

	private Firma firma;
	private List<Mitarbeiter> mitarbeiter_Liste = new ArrayList<Mitarbeiter>();;
	private List<Abteilung> abteilungs_Liste = new ArrayList<Abteilung>();;

	public Verwaltung() {
		init();
	}

	public static void main(String[] args) {
		Verwaltung verwaltung = new Verwaltung();

	}

	public void init() {

		// Mitarbeiter und Mitarbeiterliste werden erstellt.
		mitarbeiter_Liste.add(new Arbeiter(1, "Anneken", 29.1, 109, 94.4));
		mitarbeiter_Liste.add(new Arbeiter(2, "Poldi", 31.7, 97, 101.3));
		mitarbeiter_Liste.add(new Arbeiter(3, "Ottila", 17.2, 83, 44.9));
		mitarbeiter_Liste.add(new Arbeiter(4, "Eckehard", 27.8, 134, 104.7));
		mitarbeiter_Liste.add(new Arbeiter(5, "Juliane", 23.7, 124, 114.1));
		mitarbeiter_Liste.add(new Arbeiter(6, "Erna", 22.5, 123, 111.8));

		mitarbeiter_Liste.add(new Angestellter(7, "Mathis", 2400.00, 1211.30, 18.8));
		mitarbeiter_Liste.add(new Angestellter(8, "Hardwin", 2800.00, 1309.80, 19.9));
		mitarbeiter_Liste.add(new Angestellter(9, "Barthold", 1812.23, 992.20, 20.0));
		mitarbeiter_Liste.add(new Angestellter(10, "Ortrun", 1903.67, 1489.10, 21.1));
		mitarbeiter_Liste.add(new Angestellter(11, "Loreley", 1407.95, 1298.21, 22.2));
		mitarbeiter_Liste.add(new Angestellter(12, "Wilmar", 1703.67, 1496.21, 23.3));

		// Abteilungen und Abteilungsliste werden erstellt
		abteilungs_Liste.add(new Abteilung(1, ABTEILUNG_PR, new ArrayList<Mitarbeiter>() {
			{
				add(mitarbeiter_Liste.get(0));
				add(mitarbeiter_Liste.get(5));
				add(mitarbeiter_Liste.get(6));
				add(mitarbeiter_Liste.get(7));
			}
		}));

		abteilungs_Liste.add(new Abteilung(2, ABTEILUNG_SALES, new ArrayList<Mitarbeiter>() {
			{
				add(mitarbeiter_Liste.get(1));
				add(mitarbeiter_Liste.get(2));
				add(mitarbeiter_Liste.get(8));
				add(mitarbeiter_Liste.get(9));
				add(mitarbeiter_Liste.get(10));
			}
		}));

		abteilungs_Liste.add(new Abteilung(3, ABTEILUNG_IT, new ArrayList<Mitarbeiter>() {
			{
				add(mitarbeiter_Liste.get(4));
				add(mitarbeiter_Liste.get(5));
				add(mitarbeiter_Liste.get(11));
			}
		}));

		abteilungs_Liste.add(new Abteilung(4, ABTEILUNG_HR, new ArrayList<Mitarbeiter>() {
			{
				add(mitarbeiter_Liste.get(3));
			}
		}));

		Firma firma = new Firma(mitarbeiter_Liste, abteilungs_Liste);
		this.firma = firma;

	}

	/**
	 * Wurde vom Trainer nachträglich mündlich von void auf double geändert. (Ist
	 * mit Stand 26.Oktober noch nicht in der schriftlichen Angabe berücksichtigt.)
	 * 
	 * @return
	 */
	public double berechneSummeAlleGehaelter() {
		double summeGehaelter = 0.0;
		for (Mitarbeiter dieserMitarbeiter : mitarbeiter_Liste) {
			summeGehaelter = summeGehaelter + dieserMitarbeiter.berechneBrutto();
		}
		return summeGehaelter;
	};

	/**
	 * @param dieserMitarbeiter
	 * @return
	 */
	public double berechneNettoGehalt(Mitarbeiter dieserMitarbeiter) {
		double bruttoBetrag = dieserMitarbeiter.berechneBrutto();
		double steuerBetrag = 0;

		if (dieserMitarbeiter instanceof Arbeiter) {
			steuerBetrag = bruttoBetrag * TAX_ARB;
		}
		if (dieserMitarbeiter instanceof Angestellter) {
			steuerBetrag = bruttoBetrag * TAX_ANG;
		}

		return bruttoBetrag - steuerBetrag;
	};

	/**
	 * Diese Methode wird in der Angabe zu FirmaV3 und FirmaV4.3 - 4.4 verlangt.
	 * 
	 * @return
	 */
	public String ausgabe_AlleAbteilungen() {
		String tempAusgabe = "";
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			tempAusgabe += dieseAbteilung.ausgabe();
		}

		return tempAusgabe;
	}

	/**
	 * Diese Methode wird in der Angabe zu FirmaV3 und FirmaV4.3 - 4.4 verlangt. Der
	 * einzige Unterschied ist die Benennung der Uebergabeparameter.
	 * 
	 * @param abteilungID
	 * @return
	 */
	public List<Mitarbeiter> getMitarbeiterListeVonAbteilung(int abteilungID) {
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			if (dieseAbteilung.getId() == abteilungID) {
				return dieseAbteilung.getMitarb_liste();
			}
		}
		return null;
	}

	/**
	 * @param mitarbeiter_id
	 * @return
	 */
	public Mitarbeiter searchMitarbeiterAusFirma(int mitarbeiter_id) {
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			for (Mitarbeiter dieserMitarbeiter : dieseAbteilung.getMitarb_liste()) {
				if (dieserMitarbeiter.getId() == mitarbeiter_id)
					return dieserMitarbeiter;
			}
		}

		return null;
	}

	/**
	 * Diese Methode macht genau das selbe wie die Methode
	 * searchMitarbeiterAusFirma(). Lt. Angabe zu FirmaV4.3 - 4.4 muss diese neue
	 * Methode trotzdem umgesetzt werden.
	 * 
	 * @param mitarbeiterID
	 * @return
	 */
	public Mitarbeiter searchMitarbeiterInFirma(int mitarbeiterID) {
		for (Abteilung dieseAbteilung : this.firma.getAbteilungs_Liste()) {
			for (Mitarbeiter dieserMitarbeiter : dieseAbteilung.getMitarb_liste()) {
				if (dieserMitarbeiter.getId() == mitarbeiterID)
					return dieserMitarbeiter;
			}
		}

		return null;
	}

	/**
	 * Diese Methode wird in der Angabe zu FirmaV3 und FirmaV4.3 - 4.4 verlangt. Der
	 * einzige Unterschied ist die Benennung der Uebergabeparameter.
	 * 
	 * @param abteilungID
	 * @return
	 */
	public boolean searchAbteilung(int abteilungID) {
		for (Abteilung abteilung : firma.getAbteilungs_Liste()) {
			if (abteilung.getId() == abteilungID) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param dieserMitarbeiter
	 */
	public void ausgabe(Mitarbeiter dieserMitarbeiter) {
		System.out.println(dieserMitarbeiter.ausgabe());
		System.out.print("Netto: ");
		System.out.printf("%.2f%n", berechneNettoGehalt(dieserMitarbeiter));
	}

	/**
	 * @param mitarbeiterListe
	 */
	public String ausgabeMitarbeiterListe(List<Mitarbeiter> dieseMitarbeiterListe) {
		String tempAusgabe = "";
		if (dieseMitarbeiterListe != null) {
			for (Mitarbeiter dieserMitarbeiter : dieseMitarbeiterListe) {
				tempAusgabe += dieserMitarbeiter.ausgabe();
			}
		}

		return tempAusgabe;
	}

	/**
	 * @param mitarbeiterListe
	 * @return
	 */
	public int getAnzAngestellterGesamt() {

		List<Mitarbeiter> thisList = this.getMitarbeiter_Liste();
		int anzahlAngestellte = 0;

		for (Mitarbeiter dieserMitarbeiter : mitarbeiter_Liste) {
			if (dieserMitarbeiter instanceof Angestellter) {
				anzahlAngestellte++;
			}
		}

		return anzahlAngestellte;
	};

	/**
	 * @param mitarbeiterListe
	 * @return
	 */
	public int getAnzArbeiterGesamt() {
		int anzahlArbeiter = 0;

		for (Mitarbeiter dieserMitarbeiter : mitarbeiter_Liste) {
			if (dieserMitarbeiter instanceof Arbeiter) {
				anzahlArbeiter++;
			}
		}
		return anzahlArbeiter;
	}

	public void sortMitarbeiterNachNamen() {
		if (mitarbeiter_Liste.isEmpty()) {
			System.out.println("Error: Ihre Mitarbeiterliste ist leer!");
			return;
		}

		Collections.sort(getMitarbeiter_Liste(), (ersterMitarbeiter, zweiterMitarbeiter) -> ersterMitarbeiter.getName()
				.compareTo(zweiterMitarbeiter.getName()));

	}

	public void sortMitarbeiterNachGehalt() {
		if (mitarbeiter_Liste.isEmpty()) {
			System.out.println("Error: Ihre Mitarbeiterliste ist leer!");
			return;
		}

		mitarbeiter_Liste.sort(Comparator.comparingDouble(Mitarbeiter::berechneBrutto));

	}

	public List<Abteilung> getAbteilungs_Liste() {
		return abteilungs_Liste;
	}

	public void setAbteilungs_Liste(List<Abteilung> abteilungs_Liste) {
		this.abteilungs_Liste = abteilungs_Liste;
	}

	public List<Mitarbeiter> getMitarbeiter_Liste() {
		return mitarbeiter_Liste;
	}

	public void setMitarbeiter_Liste(List<Mitarbeiter> mitarbeiter_Liste) {
		this.mitarbeiter_Liste = mitarbeiter_Liste;
	};

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}
}
