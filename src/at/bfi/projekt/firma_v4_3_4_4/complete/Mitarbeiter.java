package at.bfi.projekt.firma_v4_3_4_4.complete;

public abstract class Mitarbeiter {

	private int id;
	private String name;

	public Mitarbeiter() {
	}

	/**
	 * @param id
	 */
	public Mitarbeiter(int id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Mitarbeiter(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public abstract double berechneBrutto();

	/**
	 * @return
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
	 * @return
	 */
	public String ausgabe() {
		return "\nMitarbeiter\n===========\nId: " + id + "\nName: " + name + "\n";
	}

}
