package algocrate.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class TransactionDataGenerator {

    private static final String[] NAMES = {
        "Turing", "vonNeumann", "Dijkstra", "Hoare", "Thompson",
        "Knuth", "Shannon", "Lovelace", "Hopper", "Berners-Lee",
        "Torvalds", "Babbage", "Lamport", "Codd", "Backus"
    };
    
    private static final int RECORDS_TO_GENERATE = 1000; // Change this for more rows
    private static final String OUTPUT_FILE = "largeBatch.txt";

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            Random rand = new Random();
            DecimalFormat df = new DecimalFormat("0.00");

            for (int i = 0; i < RECORDS_TO_GENERATE; i++) {
                String name = NAMES[rand.nextInt(NAMES.length)];
                String date = generateRandomDate(rand);
                double amount = 10 + (9999.99 - 10) * rand.nextDouble();

                writer.write(String.format("%-15s %s %10s\n", name, date, df.format(amount)));
            }

            System.out.println("Generated " + RECORDS_TO_GENERATE + " transaction records in " + OUTPUT_FILE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomDate(Random rand) {
        int year = 1980 + rand.nextInt(46);  // 1980 to 2025
        int month = 1 + rand.nextInt(12);
        int day = 1 + rand.nextInt(28);  // Simplified (1-28) to avoid date validation issues
        return String.format("%2d/%2d/%4d", month, day, year);
    }
}
