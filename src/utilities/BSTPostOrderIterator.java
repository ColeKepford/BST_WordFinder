/**
 * 
 */
package utilities;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import contracts.Iterator;

/**
 * @author cocog
 *
 */
public class BSTPostOrderIterator<E> implements Iterator<E> 
{

	private Stack<BSTNode<E>> out;
	
	public BSTPostOrderIterator(BSTNode<E> root)
	{
		Stack<BSTNode<E>> stack = new Stack<BSTNode<E>>();
		out = new Stack<BSTNode<E>>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			BSTNode<E> current = stack.pop();
			out.push(current);

			if(current.hasLeftChild())
			{
				stack.push((BSTNode<E>) current.getLeft());
			}
			
			if(current.hasRightChild())
			{
				stack.push((BSTNode<E>) current.getRight());
			}
		}
	}
	@Override
	public boolean hasNext() 
	{
		return !out.isEmpty();
	}

	@Override
	public E next()
	{
		if (!hasNext()) 
		{  
		       throw new NoSuchElementException("All nodes have been visited!");  
	    }
		E returnable = out.pop().getKey();
		return returnable;
	}
	
	public ArrayList<E> nextArray()
	{
		if (!hasNext()) 
		{  
		       throw new NoSuchElementException("All nodes have been visited!");  
	    }
		ArrayList<E> returnable = out.pop().getDataArrayList();
		return returnable;
	}
	

}
