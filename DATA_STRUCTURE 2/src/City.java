


public class City implements CityInterface{
	private int ID,population,CovidCases;
	private String name;
	public int getID(){return ID;}
	public String getName(){return name;}
	public int getPopulation(){return population;}
	public int getCovidCases(){return CovidCases;}
	public void setID(int ID){
		if(ID>=1)
		this.ID=ID%999;
		else
			ID=1;}
	public void setName(String name){this.name=name;}
	public void setPopulation(int population){this.population=population;}
	public void setCovidCases(int CovidCases){this.CovidCases=CovidCases;}
	public String toString(){return getID()+" " +getName()+" "+getPopulation()+" "+getCovidCases();}
	public double compareTo(City obj){
		/*double val1 = (float) Math.round(this.getCovidCases()/(double)this.getPopulation()*50000 * 100)/100;
		double val2 = (float) Math.round(obj.getCovidCases()/(double)obj.getPopulation()*50000 * 100) / 100;
		return val1-val2; */
		return this.getCovidCases()/(double)this.getPopulation()*50000 - obj.getCovidCases()/(double)obj.getPopulation()*50000;
			}
	public double fiftyCov() {return this.getCovidCases()/(double)this.getPopulation();}
	


}