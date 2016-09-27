package epam.homework.task1.trigonometricEquation;

public class TableOfResul {

	public static void show(int startPoint, int finishPoint, int step) {

		for (double i = startPoint; i <= finishPoint; i += step) {

			if (step == 0) {
				System.out.println("Ooops! Step can't be zero... Change it please");
				return;
			}
			Tangens.calculate(i);
		}
		return;
	}

}
