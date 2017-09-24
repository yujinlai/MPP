package lesson10.labs.prob6;

public class QueueThreadSafe {
	class Node {
		Object value;
		Node next;
	}

	private Node head;
	private Node tail;

	synchronized public void add(Object newValue) {
		Node n = new Node();
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		tail.value = newValue;
	}

	synchronized public Object remove() {
		if (head == null)
			return null;
		Node n = head;
		head = n.next;
		return n.value;
	}
}
