
public class BaseConverter 
{
	public static final char[] HEX_CHARS = {'A','B','C','D','E','F'};
	public static final int[] HEX_VALS = {10, 11, 12, 13, 14, 15};
	
	/**
	 * Precondition: Parameter num is a number in base 2
	 * Postcondition: result is a number in base 10
	 * @param num
	 * @return result
	 */
	public static int convertBinary(int num) 
	{
		String s = num + "";
		int result = 0;
		int digitCounter = 0;
		for (int i = s.length() - 1; i >= 0; i--) 
		{
			result += Math.pow(2, digitCounter) * (num % 10);
			digitCounter++;
			num /= 10;
		}
		
		return result;
	}
	
	/**
	 * Precondition: Parameter num is a number in base 8
	 * Postcondition: result is a number in base 10
	 * @param num
	 * @return result
	 */
	public static int convertOctal(int num) 
	{
		String s = num + "";
		int result = 0;
		int digitCounter = 0;
		for (int i = s.length() - 1; i >= 0; i--) 
		{
			result += Math.pow(8, digitCounter) * (num % 10);
			digitCounter++;
			num /= 10;
		}
		
		return result;
	}
	
	/**
	 * Precondition: Parameter num is a number in base 16
	 * Postcondition: result is a number in base 10
	 * @param num
	 * @return result
	 */
	public static int convertHexadecimal(String num) 
	{
		int result = 0;
		int digitCounter = 0;
		boolean isChar = false;
		for (int i = num.length() - 1; i >= 0; i--) 
		{
			//for loop to check if char at index i is part of HEX_CHARS array
			for (int j = 0; j < HEX_CHARS.length; j++) 
			{
				if (num.charAt(i) == HEX_CHARS[j]) 
				{
					result += Math.pow(16, digitCounter) * HEX_VALS[j];
					isChar = true;
				}
			}
			
			if (!isChar) 
			{
				result += Math.pow(16, digitCounter) * (Integer.parseInt(num.charAt(i) + "") % 10);
			}
			
			digitCounter++;
			num = num.substring(0, i);
		}
		return result;
	}
	
	/**
	 * Precondition:  num is a number in base 10
	 * Postcondition: result is a number in the base the user chooses (binary, octal, hex)
	 * @param num, choice
	 * @return result
	 */
	public static int convertDecimal(int num, String choice) 
	{
		String s = num + "";
		String temp = "";
		String result = "";
		if ( choice.equalsIgnoreCase("Binary") ) 
		{
			for ( int i = 0; i <= s.length() + 1; i++ ) 
			{
				temp += num % 2 + "";
				num /= 2;
			}
		}
		
		else if ( choice.equalsIgnoreCase("Octal") ) 
		{
			for ( int i = 0; i <= s.length() + 1; i++ ) 
			{
				temp += num % 8 + "";
				num /= 8;
			}
		}	
		
		else if ( choice.equalsIgnoreCase("Hexadecimal") ) 
		{
			for ( int i = 0; i <= s.length() + 1; i++ ) 
			{
				if ( num % 16 > 9 ) 
				{
					
				}
				
				temp += num % 16 + "";
				num /= 16;
			}
		}
		
		for (int i = temp.length() - 1; i >= 0; i--) 
		{
			result += temp.charAt(i);
		}
		
		return Integer.parseInt(result);
	}
	
	
}
