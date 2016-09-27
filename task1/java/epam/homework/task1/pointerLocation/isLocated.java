package epam.homework.task1.pointerLocation;

class isLocated {

	public static boolean Local(int point[]) {
		
		// задаем минимальные и максимальлные значаения х в области
		final int x_area[][] = { { -4, 4 }, { -6, 6 } };

		// задаем минимальные и максимальлные значаения у в области
		final int y_area[][] = { { 0, 6 }, { -3, 0 } };
		
		for (int i = 0; i < x_area.length; i++) {
			
			// добавляем переменную которая будет играть роль счетчика
			int count = 0;

			// проверяем входит ли значение координаты "X" в нашу область
			if (point[0] >= x_area[i][0] & point[0] <= x_area[i][1]) {

				for (int j = 0; j < y_area.length; j++) {
					
					// проверяем входит ли значение координаты "Y" в нашу область
					if (point[1] >= y_area[i][0] && point[1] <= y_area[i][1]) {
						// если координаты нас устроили увеличиваем счетчик и возвращаем try
						count++;
						return true;
					}

					else {
						continue;
					}

				}

			}

			else {
				continue;
			}
			
			// если счетчик больше нуля точка найдена и мы прекращаем цикл
			if (count > 0) {
				break;
			}
			return false;
		}
		return false;

	}

}
