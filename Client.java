package Salon;

public class Client {
    //Instance Variables
    private String cliName;
    private String cliPhoneNum;
    private String address;
    private String email;
    private String age;
    private String sex;
    private String allergies;
    private String medication;
    private String pastService;
    private String productPurchase;
    private String review;

    //Constructors
    public Client() {
        cliName = "No Name";
        cliPhoneNum = "000-000-0000";
        address = "No Address";
        email = "No Email";
        age = "0";
        sex = "";
        allergies = "None";
        medication = "None";
        pastService = "None";
        productPurchase = "None";
        review = "No Review";
    }
    //Overloaded Constructor
    public Client(String newCliName, String newCliPhoneNum, String newAddress, String newAge, String newEmail, String newSex,
                  String newAllergies, String newMedication, String newPastService, String newProductPurchase, String newReview) {
        cliName = newCliName;
        cliPhoneNum = newCliPhoneNum;
        address = newAddress;
        age = newAge;
        email = newEmail;
        sex = newSex;
        allergies = newAllergies;
        medication = newMedication;
        pastService = newPastService;
        productPurchase = newProductPurchase;
        review = newReview;
    }

    //Modifiers
    //Sets client's name to user-inputted client name
    //Pre: User-inputted client's name String
    //Post: None
    public void setCliName(String newCliName) {
        cliName = newCliName;
    }
    //Sets client's phone # to user-inputted client phone #
    //Pre: User-inputted client's phone # String
    //Post: None
    public void setCliPhoneNum(String newCliPhoneNum) {
        cliPhoneNum = newCliPhoneNum;
    }
    //Sets client's address to user-inputted client address
    //Pre: User-inputted client's address String
    //Post: None
    public void setCliAddress(String newAddress) {
        address = newAddress;
    }
    //Sets client's age to user-inputted client age
    //Pre: User-inputted client's age String
    //Post: None
    public void setCliAge(String newAge) {
        age = newAge;
    }
    //Sets client's email to user-inputted client email
    //Pre: User-inputted client's email String
    //Post: None
    public void setCliEmail(String newEmail) {
        email = newEmail;
    }
    //Sets client's sex to user-inputted client sex
    //Pre: User-inputted client's sex String
    //Post: None
    public void setCliSex(String newSex) {
        sex = newSex;
    }
    //Sets client's allergies to user-inputted client allergies
    //Pre: User-inputted client's allergies String
    //Post: None
    public void setCliAllergies(String newAllergies) {
        allergies = newAllergies;
    }
    //Sets client's medication to user-inputted client medication
    //Pre: User-inputted client's medication String
    //Post: None
    public void setCliMedication(String newMedication) {
        medication = newMedication;
    }
    //Sets client's past services to user-inputted client past services
    //Pre: User-inputted client's past services String
    //Post: None
    public void setCliPastService(String newPastService) {
        pastService = newPastService;
    }
    //Sets client's purchased products to user-inputted client purchased products
    //Pre: User-inputted client's purchased products String
    //Post: None
    public void setCliProductPurchase(String newProductPurchase) {
        productPurchase = newProductPurchase;
    }
    //Sets client's review to user-inputted client review
    //Pre: User-inputted client's review String
    //Post: None
    public void setCliReview(String newReview) {
        review = newReview;
    }

    //Accessors
    //Returns client's name to main method
    //Pre: None
    //Post: Client's name String
    public String getCliName() {
        return cliName;
    }
    //Returns client's phone # to main method
    //Pre: None
    //Post: Client's phone # String
    public String getCliPhoneNum() {
        return cliPhoneNum;
    }
    //Returns client's address to main method
    //Pre: None
    //Post: Client's address String
    public String getCliAddress() {
        return address;
    }
    //Returns client's age to main method
    //Pre: None
    //Post: Client's age String
    public String getCliAge() {
        return age;
    }
    //Returns client's email to main method
    //Pre: None
    //Post: Client's email String
    public String getCliEmail() {
        return email;
    }
    //Returns client's sex to main method
    //Pre: None
    //Post: Client's sex String
    public String getCliSex() {
        return sex;
    }
    //Returns client's allergies to main method
    //Pre: None
    //Post: Client's allergies String
    public String getCliAllergies() {
        return allergies;
    }
    //Returns client's medication to main method
    //Pre: None
    //Post: Client's medication String
    public String getCliMedication() {
        return medication;
    }
    //Returns client's past services to main method
    //Pre: None
    //Post: Client's past services String
    public String getCliPastService() {
        return pastService;
    }
    //Returns client's purchased products to main method
    //Pre: None
    //Post: Client's purchased products String
    public String getCliProductPurchase() {
        return productPurchase;
    }
    //Returns client's review to main method
    //Pre: None
    //Post: Client's review String
    public String getCliReview() {
        return review;
    }

    //Helpers
    //Returns client's overall information to main method
    //Pre: None
    //Post: Client's info String
    public String toString() {
        String info = "Client Name: " + cliName
                +"\nClient's Phone #: " + cliPhoneNum
                +"\nClient's Address: " + address
                +"\nClient's Age: " + age
                +"\nClient's Email: " + email
                +"\nClient's Sex: " + sex
                +"\nClient's Allergies: " + allergies
                +"\nClient's Medication: " + medication
                +"\nClient's Past Services: " + pastService
                +"\nClient's Purchased Products: " + productPurchase
                +"\nClient's Review: " + review;
        return info;
    }
}