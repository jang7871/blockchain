package com.co.jjang.blockchain;

import java.util.ArrayList;

/**
 * 보통 코인거래소 회원가입 시 나의 전자지갑도 함께 생성된다. 또는, 코인거래소에서 별도로 전자지갑 생성 요청을 하여 생성한다. 그러면,
 * 아래 자바 소스 처럼 전자지갑 공개키와 개인키를 내 회원 ID와 매핑을 하고 거래소 DB에 저장한다. 거래소에서 공개키는 확인이 가능하지만
 * 개인키는 내 지갑임에도 불구하고, 거의 확인이 되지 않는다. 코인 전송 시 내부적으로 개인키로 전자서명하여 전송한다. 참고적으로 해킹을
 * 당해 코인을 강탈 당했다는 뉴스를 종종 접하는데, 이는 블록체인이 해킹 당한 것이 아니라, 코인거래소가 보안취약점으로 인해 해킹되어
 * 개인키가 해커에게 유출되어 해커가 해킹한 개인키로 코인을 해커의 전자지갑 주소(공개키)로 전송하는 것이다. 해어킈 전자지갑 주소(공개키)
 * 소유주가 누구인지 알 수 없기 때문에 전송한 코인은 찾을 수 없다. 여기서, 시사점은 가상화폐 거래에서 개인키는 절대로 유출되면 안됨.
 * 전자지갑 클래스
 * 
 * @author Jangsung
 *
 */
public class Wallet {
	public String owner; // 소유주

	/*
	 * 정의: 개인만 알고있는 전자지갑 주소. 외부로 절대 오픈되서는 안됨. 코인 거래 시 외부로 오픈되면 나의 코인이 모두 사라질 수 있다.
	 * 또한, 개인키 주소를 잊어먹으면, 가지고 있는 코인을 영원히 찾을 수 없다. RSA 1024bit 개인키를 Base64 로 인코딩한 값.
	 * 개인키(비밀키) : 공개불가
	 */
	public String privateKey;

	/*
	 * 정의: 외부에 공개하는 키(즉, 전자지갑 주소) 코인을 거래하는 주소. 은행의 계좌번호와 유사 RSA 1024bit 공개키를 Base64
	 * 로 인코딩한 값. 공개키(주소) : 공개
	 */
	public String publicKey;
	private static ArrayList<Block> blockchain = new ArrayList<Block>();
	private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	// 생성자
	public Wallet() {
		blockchain = Blockchain.readBlockchain();
		//transactions = Mempool.readMempool();
	}

	
}
