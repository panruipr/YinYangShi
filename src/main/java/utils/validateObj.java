package utils;

public class validateObj {
	
	public static boolean isNotEmpty(String str){
		boolean flag = true;
		if("".equals(str) || null==str || "undefined".equals(str)){
			flag = false;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		isNotEmpty("");
	}

}
