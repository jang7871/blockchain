package com.co.jjang.blockchain;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/*
 * ���ڴ� ��ȣŰ�� ��ȣȭ�� ���ڼ��� �� �� ���ÿ� ����ϱ� ���� RSA ��ȣ �˰����� ����ߴ�.
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
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
			return keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeySpecException e) {
			throw new IllegalArgumentException(e);
		}
	}

	// ���ڿ� Ÿ���� ����Ű�� ����Ű Ÿ������ ��ȯ
	public static PrivateKey generatePrivateKey(byte[] privateKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
			return keyFactory.generatePrivate(new X509EncodedKeySpec(privateKey));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (InvalidKeySpecException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
