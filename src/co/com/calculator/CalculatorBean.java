package co.com.calculator;

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

		for (int i = 0; i < cipher.length; i++) {
			try {
				int numtmp = Integer.parseInt(cipher[i]);
				if(numtmp <= 1000){
					sum = sum + numtmp;
					validateNegative(sum);
				}
			} catch (NumberFormatException e) {
				System.out.println("the value " + cipher[i]
						+ " contains delimiters no specified");
				throw new Exception();
			}

		}

		return sum;
	}
	
	
	private boolean validateNegative(int number) throws Exception{
		if(number<0)
			throw new Exception("Not negatives");
		else
			return Boolean.TRUE;
	}

}
