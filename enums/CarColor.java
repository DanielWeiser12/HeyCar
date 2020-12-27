package enums;

public enum CarColor {


	YELLOW("Gelb"), RED("Rot"), GREEN("Grün"), BLUE("Blau"), GRAY("Grau"), CYAN("Cyan"), BLACK("Schwarz"), WHITE("Weiss"), MAGENTA("Magenta");

	private String color;

	private CarColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return this.color;
	}

}
