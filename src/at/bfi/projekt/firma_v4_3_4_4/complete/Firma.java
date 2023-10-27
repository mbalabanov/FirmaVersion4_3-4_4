/*
 * 
 * Firma V4.3 - 4.4 - Firma
 * Marin Balabanov
 * 
 */

package at.bfi.projekt.firma_v4_3_4_4.complete;

import java.util.ArrayList;
import java.util.List;

public class Firma {

	List<Mitarbeiter> mitarbeiter_Liste = new ArrayList<Mitarbeiter>();
	List<Abteilung> abteilungs_Liste = new ArrayList<Abteilung>();

	public Firma(List<Mitarbeiter> mitarbeiter_Liste, List<Abteilung> abteilungs_Liste) {
		this.mitarbeiter_Liste = mitarbeiter_Liste;
		this.abteilungs_Liste = abteilungs_Liste;
	}

	public List<Mitarbeiter> getMitarbeiter_Liste() {
		return this.mitarbeiter_Liste;
	}

	/**
	 * @param mitarbeiter_Liste
	 */
	public void setMitarbeiter_Liste(List<Mitarbeiter> mitarbeiter_Liste) {
		this.mitarbeiter_Liste = mitarbeiter_Liste;
	}

	/**
	 * @return
	 */
	public List<Abteilung> getAbteilungs_Liste() {
		return abteilungs_Liste;
	}

	/**
	 * @param abteilungs_Liste
	 */
	public void setAbteilungs_Liste(List<Abteilung> abteilungs_Liste) {
		this.abteilungs_Liste = abteilungs_Liste;
	}

	@Override
	public String toString() {
		return "Firma [mitarbeiter_Liste=" + this.mitarbeiter_Liste.toString() + ", abteilungs_Liste="
				+ this.abteilungs_Liste.toString() + "]";
	}

}
