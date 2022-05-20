import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Main{

    /**
     * This is the simple matching algorithm that works by taking the first destination
     * and finding the best matching driver for it, adding the destination and driver to a matched array, 
     * removing the driver from the available pool, and moving on to the next destination.
     * @param drivers the list of Driver objects read in from the data file
     * @param destinations the list of Address objects read in from the data file
     * @return an ArrayList of Match objects to print as output in main
     */
    public static ArrayList<Match> matcher(ArrayList<Driver> drivers, ArrayList<Address> destinations){
        Match matcher = new Match();
        ArrayList<Match> matches = new ArrayList<Match>();
        double maxSS = 0;
        int destIndex = 0;
        int driverIndex = 0;

        while(destIndex < destinations.size()){
            for(int i = 0; i < drivers.size(); i++){
                double currentSS = matcher.ssCalc(drivers.get(driverIndex), destinations.get(destIndex));
                if(currentSS > maxSS){
                    maxSS = currentSS;
                    driverIndex = i;
                }
            }
            matches.add(new Match(drivers.get(driverIndex), destinations.get(destIndex)));
            destIndex++;
            drivers.remove(driverIndex);
        }
        return matches;
    }

    public static void main(String[] args){

        // User input scanner
        Scanner fileInputs = new Scanner(System.in);

        // User input prompts
        System.out.println("Enter the driver names filepath:");
        String driverFilePath = fileInputs.nextLine();
        System.out.println("Enter the destinations filepath:");
        String destinationFilePath = fileInputs.nextLine();

        fileInputs.close();

        // ArrayLists created to store objects created from datafiles
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        ArrayList<Address> destinations = new ArrayList<Address>();

        // File data read into object ArrayLists
        try{
            File driverFile = new File(driverFilePath);
            Scanner lineReader = new Scanner(driverFile);
            while(lineReader.hasNextLine()){
                drivers.add(new Driver(lineReader.nextLine()));
            }
            lineReader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            File destinationsFile = new File(destinationFilePath);
            Scanner lineReader = new Scanner(destinationsFile);
            while(lineReader.hasNextLine()){
                destinations.add(new Address(lineReader.nextLine()));
            }
            lineReader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }


        // Final output and formatting

        System.out.println("");
        System.out.printf("%-50.50s  %-30.30s%n", "Address:", "Driver Name:");
        double sumTotalSS = 0;
        for(Match m : matcher(drivers, destinations)){
            sumTotalSS += m.SS;
            System.out.printf("%-50.50s  %-30.30s%n", m.destination.fullAddress, m.driver.name);
        }
        System.out.println("Total SS: " + sumTotalSS);
    }
}