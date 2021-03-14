package LinkedList;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class MyLinkedList {
    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node temp = head;
        if (head == null) {
            return -1;
        }
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.value;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.next == null) {
                    temp.next = newNode;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if (index == 0) {
            addAtHead(val);
        } else {
            Node curNode = head;
            int count = 0;
            while (curNode != null) {
                count++;
                if (count == index) {
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
                curNode = curNode.next;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = null;
            Node curNode = head;
            int count = 0;
            while (curNode != null) {
                if (count == index) {
                    prev.next = curNode.next;
                    break;
                }
                prev = curNode;
                curNode = curNode.next;
                count++;
            }
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        }
    }
}

