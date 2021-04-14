class Suspect {
 private int AFM;
 private String firstName;
 private String lastName;
 private double savings;
 private double taxedIncome;
 
 public void setKey(int AFM) {this.AFM=AFM;}
 public void setFirstName(String firstName) {this.firstName=firstName;}
 public void setLastName(String lastName) {this.lastName=lastName;}
 public void setSavings(double savings) {this.savings=savings;}
 public void setTaxedIncome(double taxedIncome) {this.taxedIncome=taxedIncome;}
 
 public int key() {return AFM;}
 public String getFirstName() {return firstName;}
 public String getLastName(){return lastName;}
 public double getSavings() {return savings;}
 public double getTaxedIncome() {return taxedIncome;}
 public double getSV() {return savings-taxedIncome;}
 
 public double compareTo(Suspect v1) {return this.getSV()-v1.getSV();}
 
 public String toString() {return AFM +" " +firstName+" "+lastName+" "+savings+" "+taxedIncome;}
}
