package utilities;

/**
 * This class implements the BSTNodeADT class. This class creates a node for a binary search tree
 * The node has up to two children, a key, and an ArrayList of elements matching the key
 */
import java.util.ArrayList;

import contracts.BSTNodeADT;
import java.io.Serializable;

public class BSTNode<E> implements BSTNodeADT<E>, Serializable
{
	private ArrayList<E> dataArray;
	private BSTNode<E> left;
	private BSTNode<E> right;
	private E key;
	
	/**
	 * This is a constructor for the BSTNode class
	 * @param data the data that the node will contain
	 * @param left the left child node
	 * @param right the right child node
	 */
	public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) 
	{
		this.dataArray = (ArrayList<E>) new ArrayList<Comparable>();
		dataArray.add(data);
		this.left = left;
		this.right = right;
		this.key = data;
	}
	
	/**
	 * Creates a node with no child nodes
	 * @param data the data to be held
	 */
	public BSTNode(E data)
	{
		this.dataArray = (ArrayList<E>) new ArrayList<Comparable>();
		dataArray.add(data);
		this.left = null;
		this.key = data;
	}

	@Override
	public BSTNodeADT<E> getLeft() 
	{
		return this.left;
	}

	@Override
	public void setLeft(BSTNodeADT<E> node) 
	{
		this.left = (BSTNode<E>) node;
	}

	@Override
	public BSTNodeADT<E> getRight() 
	{
		return this.right;
	}

	@Override
	public void setRight(BSTNodeADT<E> node) 
	{
		this.right = (BSTNode<E>) node;
	}
	
	@Override
	public ArrayList<E> getDataArrayList()
	{
		return dataArray;
	}
	@Override
	public void setDataArray(ArrayList<E> dataArray)
	{
		this.dataArray = dataArray;
	}
	
	@Override
	public void addData(E data)
	{
		dataArray.add(data);
	}
	
	@Override
	public E getData(int index)
	{
		return dataArray.get(index);
	}
	
	@Override
	public void setKey(E key)
	{
		this.key = key;
	}
	
	@Override
	public E getKey()
	{
		return key;
	}

	@Override
	public boolean hasLeftChild() 
	{
		if(left != null)
		{
			return true;
		}
		 return false;
	}

	@Override
	public boolean hasRightChild() 
	{
		if(right != null)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isLeaf() 
	{
		if(left == null && right == null)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int getSize()
	{
		return dataArray.size();
	}
}
