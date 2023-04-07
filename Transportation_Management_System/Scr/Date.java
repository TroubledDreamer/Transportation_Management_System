
public class Date
{

    private int day;



    public void setDay(int day){
        this.day = day;
    }

    public int getDay(){
        return day;
    }
    
    public String toString(){
        return Integer.toString(day);
    }
    
    public Date(int date)
    {
        this.day = date;

    }

    public int next(int day)
    {
        day++;
        return this.day;
    }

    





}
