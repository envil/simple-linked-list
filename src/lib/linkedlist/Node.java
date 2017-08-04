package lib.linkedlist;

class Node {
	/**
	 * Constructors
	 */
	public Node() {
		value = 0;
		link = null;
	}

	public Node(int value) {
		this.value = value;
		this.link = null;
	}

	public Node(int value, Node link) {
		this.value = value;
		this.link = link;
	}
	
	/**
	 * Class variables
	 */
	private int value;

	private Node link;

	/**
	 * Getters & Setters
	 * @return
	 */
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
}
