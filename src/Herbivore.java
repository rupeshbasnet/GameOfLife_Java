/**
 *  This class will implement the Herbivore and extends the Animal.  
 *  //moves every two cycle (slower) 
    //initial energy 3
    //starves at the last cycle
    //eats plants to survive
    //if doesn't gets a plant after 3 cycle starves
    //public static int LastCycle_Count;
 */
public class Herbivore extends Animal {

   /**
     * This method will override the update method of LivingBeing superclass and run the update on the Living Being object.
     * @param arr 2d Living Being Grid
     * @param row The current row of the object
     * @param col The current column of the object
     */
    @Override
    public void update(LivingBeing[][] arr, int row, int col) {
        Simulation simulation = new Simulation();
        //System.out.println("Printing the memory of [" + row + "]" + "[" + col + "]");
        //System.out.println(this.printMemory());
        if(getEnergy() >= 6 && (getCurrentAge() > 2 && getCurrentAge() < 4) && hasAlreadyUpdated() == false) 
        {
            //give birth condition is true
            birth(arr, row, col);
        }
        
        if((Simulation.getCycleCount()) % 2 == 0 && getEnergy() < 6 && getCurrentAge() < 10 && hasAlreadyUpdated() == false) {
           //eatcondition is true
           for (int i=row-1; i<=row+1; i++) 
            {
                for (int j=col-1; j<=col+1; j++) 
                {
                    if (i!= row || j!=col) 
                    {
                        if ((i>=0 && i<arr.length) && (j>=0 && j<arr[i].length)) 
                        {
                            if(arr[i][j] instanceof Plant)
                            {
                                addAge();
                                energyRandomized(arr[i][j].getCurrentAge());
                                //System.out.println("Herbivore eat condition: grid [" + row + "] [ " + col + "] is eating grid [" +i + "] [" + j+ "]");
                                //System.out.println ("energy change to  " + getEnergy() );
                                this.memory[row][col] = true;
                                simulation.addToGridData(row, col, i, j);
                                simulation.deleteGridData(row, col);
                                setHasAlreadyUpdated(true);
                                return;
                            }
                        }
                    }
                }
            }
           
        }
        
        if (getCurrentAge() >= 10 && hasAlreadyUpdated() == false) {
            //deathtime is true
            //System.out.println("Herbivore death condition: grid [" + row + "] [ " + col + "] ");
            simulation.deleteGridData(row, col);
            setHasAlreadyUpdated(true);
            
        }
        //if non of the above is true just move the object
        if ((Simulation.getCycleCount()) % 2 == 0 && hasAlreadyUpdated() == false) 
        {
            //System.out.println("inside hervivore move condition");
            move(arr, row, col); 
        }  
    }
    
    /**
     * Override the toString() method 
     * @return string value &
     */
    @Override
    public String toString() {
        return "&";

    }
 
}

    
  

