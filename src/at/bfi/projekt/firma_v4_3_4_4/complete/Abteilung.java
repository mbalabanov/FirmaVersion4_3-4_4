/*
 * 
 * Firma V4.3 - 4.4 - Abteilung
 * Marin Balabanov
 * 
 */

package at.bfi.projekt.firma_v4_3_4_4.complete;

import java.util.List;

public class Abteilung {
	private int id;
	private String name;
	private String abt_leiter;
	private List<Mitarbeiter> mitarb_liste;

	public Abteilung() {
	}

	/**
	 * @param id
	 */
	public Abteilung(int id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Abteilung(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 * @param abt_leiter
	 */
	public Abteilung(int id, String name, List<Mitarbeiter> mitarb_liste) {
		this.id = id;
		this.name = name;
		this.mitarb_liste = mitarb_liste;
	}

	/**
	 * @param id
	 * @param name
	 * @param abt_leiter
	 * @param mitarb_liste
	 */
	public Abteilung(int id, String name, String abt_leiter, List<Mitarbeiter> mitarb_liste) {
		this.id = id;
		this.name = name;
		this.abt_leiter = abt_leiter;
		this.mitarb_liste = mitarb_liste;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return abt_leiter
	 */
	public String getAbt_leiter() {
		return abt_leiter;
	}

	/**
	 * @param abt_leiter
	 */
	public void setAbt_leiter(String abt_leiter) {
		this.abt_leiter = abt_leiter;
	}

	/**
	 * @return mitarb_liste
	 */
	public List<Mitarbeiter> getMitarb_liste() {
		return mitarb_liste;
	}

	/**
	 * @param mitarb_liste
	 */
	public void setMitarb_liste(List<Mitarbeiter> mitarb_liste) {
		this.mitarb_liste = mitarb_liste;
	}

	/**
	 * @return
	 */
	public String ausgabeMitarb_liste() {
		String alleAbteilungsmitarbeiter = "";

		for (Mitarbeiter dieserMitarbeiter : mitarb_liste) {
			alleAbteilungsmitarbeiter += dieserMitarbeiter.ausgabe() + "\n\n";
		}

		return alleAbteilungsmitarbeiter;
	}

	/**
	 * @return
	 */
	public String ausgabe() {
		String ausgabeInhalt = "";

		if (id > 0) {
			ausgabeInhalt += "Abteilung mit ID " + id;
		}
		if (name != null) {
			ausgabeInhalt += "\nName: " + name;
		}
		if (abt_leiter != null) {
			ausgabeInhalt += "\nAbteilungsleiter: " + abt_leiter;
		}

		if (mitarb_liste.size() > 0) {
			ausgabeInhalt += "\n\nListe der Mitarbeiter in der Abteilung: \n" + ausgabeMitarb_liste();
		}

		return ausgabeInhalt;
	}

}
