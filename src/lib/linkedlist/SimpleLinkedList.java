package lib.linkedlist;

public class SimpleLinkedList {
	/**
	 * Constructor
	 */
	public SimpleLinkedList() {
		this.start = null;
		this.size = 0;
	}

	/**
	 * Class variables
	 */
	protected Node start;
	int size;

	/**
	 * Getters & Setters
	 * @return
	 */
	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
