package utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

import contracts.Iterator;

public class BSTPreOrderIterator<E> implements Iterator<E> 
{
	private Stack<BSTNode<E>> stack;
	
	public BSTPreOrderIterator(BSTNode<E> root)
	{
		stack = new Stack<BSTNode<E>>();
		if(root != null)
		{
			stack.push(root);
		}
		
	}
	@Override
	public boolean hasNext() 
	{
		return !stack.isEmpty();
	}

	@Override
	public E next() throws NoSuchElementException 
	{
		if (!hasNext()) 
		{  
		       throw new NoSuchElementException("All nodes have been visited!");  
	    }
		BSTNode<E> returnable = stack.pop();
		
		
		if(returnable.hasRightChild())
		{
			stack.push((BSTNode<E>) returnable.getRight());
		}
		if(returnable.hasLeftChild())
		{
			stack.push((BSTNode<E>) returnable.getLeft());
		}
		return returnable.getKey();
	}
	
	public ArrayList<E> nextNodeArray()
	{
		if (!hasNext()) 
		{  
		       throw new NoSuchElementException("All nodes have been visited!");  
	    }
		BSTNode<E> returnable = stack.pop();
		
		if(returnable.hasRightChild())
		{
			stack.push((BSTNode<E>) returnable.getRight());
		}
		if(returnable.hasLeftChild())
		{
			stack.push((BSTNode<E>) returnable.getLeft());
		}
		return returnable.getDataArrayList();
	}

}
