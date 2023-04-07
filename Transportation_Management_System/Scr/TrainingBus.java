import java.util.ArrayList;

public class TrainingBus extends Bus{
    private int teacherArea, studentArea, wifiRange;
    private ArrayList<String> courses = new ArrayList<String>();


    public TrainingBus(String name, int basePrice, int wifiRange, int lev, Ministry mny, int teacherArea,
    int studentArea, String sportList){
        super(name, teacherArea + studentArea, basePrice, lev, mny); 
        this.teacherArea = teacherArea;
        this.studentArea = studentArea;
        this.wifiRange = wifiRange;
       
        for( String x : sportList.split(","))
        {
            courses.add(x);
        }
        tripTypes += ",TRAINING";
    }

    public double getTeacherArea(){
        return teacherArea;
    }

    public double getStudentArea(){
        return studentArea;
    }

    public int getBasePrice()
    {
        return 2 * super.getBasePrice();
    }

    public int getEstimate(String type, int numPerson, int level)
    {
        return 5 * teacherArea * super.getEstimate(type, numPerson, level) / courses.size();
    }


}