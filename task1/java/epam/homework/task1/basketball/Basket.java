package epam.homework.task1.basketball;

public class Basket {

	private static int sumOfWeight;

	public static void fillTheBasket(int countOfGreenBalls, int countOfRedBalls, int countOfBlueBalls,
			int countOfOrangeBalls) {

		Ball green = new Ball("Green", 10);
		Ball red = new Ball("Red", 15);
		Ball blue = new Ball("Blue", 7);
		Ball orange = new Ball("Orange", 35);

		sumOfWeight = countOfGreenBalls * green.getBallWeight() + countOfRedBalls * red.getBallWeight()
				+ countOfBlueBalls * blue.getBallWeight() + countOfOrangeBalls * orange.getBallWeight();

		System.out.println("Корзина заполнена! Вес мячиков в корзине составил: " + sumOfWeight
				+ ". Количество синих мячиков равно: " + countOfBlueBalls);

		return;
	
	}
	
}
