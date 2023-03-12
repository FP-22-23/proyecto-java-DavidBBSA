package fp.common;

public record Memorias(String ram, String rom) {
	public String toString() {
		return "(Memoria RAM: " + ram + ", Memoria ROM: " + rom + ")";
	}
}
