package com.co.jjang.blockchain;

/**
 * ����� ����
 * ��Ʈ������ ��� 2020�� 7�� 14�� ���� 8�� 22�� ���� ����� ���̴� 639,142 �̴�.
 * @author Jangsung
 *
 */
public class Block {
	public String version; // ����� ������ ����Ʈ���� ����
	public String hash; // ����� �ּ� => SHA256(previousHash + merkleRoot + timeStamp + nonce)
	public String previousHash; // ���� ����� Hash. ���ü�ο��� ���� �������� ������ ����� Hash
	/*
	 * transaction ����� �Ǹ���+������+�ݾ��� �ؽ� �Է°����� �޾�, 2�� Ʈ�� �������� �ؽ��Ͽ� ���� �ֻ��� Hash
	 */
	public String merkleRoot;
	public long timeStamp; // ��� �����ð�. ���� �ð��� �ʷ� ����� �ð�. 1970�� 1�� 1�� 0�ʷκ��� ������� ��.
	public int nonce; // ����� Hash ���� ���ϱ� ���� ������ȣ.
	public int height; // ���ü�ο��� ����� ����. ���ü���� ���� ������ȣ ��.

	/*
	 * ��ϻ��� ���̵�. ��Ʈ���ο����� ����� ���� 10�п� �� ���� ������ �� �ֵ��� ���̵��� �ڵ� ����. ��, �ֱ� 2�ְ� ������ ����� ä��
	 * �ð��� ������� ������ 10�к��� ������, ���̵��� �ø���, 10�к��� ������ ���̵��� ���߰� �ڵ����� ���̵��� ������.
	 */
	public int difficulty;
	public String miner; // ����� ä���� ����
	public long mineTime; // ���ä�� �ҿ�ð�
	public int transactionsCnt; // ��Ͽ� ���Ե� �ŷ� ���

	// ��Ͽ� ���Ե� �ŷ� ���
	// public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
}
