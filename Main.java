
class Main{
    public static void main(String[] args){
        Driver theodore = new Driver("Thomas Drummond");

        Address dest1 = new Address("1234 Harmon Way, Oklahoma City, OK, 73000");

        Match match1 = new Match(theodore, dest1);

        System.out.println(match1.toString());
    }
}