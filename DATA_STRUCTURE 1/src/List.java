import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.*;

public class List<T>{
	static int count=0;
	
	protected Node<T> head=null;
	
	protected Node<T> tail=null;
	
	protected Node<T> tempo,back;
	T str;
	
	public boolean isEmpty(){
		return head==null;
	}
	public void addFirst(T item){
		if(isEmpty()){
			tempo=new Node<>(item);
			head=tempo;
			tail=tempo;
			head.setNext(tail);
			tail.setPrevious(head);
			tail.setNext(null);
		}
		//tail is now pointing at a different node and not at the same a as head
		else if(head==tail){
			tempo=new Node(item);
			head=tempo;head.setNext(tail);tail.setPrevious(head);tail.setNext(null);}
		else{
			tempo=new Node<>(item);
			tempo.setNext(head);
			head=tempo;
			head.next.setPrevious(head);
		}
		count++;
	}
	public T removeFirst() throws NoSuchElementException{

	 if (head==null){throw new NoSuchElementException();}
	 else if(head==tail){str=head.getNode();head=null;tail=null;count--;return str;}
	 else{str=head.getNode();head=head.next;head.setPrevious(null);count--;return str;}
	}
	public void addLast(T item){

		 if(isEmpty()){addFirst(item);return;}
		 else if(head==tail){tempo=new Node(item);head=tail;tail=tempo;head.setNext(tail);tail.setPrevious(head);}		 
		 else{
		 tempo=new Node<T>(item);
		 tempo.setPrevious(tail);
		 tail.setNext(tempo);
		 tail=tempo;}
		 count++;
		 }
	public T removeLast() throws NoSuchElementException{
	
	 if (isEmpty()){throw new NoSuchElementException();}
	 else if(head==tail){
		 T object=head.getNode();
		 head=null;
		 tail=null;
		 count--;
		 return object;
	 }
	 else{
		 tempo=tail.previous;
		 back=tail;
		 tail=tempo;
		 tail.next=null;
		 count--;
		 return back.getNode();
	 }
	}
	public T getFirst() throws NoSuchElementException{

	 if (head!=null){return head.getNode();}
	 else{throw new NoSuchElementException();}
	}
	public T getLast() throws NoSuchElementException{

		if (tail!=null){return tail.getNode();}
		else{
			throw new NoSuchElementException();
		}
	}

	public void printQueue(){

	 if(isEmpty()){System.out.println("No Nodes here");}
	 else{
	 tempo=head;
	 while(tempo.next!=null){System.out.println(tempo.getNode()+"\n");tempo=tempo.next;}
	 System.out.println(tempo.getNode());
	 }
	 }
	 public int size(){

		 if(isEmpty()){return 0;}
		 else{return count;}
	 }

}