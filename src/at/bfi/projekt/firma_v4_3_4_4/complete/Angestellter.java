package at.bfi.projekt.firma_v4_3_4_4.complete;

public class Angestellter extends Mitarbeiter {

	private double grundgehalt;
	private double zulage;
	private double ortszuschlag;

	public Angestellter() {
	}

	/**
	 * @param id
	 */
	public Angestellter(int id) {
		super(id);
	}

	/**
	 * @param id
	 * @param grundgehalt
	 * @param zulage
	 * @param ortszuschlag
	 */
	public Angestellter(int id, String name, double grundgehalt, double zulage, double ortszuschlag) {
		super(id, name);
		this.grundgehalt = grundgehalt;
		this.zulage = zulage;
		this.ortszuschlag = ortszuschlag;
	}

	public double berechneBrutto() {
		double brutto = grundgehalt + zulage + ortszuschlag;
		return brutto;
	}

	/**
	 * @return
	 */
	public double getGrundgehalt() {
		return grundgehalt;
	}

	/**
	 * @param grundgehalt
	 */
	public void setGrundgehalt(double grundgehalt) {
		this.grundgehalt = grundgehalt;
	}

	/**
	 * @return
	 */
	public double getOrtszuschlag() {
		return ortszuschlag;
	}

	/**
	 * @param zulage
	 */
	public void setOrtszuschlag(double ortszuschlag) {
		this.ortszuschlag = ortszuschlag;
	}

	/**
	 * @return
	 */
	public double getZulage() {
		return zulage;
	}

	/**
	 * @param zulage
	 */
	public void setZulage(double zulage) {
		this.zulage = zulage;
	}

	@Override
	public String ausgabe() {
		return "\nAngestellter\n============\nId: " + getId() + "\nName: " + getName() + "\nGrundgehalt: "
				+ String.format("%.2f", grundgehalt) + "\nZulage: " + String.format("%.2f", zulage) + "\nOrtszuschlag: "
				+ String.format("%.2f", ortszuschlag) + "\nBrutto: " + String.format("%.2f", berechneBrutto());
	}

}
