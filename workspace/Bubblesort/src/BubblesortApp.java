
	class ArrayBub {
	private long[] a;
	private int nElems;
		
	public ArrayBub(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int j =0; j <nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}

	public void bubbleSort() {
	
		int out, in;
		boolean swapped = false;
		
		for(out=nElems - 1; out>=1; out--) {
			// Start out each pass with no swaps
			swapped = false;
			
			// A single bubble sort pass
			for(in=0; in<out; in++)
				if( a[in] > a[in+1] ) {
					swapped = true;
					swap(in, in+1);
				}

			// Pass is done, quit if nothing changed
			if(! swapped)
				break;
			display();
		}
	}

	// Set up a pass
	// do the pass
	//    if any swaps occur, take note
	
	
	public void dubbleSort() {
	
		
	}
	
	public void bubbleSortR() {


		
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}

public class BubblesortApp
	{
	public static void main(String[] args)
		{
		int maxSize = 50;
		ArrayBub arr;
		arr = new ArrayBub(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (long) (java.lang.Math.random()*(maxSize - 1) );
			System.out.println("Before Sorting");
			arr.insert(n);
			arr.display();
			arr.dubbleSort();
			arr.bubbleSort();
			System.out.println("Sorted");
			arr.display();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
