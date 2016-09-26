package task_two;

class isLocated {

	public static void Local(int point[], int[][] x_area, int[][] y_area) {
		
		
		for (int i = 0; i < x_area.length; i++) {
			
			// добавляем переменную которая будет играть роль счетчика
			int count = 0;

			// проверяем входит ли значение координаты х в нашу область
			if (point[0] >= x_area[i][0] & point[0] <= x_area[i][1]) {

				for (int j = 0; j < y_area.length; j++) {
					
					// проверяем входит ли значение координаты у в нашу область
					if (point[1] >= y_area[i][0] && point[1] <= y_area[i][1]) {

						System.out.println("The point is located in our area");
						// если координаты нас устроили увеличиваем счетчик
						count++;
						break;
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
			System.out.println("The point does not located in our area");
		}

	}

}
