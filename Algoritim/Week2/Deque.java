import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    // construct an empty deque
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) 
            throw new IllegalArgumentException(); 

        if (size == 0) {
            head = new Node<>(item);
            tail = head;
            size++;
            return;
        }

        Node<Item> oldHead = head;
        head = new Node<>(item);
        head.next = oldHead;
        oldHead.prev = head;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) 
            throw new IllegalArgumentException(); 

        if (size == 0) {
            head = new Node<>(item);
            tail = head;
            size++;
            return;
        }

        Node<Item> oldTail = tail;
        tail = new Node<>(item);
        tail.prev = oldTail;
        oldTail.next = tail;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) 
            throw new java.util.NoSuchElementException();
        
        Node<Item> oldHead = head;

        if(size() == 1) {
            head = null; 
            tail = null;
        }else {
            head = oldHead.next;
            head.prev = null;
        }
         
        size--;
        return oldHead.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) 
            throw new java.util.NoSuchElementException();
        
        Node<Item> oldTail = tail;

        if (size() == 1) {
            head = null; 
            tail = null;
        }else {
            tail = oldTail.prev;
            tail.next = null;
        }
        
        size--;
        return oldTail.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new MyIterator<>(head);
    }

    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();

        dq.addFirst(5);
        dq.addFirst(4);
        dq.addLast(1);
        dq.addLast(0);
        
        StdOut.println(dq.size());

        Iterator<Integer> iterator = dq.iterator();

        while(iterator.hasNext()) {
            StdOut.println(iterator.next());
        }

        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeLast());

        StdOut.println(dq.isEmpty());
        StdOut.println(dq.size());
    }

    private class Node<Item> {
        Node<Item> prev;
        Node<Item> next;
        Item item;

        Node(Item item) {
            this.item = item;
            prev = null; 
            next = null;
        }

        public Item getItem() {
            return item;
        }
    }

    private class MyIterator<Item> implements Iterator<Item> { 
          
        private Node<Item> head;

        public MyIterator(Node<Item> obj) { 
            this.head = obj;
        } 
          
        public boolean hasNext() { 
            return head != null;
        } 

        public Item next() { 
            if(!hasNext()) 
                throw new java.util.NoSuchElementException();
            Item data = head.getItem(); 
            head = head.next;
            return data;
        } 

        public void remove() {
            throw new UnsupportedOperationException();
        } 
    }
}

