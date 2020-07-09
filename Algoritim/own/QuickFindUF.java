public class QuickFindUF extends UF{

	public QuickFindUF(int n) {
		super(n)
	}

	public void union(int p, int q) {
		int idP = id[p];
		int idQ = id[q];
		for (int i = 0; i < id.length ; i++) {
			if(id[i] == idP) {
				id[i] = idQ;
			}
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	} 


}