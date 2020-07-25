public class RandomWalkers {
	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		double aver = 0;

		for(int i = 0 ; i < trials; i++) {
			int x = 0;
			int y = 0;
			int step = 0;
			while (true) {
				step++;
			
				if(Math.abs(x) + Math.abs(y) == r) {
					break;
				}

				double p = Math.random();

				if (p >= 0 && p < 0.25) {
					x = x + 1;
				} else if (p >= 0.25 && p < 0.5) {
					x = x - 1;
				} else if (p >= 0.5 && p < 0.75) {
					y = y + 1;
				} else if (p >= 0.75 && p < 1) {
					y = y - 1;
				}
			}
			aver += step;		
		}

		aver /= trials;

		System.out.println("average number of steps = " + aver);
	}
		
}