/******************************************************************************
 * 
 * A generic stack, implemented using a singly linked-list.
 * Each stack element is of type Item
 * 
 ******************************************************************************/

package algocrate.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<Item> implements Iterable<Item> {

	private Node<Item> first ; // top of the stack
	private int n; // size of the stack
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;  
	}
	
	// Empty stack constructor
	public Stack() {
		this.first = null;
		this.n = 0;
	}
	
	// Check if the stack is empty of not 
	public boolean isEmpty() {
		return first == null;
	}
	
	// size of the stack 
	public int size() {
		return n;
	}
	
	// add item at the top of the stack
	public void push(Item item) {
		Node<Item> oldfirst = first; 
		first = new Node<Item>(); 
		first.item = item; 
		first.next = oldfirst;
		n++;
	}
	
	// remove the top most item from the stack (LIFO)
	public Item pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack Underflow");
		}
		Node<Item> returnNode = first; 
		first = first.next; 
		Item returnItem = returnNode.item;
		returnNode = null; //for efficient garbage collection. 
		n--;
		return returnItem;
	}
	
	// Return, but does not remove the top most item on the stack 
	public Item peek() {
		if (isEmpty()) throw new NoSuchElementException("stack underflow");
		return first.item;
	}
	
	// String representation of the stack 
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Item item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}
	
	private class LinkedIterator implements Iterator<Item>  {
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
			if (!hasNext()) throw new NoSuchElementException();
			Item returnItem = current.item; 
			current = current.next;
			return returnItem;
		}
	}
}


































