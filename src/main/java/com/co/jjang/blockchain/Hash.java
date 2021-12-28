package com.co.jjang.blockchain;

import java.security.MessageDigest;

/**
 * �ؽô� �Է°�(���ڿ� ��)�� �ؽ��Լ��� ������, ��°����� ������ ������ ���ڷ� ��µǴ� ����� ���� ��� �Լ� �Ǵ�
 * �˰����̴�. �Է°� �� �� ���ڶ� �ٸ��� ȯ���� �ٸ� ��°��� ���´�. �ؽ� ���� �Է� ���� ���� ������, ��� �ؽ�
 * ���� �ߺ����� �ʴ´�.
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
