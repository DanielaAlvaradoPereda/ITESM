/*
 * Daniela Alvarado Pereda A01329233
 * 22/08/2017
 * This class represents the queue data structure as an object.
 */
import java.util.ArrayList;

public class Queue<T>{
	// attributes
	private int capacity;
	private ArrayList<T> elements;
	private int back;

	// constructor
	public Queue(int capacity){
		this.capacity = capacity;
		elements = new ArrayList<T>(capacity);
		back = 0;
	}

	// methods
	public boolean isEmpty(){
		return back == 0 ? true : false;
	}
	public boolean isFull(){
		return back == capacity ? true : false;
	}
	public void insert(T element) throws Exception{
		if(isFull()){
			throw new Exception("Cannot insert, the queue is full");
		}
		elements.add(back++, element);
	}
	public T remove() throws Exception{
		if(isEmpty()){
			throw new Exception("Cannot remove, the queue is is empty");
		}
		back--;
		return elements.remove(0);
	}
}