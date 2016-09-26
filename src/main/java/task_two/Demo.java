package task_two;

public class Demo {

	public static void main(String[] args) {

		// задаем минимальные и максимальлные значаения х в области
		int x_area[][] = { { -4, 4 }, { -6, 6 } };

		// задаем минимальные и максимальлные значаения у в области
		int y_area[][] = { { 0, 6 }, { -3, 0 } };

		// задаем координаты точекки которые будем проверять
		int point_one[] = { -6, 1 };
		int point_two[] = { -6, 0 };
		int point_three[] = { 6, 4 };
		int point_four[] = { 4, 4 };
		

		// вызываем метод проверяющий положение точки
		isLocated.Local(point_one, x_area, y_area);
		isLocated.Local(point_two, x_area, y_area);
		isLocated.Local(point_three, x_area, y_area);
		isLocated.Local(point_four, x_area, y_area);

	}

}
