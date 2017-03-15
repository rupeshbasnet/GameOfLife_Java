/**
 * This class will implement the abstract class Animal which extends the Living Beings.
   - isalive
   - moves
   - lives for a certain amount of time
   - if energy is less than a specific amount it will die
   - can give birth if they are in a certain range of ages and they have enough
   - energy
   - if energy is higher than a certain amount it will not eat anything
 */
public abstract class Animal extends LivingBeing {

    protected int energy;
    protected boolean memory[][];
    
    /**
     * This constructor will construct Animal() and specify the memory, a 2d Boolean Memory array of the same row an column of Grid in Simulation
     * and energy as 3.
     */
    public Animal() {
        //Create a 2d Boolean Memory array of the same row an column of Grid in Simulation
        memory = new boolean[Simulation.getRow()][Simulation.getCol()];
        energy = 3;   
    }
    
    /**
     * This method will return the Energy value integer.
     * @return Integer value energy
     */
    public int getEnergy() {
        return energy;
    }
   
    /**
     * This method will allow the Animal object to give birth depending on the surrounding objects and its own 
     * specifications.
     * @param arr 2d Living Being Grid
     * @param row The current row of the object
     * @param col The current column of the object
     */
    public void birth(LivingBeing[][] arr, int row, int col) {
        Simulation simulation = new Simulation();
            for (int i=row-1; i<=row+1; i++) 
            {
                for (int j=col-1; j<=col+1; j++) 
                {
                    if (i!= row || j!=col) 
                    {
                        if ((i>=0 && i<arr.length) && (j>=0 && j<arr[i].length)) 
                        {
                            if(arr[i][j] == null) 
                            {
                                addAge();
                                setEnergy(getEnergy() - 3);    
                                simulation.addToGridData(row,col,i, j);
                                setHasAlreadyUpdated(true);
                                return;
                            }
                        }
                    }
                }
            } 
    }
    
    /**
     * This method will allow the Animal object to move depending on the surrounding objects and its own 
     * specifications.
     * @param arr 2d Living Being Grid
     * @param row The current row of the object
     * @param col The current column of the object
     */
    public void move(LivingBeing[][] arr, int row, int col) {
    Simulation simulation = new Simulation(); 
            for (int i=row-1; i<=row+1; i++) 
            {
                for (int j=col-1; j<=col+1; j++) 
                {
                    if (i!= row || j!=col) 
                    {
                        if ((i>=0 && i<arr.length) && (j>=0 && j<arr[i].length)) 
                        {
                            if(arr[i][j] == null) 
                            {
                                addAge();
                                setEnergy(getEnergy() - 1);
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
    
    /**
     Post Condition:
       randomized energy based on the age of the prey
       if age of the prey is from 0 to 1 give energy between 1 to 2 
       if age of the prey is greater or equal to 2 give energy between 3 to 5
     * @param ageOfPrey Integer value of the age of prey of the object
     */
    public void energyRandomized (int ageOfPrey)
    {   
        int value = 0;
        if(ageOfPrey <= 1) {
             value = randomWithRange(1, 2);
        }
        else if (ageOfPrey >= 2) {
             value = randomWithRange(3, 5);
        }
             setEnergy(getEnergy() + value);
    }
    
    /**
     * Gives the random value between a min and max
     * @param min integer Minimum value
     * @param max integer Maximum value
     * @return a random value between min and max.
     */
    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }
    
    /**
     * This method will set the energy of the Animal object with the new Energy parameter
     * @param newEnergy integer value of the new Energy
     */
    public void setEnergy(int newEnergy) {
        energy = newEnergy;
    }
    
    /**
     * Method from printing the memory 2D Array of an Animal object
     * @return the result string for printing
     */
    public String printMemory() {
        String line = System.getProperty("line.separator");
        
        String result = line;
        for (int row=0; row<memory.length; row++) {
            for (int column=0; column<memory[row].length; column++) {

                    result += " " + memory[row][column] + " ";   
            }
            result += line;
        }
        return result;
    }
    

}
