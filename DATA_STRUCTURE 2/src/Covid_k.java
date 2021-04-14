
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Covid_k {
	static PQ pq = new PQ();
	static int k;
	static void print() {
		System.out.println("The top K cities are:");
		for (int i=1;i<=k;i++) {
			System.out.println(pq.getMax().getName());
		}
	}
	public static void main(String[] args){
		try {


		Read<PQ> obj=new Read<>(pq);
		obj.read();
		//System.out.println(pq.remove(31));
		Scanner obj2=new Scanner(System.in);
		System.out.print("Give value of k: ");
		k=obj2.nextInt();
		if(k>obj.countlines) {
			k=0;
			int x=1/0;
		}
		print();
		}
		catch(Exception e) {System.out.println("Wrong k input!");}

	}
}
