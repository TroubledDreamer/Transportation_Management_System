import java.util.ArrayList;

public class Planner
{
    
    private String name;
    private double budget;
    private Ministry mny;
    private Bus[] buses;
    private ArrayList<Bus> possibleBuses;
    public Planner(String name, double budget, Ministry mny, Bus[] buses)
    {
       this.name = name;
       this.budget = budget;
       this.mny = mny;
       this.buses = buses;
       possibleBuses = new ArrayList<Bus>();
    }
    public String getName(){
      return name;
    }
    
    public double getBudget(){
        return budget;
    }
    
    public int planTrip(int numPassengers, String tripType, Date date, int comfortLevel) {
        int retval = -1;
        possibleBuses.clear();
        /*
        //populate possible buses by adding busses that are suitable, 
        // can hold the passengers at the comfortlevel,and can be afforded
        */
       //System.out.println(possibleBuses.size() +" affordable buses ");
       double tempbudget = budget;
        for(Bus x: buses)
        {
          if(tempbudget >= x.getEstimate(tripType, numPassengers, comfortLevel))
          {

            possibleBuses.add(x);
           // tempbudget -= x.getEstimate(tripType, numPassengers, comfortLevel);
         }
        }

        


      

          
          
        
          
   

        










        if (possibleBuses.size() >0){
             Bus minBus=null;
             /*
             //find the suitable bus with minimum price and assign to minbus`
             */

        

              int m = 0;
              for (int i = 0; i < possibleBuses.size(); i++) {
           
  
                 if (possibleBuses.get(i).canHold(numPassengers, comfortLevel) && possibleBuses.get(i).available(date)) {
  
                     minBus = possibleBuses.get(i);
                 } 
                }
          
    

              if (minBus != null){


             for (int i = 0; i < possibleBuses.size(); i++) {

               if (possibleBuses.get(i).getEstimate(tripType, numPassengers, comfortLevel) <= 
               minBus.getEstimate(tripType, numPassengers, comfortLevel) && possibleBuses.get(i).canHold(numPassengers, comfortLevel) && possibleBuses.get(i).available(date)) {

                   minBus = possibleBuses.get(i);
               } 
              }  
    


            }





             if (minBus==null)
                System.out.println("No suitable bus is available");
             else{
                 //create a trp with the type, number of passengers and the comfortlevel
                 // attempt to get get an approval id by calling the reserve method of the bus
                 // if the id >=0 


                 
                  Trip trip = new Trip(tripType, numPassengers, date, comfortLevel,this);

                  int reserved = minBus.reserve(trip, mny);
                  if (reserved >= 0){
                    trip.setBus(minBus);
                    payFor(minBus, tripType, numPassengers, comfortLevel);
                    retval = reserved;
                    System.out.println(name + " successfully reserved " + trip); 
                    return retval;
                  }
   
             }
            

          }    
        else{
          System.out.println(name + " cannot afford to pay for any suitable buses");
           return retval;
        }

      return -1;
    }
    
    
    public void payFor(Bus bus, String tripType, int numPassengers, int comfortLevel){
        budget-=bus.getEstimate(tripType, numPassengers, comfortLevel);
        
        
    }
    
    
    

 
}
