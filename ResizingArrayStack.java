/**
 * Created by j on 2017/8/16.
 */
import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    public boolean isEmpty() {return N == 0;}
    public int size() {return N;}
    private void resize(int max){
    	Item[] temp = (Item[]) new Object[max];
    	for(int i=0; i<N; i++){
    		temp[i] = a[i];
    	}
    	a = temp; 
    }
    public void push(Item item){
    	if(N == a.length) resize(2*a.length);
    	a[N++] = item;
    }
    public Item pop(){
    	Item item = a[--N];
    	a[N] = null;
    	if(N > 0 && N < a.length/4) resize(a.length/2);
    	return item;
    }
    public Iterator<Item> iterator(){
    	return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
    	private int i = N;
    	public boolean hasNext(){return i > 0;}
    	public Item next(){ return a[--N];}
    	public void remove(){}
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> s = new ResizingArrayStack<>();
        int[] a = {1, 2, 3 , 54, 6};
        int m = 3;
        int w = 3;
        int[] n = new int[1];
        for(int i=0; i<a.length; i++)
            s.push(a[i]);
        s.pop();
        System.out.println(s.size());
        System.out.println(n.length);
        System.out.println(a[m++]);
        System.out.println(a[++w]);
    }
}