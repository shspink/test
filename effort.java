package fly;

import java.util.ArrayList;
import java.util.Arrays;

public class effort {

	static boolean one_edit(String test_text, String test_text2) {
		int i = 0;
		String shorter_text = "";
		String longer_text = "";
		boolean first_edit = false;
//두 문자열 길이 차이 2 이상이면 false  문자길이 같거나 1차이
		if (test_text.length() > test_text2.length()) {
			shorter_text = test_text2;
			longer_text = test_text;
			if (test_text.length() - test_text2.length() > 1)
				return false;
		} else {
			shorter_text = test_text;
			longer_text = test_text2;
			if (test_text2.length() - test_text.length() > 1)
				return false;
		}

		// 길이 0 차이 날 때 , 문자 교체 => 하나의 문자만 틀려야함

		if (test_text.length() == test_text2.length()) {
			while (i != test_text.length()) {

				if (test_text.charAt(i) != test_text2.charAt(i)) {
					if (!first_edit)
						first_edit = true;
					else
						return false;
				}

				i++;
			}

		}
		
		// 길이 1 차이 날 때, 문자 삭제 또는 문자 삽입 수행
		
		else {
			i = 0;
			while (i != shorter_text.length()) {

				if (longer_text.charAt(i) != shorter_text.charAt(i)) {
					if (!first_edit) {
						shorter_text = shorter_text.substring(0, i) + " " + shorter_text.substring(i);
						System.out.println("CHANGE shorter_text :"+ shorter_text);
						first_edit = true;
					}
					else
						return false;
				}
				i++;
			}
		}

		return true;

	}

	// -33 필요 => index 값 도출
	// ASCII 33 ~ 126

	public static void main(String[] args) {
		String test_text = "12345";
		String test_text2 = "2355";
		if (one_edit(test_text, test_text2))
			System.out.println("ture");
		else
			System.out.println("false");

	}

}
