import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {

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
        try {
            File driverFile = new File(driverFilePath);
            Scanner lineReader = new Scanner(driverFile);
            while (lineReader.hasNextLine()) {
                drivers.add(new Driver(lineReader.nextLine()));
            }
            lineReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File destinationsFile = new File(destinationFilePath);
            Scanner lineReader = new Scanner(destinationsFile);
            while (lineReader.hasNextLine()) {
                destinations.add(new Address(lineReader.nextLine()));
            }
            lineReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Final output and formatting

        System.out.println("");
        double sumTotalSS = 0;

        int r = drivers.size();
        int c = destinations.size();
        Match ssMatch = new Match();
        double[][] cost = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cost[i][j] = -ssMatch.ssCalc(drivers.get(i), destinations.get(j));
            }
        }
        HungarianMatch hbm = new HungarianMatch(cost);
        int[] result = hbm.execute();
        for (int i = 0; i < r; i++) {
            sumTotalSS += ssMatch.ssCalc(drivers.get(i), destinations.get(result[i]));
            System.out.println(drivers.get(i).name + " will deliver to " + destinations.get(result[i]).fullAddress);
        }

        System.out.println("Total Suitability Score: " + sumTotalSS);
    }
}