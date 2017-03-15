import java.util.Scanner;
import java.security.SecureRandom;
/**
 * This class implements Simulation that handles the initialization and the update of the LivingBeing Grid
 */
public class Simulation {
    
    private static LivingBeing[][] grid;  
    
    private static int cycleCount;
    
    private static int ROWLENGTH = 10;
    private static int COLLENGTH = 10;
    
    public static int getRow() {
        return ROWLENGTH;
    }
    
    public static int getCol() {
        return COLLENGTH;
    }
    
    public static LivingBeing[][] getGrid() {
        return grid;
    }
    
    public void constr() {
        SecureRandom random = new SecureRandom();
        grid = new LivingBeing[getRow()][getCol()];
        cycleCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
            int num = 1 + random.nextInt(14);
            //populate the grid randomly
            if (num <= 2)
                grid[row][column] = new Herbivore();
            else if (num == 3)
               grid[row][column] = new Carnivore();
            else if (num >3 && num <= 6)
                grid[row][column] = new Plant();
            }
        }
    }

    public void simulate() {
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] != null) {
                  //call the update method  
                  grid[row][col].update(grid, row, col);
				}
			}
		}
      //Call the reset Update Flag method
      resetUpdateFlag();
      cycleCount++;
      //System.out.println("this is cycle count"+ cycleCount);
    }
    
    //Reset all the UpdateFlag of the grid objects
    //Once the simulate() method is completed, this method will reset the flag of all objects back to false
    public void resetUpdateFlag() {
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                if (grid[row][col] != null) {
                  grid[row][col].resetFlag();
                }
            }
        }
    }
    
    //Method for adding to grid
    public void addToGridData (int row, int col, int i, int j) {
        grid[i][j] = grid[row][col];
    }
    
    //Method for deleting from grid
    public void deleteGridData (int row, int col) {
        grid[row][col] = null;
    }
    
    //Method for instantiating a new Plant in a grid
    public void instantiateRandomPlant (int row, int col) {
        grid[row][col] = new Plant();
    }
    
    //Getter for Cyclecount
    public static int getCycleCount() {
        return cycleCount;
    }
    
    @Override
    public String toString() {

        String line = System.getProperty("line.separator");

        String result = line;
        for (int row=0; row<grid.length; row++) {
            for (int column=0; column<grid[row].length; column++) {

                if (grid[row][column] != null) {
                    result += " " + grid[row][column] + " ";
                } else {
                    result += " . ";
                }
            }
            result += line;
        }
        return result;
    }

  
}
