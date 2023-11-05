package main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe Lee
 * @date
 * @Description
 */
public class LRUCache {
    public static Map<Integer,Node> m;
    int length;
    Node head = null;
    Node tail = null;
    int capacity = 0;
    public LRUCache(int capacity) {
        m = new HashMap<>(capacity);
        length = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(m.containsKey(key)){
            return m.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            node.val = value;
            movetohead(m.get(key));
        }
        else{
            Node node = new Node(value);
            m.put(key,node);
            ++length;
            insert(node);
        }
    }
    public void remove(Node node){
        node.pre = node.next;
        if(node.next!=null){
            node.next.pre = node.pre;
        }
    }
    public void movetohead(Node node){
        remove(node);
        node.next = head;
        head.pre = node;
        head = node;

    }
    public void insert(Node node){
        if(length == 0){
            head = node;
            tail = node;
            ++length;
        }
        else if(length<=capacity){
            head.pre = node;
            node.next = head;
            head = node;
            ++length;
        }
        else{
            head.pre = node;
            node.next = head;
            head = node;
            tail = tail.pre;
            tail.next = null; //排除了最后一个
        }
    }
}
class Node{
    int val;
    Node next;
    Node pre;
    public Node(){};
    public Node(int val){
        this.val = val;
    }
}
