/*     Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
        A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
        If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

        Implement the MyLinkedList class:

        MyLinkedList() Initializes the MyLinkedList object.
        int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
        void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        void addAtTail(int val) Append a node of value val as the last element of the linked list.
        void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
        void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

 */



public class MyLinkedList {

    private static class Node {
        int val=0;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node next;

        Node(int element, Node next) {
            this.val = element;
            this.next = next;
        }

        Node(int element) {
            this.val = element;
        }
    }


    public MyLinkedList() {

    }

    transient int size = 0;

    /**
     * Pointer to first node.
     */
    transient Node head;





    public void addAtTail(int val){
        Node curr = this.head;
        if (curr == null) {
            this.head = new Node(val);
        }
        else {
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);


        }
        this.size += 1;
    }

    void addAtHead(int val) {

        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
        this.size += 1;
    }



    int get(int index) {
        if (index < (size)) {
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
             return (x !=null) ? x.getVal():0;
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
        list.addAtTail(8);
        list.addAtTail(9);
        list.addAtTail(10);
        System.out.println("list size before deletion:"+list.size);
        System.out.println(list);
        System.out.println("About to delete element " +list.get(3)+ " at index 3");
        list.deleteAtIndex(3);
        list.deleteAtIndex(0);
        list.deleteAtIndex(-1);
        list.addAtIndex(3,55);

        System.out.println("list.size:"+list.size);
        System.out.println("first element:"+list.get(1));
        System.out.println("second element:"+list.get(2));
        System.out.println("third element:"+list.get(3));
        System.out.println("fourth element:"+list.get(4));

        System.out.println(list);

    }


    @Override
    public String toString() {
        if(head != null) {
            String str = "MyLinkedList{ head=" + head.getVal();
            Node x = head;
            for (int i = 0; i < size-1; i++) { //since we are starting from 0 , its -1
                x = x.next;
                if (x != null)
                    str = str + "," + x.getVal();
            }
            str = str + "}";
            return str;
        }
        return "";
    }



    /**
     * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
     * If index equals the length of the linked list, the node will be appended to the end of the linked list.
     * If index is greater than the length, the node will not be inserted.
     * @param index
     * @param val
     */

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;
        if (index == 0)
            this.addAtHead(val);
        else {
            Node curr = this.head;
            for (int i = 0; i < (index - 1); i++) {
                curr = curr.next;
            }
            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;
            size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        /**
        Delete the index-th node in the linked list, if the index is valid.
        :type index: int
        :rtype: void
        **/
        if (index < 0 || index >= this.size)
            return;
        Node curr = this.head;

        if (index == 0)
            this.head = curr.next;
        else {
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        this.size -= 1;
    }
}
