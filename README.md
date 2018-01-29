# SR Education Coding Questions

I approach each problem using TDD method, meaning I first created a test case before implementing a function to ensure that my logic is correct. Every test case passes.

### Run
```
cd PROJECT_PATH
./gradlew clean build
./gradlew test # to run all tests
```

### Question 1:
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

### Solution to Question 1:

#### BinaryTree and BinaryTreeNode class
```java
public class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    BinaryTreeNode root;

    public boolean isBlanced(BinaryTreeNode binaryTreeNode) {

        if(binaryTreeNode == null) return true;

        return Math.abs(height(binaryTreeNode.left) - height(binaryTreeNode.right)) <= 1 && isBlanced(binaryTreeNode.left) && isBlanced(binaryTreeNode.right);
    }

    public int height(BinaryTreeNode binaryTreeNode) {

        if(binaryTreeNode == null) return 0;

        return 1 + Math.max(height(binaryTreeNode.left), height(binaryTreeNode.right));
    }
}
```

#### Unit tests
```java
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    @Test
    public void isBlanced_return_true_if_tree_is_balanced() {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.left = new BinaryTreeNode(5);
        tree.root.right.right = new BinaryTreeNode(7);

        assertTrue(tree.isBlanced(tree.root));
    }

    @Test
    public void isBlanced_return_true_if_there_is_one_difference() {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.left = new BinaryTreeNode(5);

        assertTrue(tree.isBlanced(tree.root));
    }

    @Test
    public void isBlanced_return_false_if_tree_not_balanced() {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(4);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(1);
        tree.root.left.right = new BinaryTreeNode(3);

        tree.root.right = new BinaryTreeNode(6);
        tree.root.right.right = new BinaryTreeNode(8);
        tree.root.right.right.right = new BinaryTreeNode(9);
        tree.root.right.right.right.right = new BinaryTreeNode(15);

        assertFalse(tree.isBlanced(tree.root));
    }
}
```

### Question 2:
Implement a MyQueue class which implements a queue using two stacks.

### Solution to Question 2:

#### MyQueue class
```java
import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    public int size() {
        return this.stack1.size() + this.stack2.size();
    }

    public void enQueue(int num) {
        stack1.push(num);
    }

    public int deQueue() {
        if (isEmpty()) throw new IllegalArgumentException("queue is empty");

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int first() {
        if (isEmpty()) throw new IllegalArgumentException("queue is empty");

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }
}
```

#### Unit tests
```java
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void isEmpty() {
        MyQueue myQueue = new MyQueue();
        assertTrue(myQueue.isEmpty());

        myQueue.enQueue(1);
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void size() {
        MyQueue myQueue = new MyQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        assertEquals(3, myQueue.size());
    }

    @Test
    public void test_enQueue_and_deQueue() {
        MyQueue myQueue = new MyQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);

        assertEquals(1, myQueue.deQueue());
        assertEquals(2, myQueue.deQueue());
        assertEquals(3, myQueue.deQueue());
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void first() {
        MyQueue myQueue = new MyQueue();

        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);

        assertEquals(1, myQueue.first());
    }
}
```

### Question 3:
Implement an algorithm to find the kth to last element of a singly linked list.

### Solution to Question 3:
I created the method called "getNthNodeFromLast()" to solve this problem.

#### LinkedList class
```java
public class LinkedList {

    public Node head;

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int size() {
        int size = 0;

        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            size++;
        }

        return size;
    }

    public int getNthNode(int n) {
        int size = size();
        Node tmp = head;

        if (size < n) throw new IllegalArgumentException("N cannot be larger than linked list size");

        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }

        return tmp.data;
    }

    public int getNthNodeFromLast(int n) {

        int size = size();
        Node tmp = head;

        if (size < n) throw new IllegalArgumentException("N cannot be larger than linked list size");

        for (int i = 0; i < size - 1 - n ; i++) {
            tmp = tmp.next;
        }

        return tmp.data;
    }

    public void add(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        this.head = newNode;
    }


}
```

#### Unit tests
```java
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
```

#### Test result
```java
case: getNthNodeFromLast
 assertEquals(1, linkedList.getNthNodeFromLast(0)); // correctly return the value (1) of position 0 from last
 assertEquals(2, linkedList.getNthNodeFromLast(1)); // correctly return the value (2) of position 1 from last
 assertEquals(3, linkedList.getNthNodeFromLast(2)); // correctly return the value (3) of position 2 from last
 assertEquals(4, linkedList.getNthNodeFromLast(3)); // correctly return the value (4) of position 3 from last
```

### Question 4:
Write a program that outputs all possibilities to put the operators '+', '-', or nothing between the numbers 1,2,...,9 (in this order) such that the result is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.

### Solution to Question 4:
I choose to this problem using a recursive pattern to make all the problem less complicated. I categorized into 3 cases: "+", "-", and "concatenate numbers", and created a function which recursively runs correspondingly to the cases. 

#### MakingAHundred class
```java
public class MakingAHundred {

    private static final int TARGET_NUMBER = 100;
    private static final int[] NUMS = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private static void printAllPossibilities(int sum, int number, int index, String str) {

        if (index >= NUMS.length) {
            if (sum + number == TARGET_NUMBER) {
                System.out.println(concatStr(str, number));
            }

            return;
        }

        printAllPossibilities(sum + number, NUMS[index], index + 1, concatStr(str, number));
        printAllPossibilities(sum + number, -NUMS[index], index + 1, concatStr(str, number));
        printAllPossibilities(sum, concatenatedNumber(number, index), index + 1, str);
    }

    public static void printAllPossibilities() {
        printAllPossibilities(0, NUMS[0], 1, "");
    }

    private static int concatenatedNumber(int number, int index) {
        return number >= 0 ? 10 * number + NUMS[index] : 10 * number - NUMS[index];
    }

    private static String concatStr(String str, int num) {
        return num >= 0 ? str + " + " + num : str + " - " + - num;
    }
}
```

#### Unit tests

```java
import org.junit.Test;

public class MakingAHundredTest {

    @Test
    public void printAllPossibilities() {
        MakingAHundred.printAllPossibilities();
    }

}
```
#### Test result
```
case: printAllPossibilities
 + 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9
 + 1 + 2 + 34 - 5 + 67 - 8 + 9
 + 1 + 23 - 4 + 5 + 6 + 78 - 9
 + 1 + 23 - 4 + 56 + 7 + 8 + 9
 + 12 + 3 + 4 + 5 - 6 - 7 + 89
 + 12 + 3 - 4 + 5 + 67 + 8 + 9
 + 12 - 3 - 4 + 5 - 6 + 7 + 89
 + 123 + 4 - 5 + 67 - 89
 + 123 + 45 - 67 + 8 - 9
 + 123 - 4 - 5 - 6 - 7 + 8 - 9
 + 123 - 45 - 67 + 89
```