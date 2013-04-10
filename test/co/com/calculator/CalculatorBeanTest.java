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
		assertTrue(calculator.add("1,2,3,4,3,6,9,2") == 30);
	}
	
	@Test
	public void testAddSumNumbersIntro() throws Exception {
		calculator = new  CalculatorBean();
		assertTrue(calculator.add("1\n2,3") == 6);
		assertTrue(calculator.add("1\n2,3\n7") == 13);
		
	}
	
	@Test
	public void testAddChangeDelimiter() throws Exception {
		calculator = new  CalculatorBean();
		
		assertTrue(calculator.add("//z\n1z2z3z4")==10);
		assertTrue(calculator.add("//%\n1%2%3%4")==10);
		assertTrue(calculator.add("//&\n1&2&3&4")==10);
		assertTrue(calculator.add("//#\n1#2#3#4")==10);
		
		Boolean existThrow=false;
		try {
			calculator.add("//z\n1z2^3z4");
		} catch (Exception e) {
			existThrow = true;
		}
		assertTrue(existThrow);
	}
	
	@Test
	public void testAddNegativeNumbers() {
		calculator = new  CalculatorBean();
		Boolean existThrow=false;
		try {
			calculator.add("1,3,-1,-7,-6,-2");
		} catch (Exception e) {
			existThrow = true;
			e.printStackTrace();
		}
		assertTrue(existThrow);
	}	
	
	@Test
	public void testAddNumbersBiggerIgnored() throws Exception {
		calculator = new  CalculatorBean();
		assertTrue(calculator.add("//;\n1;1001") == 1);
		assertFalse(calculator.add("//;\n1;1005") == 1006);
		assertTrue(calculator.add("2,1,1001,1005") == 3);
		
	}
	

}
