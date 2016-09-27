package epam.homework.task1.matrix;

import java.util.Arrays;

public class Calculate {

	private static int[] mixFirstToLast(int startArray[]) {

		int count = 0;
		int newEnd = 0;

		for (int i = 0; i < startArray.length - 1; i++) {

			if (count == 0) {
				newEnd = startArray[0];
				count++;
			}
			startArray[i] = startArray[i + 1];
			if (i == startArray.length - 2) {
				startArray[startArray.length - 1] = newEnd;

			}

		}
		return startArray;
	}

	public static void showTheMatrix(int[] startArray) {

		int count = 0;
		int arr2[][] = new int[startArray.length][];

		for (int i = 1; i < startArray.length; i++) {

			if (count == 0) {
				arr2[0] = startArray;
				System.out.println(Arrays.toString(arr2[0]));
				count++;
			}

			if (i != 1) {
				arr2[i] = Calculate.mixFirstToLast(arr2[i - 1]);
				System.out.println(Arrays.toString(arr2[i]));
				continue;
			}

			arr2[i] = Calculate.mixFirstToLast(startArray);
			System.out.println(Arrays.toString(arr2[i]));
		}
		return;
	}

}
