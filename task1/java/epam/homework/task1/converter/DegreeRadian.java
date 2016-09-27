package epam.homework.task1.converter;

public class DegreeRadian {

	public static double radianToDegree(double radian) {

		double degree = 0;

		degree = (radian * 180) / Math.PI;

		return degree;
	}

	public static double degreeToRadian(double degree) {

		double radian = 0;

		radian = degree * Math.PI / 180;

		return radian;

	}

}
