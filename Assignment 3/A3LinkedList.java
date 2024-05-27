// Name:
// Student number: v00

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node n = new A3Node(s);
		if (head == null) {
			head = n;
			tail = n;
			
			length = 1;
		}
		else {
			n.next = head;
			head.prev = n;
			head = n;
			
			length++;

		}
	}
	

	public void addBack(String s) {
		A3Node n = new A3Node(s);
		if (tail == null) {
			head = n;
			tail = n;
			
			length = 1;
		}
		else {
			tail.next = n;
			n.prev = tail;
			tail = n;
			
			length++;
		}
		
	}

	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		if (head != null) {
			A3Node temp = head;
        	head = head.next;

		}
	}
	
	public void removeBack() {
		A3Node cur = head;
		while (cur.next.next != null) {
			cur = cur.next;
		}
		cur.next = null;
	
	}
	
	public void removeAt(int pos) {
		if (pos == 0) {
			removeFront();
		}
		else if (pos == length-1) {
			removeBack();
		}
		else if (pos >= length) {

		}
		
		else {
			A3Node cur = head;
			for (int i = 0; i < pos-1; i++) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		

		}
		length--;
		
	}

	
	public A3LinkedList mergeSorted(A3LinkedList other) {
		A3LinkedList merged = new A3LinkedList();
		
		if (head == null) {
			return other;
		}
		
		else if (other.head == null) {
		}

		A3Node cur = merged.head;

		A3Node temp1 = head;
    	A3Node temp2 = other.head;

		

		
		while (temp1 != null && temp2 != null && cur != null) {
			if (temp1.comesBefore(temp2)) {
				cur = temp1;
				cur = cur.next;
				length++;
			}
			else {
				cur = temp2;
				cur = cur.next;
				length++;
			}
		}
		return merged;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	