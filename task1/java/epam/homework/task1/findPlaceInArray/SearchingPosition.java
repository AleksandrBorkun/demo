package epam.homework.task1.findPlaceInArray;

public class SearchingPosition {

	private static int count = 0;

	public static void wherePaste(int arr1[], int arr2[]) {

		for (int i = 0; i < arr1.length; i++) {
			if (count == arr2.length)
				break;

			for (int j = 0; j < arr2.length; j++) {

				j = count;

				if (count == arr2.length)
					break;

				if (arr1[i] < arr2[j] && i == (arr1.length - 1)) {
					System.out
							.println("Paste " + j + " element of second array after " + (i) + " element of 1sr array");
					count++;

				} else if (arr1[i] < arr2[j]) {

					break;
				} else if (arr1[i] > arr2[j] && i == 0) {

					System.out.println("Paste " + j + " element of second array befor " + i + " element of 1sr array");
					count++;
					continue;
				}

				else if (arr1[i] > arr2[j] && i == (arr1.length - 1)) {
					System.out.println(
							"Paste " + j + " element of second array after " + (i - 1) + " element of 1sr array");
					count++;

				} else if (arr1[i] > arr2[j] && i != 0 && arr1[i + 1] < arr2[j]) {

					break;
				}

				else if (arr1[i] > arr2[j] && i != 0 && arr1[i + 1] > arr2[j]) {

					System.out.println(
							"Paste " + j + " element of second array after " + (i - 1) + " element of 1sr array");
					count++;
					continue;
				}

			}
		}
		return;
	}
}
