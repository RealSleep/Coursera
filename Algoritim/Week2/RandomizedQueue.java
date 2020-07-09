import java.util.Iterator; 
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Deque<Item> dq; 
    private final static double p = 0.3; 
    // construct an empty randomized queue
    public RandomizedQueue() {
        dq = new Deque<>();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // return the number of items on the randomized queue
    public int size() {
        return dq.size();
    }

    // add the item
    public void enqueue(Item item) {
        if (StdRandom.bernoulli(p)) {
            dq.addFirst(item);
        } else {
            dq.addLast(item);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        Item res;
        if (StdRandom.bernoulli(p)) {
            res = dq.removeFirst();
        } else {
            res = dq.removeLast();
        }
        return res;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        Item res;
        if (StdRandom.bernoulli(p)) {
            res = dq.removeFirst();
        } else {
            res = dq.removeLast();
        }

        enqueue(res);
        return res;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return dq.iterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        rq.enqueue(5);
        rq.enqueue(4);
        rq.enqueue(1);
        rq.enqueue(0);
        
        StdOut.println(rq.size());

        Iterator<Integer> iterator = rq.iterator();

        while (iterator.hasNext()) {
            StdOut.println(iterator.next());
        }

        StdOut.println(rq.dequeue());
        StdOut.println(rq.sample());

        StdOut.println(rq.isEmpty());
        StdOut.println(rq.size());
        
    }

}