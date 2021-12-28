package com.co.jjang.blockchain;

import java.security.MessageDigest;

/**
 * 해시는 입력값(문자열 등)을 해시함수에 넣으면, 출력값으로 일정한 길이의 문자로 출력되는 기능을 가진 모든 함수 또는
 * 알고리즘이다. 입력값 중 한 글자라도 다르면 환전히 다른 출력값이 나온다. 해시 값은 입력 값이 같지 않으면, 모든 해시
 * 값은 중복되지 않는다.
 * @author Jangsung
 *
 */
public class Hash {
	public static String applySha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//Applies sha256 to our input,
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for(int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append("0");
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
