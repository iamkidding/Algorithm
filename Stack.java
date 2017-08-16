/**
 * Created by j on 2017/8/16.
 */
public class Stack<Item> {
    private Node first;
    private int N;
    private class Node{
    	Node next;
    	Item item;
    }    
    public boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void push(Item item){
    	Node oldfirst = first;
    	first = new Node();
    	first.item = item;
    	first.next = oldfirst;
    	N++;
    }
    public Item pop(){
    	Item item = first.item;
    	first = first.next;
        N--;
        return item;
    }
}
