package lib.linkedlist;

import resources.MessageKeys;
import resources.Messages;

public class SingleLinkedList {
	/**
	 * Constructor
	 */
	public SingleLinkedList() {
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
		if (tail == null) {
			head = node;
		} else {
			tail.setLink(node);
		}
		tail = node;
		++size;
	}
	
	/**
	 * Delete at specific position
	 * @param posToDelete
	 */
	public void deleteAtPosition(int posToDelete) {
		if (size == 0) {
			System.out.println(Messages.getMessage(MessageKeys.cannotDeleteEmpty));
			return;
		}
		if (posToDelete < 1 || posToDelete > size) {
			System.out.println(Messages.getMessage(MessageKeys.cannotDeleteInvalidPosition));
			return;
		}
		int currentPos = 1;
		Node currentNode = head;
		Node previousNode = null;
		while (currentPos < posToDelete) {
			previousNode = currentNode;
			currentNode = currentNode.getLink();
			++currentPos;
		}
		// delete at head
		if (previousNode == null) {
			head = currentNode.getLink();
		} else {
			previousNode.setLink(currentNode.getLink());
		}
		if (currentPos == size) {
			tail = previousNode;
		}
		--size;
	}
	
	/**
	 * Delete the tail
	 */
	public void deleteTail() {
		deleteAtPosition(size);
	}
	
	/**
	 * Delete all elements which have value greater than a value
	 * @param value
	 */
	public void deleteNodeBiggerThan(int value) {
		if (size == 0) {
			System.out.println(Messages.getMessage(MessageKeys.cannotDeleteEmpty));
			return;
		}
		Node currentNode = head;
		Node previousNode = null;
		while (currentNode != null) {
			if (currentNode.getValue() > value) {
				if (previousNode == null) {
					head = currentNode.getLink();
				} else {
					previousNode.setLink(currentNode.getLink());
				}
				if (currentNode.getLink() == null) {
					tail = previousNode;
				}
				--size;
			} else {
				previousNode = currentNode;
			}
			currentNode = currentNode.getLink();
		}
	}
	
	/**
	 * Print out the list
	 */
	public void print() {
		if (size == 0) {
			System.out.println(Messages.getMessage(MessageKeys.listIsEmpty));
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
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node start) {
		this.head = start;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
