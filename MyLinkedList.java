public class MyLinkedList {

    private static class Node<E> {
        int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        Node<E> next;

        Node(int element, Node<E> next) {
            this.val = element;
            this.next = next;
        }
    }


    public MyLinkedList() {

    }

    transient int size = 0;

    /**
     * Pointer to first node.
     */
    transient Node head;

    /**
     * Pointer to last node.
     */
    transient Node last;



    private void linkFirst(int e) {
        final Node f = head;
        final Node newNode = new Node( e, f);
        head = newNode;
        if (f == null)
            last = newNode;
        size++;

    }

    void addAtHead(int val) {
        linkFirst(val);
    }

    public int getFirst() {
        final Node f = head;
        if (f == null)
            throw new RuntimeException("No such element exists");
        return f.val;
    }

    int get(int index) {
        if (index < (size)) {
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x.getVal();
        } else {
            return -1;
        }

    }



    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        list.addAtHead(4);

        //System.out.println(list.size);
        System.out.println(""+list.get(1));
        System.out.println(""+list.get(2));
        System.out.println(""+list.get(3));

        System.out.println(list.toString());

    }


    @Override
    public String toString() {
        if(head != null) {
            String str = "MyLinkedList{ head=" + head.getVal();
            Node x = head;
            for (int i = 0; i < size; i++) {
                x = x.next;
                if (x != null)
                    str = str + "," + x.getVal();
            }
            str = str + "}";
            return str;
        }
        return "";
    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
