package com.co.jjang.blockchain;

import java.util.ArrayList;

public class Blockchain {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	private static int DIFFICULTY = 5; // 채굴 난이도

	// addBlock(); Block Add
	// isBlockchainValid(); Block Verify
	// readBlockchain(); JSON형식의 blockchain 파일을 Block 배열로 변환

	// blockchain을 json 파일로 바꾸는 것이가?
	public static void writeBlockchain(ArrayList<Block> blockchain) {
		try {
			// String jsonOutput = new
			// GsonBuilder().setPrettyPrinting().create().toJson(studentChain);
			// FileCtl.writeFile("blockchain.txt", jsonOutput, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// json 형식의 blockchain 파일을 Block 배열로 변환
	public static ArrayList<Block> readBlockchain() {
		try {
			// if (FileCtl.readFile("blockchain.txt") == null) return null;
			// String blockchainJson = FileCtl.readFile("blockchain.txt");
			/*
			 * ArrayList<StudentBlock> studentBlock = new Gson().fromJson(blockchainJson,
			 * new TypeToken<ArrayList<StudentBlock>>() { }.getType());
			 */
			// return studentBlock;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}