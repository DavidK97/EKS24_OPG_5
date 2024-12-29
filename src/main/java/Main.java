public class Main {

    public static void main (String [] args) {

        //TODO Junit-test og klassediagram
        RickshawService r = new RickshawService();


        //Driver
        int [] districts = new int [] {1,3};
        r.createDriver("Pete", districts);

        r.bookDriver();

        //Test to see if driver is now booked
        r.bookDriver();

    }

}
