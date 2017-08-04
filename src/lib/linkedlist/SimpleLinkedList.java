package lib.linkedlist;

public class SimpleLinkedList {
	/**
	 * @category Constructor
	 */
	public SimpleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * @category Class variables
	 */
	protected Node head;
	protected Node tail;
	int size;
	
	/**
	 * @category Linked list methods
	 */
	/**
	 * Insert a node at the beginning of the list
	 * @param value
	 */
	public void insert(int value) {
		Node node = new Node(value, head);
		if (head == null) {
			tail = node;
		}
		head = node;
		++size;
	}
	
	/**
	 * Append a node at the end of the list
	 * @param value
	 */
	public void append(int value) {
		Node node = new Node(value);
		tail.setLink(node);
		tail = node;
	}
	
	/**
	 * Print out the list
	 */
	public void print() {
		if (size == 0) {
			System.out.print("List is empty!");
			return;
		}
		System.out.print(head.getValue());
		if (head.getLink() == null) {
			return;
		}
		Node currentNode = head.getLink();
		while (currentNode != null) {
			System.out.print(" -> ");
			System.out.print(currentNode.getValue());
			currentNode = currentNode.getLink();
		}
	}

	/**
	 * @category Getters & Setters
	 */
	public Node getStart() {
		return head;
	}

	public void setStart(Node start) {
		this.head = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
