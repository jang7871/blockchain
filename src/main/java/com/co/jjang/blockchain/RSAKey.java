package com.co.jjang.blockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Base64;

/*
 * 저자는 암호키를 암호호와 전자서명 두 개 동시에 사용하기 위해 RSA 암호 알고리즘을 사용했다.
 * RSA 암호 알고리즘 보다 더 강력한 ECDSA(Elliptic Curve Digital Signature Algorithm)가 있지만
 * ECDSA는 암호화/복호화에 사용할 수 없다.
 */
public class RSAKey {
	public String privateKey;
	public String publicKey;
	private static String KEY_FACTORY_ALGORITHM = "RSA";
	private static int RSA_KEY_SIZE = 1024;

	// 생성자
	public RSAKey() {

	}

	// 키 쌍을 생성하여, 공개키와 개인키를 문자열 타입으로 변환
	public void generateKeyPair() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_FACTORY_ALGORITHM);
			generator.initialize(RSA_KEY_SIZE, new SecureRandom());
			KeyPair keyPair = generator.generateKeyPair();
			//privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
			//publicKey = Base64.en
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
