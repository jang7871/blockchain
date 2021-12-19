package com.co.jjang.blockchain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Base64;

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

	}

	// Ű ���� �����Ͽ�, ����Ű�� ����Ű�� ���ڿ� Ÿ������ ��ȯ
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
