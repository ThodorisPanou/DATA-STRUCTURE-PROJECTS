import java.io.File;
import java.util.Scanner;

public class RandomizedBST implements MafiaInterface {
	int count=0;
	public TreeNode root;
	List<Suspect> list=new List<>();
	PQ listSV=new PQ();

	Suspect[] alist = new Suspect[5];
	
	
	
	private class TreeNode {
		 Suspect item;
		 TreeNode left; 
		 TreeNode right; 
		 int N; 
		 private TreeNode(Suspect item){
			 this.item = item;
			 N=0;
		 }
		 
		}

	private boolean less(int a,int b) {return a<b;}
	private boolean equals(int a, int b) {return a==b;}
	
	private TreeNode rotR(TreeNode h) {
		TreeNode x = h.left; h.left = x.right; x.right = h; return x; }

	private TreeNode rotL(TreeNode h) {
		TreeNode x = h.right; h.right = x.left; x.left = h; return x; }
	
	TreeNode partR(TreeNode h, int k) {
		int t = (h.left == null) ? 0 : h.left.N;
		if (t > k) {
		h.left = partR(h.left, k);
		h = rotR(h); }
		if (t < k) {
		h.right = partR(h.right, k-t-1);
		h = rotL(h); }
		return h; } 
	
	private TreeNode joinLR(TreeNode a, TreeNode b) {
		if (a == null) return b;
		if (b == null) return a;
		int m = a.N + b.N;
		if (Math.random()*m < 1.0*a.N) {
			a.right = joinLR(a.right, b);
			return a; 
		} 
		else 
		{ b.left = joinLR(a, b.left); return b; }
	} 
	
	private TreeNode removeR(TreeNode h, int v) {
		if (h == null) return null;
		int w = h.item.key();
		if (less(v, w)) h.left = removeR(h.left, v);
		if (less(w, v)) h.right = removeR(h.right, v);
		if (equals(v, w)) h = joinLR(h.left, h.right);
		return h; } 
	
	
	private String printAFM(TreeNode h) {
		if (h == null) return "";
		String s = printAFM(h.left);
		s += h.item.key() + "\n" ;
		s += printAFM(h.right);
		return s; 
	}
	
	
	private TreeNode searchName(TreeNode h,String s) {
		
		if (h != null) 
		{
			if (h.item.getLastName().equals(s)) 
			{
				if(list.size()<5) 
				list.addLast(h.item);
				
			}
			searchName(h.left, s);
			searchName(h.right, s);
		
		}
		return h;
		}
	
	
	
	//NOT WORKING
	private double getMeanSavingsR(TreeNode h){
		int price = 0;
		if (h != null) 
		{
			price += h.item.getSavings();
			price +=  getMeanSavingsR(h.left);
			price += getMeanSavingsR(h.right);
		
		}
		return price;
	
				
	
	}
	
	public int size() {return root.left.N+root.right.N-1;}
	
	
	public void insert(Suspect item) {  count+=1; root = insertR(root, item);}
	
	
	private Suspect searchR(TreeNode h, int afm) {
		if (h == null) return null;
		if (equals(afm, h.item.key())) { return h.item;}
		if (less(afm, h.item.key())) return searchR(h.left, afm);
		else return searchR(h.right, afm); }
	
	
	private TreeNode insertT(TreeNode h,Suspect x) {
		if (h == null) {return new TreeNode(x);}
		
		if (less(x.key(), h.item.key())) {
			h.left = insertT(h.left, x); 
			h = rotR(h); } 
		else {
			h.right = insertT(h.right, x);
			h = rotL(h); 
			
		} 
		
	
		return h;
		
	}

	
	
	private TreeNode insertR(TreeNode h, Suspect x) {
		if (h == null) {  return  new TreeNode(x); }
		
		if (Math.random()*(h.N+1) < 1.0)
			return insertT(h, x);
		
		if (less(x.key(), h.item.key()))
			{h.left = insertR(h.left, x);}
		else
			{h.right = insertR(h.right, x);}
			
		h.N++; return h;
	}

	
	public void load(String filename) {
		try {
			Scanner File = new Scanner(new File("C:\\Users\\Thodoris\\Desktop\\" + filename + ".txt"));
			String line,temp="";
			int counter=0;
				while(File.hasNext()){
					Suspect sus = new Suspect();
					line=File.nextLine();
					for(int i=0;i<line.length();i++){
						if(!String.valueOf(line.charAt(i)).equals(" ") &i!=line.length()-1)
							{temp+=String.valueOf(line.charAt(i));}
						else {
							counter++;
							if(counter==1)
								{sus.setKey(Integer.valueOf(temp));temp="";
								}
							else if(counter==2)
								{sus.setFirstName(temp);temp="";}
							else if(counter==3)
								{sus.setLastName(temp);temp="";}
							else if(counter==4)
							{sus.setSavings(Integer.valueOf(temp));temp="";}
							else if (counter==5)
								{temp+=String.valueOf(line.charAt(i));
								sus.setTaxedIncome(Integer.valueOf(temp));
								temp="";
								counter=0;
								}
								
							}
						
						}
				
					insert(sus);
					
					}
				System.out.println("File has been succesfully uploaded.");
		}
		catch(Exception e) {System.out.println("Error in file/input");}
	}
		
	

	public void updateSavings(int AFM, double savings) {
		Suspect s = searchByAFM(AFM);
		if (!(s==null)) 
			s.setSavings(savings);
		else {
			System.out.println("AFM NOT FOUND/ERROR");
		}
		
	}

	
	public Suspect searchByAFM(int AFM) {
		return searchR(root,AFM);
	}

	
	public void remove(int val) {
		root = removeR(root, val);	
	}

	//NOT WORKING
	public double getMeanSavings() {
		double a =  getMeanSavingsR(root);
		return a/count;
	}
	
	private TreeNode lastNode(TreeNode h) {
		if (h.left==null)return h;
		else return(lastNode(h.left));
	}
	
	private void printTopSuspectsR(TreeNode h) {
		if (h == null) return;
		printTopSuspectsR(h.left);
		listSV.insert(h.item);
		printTopSuspectsR(h.right); 
	}
			

	
	public void printTopSuspects(int k) {
		listSV.insertK(k);
		printTopSuspectsR(root);
		listSV.PrintK();
	}

	
	public void printByAFM() {
		System.out.println("AFM SORTED: ");
		String s = printAFM(root);
		System.out.print(s);
		
	}
	
	public List searchByLastName(String last_name) {
		
		searchName(root,last_name);
		return list;

	}
	
	public void EmptyList() {
		float x=list.size();
		for(int i=0;i<x;i++)list.removeFirst();
		}
	
	public void printList() {
		float f=list.size();
		for(int i=0;i<f;i++)System.out.println(list.removeFirst());
		}
	
	
}
