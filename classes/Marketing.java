package Salon;

import java.util.Scanner;
public class Marketing
{
    //Instance variables
    private int choice; //integer for storing the users choice
    private Scanner scan; // scanner
    private int bAmount; // temp value for the budget value
    private String[] gcAmount; // giftcard array to store the info
    private String[] smaAmount; //social media acocunts array to store the info
    private String[] pAmount; // promotions array to store the info
    private String[] oaAmount; // online ad's array to store the info

    //Sets all of the base values
    //constructer
    public Marketing(){
        choice = 0;
        scan = new Scanner(System.in);
        bAmount = 10000;
        gcAmount = new String[0];
        smaAmount = new String[0];
        pAmount = new String[0];
        oaAmount = new String[0];
    }
    // lists all of the options
    public void list(){
        System.out.println("\nWhich section would you like to look at? \n1: Budget \n2: Giftcards \n3: Social Media Accounts \n4: Promotions \n5: Name of Salon \n6: Online Advertising \n7: info \n8: Exit");
    }
    // modifer
    public void setChoice(int x){
        choice = x;
    }
    //Accessor
    public int getChoice(){
        return choice;
    }

    //returns the info of a specific section
    public String doMarketing(){
        if(getChoice() == 1){
            System.out.println("Whats your budget?");
            setBudgetAmount(scan.nextInt());
            return budget();
        }
        if(getChoice() == 2){
            System.out.println("How many giftcards do you want?");
            setGiftcards(scan.nextInt());
            return giftcards();
        }
        if(getChoice() == 3){
            System.out.println("How many social media accounts do you want?");
            setSocialMA(scan.nextInt());
            return socialMA();
        }
        if(getChoice() == 4){
            System.out.println("How many promotions do you want?");
            setPromotions(scan.nextInt());
            return promotions();
        }
        if(getChoice() == 5){
            return nameOS();
        }
        if(getChoice() == 6){
            System.out.println("How many online ad's do you want?");
            setOaAmount(scan.nextInt());
            return onlineA();
        }
        if(getChoice() == 7){
            return info();
        }
        else{
            return "Goodbye";
        }
    }

    /*
     * This sets the budget to whatever they want unless they want the default amount($10,000)
     * Input: Takes in whatever amount they want to set the budget
     * Inside: sets the budget value to whatever they chose
     * Output: N/a
     */
    public void setBudgetAmount(int x){
        bAmount = x;
    }

    /*
     * This returns the budget amount
     * input: nothing
     * inside: returns the amount
     * output: the amount
     */
    public int getBudgetAmount(){
        return bAmount;
    }

    /*
     * This returns the budget with some text
     * input: n/a
     * inside: returns text with the getBudgetAmount method
     * output: the budget amount with some text
     */
    public String budget(){
        System.out.println("The budget is: " + getBudgetAmount());
        return "";
    }

    /*
     * This sets the amount and the value of the giftcards;
     * input: takes in the amount of giftcards they want
     * inside: sets the value of the giftcard array lenght and the actual values inside
     * output: n/a
     */
    public void setGiftcards(int x){
        gcAmount = new String[x];
        System.out.println("Set the value of each giftcard");
        for(int i = 0; i < gcAmount.length;i++){
            gcAmount[i] = scan.next();
        }
    }

    /*
     * Input: n/a
     * inside: prints out the gift card amounts
     * output: returns the values of the giftcards
     */
    public String giftcards(){
        System.out.println("The giftcard values are : ");
        for(int i = 0; i < gcAmount.length;i++){
            System.out.print(gcAmount[i] + ", ");
        }
        return "";
    }

    /*
     * input: takes in the amount of social media accounts they want to make
     * inside: sets the amount of accounts they want to make and what the names are
     * ouput: n/a
     */
    public void setSocialMA(int x){
        smaAmount = new String[x];
        System.out.println("Pick the name of the social medias");
        for(int i = 0; i < smaAmount.length; i++){
            smaAmount[i] = scan.next();
        }
    }

    /*
     * Input: n/a
     * inside: prints out the social media accounts
     * output: returns the info about the accounts
     */
    public String socialMA(){
        System.out.println("The social media accounts are : ");
        for(int i = 0; i < smaAmount.length; i++){
            System.out.println(smaAmount[i]);
        }
        return "";
    }

    /*
     * input: takes in the amount of promotions they want to make
     * inside: sets the amount of promotions they want to make and what the names are
     * ouput: n/a
     */
    public void setPromotions(int x){
        pAmount = new String[x+1];
        System.out.println("Pick the names of the promotions : ");
        for(int i = 0; i < pAmount.length; i++){
            pAmount[i] = scan.nextLine();
        }
    }

    /*
     * Input: n/a
     * inside: prints out the promotions
     * output: returns the info about the promotions
     */
    public String promotions(){
        System.out.println("The promotions are : ");
        for(int i = 0; i < pAmount.length; i++){
            if(pAmount[i].equals("")){
                i++;
            }
            System.out.println(pAmount[i]);
        }
        return "";
    }

    /*
     * input: n/a
     * inside: returns the name
     * output: the name of the salon
     */
    public String nameOS(){
        System.out.println("H&C Salon");
        return "";
    }

    /*
     * input: takes in the amount of online ad's they want to make
     * inside: sets the amount of ad's they want to make and what the names are
     * ouput: n/a
     */
    public void setOaAmount(int x){
        oaAmount = new String[x];
        System.out.println("Pick the types of online ad's (one by one) : ");
        for(int i = 0; i < oaAmount.length;i++){
            oaAmount[i] = scan.next();
        }
    }

    /*
     * Input: n/a
     * inside: prints out the online ad's
     * output: returns the info about the online ad's
     */
    public String onlineA(){
        System.out.println("The online ad's are : ");
        for(int i = 0; i < oaAmount.length; i++){
            System.out.println(oaAmount[i]);
        }
        return "";
    }

    public String line(){
        return "\n";
    }

    public String info(){
        System.out.print("The name of the salon is : ");
        return nameOS() + line() + budget() + line() + giftcards() + line() + socialMA() + line() + promotions() + line() + onlineA();
    }

    /*
     * input: n/a
     * inside: lists out all the options, takes the choice of the user, does the method for the choice and prints it out
     * output: the info of the choice the user makes
     */
    public String toString(){
        System.out.print("-----------------------------");
        while(getChoice() < 8){
            list();
            setChoice(scan.nextInt());
            doMarketing();
        }
        return "";
    }
}