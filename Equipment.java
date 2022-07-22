package Salon;

public class Equipment {
    // instance variables
    private String equipmentName;
    private String replacement;
    private String maintenanceNum;
    private String model;
    private String quality;
    private String year;
    private String costStr;
    private String quantStr;
    private String warranYrsStr;
    private double cost;
    private int quantity;
    private int warrantyYears;

    public Equipment() { // constructor
        equipmentName = "object";
        quantity = 0;
        cost = 0;
        year = "year";
        model = "model";
        quality = "new/moderate/old/very old";
        warrantyYears = 0;
        replacement = "yes/no";
        maintenanceNum = "000-000-0000";
        costStr = "cost";
        quantStr = "quantity";
        warranYrsStr = "warranty years";
    }

    // overloaded constructor
    public Equipment(String newEquipmentName, String newQuantity, String newCost, String newYear, String newModel,
                     String newQuality, String newWarrantyYears, String newReplacement, String newMaintenanceNum) {
        equipmentName = newEquipmentName;
        year = newYear;
        model = newModel;
        quality = newQuality;
        replacement = newReplacement;
        maintenanceNum = newMaintenanceNum;
        costStr = newCost;
        quantStr = newQuantity;
        warranYrsStr = newWarrantyYears;
        cost = Double.parseDouble(costStr);
        quantity = Integer.parseInt(quantStr);
        warrantyYears = Integer.parseInt(warranYrsStr);
    }

    // modifier
    // sets equipment name to user-inputed equipment name
    // pre: String newEquipmentName
    public void setEquipmentName(String newEquipmentName) {
        equipmentName = newEquipmentName;
    }

    // accessor
    // post: returns string equipment name
    public String getEquipmentName() {
        return equipmentName;
    }

    // modifier
    // sets equipment quantity to user-inputed quantity and updates string quantity
    // value
    // pre: String newQuantity
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
        quantStr = "" + quantity; // updates value for the string variation of the variable for file i/o in main
    }

    // accessor
    // post: returns int quantity
    public int getQuantity() {
        return quantity;
    }

    // modifier
    // sets equipment cost to user-inputed cost and updates string cost value
    // pre: String newCost
    public void setCost(double newCost) {
        cost = newCost;
        costStr = "" + cost; // updates value for the string variation of the variable for file i/o in main
    }

    // accessor
    // post: returns double cost
    public double getCost() {
        return cost;
    }

    // modifier
    // sets equipment year bought to user-inputed year bought
    // pre: String newYear
    public void setYear(String newYear) {
        year = newYear;
    }

    // accessor
    // post: returns string year
    public String getYear() {
        return year;
    }

    // modifier
    // sets equipment model to user-inputed model
    // pre: String newModel
    public void setModel(String newModel) {
        model = newModel;
    }

    // accessor
    // post: returns string model
    public String getModel() {
        return model;
    }

    // modifier
    // sets equipment quality to user-inputed quality
    // pre: String newQuality
    public void setQuality(String newQuality) {
        quality = newQuality;
    }

    // accessor
    // post: returns string quality
    public String getQuality() {
        return quality;
    }

    // modifier
    // sets equipment warranty (years) to user-inputed warranty and updates string
    // warranty (years) value
    // pre: String newWarrantyYears
    public void setWarrantyYears(int newWarrantyYears) {
        warrantyYears = newWarrantyYears;
        warranYrsStr = "" + warrantyYears; // updates value for the string variation of the variable for file i/o in
        // main
    }

    // accessor
    // post: returns int warranty years
    public int getWarrantyYears() {
        return warrantyYears;
    }

    // modifier
    // sets equipment replaceability to user-inputed replaceability
    // pre: String newReplacement
    public void setReplacement(String newReplacement) {
        replacement = newReplacement;
    }

    // accessor
    // post: returns string replacement
    public String getReplacement() {
        return replacement;
    }

    // modifier
    // sets maintenance number to user-inputed maintenance number
    // pre: String newMaintenanceNum
    public void setMaintenanceNum(String newMaintenanceNum) {
        maintenanceNum = newMaintenanceNum;
    }

    // accessor
    // post: returns string maintenance number
    public String getMaintenanceNum() {
        return maintenanceNum;
    }

    // method override (equals) that compares quality to object quality to see if
    // they equal to each other
    // pre: instance of equipment object
    // post: boolean value
    public boolean equals(Equipment e) {
        Equipment compare = (Equipment) e;

        if (quality.equals(compare.getQuality()) && replacement.equals(compare.getReplacement())) {
            return true;
        }

        return false;
    }

    // method override (toString) that displays equipment info
    // post: returns string value with supply info
    public String toString() {
        String info = "\nEquipment: " + equipmentName + "\nCost: $" + cost + "\nQuantity: " + quantity + "\nYear bought: "
                + year + "\nModel #: " + model + "\nQuality: " + quality + "\nWarranty (years): " + warrantyYears
                + "\nReplacement: " + replacement + "\nMaintenance (mechanic #): " + maintenanceNum;

        // notifies user if their equipment needs to be replaced
        if (quality.equals("very old") && replacement.equals("yes")) {
            info += "\n\nThis equipment needs to be replaced!";
        }

        return info;
    }

}