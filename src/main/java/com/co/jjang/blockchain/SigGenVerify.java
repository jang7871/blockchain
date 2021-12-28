package com.co.jjang.blockchain;

import java.security.Signature;

import org.apache.commons.codec.binary.Base64;

/**
 * ���ڼ����� ��ȣ�Ϳ� �ٸ��� �򹮰� ������ ��� A�� ����Ű�� ���ڼ����� �ϰ�(��, ��ȣȭ �� ���� ����), A�� ������ ���� ������
 * [A�� ����Ű+��+���ڼ���(S)]�� B���� ������. [(A�� ����Ű+��+���ڼ���(S)]�� ���� B�� A�� ����Ű�� �򹮰�
 * ���ڼ���(S')�� �����Ͽ� ���ڼ���(S) == ���ڼ���(S')�� ���̸� ���� ���� �Ǵ� ���� ���� ����.
 * 
 * @author Jang
 *
 */
public class SigGenVerify {
	private static String SIGNATURE_ALGORITHM = "SHA256withRSA";
	private static String CHASET = "UTF-8";
	private static int SIGNATURE_BLOCK_LENGTH = 172;

	// ���ڼ��� ����
	public static String generateSignature(String privateKey, String plainText) {
		try {
			Signature privateSignature = Signature.getInstance(SIGNATURE_ALGORITHM);
			privateSignature.initSign(RSAKey.generatePrivateKey(Base64.decodeBase64(privateKey.getBytes())));
			privateSignature.update(plainText.getBytes(CHASET));
			byte[] signature = privateSignature.sign();
			return Base64.encodeBase64String(signature);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// ���ڼ��� ����
	public static boolean verifySignature(String publicKey, String plainText, String sigData) {
		try {
			if (sigData.length() != SIGNATURE_BLOCK_LENGTH) {
				return false;
			}
			Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
			sig.initVerify(RSAKey.generatePublicKey(Base64.decodeBase64(publicKey.getBytes())));
			sig.update(plainText.getBytes());
			if (!sig.verify(Base64.decodeBase64(sigData))) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
