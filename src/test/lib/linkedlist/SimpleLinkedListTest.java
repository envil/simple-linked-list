package test.lib.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lib.linkedlist.Node;
import lib.linkedlist.SimpleLinkedList;
import resources.MessageKeys;
import resources.Messages;

@RunWith(Parameterized.class)
public class SimpleLinkedListTest {
	private final static int RANDOM_ARRAY_SIZE = 10000;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Parameterized.Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[RANDOM_ARRAY_SIZE][0]);
	}

	Random rand = new Random();
	private SimpleLinkedList emptyList;
	private SimpleLinkedList oneElementList;
	private SimpleLinkedList normalList;
	private SimpleLinkedList randomList;
	int randomValue;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));

		emptyList = new SimpleLinkedList();
		oneElementList = new SimpleLinkedList();
		normalList = new SimpleLinkedList();
		randomList = new SimpleLinkedList();

		oneElementList.append(10);
		normalList.append(25);
		normalList.append(100);
		normalList.append(30);
		normalList.append(15);
		normalList.append(30);
		normalList.append(30);
		normalList.append(30);
		normalList.append(30);
		normalList.append(20);
		normalList.append(30);
		normalList.append(40);
		randomValue = rand.nextInt(Integer.MAX_VALUE-1)+1;
		for (int i = 0; i < RANDOM_ARRAY_SIZE; i++) {
			int value = rand.nextInt(Integer.MAX_VALUE);
			randomList.append(value);
		}
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);

		emptyList = null;
		oneElementList = null;
		normalList = null;
		randomList = null;
	}

	@Test
	public void testInsertEmptyList() {
		emptyList.insert(randomValue);
		assertEquals(1, emptyList.getSize());
		assertEquals(randomValue, emptyList.getHead().getValue());
		isValidList(emptyList);
	}

	@Test
	public void testInsertOneElementList() {
		oneElementList.insert(randomValue);
		assertEquals(2, oneElementList.getSize());
		assertEquals(randomValue, oneElementList.getHead().getValue());
		isValidList(oneElementList);
	}

	@Test
	public void testInsertNormalList() {
		int normalListSize = normalList.getSize();
		normalList.insert(randomValue);
		assertEquals(normalListSize + 1, normalList.getSize());
		assertEquals(randomValue, normalList.getHead().getValue());
		isValidList(normalList);
	}

	@Test
	public void testInsertRandomList() {
		int randomListSize = randomList.getSize();
		randomList.insert(randomValue);
		assertEquals(randomListSize + 1, randomList.getSize());
		assertEquals(randomValue, randomList.getHead().getValue());
		isValidList(randomList);
	}

	@Test
	public void testAppendEmpty() {
		emptyList.append(randomValue);
		assertEquals(1, emptyList.getSize());
		assertEquals(randomValue, emptyList.getTail().getValue());
		isValidList(emptyList);
	}

	@Test
	public void testAppendOneElementList() {
		oneElementList.append(randomValue);
		assertEquals(2, oneElementList.getSize());
		assertEquals(randomValue, oneElementList.getTail().getValue());
		isValidList(oneElementList);
	}

	@Test
	public void testAppendNormalList() {
		int normalListSize = normalList.getSize();
		normalList.append(randomValue);
		assertEquals(normalListSize + 1, normalList.getSize());
		assertEquals(randomValue, normalList.getTail().getValue());
		isValidList(normalList);
	}

	@Test
	public void testAppendRandomList() {
		int randomListSize = randomList.getSize();
		randomList.append(randomValue);
		assertEquals(randomListSize + 1, randomList.getSize());
		assertEquals(randomValue, randomList.getTail().getValue());
		isValidList(randomList);
	}

	@Test
	public void testDeleteAtPositionInvalidPosition() {
		oneElementList.deleteAtPosition(-1);
		assertEquals(Messages.getMessage(MessageKeys.cannotDeleteInvalidPosition) + "\n", outContent.toString());
		isValidList(oneElementList);
		outContent.reset();
		normalList.deleteAtPosition(-1);
		assertEquals(Messages.getMessage(MessageKeys.cannotDeleteInvalidPosition) + "\n", outContent.toString());
		isValidList(normalList);
		outContent.reset();
		randomList.deleteAtPosition(-1);
		assertEquals(Messages.getMessage(MessageKeys.cannotDeleteInvalidPosition) + "\n", outContent.toString());
		isValidList(randomList);
	}

	@Test
	public void testDeleteAtPositionEmptyList() {
		emptyList.deleteAtPosition(randomValue);
		assertEquals(0, emptyList.getSize());
		assertEquals(Messages.getMessage(MessageKeys.cannotDeleteEmpty) + "\n", outContent.toString());
		isValidList(emptyList);
	}

	@Test
	public void testDeleteAtPositionOneElementList() {
		oneElementList.deleteAtPosition(1);
		assertEquals(0, oneElementList.getSize());
		isValidList(oneElementList);
	}

	@Test
	public void testDeleteAtPosition() {
		int randomListSize = randomList.getSize();
		randomList.deleteAtPosition(rand.nextInt(RANDOM_ARRAY_SIZE));
		assertEquals(randomListSize - 1, randomList.getSize());
		isValidList(randomList);
	}

	@Test
	public void testDeleteTailEmptyList() {
		emptyList.deleteTail();
		assertEquals(0, emptyList.getSize());
		assertEquals(Messages.getMessage(MessageKeys.cannotDeleteEmpty) + "\n", outContent.toString());
		isValidList(emptyList);
	}

	@Test
	public void testDeleteTailOneElementList() {
		oneElementList.deleteTail();
		assertEquals(0, oneElementList.getSize());
		isValidList(oneElementList);
	}

	@Test
	public void testDeleteTail() {
		int randomListSize = randomList.getSize();
		randomList.deleteTail();
		assertEquals(randomListSize - 1, randomList.getSize());
		isValidList(randomList);
	}

	@Test
	public void testDeleteNodeBiggerThanEmptyList() {
		emptyList.deleteNodeBiggerThan(RANDOM_ARRAY_SIZE);
		assertEquals(0, emptyList.getSize());
		assertEquals(Messages.getMessage(MessageKeys.cannotDeleteEmpty) + "\n", outContent.toString());
		isValidList(emptyList);
	}

	@Test
	public void testDeleteNodeBiggerThanOneElementListNoDeletion() {
		oneElementList.deleteNodeBiggerThan(100);
		assertEquals(1, oneElementList.getSize());
		isValidList(oneElementList);
	}

	@Test
	public void testDeleteNodeBiggerThanOneElementList() {
		oneElementList.deleteNodeBiggerThan(0);
		assertEquals(0, oneElementList.getSize());
		isValidList(oneElementList);
	}
	
	@Test
	public void testDeleteNodeBiggerThan() {
		randomList.deleteNodeBiggerThan(randomValue);
		Node currentNode = randomList.getHead();
		while (currentNode != null) {
			assertTrue(currentNode.getValue() <= randomValue);
			currentNode = currentNode.getLink();
		}
		isValidList(randomList);
	}

	private void isValidList(SimpleLinkedList list) {
		if (list.getSize() == 0) {
			assertEquals(null, list.getHead());
			assertEquals(null, list.getTail());
			return;
		}
		assertNotNull(list.getHead());
		assertNotNull(list.getTail());
		assertEquals(null, list.getTail().getLink());
		if (list.getSize() == 1) {
			assertEquals(null, list.getHead().getLink());
			assertEquals(null, list.getTail().getLink());
		}
		if (list.getSize() == 2) {
			assertEquals(list.getHead().getLink(), list.getTail());
		}
		int countNode = 0;
		Node currentNode = list.getHead();
		Node previousNode = null;
		while (currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.getLink();
			++countNode;
		}
		assertEquals(list.getTail(), previousNode);
		assertEquals(list.getSize(), countNode);
	}
}
