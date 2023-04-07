import java.util.ArrayList;

class SportBus extends Bus
{
    private int competitorArea, spectatorArea;
    private ArrayList<String> sports = new ArrayList<String>();
   



    public SportBus(String name, int basePrice, int lev, Ministry mny, int competitorArea, int spectatorArea, String sportList)
    {
            // n b lev mn spee sport size

        super(name, competitorArea + spectatorArea, basePrice, lev, mny);
        this.competitorArea = competitorArea;
        this.spectatorArea = spectatorArea;


        for( String x : sportList.split(","))
        {
            sports.add(x);
        }

     
        tripTypes += ",SPORT";
    }

    public double getCompetitorArea(){
        return competitorArea;
    }

    public double getSpectatorArea(){
        return spectatorArea;
    }

    public int getEstimate(String type, int numPersons, int level)
    {
        return getBasePrice() * 10 * getSize() / competitorArea;
    }






}