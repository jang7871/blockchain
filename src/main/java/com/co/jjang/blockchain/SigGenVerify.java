package com.co.jjang.blockchain;

import java.security.Signature;

import org.apache.commons.codec.binary.Base64;

/**
 * 전자서명은 암호와와 다르게 평문과 보내는 사람 A의 개인키로 전자서명을 하고(즉, 암호화 된 서명값 생성), A가 문서를 보낼 때에는
 * [A의 공개키+평문+전자서명값(S)]을 B에게 보낸다. [(A의 공개키+평문+전자서명값(S)]을 받은 B는 A의 공개키와 평문과
 * 전자서명값(S')를 생성하여 전자서명값(S) == 전자서명값(S')가 참이면 평문은 위조 또는 변조 되지 않음.
 * 
 * @author Jang
 *
 */
public class SigGenVerify {
	private static String SIGNATURE_ALGORITHM = "SHA256withRSA";
	private static String CHASET = "UTF-8";
	private static int SIGNATURE_BLOCK_LENGTH = 172;

	// 전자서명 생성
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

	// 전자서명 검증
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
