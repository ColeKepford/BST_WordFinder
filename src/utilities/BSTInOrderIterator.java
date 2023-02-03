package utilities;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import contracts.Iterator;
/**
 * This class Iterators through a Binary Search tree in order of least to greatest
 * @author cocog
 *
 * @param <E> the data type
 */
public class BSTInOrderIterator<E> implements Iterator<E>
{
	private Stack<BSTNode<E>> stack;
	
	public BSTInOrderIterator(BSTNode<E> root)
	{
		stack = new Stack<BSTNode<E>>();
		while(root != null)
		{
			stack.push(root);
			root = (BSTNode<E>) root.getLeft();
		}
	}

	@Override
	public boolean hasNext() 
	{
		return !stack.isEmpty();
	}

	@Override
	public E next()
	{
		if (!hasNext()) 
		{  
		       throw new NoSuchElementException("All nodes have been visited!");  
	    }
		BSTNode<E> node = stack.pop();
		E data = node.getKey();
		if(node.hasRightChild())
		{
			node = (BSTNode<E>) node.getRight();
			
			while(node != null)
			{
				stack.push(node);
				node = (BSTNode<E>) node.getLeft();
			}
		}
		return data;
	}
	
	/**
	 * This method returns the next node's ArrayList
	 * @return the next node's ArrayList
	 */
	public ArrayList<E> nextArray() 
	{
		BSTNode<E> node = stack.pop();
		ArrayList<E> data = node.getDataArrayList();
		if(node.hasRightChild())
		{
			node = (BSTNode<E>) node.getRight();
			
			while(node != null)
			{
				stack.push(node);
				node = (BSTNode<E>) node.getLeft();
			}
		}
		return data;
	}
	
	
}
