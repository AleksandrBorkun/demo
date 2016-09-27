package epam.homework.task1.trigonometricExample;

public class Example {

	public static double showResult(double x, double y) {

		double result;

		result = (1 + Math.pow(Math.sin(x + y), 2)) / (2 + Math.abs(x - (2 * x / 1 + Math.pow(x * y, 2)))) + x;
		
		return result;
	
	}
}
