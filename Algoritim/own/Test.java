import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Test {
	static int[] id = new int[1];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("largeUF.txt"),"UTF-8");
		int n = scan.nextInt();

		UF uf = new WeightedQuickUnionUF(n);
		long s = System.currentTimeMillis();
		while(scan.hasNext()) {
			int p = scan.nextInt();
			int q = scan.nextInt();

			if(!uf.connected(p,q)) {
				uf.union(p,q);
			}
		}long ss = System.currentTimeMillis();
		id = uf.get();
		System.out.println(ss-s+"s");
		s = System.currentTimeMillis();
		for(int i = 0; i<id.length;i++) {
			root(i);
		}
		ss = System.currentTimeMillis();
		System.out.println(ss-s+"s");
		s = System.currentTimeMillis();
		for(int i = 0; i<id.length;i++) {
			root(i*1.0);
		}
		ss = System.currentTimeMillis();
		System.out.println(ss-s+"s");
		
	}

	public static int root(int p) {
		while(p!=id[p]) p = id[p];
		return p;
	}

	public static int root(double i) {
		int p = (int)i;
		if(p==id[p]) {
			return p;
		}else{
			return root(p);
		}
	}

}