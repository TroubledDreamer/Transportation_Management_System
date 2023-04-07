public class PartyBus extends SportBus{

    private int barArea, foodArea, securityCrew;


    public PartyBus( String name, int basePrice, int lev, Ministry mny, int competitorArea, int speectatorArea, String sportList, int foodArea, int barArea, int securityCrew){

        super(name, basePrice, lev, mny, competitorArea, speectatorArea, sportList);
        this.foodArea = foodArea;
        this.barArea = barArea;
        this.securityCrew = securityCrew;
        tripTypes  += ",PARTY";

 
    }

    public int getEstimate(String type, int numPerson, int level){
        return foodArea * super.getEstimate(type, numPerson, level) / (3 * barArea);

    }

    





}
