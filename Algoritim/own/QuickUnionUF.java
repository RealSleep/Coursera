public class QuickUnionUF extends UF{

	public QuickUnionUF(int n) {
		super(n);
	}

	public void union(int p, int q) {
		id[root(p)] = id[root(q)];
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	} 

	private int root(int p) {
		while(p!=id[p]) p = id[p];
		return p;
	}


}