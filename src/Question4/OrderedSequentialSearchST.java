package Question4;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    private Node root;
    private int n;
    
    public OrderedSequentialSearchST() {
    	
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }


        if (n == 0) {
            root = new Node(key, value, null);
            n++;
            return;
        }

        //Check first node
        if (root.key.compareTo(key) == 0) {
        	root.value = value;
            return;
        } else if (root.key.compareTo(key) > 0) {
        	root = new Node(key, value, root);
            n++;
            return;
        }

        Node node = root;
        while(node != null) {
            if (node.next != null) {
            	// next key is greater so we need insert our node at the current node
                if (node.next.key.compareTo(key) > 0) {

                    Node newNode = new Node(key, value, node.next);
                    node.next = newNode;
                    n++;
                    return;
                } else if (node.next.key.compareTo(key) == 0 ) {
                    node.next.value = value;
                    return;
                }
            } else {
                Node newNode = new Node(key, value, null);
                node.next = newNode;
                n++;
                return;
            }
        	node = node.next;
        }
    }
    
    public Value get(Key key) {
        Node node = root;
        while(node != null) {
            if (node.key.compareTo(key) == 0) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }
    
}
