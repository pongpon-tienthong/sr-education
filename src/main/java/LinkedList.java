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
