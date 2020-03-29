import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
/**
 * This class contains all method need to complete this project.
 * 
 * @author ( imasy36 ) 
 * @version ( v.1 / 29 - 03 - 2020 )
 */
public class babyName {
    String address;
    int start_year;
    int end_year;
    
    //Constructors to set values to global variables
    babyName()  //default
    {
        address="Data\\us_babynames_by_year\\";
        start_year=1880;
        end_year=2014;
    }
    
    babyName(String add,int y1,int y2)  //parameterized
    {
        address=add;
        start_year=y1;
        end_year=y2;
    }
    
    //getPar method to get CSVParser of required file
    public CSVParser getPar(int year) throws IOException
    {
        String fname=address+"yob"+Integer.toString(year)+".csv";
        FileReader fr=new FileReader(fname);
        CSVParser par=CSVFormat.RFC4180.parse(fr);
        return par;
    }
   
    // getRank method to find the rank of given name in a given year 
    public int getRank(String name,int year,String gender) throws IOException
    {
        int rank=0;
        CSVParser par=getPar(year);
        for(CSVRecord rec:par)
        {
            if(rec.get(1).equals(gender))
            {
                rank++;
                if(rec.get(0).equals(name))
                    return rank;
            }
        }
        return -1;
    }
    
    //getName method to find name of given rank in a given year
    public String getName(int rank,int year,String gender) throws IOException
    {
        CSVParser par=getPar(year);
        for(CSVRecord rec:par)
        {
            if(rec.get(1).equals(gender))
            {
                rank--;
                if(rank==0)
                    return rec.get(0);
            }
        }
        return "NO NAME";
    }
    
    //whatIsNameInYear method to find name with same rank in given new year as given name in given year
    public String whatIsNameInYear(String name,int year,int new_year,String gender) throws IOException
    {
        int rank=getRank(name,year,gender);
        return getName(rank,new_year,gender);
    }
    
    //yearOfHighestRank method to find the year of highest rank of a given name
    public int yearOfHighestRank(String name,String gender) throws IOException
    {
        int rank=-1;
        int high_year=-1;
        for(int year=start_year;year<=end_year;year++)
        {
            if(rank==-1)
                rank=getRank(name,year,gender);
            if(getRank(name,year,gender)!=-1)
            {
                if(getRank(name,year,gender)<rank)
                {
                    high_year=year;
                    rank=getRank(name,year,gender);
                }   
            }                    
        }
        return high_year;
    }
    
    //getAverageRank method to find average rank of a given name
    public double getAverageRank(String name,String gender) throws IOException
    {
        double rank=0;
        int count=0;
        for(int year=start_year;year<=end_year;year++)
        {
            if(getRank(name,year,gender)!=-1)
            {
                rank=rank+getRank(name,year,gender);
                count++;
            }
        }
        if(count==0)
            return -1.0;
        else
            return rank/count;
    }
    
    //getTotalBirthsRankedHigher  method to find the total no of births having rank > rank ( given name ) 
    public int getTotalBirthsRankedHigher(String name,int year,String gender) throws IOException
    {
        int total=0;
        int rank=getRank(name,year,gender);
        CSVParser par=getPar(year);
        for(CSVRecord rec:par)
        {
            if(rec.get(1).equals(gender))
            {
                rank--;
                if(rank==0)
                    break;
                total+=Integer.parseInt(rec.get(2));    
            }
        }
        return total;
    }
    
    //totalCount method to find total no of boy/girl
    public int totalCount(int year,String gender) throws IOException
    {
        CSVParser par=getPar(year);
        int count=0;
        for (CSVRecord rec:par)
        {
            if(rec.get(1).equals(gender))
                count++;
        }
        return count;
    }
}
