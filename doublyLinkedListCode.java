public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int length;

    //making Node class
    class Node{
        int value;
        Node next;
       Node prev;

        //constructor for Node
        public Node(int value){
            this.value=value;
        }
    }

    //constructor of DoublyLinkedList
    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    //function for printing the list
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    //function for printing head
    public void getHead(){
        System.out.println("Head : " + head.value);
    }
    //function for printing the tail
    public void getTail(){
        System.out.println("Tail : " + tail.value);
    }
    //function for printing the length
    public void getLength(){
        System.out.println("Length : " + length);
    }

    /*
    Operations performed onto the DoublyLinkedList are :-
    1.append()
    2.removeLast()
    3.prepend()
    4.removeFirst()
    5.get()
    6.set()
    7.insert()
    8.remove()
    */

    //append() : function for appending the elements onto the last of the DoublyLinkedList
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;

    }

    //removeLast() : function for removing the last element of the DoublyLinkedList
    public Node removeLast(){
        if(length == 0) return null;
        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    //prepend() : function for adding the node onto the front of the DoublyLinkedList
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    //removeFirst() : function for removing the first element from the DoublyLinkedList
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    //get() : function to get the node at particular index
    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2){
            for(int i = 0; i < index ; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i = length - 1; i > index ; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    //set() : function to change the value of a particular node at given index
    public boolean set(int index , int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    //insert() : to insert a node in given index
    public boolean insert(int index , int value){
        if(index < 0 || index > length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index -1);
        Node after = before.next;
        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }

    //remove() : to remove the particular node of given index
    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();

        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;

        length--;
        return temp;
    }
}
