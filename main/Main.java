package Salon;

/* Avi Walia
 * Ms. Katsman
 * April 26
 * ICS4U
 *
 * This code creates a virtual salon that fulfills the needs and requirements of the Hair Styling and Aesthetics
 * class at Maple High School. The client can log in as admin or as employee. There are no passwords set
 * because we were asked not to. When the clients log in as either admin or employee, they will then see menus
 * outlining what they can do.
 * The admin menu includes making changes to the schedule and inventory as well as
 * accessing the client list and marketing.
 * The employee menu allows the client to do things that are more specific to each employee such as viewing their own
 * personal schedules, information, logging their hours and viewing their wages for the day.
 * The code backs everything up to files upon closing the interface so when client logs back in at a later time, their
 * old information such as inventory, client list and employee information will still be saved.
 *
 * I was unable to back up the schedule to a file, so it must be reset every time you restart the code.
 */

//import statements
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Creating marketing and services objects
        Marketing m = new Marketing();
        Services services = new Services();

        //Set list of current employees. If there are any changes to staff, code must be updated.
        String[] employeesList = {"Larry", "Squidward", "Plankton", "Sandy", "Patrick"};

        //Creating list of 14 Schedule objects (for 2 weeks)
        Schedule[] masterSchedule = new Schedule[14];
        for (int i = 0; i < 14; i++) {
            masterSchedule[i] = new Schedule();
        }

        //Creating Files to restore old data
        File clientsFile = new File("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Clients.txt");
        File employeesFile = new File("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Employee.txt");
        File equipInvFile = new File("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Equipment.txt");
        File suppInvFile = new File("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Supplies.txt");

        //Creating Arrays of objects from the files

        //Creating array of Supplies objects (inventory)
        String[][] supplyArray = fileToArray(suppInvFile);
        //converts 2D array of info to 1D array of Supplies objects
        Supplies[] supplies = new Supplies[supplyArray.length];
        for (int i = 0; i<supplyArray.length; i++){
            supplies[i] = new Supplies(supplyArray[i][0], supplyArray[i][1], supplyArray[i][2],
                    supplyArray[i][3], supplyArray[i][4], supplyArray[i][5], supplyArray[i][6]);
        }

        //Creating array of Equipment objects (inventory)
        String[][] equipmentArray = fileToArray(equipInvFile);
        //converts 2D array of info to 1D array of Equipment objects
        Equipment[] equipment = new Equipment[equipmentArray.length];
        for (int i = 0; i<equipmentArray.length; i++){
            equipment[i] = new Equipment(equipmentArray[i][0], equipmentArray[i][1], equipmentArray[i][2],
                    equipmentArray[i][3], equipmentArray[i][4], equipmentArray[i][5], equipmentArray[i][6],
                    equipmentArray[i][7], equipmentArray[i][8]);
        }

        //Creating array of Supplies objects (inventory)
        String[][] employeesArray = fileToArray(employeesFile);
        //converts 2D array of info to 1D array of Employee objects
        Employee[] employees = new Employee[employeesArray.length];
        for (int i = 0; i < employeesArray.length; i++){
            employees[i] = new Employee(employeesArray[i][0], employeesArray[i][1]);
        }

        //Creating array of Client objects (client list)
        String[][] clientsArray = fileToArray(clientsFile);
        //converts 2D array of info to 1D array of Client objects
        Client[] clients = new Client[clientsArray.length];
        for (int i = 0; i < clientsArray.length; i++){
            clients[i] = new Client(clientsArray[i][0], clientsArray[i][1], clientsArray[i][2], clientsArray[i][3],
                    clientsArray[i][4], clientsArray[i][5], clientsArray[i][6], clientsArray[i][7],
                    clientsArray[i][8], clientsArray[i][9], clientsArray[i][10]);
        }

        //Menus
        //Menu for when logging in as admin
        String adminMenu = "\nWhat would you like to do?\n" +
                "1. Update Schedule\n" +
                "2. View Master Schedule\n" +
                "3. Access Inventory\n" +
                "4. Access Marketing\n" +
                "5. Show Client List\n" +
                "6. Log out\n" +
                "Enter a number: ";

        //Menu for when logging in as employee
        String employeeMenu = "\nWhat would you like to do?\n" +
                "1. View Your Schedule\n" +
                "2. Enter Hours Worked\n" +
                "3. Calculate Wages\n" +
                "4. View Employee Info\n" +
                "5. Log out\n" +
                "Enter a number: ";

        //Menu for when user selects "Update Schedule"
        String scheduleMenu = "\nWhat would you like to do?\n" +
                "1. Start New Week\n" +
                "2. Add Booking\n" +
                "3. Delete Booking\n" +
                "4. Exit\n" +
                "Enter a number: ";

        //Menu for when user wants to access supplies inventory
        String suppliesInventoryMenu = "\nWhat would you like to do?\n" +
                "1. View Entire Inventory\n" +
                "2. Search by Category\n" +
                "3. Update Inventory\n"+
                "4. Add New Item\n" +
                "5. Check Restock\n" +
                "6. Exit\n" +
                "Enter a number: ";

        //Menu for when user want to access equipment inventory
        String equipmentInventoryMenu = "\nWhat would you like to do?\n" +
                "1. View Entire Inventory\n" +
                "2. Update Inventory\n"+
                "3. Add New Item\n" +
                "4. Exit\n" +
                "Enter a number: ";

        //Loop for program to keep running until user wants to stop
        boolean running = true; //when running is set to false, the loop will stop asking user what they want to do.
        while (running) {
            //Ask who is logging on
            System.out.println("Type 'Exit' to quit");
            System.out.print("Who is logging on? (Employee Name / Admin): ");
            String user = input.nextLine().toLowerCase();
            if (user.equals("exit")){
                running = false;
            } else if (user.equals("admin")) { //For Admin Login
                while (user.equals("admin")) {
                    //Displaying options for admin
                    System.out.print(adminMenu);
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.println();

                    if (choice == 1) { //Update Schedule
                        boolean scheduleRunning = true;
                        while (scheduleRunning) {
                            //Displaying update schedule options
                            System.out.print(scheduleMenu);
                            int scheduleChoice = input.nextInt();
                            input.nextLine();
                            System.out.println();

                            if (scheduleChoice == 1) { //Creates new week
                                //will move next week's schedule to this week and create a blank schedule for week 2
                                //used at the end of the week to reset the schedule
                                Schedule.refreshAll(masterSchedule);

                            } else if (scheduleChoice == 2) { //Book Clients
                                //Checks if the customer already exists in the database
                                System.out.println("Is this a repeating customer? (y/n)");
                                String answer = input.nextLine().toLowerCase();
                                Client bookingClient = new Client();

                                //if they do, you can reference them through their email
                                if (answer.equals("y")){
                                    System.out.println("Enter email:");
                                    String cEmail = input.nextLine().toLowerCase();
                                    boolean clientFound = false;
                                    //Checks that the email is correct, will continue looping until valid email entered.
                                    while (!clientFound) {
                                        for (Client c : clients) {
                                            if (cEmail.equals(c.getCliEmail().toLowerCase())) {
                                                clientFound = true;
                                                bookingClient = c;
                                            }
                                        }
                                        if (!clientFound) {
                                            System.out.print("Client not Found. Try Again or type Exit to make new client: ");
                                            user = input.nextLine().toLowerCase();
                                            if (user.equals("exit")) {
                                                clientFound = true;
                                                Client[] tempArr = new Client[clients.length + 1];
                                                int i = 0;
                                                for (; i < clients.length; i++) {
                                                    tempArr[i] = clients[i];
                                                }
                                                tempArr[i] = setClientObject();
                                                clients = tempArr;
                                                bookingClient = clients[i];
                                            }
                                        }
                                    }
                                } else { //if the client does not already exist, add them to list of clients
                                    Client[] tempArr = new Client[clients.length + 1];
                                    int i = 0;
                                    for (; i< clients.length; i++){
                                        tempArr[i] = clients[i];
                                    }
                                    tempArr[i] = setClientObject();
                                    clients = tempArr;
                                    bookingClient = clients[i];
                                }

                                //List services available
                                services.list();
                                //Pick which service they would like to do
                                services.setService(input.nextInt());
                                //Will output cost and time of service based on parameters of client (age, gender, etc.)
                                services.runServices(bookingClient);

                                //Ask user which day they want to book (from 1-14; Monday to Sunday for 2 weeks)
                                System.out.print("For which day would you like to book " +
                                        "(Enter Number 1-14 (Monday to Sunday). Type 0 to cancel): ");
                                int day = input.nextInt();
                                input.nextLine();

                                //if they enter 0, don't book
                                if (day == 0){
                                    System.out.println();
                                } else if (day > 0 && day < 15) { //if they enter a valid day book
                                    //Get Start Time
                                    System.out.println("Enter times only at :00 and :30");
                                    System.out.print("Enter start time ('9:00', '12:30', etc): ");
                                    String start = input.nextLine();
                                    //Get end time
                                    System.out.print("Enter End Time ('9:00', '12:30', etc): ");
                                    String end = input.nextLine();
                                    //Get employee name
                                    System.out.print("Enter Employee Name: ");
                                    String eName = input.nextLine();

                                    //Make sure they enter valid employee name
                                    boolean inArray = false;
                                    for (String name : employeesList){
                                        if (eName.equals(name)) {
                                            inArray = true;
                                            break;
                                        }
                                    }
                                    //Will re-prompt if name is not valid
                                    if (!inArray){
                                        System.out.println("Sorry that Employee does not exist. Try Again: ");
                                        eName = input.nextLine();
                                    }

                                    //Get service that is being done
                                    System.out.print("Enter Service: ");
                                    String service = input.nextLine();
                                    //call bookClient method from Schedule class
                                    masterSchedule[day - 1].bookClient(start, end, bookingClient.getCliName(), eName, service);
                                }

                            } else if (scheduleChoice == 3) { //Delete Booking
                                //Ask user which day they want to delete booking (1-14: Monday to Sunday for 2 weeks)
                                System.out.print("For which day would you like to delete booking " +
                                        "(Enter Number 1-14 (Monday to Sunday). Type 0 to cancel): ");
                                int day = input.nextInt();
                                input.nextLine();
                                //if they enter 0, don't cancel anything
                                if (day == 0){
                                    System.out.println();
                                } else if (day > 0 && day < 15) { //if they enter a valid day
                                    //Get Start Time
                                    System.out.println("Enter times only at :00 and :30");
                                    System.out.print("Enter start time ('9:00', '12:30', etc): ");
                                    String start = input.nextLine();
                                    //Get end time
                                    System.out.print("Enter End Time ('9:00', '12:30', etc): ");
                                    String end = input.nextLine();
                                    //Get employee name
                                    System.out.print("Enter Employee Name: ");
                                    String eName = input.nextLine();
                                    //Make sure they input valid employee name
                                    boolean inArray = false;
                                    for (String name : employeesList){
                                        if (eName.equals(name)) {
                                            inArray = true;
                                            break;
                                        }
                                    }
                                    //re-prompts if invalid input
                                    if (!inArray){
                                        System.out.println("Sorry that Employee does not exist. Try Again: ");
                                        eName = input.nextLine();
                                    }

                                    masterSchedule[day - 1].deleteTimeSlots(start, end, eName);
                                }

                            } else { //if they enter any other option, it will go back to the admin menu
                                scheduleRunning = false;
                            }
                        }

                    } else if (choice == 2) { //Print Master Schedule
                        //Asks which day to view schedule for
                        System.out.print("For which day would you like to view the schedule? " +
                                "(Enter Number 1-14 (Monday to Sunday) Type 0 to print this weeks): ");
                        int day = input.nextInt();
                        input.nextLine();
                        if (day == 0){ //if they enter 0, print the whole week's schedule
                            printMasterSchedule(masterSchedule);
                        } else if (day > 0 && day < 15){
                            System.out.println(masterSchedule[day-1]);
                        }

                    } else if (choice == 3) { //Inventory
                        boolean inventoryRunning = true;
                        while (inventoryRunning){
                            //print inventory menu
                            System.out.print("Would you like to view supplies or equipment? " +
                                    "(Enter 1 for Supplies, 2 for Equipment, and 0 to Exit): ");
                            int inventoryChoice = input.nextInt();
                            input.nextLine();

                            //Supplies
                            if (inventoryChoice == 1) {
                                boolean suppInvRunning = true;
                                while (suppInvRunning){
                                    //Print supplies inventory menu
                                    System.out.print(suppliesInventoryMenu);
                                    int iMenuChoice = input.nextInt();
                                    input.nextLine();
                                    System.out.println();

                                    if (iMenuChoice == 1) { //print info of all supplies
                                        for (Supplies s : supplies) {
                                            System.out.println(s);
                                            System.out.println();
                                        }

                                    } else if (iMenuChoice == 2) { //print all supplies of certain category
                                        String[] categories = new String[supplies.length];
                                        //getting list of all categories (will include repeats)
                                        for (int i = 0; i < categories.length; i++){
                                            categories[i] = supplies[i].getCategory();
                                        }

                                        //Creating new string without repeats
                                        String[] reducedCategories = new String[categories.length];
                                        System.out.println("Categories:");
                                        int index = 0; //variable to increment reduced array index
                                        //Loop through each item in categories
                                        for (int i = 0; i < categories.length; i++){
                                            int flag = 0;
                                            for (int j = 0; j < i; j++){
                                                //compare elements and skip duplicates
                                                if (categories[i].equals(categories[j])){
                                                    flag = 1;
                                                    break;
                                                }
                                            }
                                            //only add category if it is unique
                                            if (flag == 0){
                                                reducedCategories[index] = categories[i];
                                                index ++;
                                            }
                                        }
                                        //printing categories
                                        for (int i = 0; i < index; i++){
                                            System.out.print(reducedCategories[i] + "  ");
                                        }
                                        //asking user which category to search from
                                        System.out.println("\nWhich category would you like to search from?");
                                        //call static method filteredSearch from Supplies with search parameter
                                        Supplies[] filteredList = Supplies.filteredSearch(input.nextLine(), supplies);
                                        //printing the list of supplies
                                        for (Supplies s : filteredList) {
                                            System.out.println(s + "\n");
                                        }

                                    } else if (iMenuChoice == 3) { //Updating Inventory
                                        //asking which product to update
                                        System.out.print("Which product would you like to update (Enter Product Name): ");
                                        String productName = input.nextLine().toLowerCase();
                                        //finding product from supplies array
                                        int index = -1;
                                        while (index == -1) {
                                            for (int i = 0; i < supplies.length; i++) {
                                                //finding which supply matches with what the user gave
                                                if (supplies[i].getProduct().toLowerCase().equals(productName)) {
                                                    index = i;
                                                }
                                            }
                                            //re-prompting if user enters invalid input
                                            if (index == -1) {
                                                System.out.print("Invalid Input. Try Again: ");
                                                productName = input.nextLine().toLowerCase();
                                            }
                                        }
                                        //displaying old inventory value
                                        System.out.println("Old Value: " + supplies[index].getQuantity());
                                        //asking for new inventory value
                                        System.out.print("Enter new value? ");
                                        supplies[index].setQuantity(input.nextInt());
                                        input.nextLine();

                                    } else if (iMenuChoice == 4){ //Adding new product to supplies array
                                        //creating temporary array with length one larger
                                        Supplies[] tempArr = new Supplies[supplies.length + 1];
                                        //copying everything to tempArr
                                        int i = 0;
                                        for (; i< supplies.length; i++){
                                            tempArr[i] = supplies[i];
                                        }
                                        //adding new supply object with setSupplyObject method
                                        tempArr[i] = setSupplyObject();
                                        //copying from tempArr back to supply array
                                        supplies = tempArr;

                                    } else if (iMenuChoice == 5){ //Check restock
                                        //use checker method from Services class. Checks if any items need restocking
                                        //Will display a list
                                        services.checker(supplies);

                                    } else { //will go back to inventory menu
                                        suppInvRunning = false;
                                    }
                                }
                                //Equipment
                            } else if (inventoryChoice == 2){
                                boolean equipInvRunning = true;
                                while (equipInvRunning){
                                    //Displaying equipment menu
                                    System.out.print(equipmentInventoryMenu);
                                    int iMenuChoice = input.nextInt();
                                    input.nextLine();
                                    System.out.println();

                                    if (iMenuChoice == 1){ //print list of all equipment
                                        for (Equipment e : equipment){
                                            System.out.println(e + "\n");
                                        }

                                    } else if (iMenuChoice == 2){//Update Equipment Stock
                                        System.out.print("Which product would you like to update? (Enter name) ");
                                        String productName = input.nextLine().toLowerCase();
                                        int index = -1;
                                        while (index == -1) {
                                            //checks if equipment name user gave is in list and saves the index of the object if it exists.
                                            for (int i = 0; i < equipment.length; i++) {
                                                if (equipment[i].getEquipmentName().toLowerCase().equals(productName)) {
                                                    index = i;
                                                }
                                            }
                                            //if name not in list, program will re-prompt user to give correct equipment name
                                            if (index == -1) {
                                                System.out.print("Invalid Input. Try Again: ");
                                                productName = input.nextLine().toLowerCase();
                                            }
                                        }

                                        //Update relevant equipment info
                                        //Update quantity
                                        System.out.println("Enter quantity: ");
                                        int quantity = input.nextInt();
                                        input.nextLine();
                                        equipment[index].setQuantity(quantity);
                                        //Update quality
                                        System.out.println("Enter quality: ");
                                        String quality = input.nextLine();
                                        quality = quality.toLowerCase();
                                        equipment[index].setQuality(quality);
                                        //Update replacement value
                                        System.out.println("Enter replacement (yes/no)");
                                        //Making sure correct input is giving (yes/no)
                                        boolean correctInput;
                                        do {
                                            String replacement = input.next();
                                            replacement = replacement.toLowerCase();

                                            if (replacement.equals("yes") || replacement.equals("no")) {
                                                correctInput = true;
                                                equipment[index].setReplacement(replacement);
                                            } else {
                                                System.out.print("Invalid input, please enter yes or no.");
                                                correctInput = false;
                                            }
                                        } while (!correctInput);
                                        //Update mechanic number
                                        System.out.println("Enter maintenance mechanic #: ");
                                        input.nextLine();
                                        String maintenanceNum = input.nextLine();
                                        equipment[index].setMaintenanceNum(maintenanceNum);

                                    } else if (iMenuChoice == 3){ //Add new piece of equipment
                                        //create temporary array
                                        Equipment[] tempArr = new Equipment[equipment.length + 1];
                                        //copy contents of equipment to tempArr
                                        int i = 0;
                                        for (; i< equipment.length; i++){
                                            tempArr[i] = equipment[i];
                                        }
                                        //adds new object to array using setEquipmentObject method
                                        tempArr[i] = setEquipmentObject();
                                        //copying tempArr back to equipment with new object
                                        equipment = tempArr;

                                    } else { //will return to inventory menu
                                        equipInvRunning = false;
                                    }
                                }

                            } else { //will return to admin menu
                                inventoryRunning = false;
                            }
                        }

                    } else if (choice == 4) { //will run marketing
                        System.out.println(m);

                    } else if (choice == 5) { //will print entire client list and their info
                        for (Client c: clients){
                            System.out.println(c + "\n");
                        }
                    } else { //Log out
                        user = ""; //break loop, go back to log in loop
                    }
                }

                //For Employee Login
            } else {
                //Checking if employee name that user inputs is a valid name;
                boolean employeeFound = false;
                Employee userEmployee = new Employee();
                //loop until valid employee name is entered
                while (!employeeFound) {
                    for (Employee e : employees) {
                        if (user.equals(e.getEmpName().toLowerCase())) {
                            //if input is valid, then set userEmployee as correct employee.
                            employeeFound = true;
                            userEmployee = e;
                        }
                    }
                    //if input is not valid, re-prompt user
                    if (!employeeFound) {
                        System.out.println("Employee not Found");
                        System.out.println("Employee List");
                        for (String name : employeesList){
                            System.out.print(name + "  ");
                        }
                        System.out.print("\nTry Again: ");
                        user = input.nextLine().toLowerCase();
                    }
                }

                //will loop until employee logs out
                while (user.equals(userEmployee.getEmpName().toLowerCase())) {
                    //print employee menu
                    System.out.print(employeeMenu);
                    //get user choice
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.println();

                    if (choice == 1) { //View their schedule
                        //ask for which day
                        System.out.print("For which day would you like to view your schedule? " +
                                "(Enter Number 1-14): ");
                        int day = input.nextInt();
                        input.nextLine();
                        //prints their schedule for the day
                        masterSchedule[day-1].viewEmployee(userEmployee.getEmpName());

                    } else if (choice == 2) { //Set hours worked for the day
                        //ask user how many hours they worked
                        System.out.print("Enter the number of hours you worked today: ");
                        //save it in clockInOut variable in Employee class
                        userEmployee.setClockInOut(input.nextInt());
                        input.nextLine();

                    } else if (choice == 3) { //Checks salary for the day based on hours worked (choice 2)
                        //calculates salary using empSalary method in Employee class (plus random tip)
                        userEmployee.empSalary(userEmployee.getClockInOut());
                        //shows user their wages for the day
                        System.out.println("Your wages for the day are: " + userEmployee.getEmpSalary());

                    } else if (choice == 4) { //Employee info
                        //display employee info (name and phone number)
                        System.out.println(userEmployee);

                    } else if (choice == 5) { //Log out
                        user = ""; //break loop, go back to log in loop
                    }
                }
            }
        }

        //Writing to Files

        try {
            //Refreshing client file after loop ends
            FileWriter fwClient = new FileWriter("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Clients.txt", false);
            PrintWriter pwClient = new PrintWriter(fwClient, false);
            //Erasing the current contents of Client file
            pwClient.flush();
            //Writing info of every Client object to Client file
            for (Client c: clients){
                fwClient.write(c.getCliName() + "," + c.getCliPhoneNum() + "," + c.getCliAddress() + "," +
                        c.getCliAge() + "," + c.getCliEmail() + "," + c.getCliSex() + "," +
                        c.getCliAllergies() + "," + c.getCliMedication() + "," + c.getCliPastService() + "," +
                        c.getCliProductPurchase() + "," + c.getCliReview() + "\n");
            }
            //closing FileWriter and PrintWriter
            fwClient.flush();
            fwClient.close();

            //Refreshing Employee File
            FileWriter fwEmployee = new FileWriter("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Employee.txt", false);
            PrintWriter pwEmployee = new PrintWriter(fwEmployee, false);
            //Erasing current contents of Employee File
            pwEmployee.flush();
            //Writing info of every Employee object to Employee file
            for (Employee e : employees){
                fwEmployee.write(e.getEmpName() + "," + e.getEmpPhoneNum() + "\n");
            }
            //closing FileWriter and PrintWriter
            fwEmployee.flush();
            fwEmployee.close();

            //Refreshing Equipment File
            FileWriter fwEquipment = new FileWriter("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Equipment.txt", false);
            PrintWriter pwEquipment = new PrintWriter(fwEquipment, false);
            //Erasing current contents of Equipment file
            pwEquipment.flush();
            //Writing info of every Equipment object to Equipment file
            for (Equipment eq : equipment){
                fwEquipment.write(eq.getEquipmentName() + "," + eq.getQuantity() + "," + eq.getCost() + "," +
                        eq.getYear() + "," + eq.getModel() + "," + eq.getQuality() + "," + eq.getWarrantyYears() + "," +
                        eq.getReplacement() + "," + eq.getMaintenanceNum() + "\n");
            }
            //closing FileWriter and PrintWriter
            fwEquipment.flush();
            fwEquipment.close();

            //Refreshing Supplies File
            FileWriter fwSupplies = new FileWriter("/Users/aviwalia/IdeaProjects/ICS4U/src/Salon/Supplies.txt", false);
            PrintWriter pwSupplies = new PrintWriter(fwSupplies, false);
            //Erasing contents of Supplies file
            pwSupplies.flush();
            //Writing info of every Supplies object to Supplies file
            for (Supplies s : supplies){
                fwSupplies.write(s.getCategory() + "," + s.getBrand() + "," + s.getProduct() + "," +
                        s.getCost() + "," + s.getQuantity() + "," + s.getMinQuantity() + "," +
                        s.getDescription() + "\n");
            }
            //closing FileWriter and PrintWriter
            fwSupplies.flush();
            fwSupplies.close();

        } catch (IOException e){ //Catching IOException
            System.out.println("An error occurred updating files");
        }
    }


    /**
     * Prints the schedule for the current week
     * @param masterSchedule 1D array of schedule objects
     * returns nothing
     */
    public static void printMasterSchedule(Schedule[] masterSchedule){
        System.out.println("Monday");
        System.out.println(masterSchedule[0] + "\n");

        System.out.println("Tuesday");
        System.out.println(masterSchedule[1] + "\n");

        System.out.println("Wednesday");
        System.out.println(masterSchedule[2] + "\n");

        System.out.println("Thursday");
        System.out.println(masterSchedule[3] + "\n");

        System.out.println("Friday");
        System.out.println(masterSchedule[4] + "\n");

        System.out.println("Saturday");
        System.out.println(masterSchedule[5] + "\n");

        System.out.println("Sunday");
        System.out.println(masterSchedule[6] + "\n");
    }

    /**
     * Takes in a file and returns a 2D array of the information
     *
     * @param file text file of information about an object on each line. Info is separated by commas
     * @return a 2D array. Each row is an object and the columns are the constructor parameters.
     */
    public static String[][] fileToArray(File file) {
        String[][] returnArray = new String[0][]; //initializing array
        try {
            //opening file reader
            Scanner myReader = new Scanner(file);
            int index = 0;
            //will loop after each line and will stop looping when there are no more lines to read in file
            while (myReader.hasNextLine()) {
                //increasing array length by one
                int length = returnArray.length;
                String[][] temp = new String[length + 1][];
                for (int i = 0; i < length; i++){ //copying to temp array
                    temp[i] = returnArray[i];
                }
                returnArray = temp;
                //split the line into an array of Strings
                String[] data = myReader.nextLine().split(","); //commas separate each String
                returnArray[index] = data; //sets last index of returnArray to data
                index += 1;
            }
        } catch (FileNotFoundException e) { //Catches FileNotFoundError
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return returnArray; //returns 2D array
    }

    /**
     * Sets up a new Supplies object. Asks user for parameters.
     * No method parameters
     * @return returns a newly made Supplies object
     */
    public static Supplies setSupplyObject(){
        Supplies S = new Supplies(); //creating new object with no parameters
        Scanner input = new Scanner(System.in);

        System.out.println("DO NOT ENTER ANY COMMAS\n"); //Commas will mess up the files, so they cannot be entered

        //Getting object information using Scanner and using class methods to assign values to instance variables
        System.out.println("Enter category: ");
        String category = input.nextLine();
        category = category.toLowerCase();
        S.setCategory(category);

        System.out.println("Enter brand: ");
        String brand = input.nextLine();
        S.setBrand(brand);

        System.out.println("Enter product name: ");
        String product = input.nextLine();
        S.setProduct(product);

        System.out.println("Enter product cost: ");
        double cost = input.nextDouble();
        S.setCost(cost);

        System.out.println("Enter current quantity: ");
        double quantity = input.nextDouble();
        S.setQuantity(quantity);

        System.out.println("Enter minimum quantity (when the # of item needs to be restocked): ");
        double minQuantity = input.nextDouble();
        S.setMinQuantity(minQuantity);

        System.out.println("Enter description of the product: ");
        input.nextLine();
        String description = input.nextLine();
        S.setDescription(description);

        return S; //returns Supply object
    }

    /**
     * Sets up a new Equipment object. Asks user for parameters.
     * No method parameters
     * @return returns a newly made Equipment object
     */
    public static Equipment setEquipmentObject (){
        Equipment e = new Equipment(); //Creating Equipment object
        Scanner input = new Scanner(System.in);

        System.out.println("DO NOT ENTER ANY COMMAS\n"); //Commas will mess up the files, so they cannot be entered

        //Getting object information using Scanner and using class methods to assign values to instance variables
        System.out.println("Enter equipment name: ");
        String equipmentName = input.nextLine();
        e.setEquipmentName(equipmentName);

        System.out.println("Enter cost: ");
        double cost = input.nextDouble();
        input.nextLine();
        e.setCost(cost);

        System.out.println("Enter quantity: ");
        int quantity = input.nextInt();
        input.nextLine();
        e.setQuantity(quantity);

        System.out.println("Enter year bought: ");
        String year = input.nextLine();
        year = year.toLowerCase();
        e.setYear(year);

        System.out.println("Enter equipment model #: ");
        String model = input.nextLine();
        e.setModel(model);

        System.out.println("Enter quality: ");
        String quality = input.nextLine();
        quality = quality.toLowerCase();
        e.setQuality(quality);

        System.out.println("Enter warranty (years): ");
        int warrantyYears = input.nextInt();
        e.setWarrantyYears(warrantyYears);

        System.out.println("Enter replacement (yes/no)");
        //Making sure correct input is giving (yes/no)
        boolean correctInput;
        do {
            String replacement = input.next();
            replacement = replacement.toLowerCase();

            if (replacement.equals("yes") || replacement.equals("no")) {
                correctInput = true;
                e.setReplacement(replacement);
            } else {
                System.out.print("Invalid input, please enter yes or no.");
                correctInput = false;
            }
        } while (!correctInput);

        System.out.println("Enter maintenance mechanic #: ");
        input.nextLine();
        String maintenanceNum = input.nextLine();
        e.setMaintenanceNum(maintenanceNum);

        return e; //return Employee object
    }

    /**
     * Sets up a new Client object. Asks user for parameters.
     * No method parameters
     * @return returns a newly made Client object
     */
    public static Client setClientObject(){
        Scanner input = new Scanner(System.in);
        Client c = new Client(); //Creating new client method using basic constructor
        String cliName, cliPhoneNum, address, email, age, sex, allergies,
                medication, pastService, productPurchase, review;

        System.out.println("DO NOT ENTER ANY COMMAS\n"); //Commas will mess up the files, so they cannot be entered

        //Getting object information using Scanner and using class methods to assign values to instance variables
        System.out.print("Enter client's name: ");
        cliName = input.nextLine();
        c.setCliName(cliName);

        System.out.print("Enter client's phone number: ");
        cliPhoneNum = input.next();
        c.setCliPhoneNum(cliPhoneNum);

        input.nextLine();
        System.out.print("Enter client's address: ");
        address = input.nextLine();
        c.setCliAddress(address);

        System.out.print("Enter client's email: ");
        email = input.next();
        c.setCliEmail(email);

        input.nextLine();
        System.out.print("Enter client's age: ");
        age = input.nextLine();
        c.setCliAge(age);

        System.out.print("Enter client's sex: ");
        sex = input.next();
        c.setCliSex(sex);

        input.nextLine();
        System.out.print("Enter client's allergies: ");
        allergies = input.nextLine();
        c.setCliAllergies(allergies);

        System.out.print("Enter client's medication: ");
        medication = input.nextLine();
        c.setCliMedication(medication);

        System.out.print("Enter client's past services at the salon: ");
        pastService = input.nextLine();
        c.setCliPastService(pastService);

        System.out.print("Enter products that the client has purchased at the salon: ");
        productPurchase = input.nextLine();
        c.setCliProductPurchase(productPurchase);

        System.out.print("Enter client's salon review: ");
        review = input.nextLine();
        c.setCliReview(review);

        return c; //Return Client object
    }
}