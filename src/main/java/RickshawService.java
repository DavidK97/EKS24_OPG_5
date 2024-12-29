import java.util.ArrayList;

public class RickshawService {
    private String [][] districts;
    private ArrayList <Driver> drivers;
    private TextUI ui;


    public RickshawService () {
        this.districts = new String [3][4]; //3 districts, with 3 destinations each
        this.drivers = new ArrayList<>();
        this.ui = new TextUI();
        fillDistrictsArray();
    }

    public void createDriver (String name, int [] districtNumbers) {
        Driver driver = new Driver (name, districtNumbers);
        drivers.add(driver);
    }

    public void fillDistrictsArray () {
        districts[0] = new String[]{"Christiana", "Operaen", "Havnebad Islands Brygge"};
        districts[1] = new String[] {"Tivoli", "Rådshuspladsen", "Christiansborg"};
        districts[2] = new String[] {"Amalienborg", "Strøget", "Nyhavn"};
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

//TODO anden løsning på dette her måske?
        int destination = ui.promptNumeric("Tast tallet for den ønskede destination");
        switch (destination) {
            case 1, 2, 3:
                ui.displayMsg(findDriver(1));
                break;
            case 4, 5, 6:
                ui.displayMsg(findDriver(2));
                break;
            case 7, 8, 9:
                ui.displayMsg(findDriver(3));
                break;
            default:
                ui.displayMsg("Venligt indtast kun tal fra listen");
                bookDriver();
                break;
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
