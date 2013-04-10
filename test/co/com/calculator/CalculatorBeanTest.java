package co.com.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorBeanTest {

		
	CalculatorBean calculator;
	

	@Test
	public void testAddEmpty() throws Exception {
		calculator = new  CalculatorBean();
		assertTrue(calculator.add("") == 0);
	}
	
	@Test
	public void testAddSumNumbers() throws Exception {
		calculator = new  CalculatorBean();
		assertTrue(calculator.add("1") == 1);
		assertTrue(calculator.add("1,2") == 3);
		assertTrue(calculator.add("1,2,3") == 6);
		assertTrue(calculator.add("1,2,3,4") == 10);
	}
	
	@Test
	public void testAddSumNumbersIntro() throws Exception {
		calculator = new  CalculatorBean();
		assertTrue(calculator.add("1\n2,3") == 6);
	}
	
	@Test
	public void testAddChangeDelimiter() {
		calculator = new  CalculatorBean();
		Boolean existThrow=false;
		try {
			assertTrue(calculator.add("//;\n1;2^3;4") == 10);
		} catch (Exception e) {
			existThrow = true;
		}
		assertTrue(existThrow);
	}
	
	
	@Test
	public void testAddNumbersBigger() throws Exception {
		calculator = new  CalculatorBean();
		assertTrue(calculator.add("//;\n1;1001") == 1);
		assertFalse(calculator.add("//;\n1;1005") == 1006);
		
	}
	

}
