package com.co.jjang.blockchain;

import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * 암호화는 공개키로 암호화하고, 개인키로 복호화한다.
 * 
 * @author Jangsung
 *
 */
public class RsaEncrytDecrypt {

	private static String KEY_FACTORY_ALGORITHM = "RSA";
	private static int MAX_ENCRYPT_BLOCK = 117;
	private static int MAX_DECRYPT_BLOCK = 128;

	// 평문을 공개키로 암호화, 평문을 암호문으로 변환
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
					// cipher.doFinal(평문 길이, 평문 시작 지점, 평문 길이)
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
	// 암호문을 개인키로 복호화
}
