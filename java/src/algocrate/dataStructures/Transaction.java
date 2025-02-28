/******************************************************************************
 * 
 * A data type for commercial transactions.
 * An immutable data type for encapsulating commercial transactions with a customer name, date and amount.  
 * 
 ******************************************************************************/


package algocrate.dataStructures;

import java.util.Comparator;

public class Transaction implements Comparable<Transaction> {
	private final String who; //customer
	private final Date when; // date
	private final double amount; // amount

	//Constructor with String, Date and Double input type
	public Transaction(String who, Date when, Double amount) {
		if (Double.isNaN(amount) || Double.isInfinite(amount)) {
			throw new IllegalArgumentException("Amount can't be NaN or Infinite");
		}
		
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	//Constructor with String datatype containing a transaction
	public Transaction(String transaction) {
		String[] a = transaction.split("\\s+");
		this.who = a[0]; 
		this.when = new Date(a[1]);
		this.amount = Double.parseDouble(a[2]);
		if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
		
	}
	
	public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Transaction that = (Transaction) other;
        return (this.amount == that.amount) && (this.who.equals(that.who))
                                            && (this.when.equals(that.when));
    }

    public int hashCode() {
        int hash = 1;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash + ((Double) amount).hashCode();
        return hash;
        // return Objects.hash(who, when, amount);
    }
    
    @Override
    public String toString() {
    	return String.format("%-10s %10s %8.2f", who, when, amount);
    }
    
    public static class WhoOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction v, Transaction w) {
            return v.who.compareTo(w.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction v, Transaction w) {
            return v.when.compareTo(w.when);
        }
    }

     public static class HowMuchOrder implements Comparator<Transaction> {

        @Override
        public int compare(Transaction v, Transaction w) {
            return Double.compare(v.amount, w.amount);
        }
    }

}



















































