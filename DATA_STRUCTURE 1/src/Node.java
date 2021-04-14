public class Node<T>{
	Node next;
	Node previous;
	T in;
	Node(T in){this.in=in;}
	Node(){}//default const
	public T getNode(){return in;}
	public void setNext(Node<T> data){next=data;}
	public void setPrevious(Node<T> data){previous=data;}
}
