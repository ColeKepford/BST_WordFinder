package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;
import utilities.BSTInOrderIterator;
import utilities.BSTPostOrderIterator;
import utilities.BSTPreOrderIterator;
import utilities.BSTReferencedBased;

class BST_Tests 
{
	private BSTReferencedBased<Integer> ints;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		ints = new BSTReferencedBased<Integer>();
		ints.add(5);
		ints.add(5);
		ints.add(3);
		ints.add(1);
		ints.add(56);
		ints.add(99);
		ints.add(-66);
		ints.add(27);
	}

	@Test
	void testGetRootData() throws TreeException 
	{
		int rootData = ints.getRootData();
		assertEquals(5, rootData);
	}
	
	@Test
	void testGetRootDataArray() throws TreeException
	{
		ArrayList<Integer> fives = new ArrayList<>();
		fives.add(5);
		fives.add(5);
		
		Object[] fivers = fives.toArray();
		
		Object[] rootData = ints.getRootDataArray().toArray();
		
		assertArrayEquals(fivers, rootData);
	}

	@Test
	void testGetHeight()
	{
		assertEquals(4, ints.getHeight());
	}
	
	@Test
	void testSize()
	{
		assertEquals(8, ints.size());
	}
	
	@Test
	void testIsEmptyAndClear()
	{
		ints.clear();
		assertTrue(ints.isEmpty());
	}
	
	@Test
	void testContains() throws TreeException
	{
		assertTrue(ints.contains(-66));
		assertTrue(ints.contains(99));
		assertTrue(ints.contains(3));
	}
	
	@Test
	void testGetEntry() throws TreeException
	{
		int test1 = ints.getEntry(-66);
		assertEquals(-66, test1);
		int test2 = ints.getEntry(3);
		assertEquals(3, test2);
	}
	
	@Test
	void testAdd() throws TreeException
	{
		assertTrue(ints.add(999));
		int test1 = ints.getEntry(999);
		assertEquals(999, test1);
	}
	
	@Test
	void testInOrderIterator() throws TreeException
	{
		ints.clear();
		ints.add(8);
		ints.add(5);
		ints.add(-2);
		ints.add(99);
		
		int[] nums = new int[4];
		nums[0] = -2;
		nums[1] = 5;
		nums[2] = 8;
		nums[3] = 99;
		
		BSTInOrderIterator<Integer> i = (BSTInOrderIterator<Integer>) ints.inorderIterator();
		int[] treeNums = new int[4];
		
		for(int x = 0; i.hasNext(); x++)
		{
			treeNums[x] = i.next();
		}
		
		assertArrayEquals(nums, treeNums);
	}
	
	@Test
	void TestPreOrderIterator() throws TreeException
	{
		ints.clear();
		ints.add(8);
		ints.add(5);
		ints.add(-2);
		ints.add(99);
		
		int[] nums = new int[4];
		nums[0] = 8;
		nums[1] = 5;
		nums[2] = -2;
		nums[3] = 99;
		
		BSTPreOrderIterator<Integer> i = (BSTPreOrderIterator<Integer>) ints.preorderIterator();
		int[] treeNums = new int[4];
		
		for(int x = 0; i.hasNext(); x++)
		{
			treeNums[x] = i.next();
		}
		
		assertArrayEquals(nums, treeNums);
	}
	
	@Test
	void PostOrderIterator() throws TreeException
	{
		ints.clear();
		ints.add(8);
		ints.add(5);
		ints.add(-2);
		ints.add(99);
		
		int[] nums = new int[4];
		nums[0] = -2;
		nums[1] = 5;
		nums[2] = 99;
		nums[3] = 8;
		
		BSTPostOrderIterator<Integer> i = (BSTPostOrderIterator<Integer>) ints.postorderIterator();
		
		int[] treeNums = new int[4];
		
		for(int x = 0; i.hasNext(); x++)
		{
			treeNums[x] = i.next();
		}
		
		assertArrayEquals(nums, treeNums);
	}
}
