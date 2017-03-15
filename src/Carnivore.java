/**
 *  This class will implement the Carnivore and extends the Animal.  
 */
public class Carnivore extends Animal {
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
        if(getEnergy() >= 6 && (getCurrentAge() > 2 && getCurrentAge() < 4) && hasAlreadyUpdated() == false) {
            //System.out.println("inside carivore birth condition");
            birth(arr, row, col);
        }
 
        if(getEnergy() < 6 && hasAlreadyUpdated() == false) {
           //eat condition
           for (int i=row-1; i<=row+1; i++) 
            {
                for (int j=col-1; j<=col+1; j++) 
                {
                    if (i!= row || j!=col) 
                    {
                        if ((i>=0 && i<arr.length) && (j>=0 && j<arr[i].length)) 
                        {
                            if(arr[i][j] instanceof Herbivore)
                            {
                                addAge();
                                energyRandomized(arr[i][j].getCurrentAge());
                                //System.out.println("carnivore eat condition: grid [" + row + "] [ " + col + "] is eating grid [" +i + "] [" + j+ "]");
                                //System.out.println ("energy change to  " + getEnergy() );
                                simulation.addToGridData(row, col, i, j);
                                this.memory[row][col] = true;
                                simulation.deleteGridData(row, col);
                                
                                setHasAlreadyUpdated(true);
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (getCurrentAge() >= 7 && hasAlreadyUpdated() == false) {
            //death condition
            simulation.deleteGridData(row, col);
            setHasAlreadyUpdated(true);
            return;
        }
        if (getCurrentAge() < 7 && hasAlreadyUpdated() == false) {
            //move condition
            move(arr, row, col);     
        }
    }
    
    /**
     * Override the toString() method 
     * @return string value @
     */
    @Override
    public String toString() {
      return "@";
       
    }

}
