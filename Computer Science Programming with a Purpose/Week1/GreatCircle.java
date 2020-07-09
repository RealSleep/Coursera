public class GreatCircle {
	public static void main(String[] args) {
		double x1 = Double.parseDouble(args[0]);		
		double y1 = Double.parseDouble(args[1]);
		double x2 = Double.parseDouble(args[2]);
		double y2 = Double.parseDouble(args[3]);

		double r = 6371.0;

		double deltaX = (x2 - x1) / 2.0;
		double deltaY = (y2 - y1) / 2.0;

		double sin1 = Math.sin(Math.toRadians(deltaX)) * Math.sin(Math.toRadians(deltaX));
		double sin2 = Math.sin(Math.toRadians(deltaY)) * Math.sin(Math.toRadians(deltaY));

		double underSqrt = Math.sqrt(sin1 + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * sin2);

		double distance = 2 * r * Math.asin(underSqrt);

		System.out.println(distance + " kilometers");
	}
}