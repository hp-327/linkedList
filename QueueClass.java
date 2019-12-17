package p6_package;

import p6_package.BasicLinkedListClass;

public class QueueClass
{
	private BasicLinkedListClass queueData;
	
	public QueueClass()
	{
		queueData= new BasicLinkedListClass();
	}
	/**
	 * Copy constructor
	 * @param copied - QueueClass object to be copied
	 */
	public QueueClass(QueueClass copied)
	{
		queueData= new BasicLinkedListClass(copied.queueData);
	}
	/**
	 * Clears queue
	 */
	public void clear()
	{
		queueData.clear();
	}
	/**
	 * Displays queue as comma-delimited list
	 */
	public void displayQueue()
	{
		int index;
		System.out.print("Queue Tail ->");
		for(index = 0; index < queueData.getCurrentSize(); index++)
		{
			System.out.print(queueData.getAtIndex(index));
			if (index != queueData.getCurrentSize()-1)
			{
				System.out.print(", ");
			}
		}
		System.out.print("<- Queue Front");
		System.out.println();
	}
	/**
	 * Enqueues value
	 * @param newValue - Value to be enqueued
	 */
	public void enqueue(int newValue)
	//add item at tail
	{
		int size  = queueData.getCurrentSize();
		queueData.setAtIndex(size-1, newValue, BasicLinkedListClass.INSERT_AFTER);
	}

	/**
	 * Removes and returns value from front of queue
	 * @return: integer value if successful, FAILED_ACCESS if not
	 */
	public int dequeue()
	//remove item at head
	{
		if (!isEmpty())
		{	
			return queueData.removeAtIndex(0);
		}
		else
		{
			return BasicLinkedListClass.FAILED_ACCESS;
		}
		
	}
	/**
	 * Reports queue empty state
	 * @return: Boolean evidence of empty list
	 */
	public boolean isEmpty()
	{
		return queueData.isEmpty();
	}
	/**
	 * Provides peek at front of queue
	 * @return: integer value if successful, FAILED_ACCESS if not
	 */
	public int peekFront()
	{
		if (!isEmpty())
		{	
			int size= queueData.getCurrentSize()-1;
			return (queueData.getAtIndex(size));
		}
		else
		{
			return BasicLinkedListClass.FAILED_ACCESS;
		}
	}
}
