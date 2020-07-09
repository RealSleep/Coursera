public abstract class UF {

	protected int[] id;

	public UF(int n) {
		id = new int[n];
		for (int i = 0; i < n ; i++) {
			id[i] = i;
		}
	}

	public abstract  void union(int p, int q);

	public abstract  boolean connected(int p, int q);

	public int[] get() {
		return id;
	}

	public int find(int p) {
		return 0;
	}

	public int count() {
		return 0;
	}

}