package co.com.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorBean {

	public int add(String numbers) throws Exception {

		int sum = 0;
		String delimiter = ",";
		if (numbers.equals("")) {
			return 0;
		}

		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, 3);
			int indexNewline = numbers.indexOf("\n");
			numbers = numbers.substring(indexNewline + 1);
		}

		numbers = numbers.replace("\n", delimiter);
		String[] cipher = numbers.split(delimiter);
		List<Integer> negatives = new ArrayList<Integer>();

		for (int i = 0; i < cipher.length; i++) {
			try {
				int numtmp = Integer.parseInt(cipher[i]);
				if(numtmp <= 1000){
					if(numtmp<0){
						negatives.add(numtmp);
					}
					sum = sum + numtmp;
				}
			} catch (NumberFormatException e) {
				System.out.println("the value " + cipher[i]
						+ " contains delimiters no specified");
				throw new Exception();
			}

		}
		if(negatives.size()>0){
			throw new Exception("Not support negative:" + negatives);
		}

		return sum;
	}
	

}
