import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Main{
    public static void main(String[] args){

        Scanner fileInputs = new Scanner(System.in);

        System.out.println("Enter the driver names filepath:");
        String driverFilePath = fileInputs.nextLine();
        System.out.println("Enter the destinations filepath:");
        String destinationFilePath = fileInputs.nextLine();

        fileInputs.close();

        ArrayList<Driver> drivers = new ArrayList<Driver>();
        ArrayList<Address> destinations = new ArrayList<Address>();

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
       
        System.out.println(drivers);
        System.out.println("");
        System.out.println(destinations);

        // Driver theodore = new Driver("Thomas Drummond");

        // Address dest1 = new Address("1234 Harmon Way, Oklahoma City, OK, 73000");

        // Match match1 = new Match(theodore, dest1);

        // System.out.println(match1.toString());
    }
}