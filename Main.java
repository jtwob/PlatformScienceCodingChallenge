
class Main{
    public static void main(String[] args){
        Driver theodore = new Driver("Thomas Drummond");
        System.out.println(theodore.toString());

        System.out.println();

        Address dest1 = new Address("1234 Harmon Way, Oklahoma City, OK, 73000");
        System.out.println(dest1.toString());
    }
}