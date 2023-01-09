import java.util.HashSet;

/**
 * Match Class
 */
public class Match {
    Address destination;
    Driver driver;
    double SS;

    /**
     * Vanilla Match constructor
     */
    public Match() {
        this.SS = 0;
    }

    /**
     * The Match Object constructor, takes a driver object, an address object,
     * and calculates the total SS between the pair.
     * 
     * @param n the Driver object in the match
     * @param k the Address object in the match
     */
    public Match(Driver n, Address k) {
        this.destination = k;
        this.driver = n;
        this.SS = ssCalc(n, k);
    }

    /**
     * This is the ssCalc function that will be used outside of the match class
     * to find best matches between drivers and destinations.
     * 
     * @param n the Driver object
     * @param m the Address object
     * @return returns the calculated total SS between the two
     */
    public double ssCalc(Driver n, Address m) {
        double totalSS = 1.0;

        // Access the correct driver base SS for an even or odd length street name
        if (m.even) {
            totalSS *= n.evenSS;
        } else {
            totalSS *= n.oddSS;
        }

        // Check for common factors
        Boolean common = false;
        HashSet<Integer> commonFactors = new HashSet<Integer>();

        for (Integer i : n.factors) {
            commonFactors.add(i);
        }
        for (Integer i : m.factors) {
            if (commonFactors.contains(i)) {
                common = true;
            }
        }

        // Check to see if the SS needs the common factor multiplier
        if (common) {
            totalSS *= 1.5;
        }

        return totalSS;
    }

    @Override
    public String toString() {
        return ("Address: " + this.destination.fullAddress + "\tDriver: " + this.driver.name);
    }
}