import java.util.HashSet;

/**
 * Match Class
 */
public class Match {
    Address destination;
    Driver driver;
    double SS;

    /**
     * The Match Object constructor, takes a driver object, an address object,
     * and calculates the total SS between the pair.
     * @param n
     */
    public Match(Driver n, Address k){
        this.destination = k;
        this.driver = n;
        this.SS = ssCalc(n, k);
    }

    /**
     * This is the ssCalc function that will be used outside of the match class 
     * to find best matches between drivers and destinations.
     * @param n the Driver object
     * @param m the Address object
     * @return returns the calculated total SS between the two
     */
    public double ssCalc(Driver n, Address m){
        double totalSS = 1.0;
        if(m.even){
            totalSS *= n.evenSS;
        }else{
            totalSS *= n.oddSS;
        }

        Boolean common = false;

        HashSet<Integer> commonFactors = new HashSet<Integer>();

        for(Integer i : n.factors){
            commonFactors.add(i);
        }
        for(Integer i : m.factors){
            if(commonFactors.contains(i)){
                common = true;
            }
        }

        if(common){
            totalSS*=1.5;
        }

        return totalSS;
    }

    /**
     * Overridden toString for testing and general use.
     * @return String of Match data
     */
    public String toString(){
        return ("Address: \n" + this.destination.toString() + "\n\nDriver: \n"+ this.driver.toString() + "\n\nTotal SS: " + this.SS);
    }
}