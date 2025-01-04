import java.util.ArrayList;

public class RickshawService {
    private String [][] districts;
    private ArrayList <Driver> drivers;
    private TextUI ui;


    public RickshawService () {
        this.districts = new String [3][3]; //3 districts, with 3 destinations each
        this.drivers = new ArrayList<>();
        this.ui = new TextUI();
        fillDistrictsArray();
    }

    public void fillDistrictsArray () {
        districts[0] = new String[]{"Christiana", "Operaen", "Havnebad Islands Brygge"};
        districts[1] = new String[] {"Tivoli", "Rådshuspladsen", "Christiansborg"};
        districts[2] = new String[] {"Amalienborg", "Strøget", "Nyhavn"};
    }

    public void createDriver (String name, int [] districtCoverage) {
        Driver driver = new Driver (name, districtCoverage);
        drivers.add(driver);
    }


    public void bookDriver () {
        ui.displayMsg("Mulige destinationer: ");
        int counter = 1;
        for (int i = 0; i < districts.length; i++) {
            for (int j = 0; j < districts[i].length; j++) {
                System.out.println(counter + ") " + districts[i][j]);
                counter++;
            }
        }
        int destination = ui.promptNumeric("Tast tallet for den ønskede destination");

        int districtNumber = ((destination - 1) / 3) + 1;
        if (districtNumber >= 1 && districtNumber <= districts.length) {
            ui.displayMsg(findDriver(districtNumber));
        } else {
            ui.displayMsg("Venligt indtast kun tal fra listen");
            bookDriver();
        }
    }


    private String findDriver (int districtNumber) {
        for (Driver driver: drivers) {
            if (!driver.getIsBooked() && driver.coversDistrict(districtNumber)) {
                driver.setIsBooked(true);
                return "Chauffør fundet! Navn: " + driver.getName();
            }
        }

        return "Der er ikke nogen ledige chauførrer";
    }


}
