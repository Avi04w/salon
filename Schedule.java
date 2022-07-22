package Salon;

public class Schedule {
    private String[][][] Sch= new String[17][5][4];

    public Schedule(){
        int temp = 9;
        int interval = 0;
        //puts in times values vertically
        for (int i = 0; i<Sch.length;i++){
            //the next 2 if statments loop to insert a hour a time value for each slot vertically
            if(interval==0){
                String s = Integer.toString(temp);
                String j = Integer.toString(interval);
                Sch[i][0][0] = s+":"+j+j+"-"+s+":30";
                interval = 30;
            }else if (interval>0){
                String s = Integer.toString(temp);
                String j = Integer.toString(interval);
                interval = 0;
                temp +=1;
                String pop = Integer.toString(temp);
                Sch[i][0][0] = s+":"+j+"-"+pop+":00";
                //this if statment resets the hour counter when it has hit 12
            }if(temp==12&&interval==30){
                String s = Integer.toString(temp);
                String j = Integer.toString(interval);
                interval = 0;
                temp =1;
                String pop = Integer.toString(temp);
                Sch[i][0][0] = s+":"+j+"-"+pop+":00";
            }
        }
        //copy pasting the time values horizontally
        for (int i=0;i<Sch.length;i++){
            for(int j=1;j<Sch[i].length;j++){
                Sch[i][j][0] = Sch[i][0][0];
            }
        }
        //Set the employee names in the array
        for (int i=0;i<Sch.length;i++) {
            Sch[i][0][1] = "Larry";
            Sch[i][1][1] = "Squidward";
            Sch[i][2][1] = "Plankton";
            Sch[i][3][1] = "Sandy";
                    Sch[i][4][1] = "Patrick";
        }
    }
    //this method resets the schedule but putting the last 7 days in place of the first, and then setting the last 7 to new blank schedules
    public static void refreshAll(Schedule[] s1){
        int temp =7;
        //copy pasting the last 7 days into the first 7 days
        for (int i=0;i<7;i++){
            s1[i]=s1[temp];
            temp+=1;
        }
        //reseting the last 7 days
        for(int i=7;i<s1.length;i++){
            s1[i] = new Schedule();
        }
    }
    //displays the schedule for a single employee
    public String viewEmployee(String name) {
        int row =0;
        //finds out where the specific employees column on the array is
        for(int j=0;j<5;j++) {
            if (Sch[0][j][1].equals(name)) {
                row=j;
            }
        }
        String str = String.format("%-18s %-25s %s", name, "Client", "Service");
        System.out.println(str);
        //print out the schedule
        for(int i=0;i<Sch.length;i++) {
            String str1=String.format("%-18s %-25s %s", Sch[i][0][0],Sch[i][row][2],Sch[i][row][3]);
            System.out.println(str1);
        }
        return " ";
    }
    //to string displays an entire day
    public String toString() {
        //printing out the header for the day
        String str = String.format("%-18s %-26s %-26s %-26s %-26s %-26s", " ","Larry", "Squidward", "Plankton", "Sandy", "Patrick");
        System.out.println(str);
        //print out the schedule
        for(int i =0;i<Sch.length;i++) {
            String str1 = String.format("%-18s %-26s %-26s %-26s %-26s %-26s", Sch[i][0][0],Sch[i][0][3],Sch[i][1][3],Sch[i][2][3],Sch[i][3][3],Sch[i][4][3]);
            System.out.println(str1);
        }
        return " ";
    }
    //deletes a specfic time slot
    public void deleteTimeSlots(String start, String end, String ename){
        int s=0; int e=0; int row =0;
        //find the start and end time in the array itself
        for(int i=0;i<Sch.length;i++){
            if(Sch[i][0][0].substring(0,4).equals(start)||Sch[i][0][0].substring(0,5).equals(start)){
                s = i;
            }
            if(Sch[i][0][0].substring(Sch[i][0][0].length()-3,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-4,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-5,Sch[i][0][0].length()).equals(end)){
                e = i;
            }
        }
        //this for loop finds what employee we deleting under
        for(int j=0;j<5;j++) {
            if (Sch[0][j][1].equals(ename)) {
                row=j;
            }
        }
        //this is the actual delete
        for(int fill=s; fill<=e;fill++){
            Sch[fill][row][2]=null;
            Sch[fill][row][3]=null;
        }
    }
    public void bookClient(String start,String end,String name,String ename, String service){
        int s=0; int e=0; int row =0;
        //find the start and end time in the array itself
        for(int i=0;i<Sch.length;i++){
            if(Sch[i][0][0].substring(0,4).equals(start)||Sch[i][0][0].substring(0,5).equals(start)){
                s = i;
            }
            if(Sch[i][0][0].substring(Sch[i][0][0].length()-3,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-4,Sch[i][0][0].length()).equals(end)||Sch[i][0][0].substring(Sch[i][0][0].length()-5,Sch[i][0][0].length()).equals(end)){
                e = i;
            }
        }
        //this for loop finds what employee we booking under
        for(int j=0;j<5;j++) {
            if (Sch[0][j][1].equals(ename)) {
                row=j;
            }
        }
        //actual booking process
        //first for loop checks is there are any bookings under the employee during the specified time
        for(int temp1 =s; temp1<=e;temp1++){
            //if there are bookings, the code ends
            if(Sch[temp1][row][2]!=null){
                temp1=e+1;
                System.out.println(ename+" is busy during this time slot.");
                //if the space if free, the booking takes place
            }else if(Sch[temp1][row][2]==null&&temp1==e){
                for(int fill=s; fill<=e;fill++){
                    Sch[fill][row][2]=name;
                    Sch[fill][row][3]=service;
                }
            }
        }
    }
}