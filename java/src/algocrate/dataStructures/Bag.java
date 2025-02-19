/******************************************************************************
 * 
 * A generic bag data structure, implemented using a singly linked list. 
 * 
 * Usage : 
 * % cat queen.txt 
 *   is this the real life is this just fantasy
 * % java Bag < test.txt
 * size of bag = 9
 * fantasy
 * just
 * this
 * is
 * life
 * real
 * the
 * this
 * is
 * 
 ******************************************************************************/

package algocrate.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import algocrate.utils.StdIn;

/*
 * The Bag class represents a bag ( or multiset ) of generic items. 
 * It supports insertion and interating over the items in arbitrary order.
 * 
 * This implementation uses a singly linked list with a static nested class Node
 * The isEmplty, and size operations take constant time. 
 * Iteration takes time proportional to the number of items. 
 */

public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first; // begining of bag
	private int n; // number of elements in bag

	// helper linked list class
	private static class Node<Item> {
		private Item item; // Store the data
		private Node<Item> next; // Pointer to the next node
	}

	/*
	 * Initialize an empty bag
	 */
	public Bag() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	/*
	 * Add the Item to this bag
	 */
	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	/*
	 * Returns an interator that interates over the items in this bag in arbitrary
	 * order. Since it's being implemented using a LinkedList, the iterator order
	 * should be reverse of addition to the bag
	 */
	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}

	// Doesn't support remove operation, for now
	private class LinkedIterator implements Iterator<Item> {
		private Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	/*
	 * Unit test for bag data type.
	 */
	public static void main(String[] args) {

		Bag<String> bag = new Bag<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			bag.add(item);
		}

		System.out.println("size of bag = " + bag.size());
		for (String s : bag) {
			System.out.println(s);
		}

	}
}
