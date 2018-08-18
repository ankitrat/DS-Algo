import java.util.*;
class Node{
    int key;
    int value;
    Node prev;
    Node next;
}
public class LRUCache {
    Node head,end;
    int capacity;
    HashMap<Integer,Node> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            addAtTop(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            node.value=value;
            addAtTop(node);
        }else{
            Node node=new Node();
            node.key=key;
            node.value=value;
            node.prev=null;
            node.next=null;
            if(map.size()>=capacity){
                map.remove(end.key);
                removeNode(end);
                addAtTop(node);
            }else{
                addAtTop(node);
            }
            map.put(key,node);
        }
    }
    public void removeNode(Node node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }else{
            head=node.next;
        }
        
        if(node.next!=null){
            node.next.prev=node.prev;
        }else{
            end=node.prev;
        }
    }
    public void addAtTop(Node node){
        node.prev=null;
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(end==null){
            end=head;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */