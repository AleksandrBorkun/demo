package epam.homework.task1.workingWithArrays;

public class RandomArrays {

	public static int[] createIntArray(int arrayLength, int maxValue) {

		int array[] = new int[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() * maxValue + 1));
		}

		return array;

	}
}
