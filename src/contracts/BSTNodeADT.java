package contracts;

import java.io.Serializable;
import java.util.ArrayList;

public interface BSTNodeADT<E> extends Serializable
{
	/**
	 * This method returns the left node
	 * @return the left node
	 */
	public BSTNodeADT<E> getLeft();
	
	/**
	 * This method sets the left node
	 * @param node the node to be set
	 */
	public void setLeft(BSTNodeADT<E> node);
	
	/**
	 * This method returns the right ndoe
	 * @return the right node
	 */
	public BSTNodeADT<E> getRight();
	
	/**
	 * This method sets the right node
	 * @param node the note to be set
	 */
	public void setRight(BSTNodeADT<E> node);
	
	/**
	 * This method returns an Arraylist containing all elements of the node
	 * @return an ArrayList of the node's elements
	 */
	public ArrayList<E> getDataArrayList();
	
	/**
	 * This method sets the node's ArrayList
	 * @param dataArray the ArrayList to be set
	 */
	public void setDataArray(ArrayList<E> dataArray);
	
	/**
	 * This method adds an element to the node's ArrayList
	 * @param data the data to be added
	 */
	public void addData(E data);
	
	/**
	 * This method returns an element at an index from the node's ArrayList
	 * @param index the index of the ArrayList
	 * @return the element at the index
	 */
	public E getData(int index);
	
	/**
	 * This method sets the key of the node
	 * @param key the data to be set as key
	 */
	public void setKey(E key);
	
	/**
	 * This method returns the key
	 * @return the key
	 */
	public E getKey();
	
	/**
	 * The method checks if the node has a left child
	 * @return true if left child exists, false otherwise
	 */
	public boolean hasLeftChild();
	
	/**
	 * This method checks if the node has a right child
	 * @return true if right child exists, false otherwise
	 */
	public boolean hasRightChild();
	
	/**
	 * This method checks if this node is a leaf
	 * @return true if no child nodes, false if not
	 */
	public boolean isLeaf();
	
	/**
	 * This method returns how many elements are in the node
	 * @return the number of elements in the node
	 */
	public int getSize();	
}
