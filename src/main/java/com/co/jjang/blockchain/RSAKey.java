package com.co.jjang.blockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.binary.Base64;

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
		generateKeyPair();
	}

	// 문자열 타입의 공개키, 개인키 생성
	public void generateKeyPair() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_FACTORY_ALGORITHM);
			generator.initialize(RSA_KEY_SIZE, new SecureRandom());
			KeyPair keyPair = generator.generateKeyPair();
			privateKey = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
			publicKey = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 문자열 타입의 공개키를 공개키 타입으로 변환
	public static PublicKey generatePublicKey(byte[] publicKey) {
		try {
			return null;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeySpecException e) {
			throw new IllegalArgumentException(e);
		}

	}
}
