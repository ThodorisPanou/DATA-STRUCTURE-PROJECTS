import java.util.Comparator;

public class DoubleComparator implements Comparator<Suspect>{
	@Override
	public int compare(Suspect c1, Suspect c2) {
		if(c1.getTaxedIncome()<9000) {return 1;}
		else if(c2.getTaxedIncome()<9000) {return -1;}
		double d= c1.compareTo(c2);
		if(d>0) {return 1;}
		else if(d<0) {return -1;}
		else {return 0;}
	}
}
