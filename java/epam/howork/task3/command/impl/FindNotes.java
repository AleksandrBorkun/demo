package epam.howork.task3.command.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import epam.howork.task3.bean.Request;
import epam.howork.task3.bean.Response;
import epam.howork.task3.command.Command;

public class FindNotes implements Command {

	public Response execute(Request request) {

		String line = null;
		int lineNumber = 0;
		Response response = new Response();
		Scanner in = new Scanner(System.in);
		System.out.println("Введите имя файла в котором нужно осуществить поиск");
		String fileName = in.nextLine() + ".txt";
		System.out.println("Введите ключевые слова для поиска");
		String keyWord = in.nextLine();
		File file = new File(fileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while ((line = br.readLine()) != null) {
				lineNumber++;
				if (line.contains(keyWord)) {
					System.out.println("Was found on the " + lineNumber + " line: " + line);
				}
			}
			if (lineNumber == 0)
				System.out.println("По заданному поиску ничего не найденно. Вы искали: " + keyWord);
			response.setErrorStatus(false);
			response.setResultMessage("Поиск завершен успешно");

		} catch (FileNotFoundException e1) {
			response.setErrorStatus(true);
			response.setErrorMessage("файл с таким именем: " + fileName + ". Попробуйте еще.");

		} catch (IOException e) {
			response.setErrorStatus(true);
			response.setErrorMessage("чтото пошло не так... имя файла " + fileName + ". Попробуйте еще.");

		}

		return response;
	}

}
