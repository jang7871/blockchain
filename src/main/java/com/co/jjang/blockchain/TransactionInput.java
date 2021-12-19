package com.co.jjang.blockchain;

public class TransactionInput {
	public String transactionOutputId;
	public TransactionOutput UTXO; // 한번도 거래에 사용되지 않은 코인. 거래에 한 번 사용되면 그 코인은 사용할 수 없음.

}
