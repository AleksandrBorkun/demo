package epam.homework.task1.pointerLocation;

public class Demo {

	public static void main(String[] args) {

		// задаем координаты точекки которые будем проверять
		int point_one[] = { -6, 1 };
		int point_two[] = { -6, 0 };
		int point_four[] = { 4, 4 };

		// вызываем метод проверяющий положение точки
		System.out.println(
				isLocated.Local(point_one) + "\n" + isLocated.Local(point_two) + "\n" + isLocated.Local(point_four));

	}

}
