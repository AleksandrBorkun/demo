package epam.homework.task4;

import java.util.Arrays;

public class demo {

	public static void theSimpleNumInArray(int arrayLength, int maxValue) {

		int array[] = new int[arrayLength];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() * maxValue + 1));
		}

		System.out.println("The genereting array is: " + Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {

			if (array[i] == 1 || array[i] == 2 || array[i] == 3) {
				System.out.println("The " + array[i] + " is a simple number, and its on " + i + " position");
			}

			else {
				for (int j = 2; j < array[i] / 2; j++) {
					if (array[i] % j != 0 && j == (array[i] / 2 - 1)) {
						System.out.println("The " + array[i] + " is a simple number, and its on " + i + " position");
					} else if (array[i] % j == 0) {
						break;
					} else
						continue;
				}
			}

		}

		return;
	}

}
