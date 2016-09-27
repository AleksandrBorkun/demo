package epam.homework.task1.shellSort;

import java.util.Arrays;

import epam.homework.task1.workingWithArrays.RandomArrays;

public class sortShella {

	public static void printResult(int arrayLength, int maxValue) {

		int array[] = RandomArrays.createIntArray(arrayLength, maxValue);

		System.out.println("The generation array is: " + Arrays.toString(array));
		System.out.println(Calculate.sort(array));
		return;

	}

	public static int[] getSortArray(int arrayLength, int maxValue) {

		int array[] = RandomArrays.createIntArray(arrayLength, maxValue);

		return Calculate.sort(array);

	}

}
