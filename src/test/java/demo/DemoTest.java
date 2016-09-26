package demo;

import epam.homework.task4.demo;
import task_one.example;
import task_three.tableOfResul;

import org.testng.annotations.Test;

public class DemoTest {

	
	@Test
	public void test(){
		
	demo.theSimpleNumInArray(10, 100);
			
	}
	
	@Test
	public void secondTest(){
		
		example.showResult(0, 0);
		
	}
	
	@Test
	public void thirdTest(){
		tableOfResul.show(0, 100, 10);
	}
	
}
