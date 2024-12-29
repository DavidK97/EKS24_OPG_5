public class Driver {
    public String name;
    public boolean isBooked;
    public int [] districtCoverage;


    public Driver (String name, int [] districtCoverage) {
        this.name = name;
        this.districtCoverage = districtCoverage;
        this.isBooked = false;
    }

    public boolean coversDistrict (int districtNumber) {
        for (int district: districtCoverage) {
            if (district == districtNumber){
                return true;
            }
        }
        return false;
    }


    //getters and setters
    public String getName () {
        return name;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public int[] getDistrictCoverage() {
        return districtCoverage;
    }

    public void setIsBooked (boolean isBooked) {
        this.isBooked = isBooked;
    }



}
