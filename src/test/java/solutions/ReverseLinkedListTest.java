package solutions;

import solutions.ReverseLinkedList;
import structure.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseLinkedListTest {
	
	private static ReverseLinkedList testInstance;
	@Before
	public void setUp() throws Exception {
		testInstance = new ReverseLinkedList();
	}

	@Test
	public void testReverseLindedList() {
		ListNode reversedList = testInstance.reverseLindedList(ListNode.generateList("3->2->1->0->null"));
		assertEquals(reversedList.toString(),"0->1->2->3->null");
	}
	

}
