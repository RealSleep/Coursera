public class WeightedQuickUnionUF extends UF{

	private int[] sz;

	public WeightedQuickUnionUF(int n) {
		super(n);
		sz = new int[n];
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i==j) return;
		if(sz[i] < sz[j]) {	id[i] = j; sz[j] += sz[i]; }
		else {	id[j] = i; sz[i] += sz[j]; }
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	} 

	private int root(int p) {
		while(p!=id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}	
		return p;
	}


}