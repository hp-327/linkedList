package p6_package;

public class BLLMain
{
	public static final int FAILED_ACCESS = -999999;
	public static final int INSERT_AFTER = 1003;
	public static final int INSERT_BEFORE = 1002;
	public static final int REMOVE = 1004;
	public static final int REPLACE = 1001;
	public static final int RETRIEVE = 1005;
	
	public static void main(String[] args) 
	{
        // TODO Auto-generated method stub
        BasicLinkedListClass bc = new BasicLinkedListClass();
        
        bc.setAtIndex(0,43, INSERT_AFTER);
        bc.runDiagnosticDisplay(false);
        bc.runDiagnosticDisplay(true);
        
        bc.setAtIndex(1,45, INSERT_AFTER);
        bc.runDiagnosticDisplay(false);
        bc.runDiagnosticDisplay(true);
        
        bc.setAtIndex(2,32, INSERT_AFTER);
        bc.runDiagnosticDisplay(false);
        bc.runDiagnosticDisplay(true);
        
        bc.setAtIndex(3,35, INSERT_AFTER);
        bc.runDiagnosticDisplay(false);
        bc.runDiagnosticDisplay(true);
        
        bc.setAtIndex(4,56, INSERT_AFTER);
        bc.runDiagnosticDisplay(false);
        bc.runDiagnosticDisplay(true);
	}
	 IteratorClass iteratorTest = new IteratorClass();
	 {
	iteratorTest.setAfterCurrent(0);
    iteratorTest.setBeforeCurrent(43);
    iteratorTest.runDiagnosticDisplay();
    iteratorTest.setBeforeCurrent(45);
    iteratorTest.runDiagnosticDisplay();
    iteratorTest.setBeforeCurrent(31);
    iteratorTest.runDiagnosticDisplay();
    iteratorTest.setBeforeCurrent(42);
    /*iteratorTest.setAtIndex(1,45, IteratorClass.INSERT_AFTER);
    iteratorTest.setAtIndex(2,32, IteratorClass.INSERT_AFTER);
    iteratorTest.setAtIndex(3,35, IteratorClass.INSERT_AFTER);
    iteratorTest.setAtIndex(4,56, IteratorClass.INSERT_AFTER);
    iteratorTest.runDiagnosticDisplay(false);
    iteratorTest.runDiagnosticDisplay(true);*/
	 }
    
    QueueClass queueTest=new QueueClass();
    {
    queueTest.displayQueue();
    queueTest.enqueue(9);
    queueTest.displayQueue();
    queueTest.enqueue(18);
    queueTest.displayQueue();
    queueTest.enqueue(18);
    queueTest.displayQueue();
    queueTest.enqueue(12);
    queueTest.displayQueue();
    //queueTest.dequeue();
    queueTest.displayQueue();
    }
}
