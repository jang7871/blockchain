package com.co.jjang.blockchain;

import java.util.ArrayList;

public class Transaction {
	public String transactionId;// SHA256(sender+reciepient+value) ���� �ؽ��� ��
	public String sender; // ������ ��� �������� �ּ�(������ ��� �������� ����Ű)
	public String reciepinet; // �޴� ��� �������� �ּ�(�޴� ��� �������� ����Ű)
	public float value; // ������ ���ΰ�
	/*
	 * ����: ������� ���ڿ�(����)�� ���۰������� �������� �ʾҴٴ� �Ͱ� �� ������ ���� ������ٴ� ���� �����ϴ� ü��
	 */
	public String signature;
	public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
	// public ArrayList<TransactionOutput> ouputs = new
	// ArrayList<TransacionOutput>();
}
