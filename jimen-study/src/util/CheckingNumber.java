package util;

public class CheckingNumber {
	
	public static boolean checkNum(String num) {
		try {
			int how=Integer.parseInt(num);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	
}
