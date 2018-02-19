/*
 * Daniela Alvarado Pereda A01329233
 * 22/08/2017
 * This class represents the stack data structure as an object.
 */
import java.util.ArrayList;

public class Stack<T>{
	// attributes
	private int capacity;
	private ArrayList<T> elements;
	private int top;

	// constructor
	public Stack(int capacity){
		this.capacity = capacity;
		elements = new ArrayList<T>(capacity);
		top = 0;
	}

	// methods
	public boolean isEmpty(){
		return top == 0 ? true : false;
	}
	public boolean isFull(){
		return top == capacity ? true : false;
	}
	public void push(T element) throws Exception{
		if(isFull()){
			throw new Exception("Cannot push, the stack is full");
		}
		elements.add(top++, element);
	}
	public T pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Cannot pop, the stack is is empty");
		}
		return elements.remove(top-- - 1);
	}
}