import java.util.ArrayList;

/**
 * Address Class
 */
public class Address {
    String fullAddress;
    String streetName;
    int length;
    Boolean even;
    ArrayList<Integer> factors;

    /**
     * The Address Object constructor, takes a longform address and generates 
     * the rest of the class variables data from it. 
     * @param n
     */
    public Address(String n){
        this.fullAddress = n;
        streetParser();
        this.length = this.streetName.length();
        this.even = this.length % 2 == 0?true:false;
        this.factors = new ArrayList<Integer>();
        factorFinder();
    }

    /**
     * factorFinder function uses the predetermined length of the street name
     * to generate the list of factors needed for the SS multiplier. Called in
     * the Address constructor immediately after factors variable is initialized. 
     */
    private void factorFinder(){
        for(int i = 2; i < this.length; i++){
            if(this.length%i == 0){
                this.factors.add(i);
            }
        }
    }

    /**
     * The address format required for this parser
     * 0000 xyz st., anywhere, TX, 00000
     * Populates the streetName class variable with result.
     */
    private void streetParser(){
        String streetAddress = this.fullAddress.split(",")[0];
        this.streetName = streetAddress.split(" ", 2)[1];
    }

    /**
     * Overridden toString for testing and general use.
     * @return String of Address data
     */
    public String toString(){
        return ("Full Address: " + this.fullAddress +"\nStreet Name: "+ this.streetName+ "\nLength: " + this.length + "\nFactors: " + this.factors +"\nEven: "+ this.even);
    }
}