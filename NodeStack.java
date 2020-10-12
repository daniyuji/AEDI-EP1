package Pilhas;

import java.util.EmptyStackException;

public class NodeStack<E> implements Stack<E>{
	protected Node<E> top;
	protected int size;
	
	public NodeStack() { 
		top = null;
		size = 0;
	}
	
	public int size() {return size; }
	
	public boolean isEmpty() { return top == null; }
	
	public E top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return top.getElement();
	}
	
	public void push(E elem) {
		Node<E> newNode = new Node<E>(elem, top);
		top = newNode;
		size++;
	}
	
	public E pop() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		E tmp = top.getElement();
		top = top.getNext();
		size--;
		return tmp;
	}
}
