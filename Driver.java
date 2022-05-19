import java.util.ArrayList;

/**
 * Driver Class
 */
public class Driver /**implements Comparable*/{
    String name;
    int length;
    ArrayList<Integer> factors;
    double evenSS;
    double oddSS;

    /**
     * The Driver Object constructor, takes name of a driver and generates 
     * the rest of the class variables data from the name. 
     * @param n
     */
    public Driver(String n){
        this.name = n;
        this.length = name.length();
        this.factors = new ArrayList<Integer>();
        factorFinder();
        this.evenSS = numVowels()*1.5;
        this.oddSS = numConsonants();
    }

    /**
     * factorFinder function uses the predetermined length of the Driver's name
     * to generate the list of factors needed for the SS multiplier. Called in
     * the Driver constructor immediately after factors variable is initialized. 
     */
    private void factorFinder(){
        for(int i = 2; i < this.length; i++){
            if(this.length%i == 0){
                this.factors.add(i);
            }
        }
    }

    /**
     * numVowels uses class variables to determine the number of vowels in
     * the provided driver name.
     * @return the number of vowels
     */
    private int numVowels(){
        int count = 0;
        for(int i = 0; i < this.length; i++){
            switch(this.name.charAt(i)){
                case 'a': count++;
                break;
                case 'A': count++;
                break;
                case 'e': count++;
                break;
                case 'E': count++;
                break;
                case 'i': count++;
                break;
                case 'I': count++;
                break;
                case 'o': count++;
                break;
                case 'O': count++;
                break;
                case 'u': count++;
                break;
                case 'U': count++;
                break;
            }
        }

        return count;
    }

    /**
     * numConsonants uses class variables to determine the number of consonants
     * (not including whitespace) in the provided driver name.
     * @return the number of consonants
     */
    private int numConsonants(){
        int count = this.length;
        for(int i = 0; i < this.length; i++){
            switch(this.name.charAt(i)){
                case 'a': count--;
                break;
                case 'A': count--;
                break;
                case 'e': count--;
                break;
                case 'E': count--;
                break;
                case 'i': count--;
                break;
                case 'I': count--;
                break;
                case 'o': count--;
                break;
                case 'O': count--;
                break;
                case 'u': count--;
                break;
                case 'U': count--;
                break;
                case ' ': count--;
                break;
            }
        }

        return count;
    }

    // public int compareTo(Driver obj){
        // int comp = this.evenSS.compareTo(obj.evenSS)
    // }

    /**
     * Overridden toString for testing and general use.
     * @return String of Driver data
     */
    public String toString(){
        return ("Name: " + this.name + "\nLength: " + this.length+"\nFactors: " + this.factors +"\nEvenSS: "+ this.evenSS+"\nOddSS: "+ this.oddSS);
    }
}