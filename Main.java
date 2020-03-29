import java.util.*;
import java.io.*;
/**
 * Write a description of Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main {
    public static void main(String args[]) throws IOException
    {
        babyName ob=new babyName();
        int cho;
        String name=new String();
        String gender=new String();
        int rank,year,new_year;
        do
        {    
            System.out.println("\nEnter you choice");
            System.out.println(" 1. Get Rank [name , year , gender [M/F] ] \n 2. Get Name [rank , year , gender]");
            System.out.println(" 3. Name in new year [name , year , new year , gender] \n 4. Year of highest rank [name , gender]");
            System.out.println(" 5. Average rank [name , gender] \n 6. Total birth greater than rank [name , year , gender] ");
            System.out.println(" 7. Total Boy / Girl [ year , gender ] \n 8. Exit");
            Scanner in = new Scanner(System.in);
            cho=in.nextInt();
            switch(cho)
            {
                case 1: System.out.println("Enter values of variables as asked [using Enter]: ");
                        in=new Scanner(System.in);
                        name=in.next();
                        in=new Scanner(System.in);
                        year=in.nextInt();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.getRank(name,year,gender));
                        break;
                case 2: //Get Name [rank , year , gender]
                        System.out.println("Enter values of variables as asked [using Enter]: ");  
                        in=new Scanner(System.in);
                        rank=in.nextInt();
                        in=new Scanner(System.in);
                        year=in.nextInt();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.getName(rank,year,gender));
                        break;
                case 3: //Name in new year [name , year , new year , gender]
                        System.out.println("Enter values of variables as asked [using Enter]: ");  
                        in=new Scanner(System.in);
                        name=in.next();
                        in=new Scanner(System.in);
                        year=in.nextInt();
                        in=new Scanner(System.in);
                        new_year=in.nextInt();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.whatIsNameInYear(name,year,new_year,gender));
                        break;
                case 4: //Year of highest rank [name , gender]
                        System.out.println("Enter values of variables as asked [using Enter]: ");  
                        in=new Scanner(System.in);
                        name=in.next();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.yearOfHighestRank(name,gender));
                        break;
                case 5: //Average rank [name , gender]
                        System.out.println("Enter values of variables as asked [using Enter]: ");  
                        in=new Scanner(System.in);
                        name=in.next();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.getAverageRank(name,gender));
                        break;
                case 6: //Total birth greater than rank [name , year , gender]
                        System.out.println("Enter values of variables as asked [using Enter]: ");
                        in=new Scanner(System.in);
                        name=in.next();
                        in=new Scanner(System.in);
                        year=in.nextInt();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.getTotalBirthsRankedHigher(name,year,gender));
                        break;
                case 7: //Total Boy / Girl [ year , gender ]
                        System.out.println("Enter values of variables as asked [using Enter]: ");  
                        in=new Scanner(System.in);
                        year=in.nextInt();
                        in=new Scanner(System.in);
                        gender=in.next();
                        System.out.println("Result : " + ob.totalCount(year,gender));
                        break;
                case 8: //Exit
                        System.exit(0);    
                        break;
                default:System.out.println(" Wrong input Try again ");
                        cho=2;
                        break;                        
            }
        }while(cho!=8);
    }
}
