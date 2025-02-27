package algocrate.dataStructures;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TransactionTest {

    @Test
    public void testTransactionParsing() {
        Transaction t = new Transaction("Turing 6/17/1990 644.08");
        Assert.assertEquals(t.who(), "Turing");
        Assert.assertEquals(t.when(), new Date("6/17/1990"));
        Assert.assertEquals(t.amount(), 644.08, 0.001);
    }

    @Test
    public void testCompareByAmount() {
        Transaction t1 = new Transaction("Alice 1/1/2020 100.50");
        Transaction t2 = new Transaction("Bob 2/2/2021 200.75");

        Assert.assertTrue(t1.compareTo(t2) < 0, "t1 should be smaller than t2");
        Assert.assertTrue(t2.compareTo(t1) > 0, "t2 should be greater than t1");
    }

    @Test
    public void testCompareByWho() {
        Transaction t1 = new Transaction("Alice 1/1/2020 100.50");
        Transaction t2 = new Transaction("Bob 2/2/2021 200.75");

        Transaction.WhoOrder whoOrder = new Transaction.WhoOrder();
        Assert.assertTrue(whoOrder.compare(t1, t2) < 0, "Alice should come before Bob");
    }

    @Test
    public void testCompareByWhen() {
        Transaction t1 = new Transaction("Alice 1/1/2020 100.50");
        Transaction t2 = new Transaction("Bob 2/2/2021 200.75");

        Transaction.WhenOrder whenOrder = new Transaction.WhenOrder();
        Assert.assertTrue(whenOrder.compare(t1, t2) < 0, "1/1/2020 should be before 2/2/2021");
    }

    @Test
    public void testSortingByAmountDescending() {
        Transaction[] transactions = {
            new Transaction("Alice 1/1/2020 100.50"),
            new Transaction("Bob 2/2/2021 200.75"),
            new Transaction("Charlie 3/3/2022 50.25")
        };

        Arrays.sort(transactions, (o1, o2) -> Double.compare(o2.amount(), o1.amount()));

        Assert.assertEquals(transactions[0].who(), "Bob");     // Highest amount
        Assert.assertEquals(transactions[1].who(), "Alice");   // Middle amount
        Assert.assertEquals(transactions[2].who(), "Charlie"); // Lowest amount
    }

    @Test
    public void testSortingByDate() {
        Transaction[] transactions = {
            new Transaction("Alice 5/5/2022 100.00"),
            new Transaction("Bob 3/3/2021 200.00"),
            new Transaction("Charlie 1/1/2020 50.00")
        };

        Arrays.sort(transactions, new Transaction.WhenOrder());

        Assert.assertEquals(transactions[0].who(), "Charlie"); // Earliest date
        Assert.assertEquals(transactions[1].who(), "Bob");
        Assert.assertEquals(transactions[2].who(), "Alice");   // Latest date
    }
}
