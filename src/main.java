import lib.linkedlist.SimpleLinkedList;

public class main {
	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		list.append(100);
		list.append(30);
		list.append(15);
		list.append(30);
		list.append(30);
		list.append(30);
		list.append(30);
		list.append(20);
		list.append(30);
		list.append(40);
		list.insert(25);
		System.out.println("Initial list:");
		list.print();
		list.deleteTail();
		System.out.println("\nDeleted tail list:");
		list.print();
		list.deleteNodeBiggerThan(25);
		System.out.println("\nDeleted nodes which have value > 25 list:");
		list.print();
	}
}
