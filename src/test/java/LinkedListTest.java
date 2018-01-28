import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void test_size_return_correct_size_of_linked_list() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        assertEquals(4, linkedList.size());
    }

    @Test
    public void getNthNodeFromLast() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        assertEquals(1, linkedList.getNthNodeFromLast(0));
        assertEquals(2, linkedList.getNthNodeFromLast(1));
        assertEquals(3, linkedList.getNthNodeFromLast(2));
        assertEquals(4, linkedList.getNthNodeFromLast(3));
    }

    @Test
    public void test_add_add_data_to_linked_list_correct_order() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        assertEquals(4, linkedList.getNthNode(0));
        assertEquals(3, linkedList.getNthNode(1));
        assertEquals(2, linkedList.getNthNode(2));
        assertEquals(1, linkedList.getNthNode(3));
    }
}