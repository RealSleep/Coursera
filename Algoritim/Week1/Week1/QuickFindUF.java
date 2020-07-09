public class QuickFindUF {

	private int[] id;

	public QuickFindUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int idP = id[p];
		int idQ = id[q];
			
		for(int i = 0; i < id.length; i++) {
			if(idP == id[i])
				id[i] = idQ;
		}

	}

	public void print() {
		System.out.println(java.util.Arrays.toString(id));
	}

	public static void main(String[] args) {
		QuickFindUF q = new QuickFindUF(10);

		q.union(4,3);
		q.union(3,8);
		q.union(6,5);
		q.union(9,4);
		q.union(2,1);
		q.union(8,9);
		q.union(7,2);
		q.union(5,0);
		q.print();
	}
}