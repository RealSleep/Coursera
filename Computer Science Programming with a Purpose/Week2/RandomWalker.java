public class RandomWalker {
	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int x = 0;
		int y = 0;
		int step = 0;
		while (true) {
			step++;
			System.out.printf("(%d, %d)\n", x, y);
			if(Math.abs(x) + Math.abs(y) == r) {
				break;
			}

			int p = (int)(Math.random() * 4);

			if (p == 0) {
				x = x + 1;
			} else if (p == 1) {
				x = x - 1;
			} else if (p == 2) {
				y = y + 1;
			} else {
				y = y - 1;
			}
		}
		System.out.println("steps = " + (step-1));
	}
}