package utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import contracts.BSTreeADT;
import contracts.Iterator;
import exceptions.TreeException;
/**
 * This class implements the BSTreeADT interface.
 * This class creates the functionality of a Binary Search Tree.
 * @author cocog
 *
 * @param <E> the datatype of the tree
 */
public class BSTReferencedBased<E extends java.lang.Comparable<E>> implements BSTreeADT<E>  
{
	
	private static final long serialVersionUID = 1L;
	
	private BSTNode<E> root;
	private int size;

	@Override
	public E getRootData() throws TreeException 
	{
		return root.getKey();
	}
	
	/**
	 * This method returns the root node's ArrayList
	 * @return the root node's ArrayList
	 * @throws TreeException if TreeException throw TreeException
	 */
	public ArrayList<E> getRootDataArray() throws TreeException
	{
		return root.getDataArrayList();
	}

	@Override
	public int getHeight() 
	{
		if(isEmpty())
		{
			return 0;
		}
		Queue<BSTNode<E>> queue = new LinkedList<BSTNode<E>>();
		queue.add(root);
		int height = 0;
		
		while(true)
		{
			int nodeCount = queue.size();
			if(nodeCount == 0)
			{
				return height;
			}
			height++;
			
			while(nodeCount > 0)
			{
				BSTNode<E> newNode = queue.peek();
				queue.remove();
				
				if(newNode.hasLeftChild())
				{
					queue.add((BSTNode<E>) newNode.getLeft());
				}
				if(newNode.hasRightChild())
				{
					queue.add((BSTNode<E>) newNode.getRight());
				}
				nodeCount--;
			}
		}
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return root == null;
	}

	@Override
	public void clear() 
	{
		root = null;
	}

	@Override
	public boolean contains(E entry) throws TreeException 
	{
		BSTNode<E> current = root;
		while(current != null)
		{
			if(entry.compareTo(current.getKey()) == 0)
			{
				return true;
			}
			else if(entry.compareTo(current.getKey()) == -1)
			{
				current = (BSTNode<E>) current.getLeft();
			}
			else
			{
				current = (BSTNode<E>) current.getRight();
			}
		}
		return false;
	}

	@Override
	public E getEntry(E entry) throws TreeException 
	{
		BSTNode<E> current = root;
		while(current != null)
		{
			if(entry.compareTo(current.getKey()) == 0)
			{
				return current.getKey();
			}
			else if(entry.compareTo(current.getKey()) < 0)
			{
				current = (BSTNode<E>) current.getLeft();
			}
			else if(entry.compareTo(current.getKey()) > 0)
			{
				current = (BSTNode<E>) current.getRight();
			}
		}
		return null;
	}
	
	/**
	 * This method returns the node's ArrayList that has a key matching entry
	 * @param entry the key to search for
	 * @return returns the matching node's ArrayList
	 * @throws TreeException throws TreeException if TreeException
	 */
	public ArrayList<E> getDataArray(E entry) throws TreeException
	{
		BSTNode<E> current = root;
		while(current != null)
		{
			if(entry.compareTo(current.getKey()) == 0)
			{
				return current.getDataArrayList();
			}
			else if(entry.compareTo(current.getKey()) < 0)
			{
				current = (BSTNode<E>) current.getLeft();
			}
			else if(entry.compareTo(current.getKey()) > 0)
			{
				current = (BSTNode<E>) current.getRight();
			}
		}
		return null;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException 
	{
		BSTNode<E> newNode = new BSTNode<E>(newEntry);
		if(isEmpty())
		{
			root = newNode;
			size++;
			return true;
		}
		
		BSTNode<E> current = root;
		BSTNode<E> parent = null;
		while(true)
		{
			parent = current;
			
			if(newEntry.compareTo(current.getKey()) < 0)
			{
				current = (BSTNode<E>) current.getLeft();
				if(current == null)
				{
					parent.setLeft(newNode);
					size++;
					return true;
				}
			}
			else if(newEntry.compareTo(current.getKey()) == 0)
			{
				current.addData(newEntry);
				size++;
				return true;
			}
			else
			{
				current = (BSTNode<E>) current.getRight();
				if(current == null)
				{
					parent.setRight(newNode);
					size++;
					return true;
				}
			}
		}
	}

	@Override
	public Iterator<E> inorderIterator() 
	{
		BSTInOrderIterator<E> ordered = new BSTInOrderIterator<E>(root);
		return ordered;
	}

	@Override
	public Iterator<E> preorderIterator() 
	{
		BSTPreOrderIterator<E> ordered = new BSTPreOrderIterator<E>(root);
		return ordered;
	}

	@Override
	public Iterator<E> postorderIterator() 
	{
		BSTPostOrderIterator<E> ordered = new BSTPostOrderIterator<E>(root);
		return ordered;
	}
}
