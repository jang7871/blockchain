package com.co.jjang.blockchain;

import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * ��ȣȭ�� ����Ű�� ��ȣȭ�ϰ�, ����Ű�� ��ȣȭ�Ѵ�.
 * 
 * @author Jangsung
 *
 */
public class RsaEncrytDecrypt {

	private static String KEY_FACTORY_ALGORITHM = "RSA";
	private static int MAX_ENCRYPT_BLOCK = 117;
	private static int MAX_DECRYPT_BLOCK = 128;

	// ���� ����Ű�� ��ȣȭ, ���� ��ȣ������ ��ȯ
	public static String rsaEncrypt(String publicKey, String plainText) {
		String result = "";
		try {
			Cipher cipher = Cipher.getInstance(KEY_FACTORY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, RSAKey.generatePublicKey(Base64.decodeBase64(publicKey.getBytes())));
			byte[] inputArray = plainText.getBytes();
			int inputLength = inputArray.length;
			int offSet = 0;
			byte[] resultBytes = {};
			byte[] cache = {};

			for (int i = 0; i < inputLength; i++) {
				if (inputLength - offSet < MAX_ENCRYPT_BLOCK) {
					// cipher.doFinal(�� ����, �� ���� ����, �� ����)
					cache = cipher.doFinal(inputArray, offSet, MAX_ENCRYPT_BLOCK);
					offSet += MAX_ENCRYPT_BLOCK;
				} else {
					cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
					offSet = inputLength;
				}
				// Arrays.copyOf(source Data, copied Data);
				resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
				// System.arraycopy(src Data, src position, dest Data, dest position, new copied
				// length)
				System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
			}

			result = Base64.encodeBase64String(resultBytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	// ��ȣ���� ����Ű�� ��ȣȭ
}
