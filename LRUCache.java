import java.util.*;
import java.util.regex.*;
class Node{
    Character key;
    Character value;
    Node prev;
    Node next;
}
class LRUCache{
    private Map<Character,Node> map=new HashMap<>();
    int capacity=6;
    Node head,end;
    
    public void putEntry(Character key,Character value){
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            addAtTop(node);
        }else{
            Node node=new Node();
            node.prev=null;
            node.next=null;
            node.key=key;
            node.value=value;
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
    public void traverse(){
        Pattern p=Pattern.compile("[^a-zA-Z0-9]");
        Node temp=head;
        while(temp!=null){
            Matcher match=p.matcher(temp.value.toString());
            if(match.find()){
                Character ch=leaseRecentlyUsed();
                temp.value=ch;
            }
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public Character get(Character key){
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            addAtTop(node);
            return node.value;
        }
        return 'D';
    }
    public  Character leaseRecentlyUsed(){
        return end.value;
    
    }
    public static void main(String[] args){
        LRUCache cache=new LRUCache();
        String str="An,k,t";
        for(int i=0;i<str.length();i++){
            cache.putEntry(str.charAt(i),str.charAt(i));
        }
        cache.traverse();
        System.out.println("********************");
        System.out.println(cache.get('k'));
        System.out.println("**************");
        cache.traverse();
        // System.out.println("**************");
        // System.out.println(cache.leaseRecentlyUsed());
        
    }
    
}