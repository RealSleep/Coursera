public class BandMatrix {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int r = Integer.parseInt(args[1]);
		int indexDig = 0;
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				char ch = '0';
				if(Math.abs(j - indexDig) <= r) {
					ch = '*';
				}
				System.out.print(ch + "  ");
			}
			indexDig++;
			System.out.println();
		}
	}

}