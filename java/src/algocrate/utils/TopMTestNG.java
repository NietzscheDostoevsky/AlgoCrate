// A testing client for Priority Queue ADT using TestNG
// Transactions are sorted by their natural order of 'amount'


package algocrate.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import algocrate.dataStructures.Stack;
import algocrate.dataStructures.Transaction;
import algocrate.dataStructures.MinPQ;

public class TopMTestNG {

	private static final int M = 5; // Top M transactions to keep. 
	private List<Transaction> transactions;
	private Stack<Transaction> topTransactions;
	
	@BeforeClass
	public void setup() throws IOException {
		transactions = new ArrayList<Transaction>();
		topTransactions = new Stack<Transaction>(); 
		
		// Reading transactions from the test data file, tinyBatch.txt
		try (BufferedReader reader = new BufferedReader(new FileReader("../java/src/algocrate/utils/tinyBatch.txt"))) {
			String line;
			MinPQ<Transaction> pq = new MinPQ<>(M + 1); // MinPQ maintaining top M elements. 
			
			while ((line = reader.readLine()) != null) {
				Transaction transaction = new Transaction(line) ; 
				transactions.add(transaction);
				pq.insert(transaction);
				
				if (pq.size() > M) {
					pq.delMin(); // Remove the smallest elements if size exceeds M
				}
			}
			
			while (!pq.isEmpty()) {
				topTransactions.push(pq.delMin());
			}
		}
	}
	
	@Test
	public void testTopMSize() {
		Assert.assertEquals(topTransactions.size(), M, "Stack should contains exactly M elements");
	}
	
	@Test
	public void testTransactionsPresence() {
		for (Transaction t : topTransactions) {
			Assert.assertTrue(transactions.contains(t), "Top M transactions should exist in the input data");
		}
	}
	
	@Test
	public void printTopTransactions() {
		for (Transaction t : topTransactions) 
			System.out.println(t.toString());
	}
}









































