
package p6_package;

public class IteratorClass extends BasicLinkedListClass
{
	private final char SPACE = 32;
	private final char LEFT_BRACKET = 91;
	private final char RIGHT_BRACKET = 93;
	private int currentIndex;
	
	/**
	 * Default constructor for IteratorClass
	 */
	public IteratorClass()
	{
		super();
		currentIndex = 0;
	}
	/**
	 *Copy constructor for IteratorClass
	 *copied - IteratorClass object to be copied
	 */
	public IteratorClass(IteratorClass copied)
	{
		super(copied);
		currentIndex = 0;
	}
	/**
	 *Clears virtual array
	 *Overrides: clear in class BasicLinkedListClass
	 */
	public void clear()
	{
		super.clear();
	}
	/**
	 * Gets value at iterator cursor location
	 * @return: integer value returned; FAILED_ACCESS if not found
	 */
	public int getAtCurrent()
	{
		return (getAtIndex(currentIndex));
	}
	/**
	 * Reports if iterator cursor is at beginning of existing list
	 * Note: Empty list does not exist
	 * @return: Boolean result of action; true if at beginning of existing list, false otherwise
	 */
	public boolean isAtBeginning()
	{
		return (currentIndex == 0 && getCurrentSize()>0);
	}
	/**
	 * Reports if iterator cursor is at end of existing list
	 * Note: Empty list does not exist
	 * @return: Boolean result of action; true if at end of existing list, false otherwise
	 */
	public boolean isAtEnd()
	{
		return (currentIndex == getCurrentSize()-1 && !isEmpty() );
	}
	/**
	 * Reports if list is empty
	 *isEmpty in class BasicLinkedListClass
	 * @return:Boolean result of action; true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return (super.isEmpty());	
	}
	/**
	 * Moves iterator cursor one position to the right, or next, of existing list
	 * Note: Empty list does not exist
	 * @return: Boolean result of action; true if successful, false otherwise
	 */
	public boolean moveNext()
	{
		if (!isAtEnd())
		{
			currentIndex = currentIndex+1;
			return true;
		}
		return false;
	}
	/**
	 * Moves iterator cursor one position to the left, or previous, of existing list
	 * Note: Empty list does not exist
	 * @return: Boolean result of action; true if successful, false otherwise
	 */
	public boolean movePrev()
	{
		if (!isAtBeginning())
		{
			currentIndex = currentIndex-1;
			return true;
		}
		return false;
	}
	/**
	 * Removes and returns a data value from the iterator cursor position
	 * Note: cursor must remain in same relative position after removal unless the last item is removed
	 * @return: integer value removed from list
	 */
	public int removeAtCurrent()
	{
		int removed = removeAtIndex(currentIndex);
		if (!isEmpty())
			{
			currentIndex++;
			return removed;
			}
		return FAILED_ACCESS;
	}
	/**
	 * Replaces value at iterator cursor
	 * newValue - integer value to be replaced in list
	 * @return:Boolean result of action; true if successful, false otherwise
	 */
	public boolean replaceAtCurrent(int newValue)
	{
		return setAtIndex(currentIndex, newValue, REPLACE);	
	}
	/**
	 * Shows space-delimited list with cursor location indicated
	 * Indicates cursor with left/right brackets (e.g., "[##]")
	 */
	public void runDiagnosticDisplay()
	{
		int tempIndex;
		for (tempIndex = 0; tempIndex < getCurrentSize(); tempIndex++)
		{
			if (tempIndex > 0)
			{
				System.out.print(SPACE);
			}
			if (tempIndex ==(currentIndex))
			{
				System.out.print( LEFT_BRACKET );
				System.out.print(getAtIndex( tempIndex ));
				System.out.print(RIGHT_BRACKET);
			}
			else
			{
				System.out.print(getAtIndex( tempIndex ) );
			}	
		}
		System.out.println();
	}
	/**
	 * Sets value to location after current index
	 * @param newValue - integer value to be inserted into list
	 * @return:Boolean result of operation
	 */
	public boolean setAfterCurrent(int newValue)
	{
		boolean result = setAtIndex(currentIndex, newValue, INSERT_AFTER);
		if(getCurrentSize()!=0)
		{
			currentIndex--;	
		}
		return result;
	}
	/**
	 * Sets value to location before current index
	 * @param newValue - integer value to be inserted into list
	 * @return:Boolean result of operation
	 */
	public boolean setBeforeCurrent(int newValue)
	{
		boolean result = setAtIndex(currentIndex, newValue, INSERT_BEFORE);
		if(getCurrentSize()!=0)
		{
			currentIndex++;
		}	
		return result;
	}
	/**
	 * Sets iterator cursor to beginning of existing list
	 * Note: Empty list does not exist
	 * @return: Boolean result of action; true if successful, false otherwise
	 */
	public boolean setToBeginning()
	{
		if (!isEmpty())
		{
		currentIndex = 0;
		return true;
		}
		return false;
	}
	/**
	 * Sets iterator cursor to the end of existing list
	 * Note: Empty list does not exist
	 * @return: Boolean result of action; true if successful, false otherwise
	 */
	public boolean setToEnd()
	{
		if (!isEmpty())
		{
			currentIndex = getCurrentSize()-1;
			return true;
		}
			return false;
	}

}