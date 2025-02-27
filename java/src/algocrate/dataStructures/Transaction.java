/******************************************************************************
 * 
 * A data type for commercial transactions.
 * An immutable data type for encapsulating commercial transactions with a customer name, date and amount.  
 * 
 ******************************************************************************/


package algocrate.dataStructures;



public class Transaction implements Comparable<Transaction> {
	private final String who; //customer
	private final Date when; // date
	private final double amount; // amount
}
