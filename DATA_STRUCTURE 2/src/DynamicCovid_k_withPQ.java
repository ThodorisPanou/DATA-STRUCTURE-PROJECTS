import java.util.Scanner;

public class DynamicCovid_k_withPQ implements PQInterface {

		 private int k;
		 public Suspect[] heap; 
		 static int size=0; 
		 private static int DEFAULT_CAPASuspect = 5; 
		 static int count=1;
		 private DoubleComparator comparator=new DoubleComparator();
		 private Suspect[] board;
		 //////////////////Main Values/////////////
		 static DynamicCovid_k_withPQ pq = new DynamicCovid_k_withPQ();
		static int k_v;
	    
	    
	    
	    public DynamicCovid_k_withPQ(){ 
	    	this.heap = new Suspect[DEFAULT_CAPASuspect + 1];
	    	}
	    
	    
	    
	    boolean isEmpty() {
	    	return size==0;
	    }
	    
	    
	    int size() {return size;}
	    
	    
	    public void insert(Suspect item) {
	    	if (isEmpty()) {
	        	size++;
	    		heap[1]=item;
	    	
	    		
	    	}
	    	else {
	    		if(size>0.75* DEFAULT_CAPASuspect*count) {resize(true);}
	        	size++;
	    		heap[size]= item;
	    		swim(size,true);
	    		}
	    	if(size>k_v) {
	    		//heap[1]=null;
	    		getMax();
				
	    		
	    	}
	    }	
	    
	    
	    
	    
	    
	    Suspect max() { 
	    	if (size == 0)
	    			return null; 
	    	return heap[1];
	}
	    
	    public int getK() {return k;}
	    public void insertK(int k) {this.k=k;}
	    
	   Suspect getMax() {
	    	
	    	if (size == 0)
	            {return null;}
	        Suspect root = heap[1];

	        swap(1,size,true);

	        size--;
	        sink(1);

	        return root;
	}
	   void PrintK() {
		   
		   board=new Suspect[k];
		   for(int i=1;i<=k;i++) {
			   board[i-1]=getMax();
		   }
		  for(int i=k-1;i>=0;i--) {
			   System.out.println(board[i].getName());
		   }
	   }
	    

	    
	    Suspect remove(int id) {  
	    	if(isEmpty())
        		return null;
        	else {
        		int holder=-1;
        		Suspect kick=null;
        		for(int i=1;i<=size();i++) {
        			if(heap[i].getID()==id) {
        				kick=heap[i];
        				holder=i;
        			}
        		}
        		if(holder!=-1) {
        		swap(holder,size,true);
        		size--;
        		sink(holder);
        		}
        		return kick;
        		
        	}

	        }
	    
	    
	    
		
	    
	    private void swim(int child,boolean flag) {
	    	int parent=child/2;
	    	if (flag) {
	    		
			while(parent>=1){
				int dif = comparator.compare(heap[child],heap[parent]);
				
				if(dif <0)
					{
					
					swap(parent,child,true);
					child=parent;
					parent/=2;
					}
				else
					{break;}
			}
	    	}
	 }

	      
	    
	    
	    
	    private void sink(int i) {

	        int left = 2 * i;
	        int right = left + 1;
	        if (right>size){
				if (left>size)
					return;
				else {
					int dif = comparator.compare(heap[left],heap[1]);
					if (dif<0){
						swap(1,2,true);
						}
					}
			}
	

	        while (right <= size) {

	            int max = right;
	            if (right <= size) {
	                if (comparator.compare(heap[left], heap[right]) < 0.0)
	                    max = left;
	            }


	            if (comparator.compare(heap[i], heap[max]) <= 0.0)
	                return;
	            else {
	                swap(i, max,true);
	                i = max;
	                left = i * 2;
	                right = left+1 ;
	            }
	        }
	    }
	    
	    
	    
	    
	    
	    private void swap(int i, int j,boolean flag) {
	    	if (flag) {
	        Suspect tmp = heap[i];
	        heap[i] = heap[j];
	        heap[j] = tmp;
	    	}
	    }
	    
	    
	    
	    
	  

	    
	    private void resize(boolean flag) {
	    	count++;
	    	if (flag) {
	    	Suspect newHeap[];
	    	newHeap = new  Suspect[2*DEFAULT_CAPASuspect];
	        
	        for (int i = 0; i <= size; i++) {
	            newHeap[i] = heap[i];
	        	}
	        this.heap = newHeap;
	    	}
	    		
	    	}
	    ///////////////////////////////////////////////////
	        
	
 
public static void main(String args[]) {
		try {
		Read<DynamicCovid_k_withPQ> obj=new Read<>(pq);
		//System.out.println(pq.remove(31));
		Scanner obj2=new Scanner(System.in);
		System.out.print("Give value of k: ");
		k_v=obj2.nextInt();
		pq.insertK(k_v);
		obj.read();
		if(obj.countlines>=k_v) {System.out.println("Top K cities are:");}
		pq.PrintK();
		}
		catch(Exception e) {System.out.println("Wrong k input!");}

	}

	
	
	}
