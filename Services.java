package Salon;

import java.util.Scanner;

public class Services{
    //Instance variables
    private String haircuts;
    private String coloring;
    private String blowouts;
    private String treatments;
    private String foils;
    private String hairstyling;
    private int time;
    private int price;
    private int choice;
    private Client a;
    private String pick;
    private String[] restock;
    private Services s;
    private Supplies sup = new Supplies();

    //Constucter
    public Services(){
        haircuts = "";
        coloring = "";
        blowouts = "";
        treatments = "";
        foils = "";
        hairstyling = "";
        time = 0;
        price = 0;
        choice = 0;
        a = new Client();
        pick = "";
    }
    /*
     * Input: Takes in the supplies as an array
     * Inside: compares the current quantity to the minimum
     * output: Outputs if a item needs to be restocked.
     */
    public String checker(Supplies[] x) {
        System.out.println("...........................................................\n");
        int counter = 0;
        for(int i = 0; i < x.length;i++){
            if(x[i].getQuantity() <= x[i].getMinQuantity()){
                System.out.println(x[i].getProduct() + " needs to be restocked");
                counter++;
            }
            else{
                if(counter == 0 && i == x.length-1){
                    System.out.println("Nothing needs to be restocked");
                }
            }
        }
        System.out.println("\n...........................................................");
        return "";
    }
    //lists the options
    public void list(){
        System.out.println("Pick a service \n1: haircuts \n2: coloring \n3: blowouts \n4: treatments \n5: foils \n6: hairstyling \n7: leave");
    }
    //modifer
    public void setService(int x){
        choice = x;
    }
    //accessor
    public int getService(){
        return choice;
    }
    //returns the info of a specific section
    public String doService(Client c){
        Scanner scan = new Scanner(System.in); //scanner to let the client pick
        if(getService() == 1){
            //checks if they wanted a haircut
            pick = "haircuts"; //sets the pick variable to what the client picked
            return doHaircuts(c);
        }
        if(getService() == 2){
            //checks if they wanted coloring
            System.out.println("1: Full Head Color \n2: Roots Touch up \n3: Color Toning");
            int x = scan.nextInt();
            if(x == 1){
                //checks if they wanted the first option
                int temp = 1; //temp value to guide the method in doing the right option
                pick = "Full Head Color"; //sets the pick variable to what the client picked
                return doColoring(temp);
            }
            else if(x == 2){
                //if client wanted second option
                int temp = 2; //temp value to guide the method in doing the right option
                pick = "Roots Touch up"; //sets the pick variable to what the client picked
                return doColoring(temp);
            }
            else{
                //if client wanted third option
                int temp = 3; //temp value to guide the method in doing the right option
                pick = "Color Toning"; //sets the pick variable to what the client picked
                return doColoring(temp);
            }
        }
        if(getService() == 3){
            //if client wanted blowouts
            System.out.println("1: Wash and Blow out \n2: Wash, Blowout and Curl");
            int x = scan.nextInt();
            if(x == 1){
                //if client wanted first option
                int temp = 1; //temp value to guide the method in doing the right option
                pick = "Wash and Blow out"; //sets the pick variable to what the client picked
                return doBlowouts(temp);
            }
            else{
                //if client wanted second option
                int temp = 2; //temp value to guide the method in doing the right option
                pick = "Wash, Blowout and Curl"; //sets the pick variable to what the client picked
                return doBlowouts(temp);
            }
        }
        if(getService() == 4){
            //if client wanted treatments
            System.out.println("1: Olaplex Treatments \n2: Keratin Defrizz Treatment \n3: Repair Treatment");
            int x = scan.nextInt();
            if(x == 1){
                //if client wanted first option
                int temp = 1; //temp value to guide the method in doing the right option
                pick = "Olaplex Treatments"; //sets the pick variable to what the client picked
                return doTreatments(temp);
            }
            else if(x == 2){
                //if client wanted second option
                int temp = 2; //temp value to guide the method in doing the right option
                pick = "Keratin Defrizz Treatment"; //sets the pick variable to what the client picked
                return doTreatments(temp);
            }
            else{
                //if client wanted third option
                int temp = 3; //temp value to guide the method in doing the right option
                pick = "Repair Treatment"; //sets the pick variable to what the client picked
                return doTreatments(temp);
            }
        }
        if(getService() == 5){
            //if client wanted foils
            System.out.println("1: Full Head Highlights \n2: Half-Head Highlights \n3: Balayage/Ombre \n4: Bleach Root Touchup");
            int x = scan.nextInt();
            if(x == 1){
                //if client wanted first option
                int temp = 1; //temp value to guide the method in doing the right option
                pick = "Full Head Highlights"; //sets the pick variable to what the client picked
                return doFoils(temp);
            }
            else if(x == 2){
                //if client wanted second option
                int temp = 2; //temp value to guide the method in doing the right option
                pick = "Half-Head Highlights"; //sets the pick variable to what the client picked
                return doFoils(temp);
            }
            else if(x == 3){
                //if client wanted third option
                int temp = 3; //temp value to guide the method in doing the right option
                pick = "Balayage/Ombre"; //sets the pick variable to what the client picked
                return doFoils(temp);
            }
            else{
                //if client wanted fourth option
                int temp = 4; //temp value to guide the method in doing the right option
                pick = "leach Root Touchup"; //sets the pick variable to what the client picked
                return doFoils(temp);
            }
        }
        else if(getService() == 6){
            //if client wanted hairstyling
            System.out.println("1: Braids \n2: Updos");
            int x = scan.nextInt();
            if(x == 1){
                //if client wanted first option
                int temp = 1; //temp value to guide the method in doing the right option
                pick = "Braids"; //sets the pick variable to what the client picked
                return doHairStyling(temp);
            }
            else{
                //if client wanted second option
                int temp = 2; //temp value to guide the method in doing the right option
                pick = "Updos"; //sets the pick variable to what the client picked
                return doHairStyling(temp);
            }
        }
        else{
            return "Goodbye";
        }
    }

    /*
     * input: takes in the clint to find the age & gender of client
     * inside: finds the age & gender to find which service belongs to them
     * output: returns the correct haircut for the specific client
     */
    public String doHaircuts(Client c){
        int i = 0; // place holder for client age as an int
        try{
            i = Integer.parseInt(c.getCliAge()); // turns the client String age to an int age
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        if(i >= 18 && c.getCliSex().equalsIgnoreCase("female")){
            //checks if the client is a female who is 18 or older
            setTime(60);
            setPrice(45);
            return ("The price is $45 and the it will take 60 minutes");
        }
        else if(i >= 18 && c.getCliSex().equalsIgnoreCase("male")){
            //checks if the client is a male who is 18 or older
            setTime(30);
            setPrice(30);
            return ("The price is $30 and the it will take 30 minutes");
        }
        else{
            //if the client is not above or equal to 18
            setTime(30);
            setPrice(25);
            return ("The price is $25 and the it will take 30 minutes");
        }
    }
    //modifer
    public void setPrice(int x){
        price = x;
    }
    //modifer
    public void setTime(int x){
        time = x;
    }

    /*
     * input: takes in a temp value to see which of the colouring to actually preform
     * inside: checks which coloring to do and corrospondingly sets the time and price
     * output: the price and time in minutes
     */
    public String doColoring(int temp){
        if(temp == 1){
            //if client wanted first option
            setTime(120);
            setPrice(70);
            return ("The price is $70 and the it will take 120 minutes");
        }
        else if(temp == 2){
            //if client wanted second option
            setTime(90);
            setPrice(50);
            return ("The price is $50 and the it will take 90 minutes");
        }
        else{
            //if client wanted third option
            setTime(120);
            setPrice(60);
            return ("The price is $60 and the it will take 120 minutes");
        }
    }

    /*
     * input: takes in a temp value to see which of the blowouts to actually preform
     * inside: checks which blowouts to do and corrospondingly sets the time and price
     * output: the price and time in minutes
     */
    public String doBlowouts(int temp){
        if(temp == 1){
            //if client wanted first option
            setTime(30);
            setPrice(50);
            return ("The price is $50 and the it will take 30 minutes");
        }
        else{
            //if client wanted second option
            setTime(60);
            setPrice(65);
            return ("The price is $70 and the it will take 60 minutes");
        }
    }

    /*
     * input: takes in a temp value to see which of the treatments to actually preform
     * inside: checks which treatment to do and corrospondingly sets the time and price
     * output: the price and time in minutes
     */
    public String doTreatments(int temp){
        if(temp == 1){
            //if client wanted first option
            setTime(90);
            setPrice(55);
            return ("The price is $55 and the it will take 90 minutes");
        }
        else if(temp == 2){
            //if client wanted second option
            setTime(90);
            setPrice(200);
            return ("The price is $200 and the it will take 90 minutes");
        }
        else{
            //if client wanted third option
            setTime(90);
            setPrice(30);
            return ("The price is $30 and the it will take 90 minutes");
        }
    }

    /*
     * input: takes in a temp value to see which of the foil to actually preform
     * inside: checks which foil to do and corrospondingly sets the time and price
     * output: the price and time in minutes
     */
    public String doFoils(int temp){
        if(temp == 1){
            //if client wanted first option
            setTime(210);
            setPrice(120);
            return ("The price is $120and the it will take 210 minutes");
        }
        else if(temp == 2){
            //if client wanted second option
            setTime(150);
            setPrice(90);
            return ("The price is $90 and the it will take 150 minutes");
        }
        else if(temp == 3){
            //if client wanted third option
            setTime(210);
            setPrice(190);
            return ("The price is $30 and the it will take 210 minutes");
        }
        else{
            //if client wanted fourth option
            setTime(120);
            setPrice(65);
            return ("The price is $65 and the it will take 120 minutes");
        }
    }

    /*
     * input: takes in a temp value to see which of the hairstyling to actually preform
     * inside: checks which hairstyling to do and corrospondingly sets the time and price
     * output: the price and time in minutes
     */
    public String doHairStyling(int temp){
        if(temp == 1){
            //if client wanted first option
            setTime(30);
            setPrice(25);
            return ("The price is $25 and the it will take 30 minutes");
        }
        else{
            //if client wanted second option
            setTime(60);
            setPrice(55);
            return ("The price is $55 and the it will take 60 minutes");
        }
    }

    //accessor
    public int getTime(Client c){
        return time;
    }

    //accessor
    public int getPrice(Client c){
        return price;
    }

    /*
     * input: takes in the Client
     * inside: does the service, prints out what the client picked, the price, and the time
     * output: what the client picked, the price and the time
     */
    public void runServices(Client c) {
        doService(c);
        System.out.println("The client picked " + pick + "\nThe price is $" + getPrice(c) + "\nThe time it will take is " + getTime(c) + " minutes");
    }
}