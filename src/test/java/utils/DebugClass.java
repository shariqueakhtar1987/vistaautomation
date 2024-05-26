package utils;


import java.io.IOException;




public class DebugClass {


	
	public static void main(String[] args) throws IOException {
		String BrowserList="Firefox,Chrome,Edge";
		String [] BrowserNameArr = BrowserList.split(",");
		System.out.println(BrowserNameArr.length);

		for (String x: BrowserNameArr) {
			System.out.println(x);
		}		 

	}
}
