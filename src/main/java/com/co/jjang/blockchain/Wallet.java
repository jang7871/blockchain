package com.co.jjang.blockchain;

public class Wallet {
	public String owner;		// 소유주
	
	/*
	 * 정의: 개인만 알고있는 전자지갑 주소. 외부로 절대 오픈되서는 안됨. 코인 거래 시 외부로 오픈되면 나의 코인이
	 * 모두 사라질 수 있다. 또한, 개인키 주소를 잊어먹으면, 가지고 있는 코인을 영원히 찾을 수 없다.
	 * RSA 1024bit 개인키를 Base64 로 인코딩한 값.
	 * 개인키(비밀키)	: 공개불가
	 */
	public String privateKey;
	
	/*
	 * 정의: 외부에 공개하는 키(즉, 전자지갑 주소) 코인을 거래하는 주소. 은행의 계좌번호와 유사
	 * RSA 1024bit 공개키를 Base64 로 인코딩한 값.
	 * 공개키(주소)		: 공개 
	 */
	public String publicKey;
}
