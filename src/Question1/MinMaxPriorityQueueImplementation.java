package Question1;

public class MinMaxPriorityQueueImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinMaxPriorityQueue queue = new MinMaxPriorityQueue(5); 
		queue.insert(5);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(1);
		queue.insert(7);
		queue.insert(11);
		queue.insert(26);
		queue.insert(78);
		queue.insert(45);
		queue.insert(0);
		
        System.out.println("Find Max: " + queue.findMax() + ", Delete Max: " + queue.delMax());
        System.out.println("Find Min: " + queue.findMin() + ", Delete Min: " + queue.delMin());
		
	}

}

enum HEAP_TYPE {
    MAX_HEAP, MIN_HEAP;
}

class Node implements Comparable<Node>{
    Comparable key;

    @Override
    public int compareTo(Node n) {
        return key.compareTo(n.key);
    }
}

class MinMaxPriorityQueue<Key extends Comparable<Key>> { 
    private Node[] minPriorityQueue;
    private Node[] maxPriorityQueue;
    private int n = 0;
    
    public MinMaxPriorityQueue(int capacity) {
    	minPriorityQueue = new Node[capacity + 1];
    	maxPriorityQueue = new Node[capacity + 1];
        n = 0;
    }
    
    public void insert(Comparable key) {

        // we only have to check for one of the queues cause they will be of the same length
        if (n == minPriorityQueue.length - 1) {
        	resize(2 * minPriorityQueue.length);
        }
        
        
        Node node = new Node();
        node.key = key;
        
//        Node node2 = new Node();
//        node2.key = key;
        ++n;
        
        minPriorityQueue[n] = node;
        maxPriorityQueue[n] = node;//node2;
        

        swim(n, HEAP_TYPE.MIN_HEAP);
        swim(n, HEAP_TYPE.MAX_HEAP);
    }
    
    private void swim(int k, HEAP_TYPE type) {
    	if(type == HEAP_TYPE.MAX_HEAP) {
	        while (k > 1 && less(k/2, k)) {
	            exch(k, k/2, maxPriorityQueue);
	            k = k/2;
	        }
    	} else {
            while (k > 1 && greater(k/2, k)) {
                exch(k, k/2,  minPriorityQueue);
                k = k/2;
            }
    	}
    }

    private void sink(int k, HEAP_TYPE type) {
    	if(type == HEAP_TYPE.MAX_HEAP) {
	        while (2*k <= n) {
	            int j = 2*k;
	            if (j < n && less(j, j+1)) j++;
	            if (!less(k, j)) break;
	            exch(k, j,  maxPriorityQueue);
	            k = j;
	        }
    	} else { 
            while (2*k <= n) {
                int j = 2*k;
                if (j < n && greater(j, j+1)) j++;
                if (!greater(k, j)) break;
                exch(k, j, minPriorityQueue);
                k = j;
            }
    	}
    	
    }
    
    public Comparable delMin() {

        Node min = minPriorityQueue[1];
        
        exch(1, n--, minPriorityQueue);
        sink(1, HEAP_TYPE.MIN_HEAP);
        
        minPriorityQueue[n+1] = null; 
        maxPriorityQueue[n+1] = null; 
        
        if ((n > 0) && (n == (minPriorityQueue.length - 1) / 4)) 
        	resize(minPriorityQueue.length / 2);
        
        return min.key;
    }

    public Comparable delMax() {
      
        Node max = maxPriorityQueue[1];
        
        exch(1, n--, maxPriorityQueue);
        sink(1, HEAP_TYPE.MAX_HEAP);
        
        maxPriorityQueue[n+1] = null; 
        minPriorityQueue[n+1] = null;  
        
        if ((n > 0) && (n == (maxPriorityQueue.length - 1) / 4)) 
        	resize(maxPriorityQueue.length / 2);
       
        return max.key;
    }
    

	
    private void resize(int capacity) {
        assert capacity > n;
        Node[] temp = new Node[capacity];
        Node[] temp2 = new Node[capacity];
        
        for (int i = 1; i <= n; i++) {
            temp[i] = minPriorityQueue[i];
            temp2[i] = maxPriorityQueue[i];
        }
        
        minPriorityQueue = temp;
        maxPriorityQueue = temp2;
    }
    
    private void exch(int i, int j, Node[] queue) {
        Node swap = queue[i];
        queue[i] = queue[j];
        queue[j] = swap;
    }
    
    private boolean less(int i, int j) {
    	return maxPriorityQueue[i].compareTo(maxPriorityQueue[j]) < 0;
    }
    
    private boolean greater(int i, int j) {
    	return minPriorityQueue[i].compareTo(minPriorityQueue[j]) > 0;
    }
    
    public Comparable findMin() {
        return minPriorityQueue[1].key;
    }

    public Comparable findMax() {
        return maxPriorityQueue[1].key;
    }
    
}