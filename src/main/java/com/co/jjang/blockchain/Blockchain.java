package com.co.jjang.blockchain;

import java.util.ArrayList;

public class Blockchain {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	private static int DIFFICULTY = 5; // ä�� ���̵�

	// addBlock(); Block Add
	// isBlockchainValid(); Block Verify
	// readBlockchain(); JSON������ blockchain ������ Block �迭�� ��ȯ

	// blockchain�� json ���Ϸ� �ٲٴ� ���̰�?
	public static void writeBlockchain(ArrayList<Block> blockchain) {
		try {
			// String jsonOutput = new
			// GsonBuilder().setPrettyPrinting().create().toJson(studentChain);
			// FileCtl.writeFile("blockchain.txt", jsonOutput, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// json ������ blockchain ������ Block �迭�� ��ȯ
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