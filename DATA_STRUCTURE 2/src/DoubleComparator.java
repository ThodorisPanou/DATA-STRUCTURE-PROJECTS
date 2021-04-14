import java.util.Comparator;

public class DoubleComparator implements Comparator<City>{
	@Override
	public int compare(City c1, City c2) {
		double d= c1.compareTo(c2);
		if(d>0) {return 1;}
		else if(d<0) {return -1;}
		else {return -c1.getName().compareTo(c2.getName());}
	}
}
