package p6_package;

public class BasicLinkedListClass
{
	public static final int FAILED_ACCESS = -999999;
	public static final int INSERT_AFTER = 1003;
	public static final int INSERT_BEFORE = 1002;
	public static final int REMOVE = 1004;
	public static final int REPLACE = 1001;
	public static final int RETRIEVE = 1005;
	private NodeClass headRef;

	/**
	 * 
	 * @author HannahPark
	 *Initialization constructor for NodeClass
	 *newData - integer value to be placed in node
	 */
	private class NodeClass
	{
		NodeClass nextRef;
		int nodeData; 
		/**
		 * Initialization constructor for NodeClass
		 * @param copied - NodeClass object to be copied into this node
		 */
		private NodeClass(NodeClass copied)
		{
			nodeData= copied.nodeData;
			nextRef = null;
		}
		/**
		 * Initialization constructor for NodeClass
		 * @param newData - integer value to be placed in node
		 */
		private NodeClass(int newData)
		{
			nodeData = newData;
			nextRef = null;
		}
	}
	/**
	 * Default constructor, initializes linked list
	 */
	protected	BasicLinkedListClass()
	{
		headRef = null;	
	}
	/**
	 * Copy constructor, initializes linked list, then copies all nodes to local(this) linked list
	 * @param copied - BasicLinkedListClass object to be copied
	 */
	protected	BasicLinkedListClass(BasicLinkedListClass copied)
	{
		//copy from reference 
		NodeClass current=(copied.headRef);
		//copy to
		NodeClass local =(copied.headRef);
		if(copied.headRef != null)
		{
			headRef = new NodeClass(copied.headRef);
			local = headRef;
		while(current.nextRef != null)
			{
			//updating the current node link
				current = current.nextRef;
				local = local.nextRef;
				local = new NodeClass(current);
			}
		}
		else
		{
		headRef = null;
		}
	}
	/**
	 * Utility method used by getAtIndex and removeAtIndex to access and possibly remove element depending on control code
	 * Note: Data is managed with virtual index found by getRefAtIndex
	 * Note: Uses only one loop
	 * @param controlCode - integer value with either RETRIEVE or REMOVE to control operations
	 * @param index - integer virtual index of element to be retrieved or removed
	 * @return: integer value at element or FAILED_ACCESS if attempt to access data out of bounds
	 */
	private int	accessAtIndex(int controlCode, int index)
	{
		NodeClass working = getRefAtIndex(headRef, index);
		if(working == null)
		{
			return FAILED_ACCESS;
		}
		if (controlCode == RETRIEVE)
		{				
			return working.nodeData;
			
		}
		else if (controlCode == REMOVE)
		{
			int valAtNode;
			NodeClass prevIndex= (getRefAtIndex(working, index-1));
			NodeClass nodeIndex = (getRefAtIndex(working, index));
			NodeClass nextIndex = (getRefAtIndex(working, index+1));
			valAtNode = nodeIndex.nodeData;
			prevIndex.nextRef = nextIndex;
			return valAtNode;
		}
		return FAILED_ACCESS;
	}
	/**
	 * Clears linked list of all valid values by setting linked list head reference to null
	 */
	protected void	clear()
	{
		headRef = null;	
	}
	/**
	 * Accesses item in linked list at specified virtual index if it is within linked list limits
	 * Note: Linked list value specified by virtual index is returned to calling program
	 * Note: Calls accessAtIndex with RETRIEVE to conduct action
	 * @param accessIndex - integer virtual index of requested element value
	 * @return: integer accessed value if successful, FAILED_ACCESS if not
	 */
	protected int	getAtIndex(int accessIndex)
	{
		return accessAtIndex(RETRIEVE, accessIndex);
	}
	/**
	 * Gets virtual index of last item in linked list
	 * Note: Uses getCurrentSizeHelper
	 * Note: Handles empty list prior to calling helper
	 * @return: integer virtual index
	 */
	protected int	getCurrentSize()
	{
		if (headRef != null)
		{
			return (getCurrentSizeHelper(headRef));
		}
			return 0;
	}
	/**
	 * Uses recursion to find virtual linked list size
	 * @param wkgRef - NodeClass current reference in recursion, initially called with head reference
	 * @return: integer linked list size
	 */
	private int	getCurrentSizeHelper(NodeClass wkgRef)
	{
		if (wkgRef.nextRef == null)
		{
			return 1;
		}
		return (1+getCurrentSizeHelper(wkgRef.nextRef));
	}
	/**
	 * Private recursive method that finds a node represented by a virtual index
	 * Note: if requested index is less than zero or outside linked list, returns null
	 * @param wkgReff - NodeClass reference that initially called with the head reference, and is used for recursive operations
	 * @param requestedIndex - integer value representing virtual index requested by the user
	 * @return: NodeClass reference to the element at the virtual index
	 */
	private NodeClass getRefAtIndex(NodeClass wkgRef, int requestedIndex)
	{
		if (wkgRef == headRef && requestedIndex ==0)
		{
			return headRef;
		}
		if(requestedIndex < 0 || requestedIndex > getCurrentSize())
		{
			return null;
		}
		if(wkgRef != null && requestedIndex > 0)
		{
			return getRefAtIndex(wkgRef.nextRef, requestedIndex-1);
		}

		return wkgRef;
	}
	/**
	 * Tests for empty linked list
	 * @return: Boolean result of test for empty
	 */
	protected boolean	isEmpty()
	{
		return (headRef == null);
	}
	/**
	 * Description: Removes item from linked list at specified virtual index if index within linked list size bounds
	 * Note: Linked list node specified by virtual index is removed from list
	 * Note: Calls accessAtIndex with REMOVE to conduct action
	 * @param removeIndex - integer index of element value to be removed
	 * @return: removed integer value if successful, FAILED_ACCESS if not
	 */
	protected int removeAtIndex(int removeIndex)
	{
		return accessAtIndex(REMOVE, removeIndex);
	}
	/**
	 * Displays formatted list with virtual indices
	 * @param showIndex - Boolean value turns on display of index under value if set to true, otherwise only shows pipe delimited values
	 */
	protected void	runDiagnosticDisplay(boolean showIndex)
	{
		int index = 0;
		NodeClass workingRef = headRef;
		System.out.print("\nList: |") ;
		while(workingRef != null)
		{
			System.out.format("%3d|",workingRef.nodeData);
			workingRef = workingRef.nextRef;
		}
		System.out.print("\nIndex:|");
		workingRef = headRef;
		while(workingRef != null)
		{
			System.out.format("%3d|", index);
			index++;
			workingRef = workingRef.nextRef;
		}
	}
	/**
	 * Description: sets item in linked list at specified virtual index
	 * Note: If constant REPLACE is used, new value overwrites value at current virtual index
	 * Note: If constant INSERT_BEFORE is used, new value is inserted prior to the value at the current virtual index
	 * Note: If constant INSERT_AFTER is used, new value is inserted after the value at the current virtual index
	 * Note: Method must check for correct virtual array boundaries; if index requested is below zero or above list size - 1, method must take no action and return false
	 * Note: Method must check for correct replace flag; if it is not one of the three specified flags, it must take no action and return false
	 * @param setIndex - integer index of element at which value is to be replaced, or value is to be inserted before or after
	 * @param newValue - integer value to be placed in linked list
	 * @param replaceFlag - integer flag to indicate insertion or replacement in the linked list
	 * @return: Boolean success if inserted, or failure if incorrect index or replace flag was used
	 */
	protected boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
	{
		boolean checkFlag = false; 
		NodeClass working = getRefAtIndex(headRef, 0);
		NodeClass prevIndex;
		NodeClass nodeIndex = (getRefAtIndex(working, setIndex));
		if(headRef == null)
		{
			if (setIndex == 0)
			{
				headRef = new NodeClass(newValue);
				return true;
			}
		}

		if (replaceFlag == REPLACE)
		{
			nodeIndex.nodeData = newValue;
			checkFlag = true;
		}
		else if (replaceFlag == INSERT_BEFORE)
		{	
			prevIndex = (getRefAtIndex(working, setIndex-1));
			if(prevIndex == null)
			{
				prevIndex = headRef;
				headRef = new NodeClass(newValue);
				headRef.nextRef = prevIndex;
				checkFlag = true;
			}
			else 
			{
				prevIndex.nextRef= new NodeClass(newValue);
				checkFlag = true;
			}
		}
		else if (replaceFlag == INSERT_AFTER)
		{
			prevIndex = (getRefAtIndex(working, setIndex-1));
			if (nodeIndex!=null)
			{
				NodeClass tempNode = new NodeClass(newValue);
				tempNode.nextRef = nodeIndex.nextRef;
				nodeIndex.nextRef = tempNode;
				
			}
			else
			{
			prevIndex.nextRef= new NodeClass(newValue);
			checkFlag = true;
			}
		}
		return checkFlag;
		
	}

}
