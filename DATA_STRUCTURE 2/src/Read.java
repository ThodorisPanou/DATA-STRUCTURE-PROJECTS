import java.io.File;
import java.util.Scanner;

public class Read<T extends PQInterface> {
	T pq;
	static int countlines;
	public Read(T queue) {
		pq=queue;
		countlines=0;
	}
	
	public void read() {
	try {
		Scanner File = new Scanner(new File("C:\\Users\\Thodoris\\Desktop\\Info.txt"));
		String line,temp="";
		int counter=0;
			while(File.hasNext()){
				City town = new City();
				line=File.nextLine();
				for(int i=0;i<line.length();i++){
					if(!String.valueOf(line.charAt(i)).equals(" ") &i!=line.length()-1)
						{temp+=String.valueOf(line.charAt(i));}
					else {
						counter++;
						if(counter==1)
							{town.setID(Integer.valueOf(temp));temp="";}
						else if(counter==2)
							{town.setName(temp);temp="";}
						else if(counter==3)
							{town.setPopulation(Integer.valueOf(temp));temp="";}
						else if (counter==4)
							{temp+=String.valueOf(line.charAt(i));
							town.setCovidCases(Integer.valueOf(temp));
							pq.insert(town);
							temp="";
							//System.out.println(town);
							counter=0;
							}
							
						}
					
					}
				countlines++;
				}
	}
	catch(Exception e) {System.out.println("Error in file/input");}
}
}

