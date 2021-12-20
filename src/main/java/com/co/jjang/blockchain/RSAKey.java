package com.co.jjang.blockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.binary.Base64;

/*
 * ���ڴ� ��ȣŰ�� ��ȣȣ�� ���ڼ��� �� �� ���ÿ� ����ϱ� ���� RSA ��ȣ �˰����� ����ߴ�.
 * RSA ��ȣ �˰��� ���� �� ������ ECDSA(Elliptic Curve Digital Signature Algorithm)�� ������
 * ECDSA�� ��ȣȭ/��ȣȭ�� ����� �� ����.
 */
public class RSAKey {
	public String privateKey;
	public String publicKey;
	private static String KEY_FACTORY_ALGORITHM = "RSA";
	private static int RSA_KEY_SIZE = 1024;

	// ������
	public RSAKey() {
		generateKeyPair();
	}

	// ���ڿ� Ÿ���� ����Ű, ����Ű ����
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

	// ���ڿ� Ÿ���� ����Ű�� ����Ű Ÿ������ ��ȯ
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
