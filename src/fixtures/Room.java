package fixtures;

public class Room extends Fixture{
	
	private int n, s, w, e;
	
	public Room(String name, String shortDescription, String longDescription, int aN, int aS, int aW, int aE) {
		super(name, shortDescription, longDescription);
		this.n = aN;
		this.s = aS;
		this.w = aW;
		this.e = aE;
	}
	
	// getters
	// north
	public int getN() {
		return n;
	}
	
	public void setN(int aN) {
		this.n = aN;
	}

	public int getS() {
		return s;
	}

	public void setS(int aS) {
		this.s = aS;
	}

	public int getW() {
		return w;
	}

	public void setW(int aW) {
		this.w = aW;
	}

	public int getE() {
		return e;
	}

	public void setE(int aE) {
		this.e = aE;
	}
	
}
