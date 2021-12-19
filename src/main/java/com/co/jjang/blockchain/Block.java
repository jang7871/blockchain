package com.co.jjang.blockchain;

/**
 * 블록의 정의
 * 비트코인의 경우 2020년 7월 14일 오전 8시 22분 현재 블록의 높이는 639,142 이다.
 * @author Jangsung
 *
 */
public class Block {
	public String version; // 블록을 생성한 소프트웨어 버전
	public String hash; // 블록의 주소 => SHA256(previousHash + merkleRoot + timeStamp + nonce)
	public String previousHash; // 직전 블록의 Hash. 블록체인에서 가장 마지막에 생성된 블록의 Hash
	/*
	 * transaction 목록중 판매자+구매자+금액을 해시 입력값으로 받아, 2진 트리 형식으로 해시하여 가장 최상위 Hash
	 */
	public String merkleRoot;
	public long timeStamp; // 블록 생성시간. 현재 시간을 초로 계산한 시간. 1970년 1월 1일 0초로부터 현재까지 초.
	public int nonce; // 블록의 Hash 값을 구하기 위한 순차번호.
	public int height; // 블록체인에서 블록의 높이. 블록체인의 고유 순차번호 값.

	/*
	 * 블록생성 난이도. 비트코인에서는 블록이 거의 10분에 한 개씩 생성될 수 있도록 난이도를 자동 조절. 즉, 최근 2주간 생성된 블록의 채굴
	 * 시간을 평균으로 나누어 10분보다 적으면, 난이도를 올리고, 10분보다 높으면 난이도를 낮추게 자동으로 난이도를 조절함.
	 */
	public int difficulty;
	public String miner; // 블록을 채굴한 광부
	public long mineTime; // 블록채굴 소요시간
	public int transactionsCnt; // 블록에 포함된 거래 목록

	// 블록에 포함된 거래 목록
	// public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
}
