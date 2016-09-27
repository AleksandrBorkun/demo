package epam.homework.task1.searchNumber;

import java.util.Arrays;

import epam.homework.task1.workingWithArrays.RandomArrays;

public class SearchSimple {

	public static void theSimpleNumInArray(int arrayLength, int maxValue) {

		int [] array = RandomArrays.createIntArray(arrayLength, maxValue);

		if (array.length == 0)
			System.out.println("The length is zero. So There is no any number");
		else
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
