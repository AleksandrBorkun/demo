package epam.homework.task1.findPlaceInArray;

import java.util.Arrays;

import epam.homework.task1.shellSort.Calculate;
import epam.homework.task1.workingWithArrays.RandomArrays;

public class findPastePlaces {

	public static void showWherePaste(int firstArrayLength, int secondArrayLength, int maxValue) {

		// создаем и сортируем два случайных массива
		int arr1[] = Calculate.sort(RandomArrays.createIntArray(firstArrayLength, maxValue));
		int arr2[] = Calculate.sort(RandomArrays.createIntArray(secondArrayLength, maxValue));

		System.out.println("First generetion array is: " + Arrays.toString(arr1));
		System.out.println("Second generetion array is: " + Arrays.toString(arr2));

		SearchingPosition.wherePaste(arr1, arr2);

	}
}
