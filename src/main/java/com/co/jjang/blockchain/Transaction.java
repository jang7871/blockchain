package com.co.jjang.blockchain;

import java.util.ArrayList;

public class Transaction {
	public String transactionId;// SHA256(sender+reciepient+value) 으로 해시한 값
	public String sender; // 보내는 사람 전자지갑 주소(보내는 사람 전자지갑 공개키)
	public String reciepinet; // 받는 사람 전자지갑 주소(받는 사람 전자지갑 공개키)
	public float value; // 보내는 코인값
	/*
	 * 정의: 만들어진 문자열(문자)이 전송과정에서 변조되지 않았다는 것과 본 문장을 내가 만들었다는 것을 증명하는 체계
	 */
	public String signature;
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	// public ArrayList<TransactionOutput> ouputs = new
	// ArrayList<TransacionOutput>();
}
