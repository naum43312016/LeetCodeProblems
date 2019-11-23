package naum.asafov.com.LRUCache146;

import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ //);
/*
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */
public class Main {
    public static void main(String[] args) {
        /*Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        List<Integer> l = new LinkedList<>();
        l.remove(l.size()-1);
        System.out.println(s.pop());*/

        //map.get(3);
        //System.out.println(map.get(3));
        /*
        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
         */
        LRUCache obj = new LRUCache(3);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        obj.put(4,4);
        System.out.println(obj.get(4));
        System.out.println(obj.get(3));
        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        obj.put(5,5);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
        System.out.println(obj.get(5));
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> nodeMap;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        moveToStart(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            moveToStart(node);
        } else {
            Node node = new Node(key, value);
            addStart(node);
            nodeMap.put(key, node);
            size++;
            if (size > capacity) {
                int leastKey = tail.key;
                tail = tail.prev;
                tail.next = null;
                nodeMap.remove(leastKey);
                size--;
            }
        }
    }

    private void addStart(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void moveToStart(Node node) {
        if (node == head) return;
        else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
            addStart(node);
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addStart(node);
        }
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}