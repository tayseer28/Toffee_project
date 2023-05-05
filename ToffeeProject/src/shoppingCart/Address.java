package shoppingCart;

public class Address {

    private String governorate;
    private String district;
    private String street;
    private int buildingNumber;

    private int floorBuilding;
    private String flatBuilding;
    private String landMark;
    //private Customer cust;

    public Address(String governorate, String district, String street, int buildingNumber, int floorBuilding, String flatBuilding, String landMark) {
        this.governorate = governorate;
        this.district = district;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.floorBuilding = floorBuilding;
        this.flatBuilding = flatBuilding;
        this.landMark = landMark;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getFloorBuilding() {
        return floorBuilding;
    }

    public void setFloorBuilding(int floorBuilding) {
        this.floorBuilding = floorBuilding;
    }

    public String getFlatBuilding() {
        return flatBuilding;
    }

    public void setFlatBuilding(String flatBuilding) {
        this.flatBuilding = flatBuilding;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }
}
