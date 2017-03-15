import java.security.SecureRandom;
import java.security.SecureRandom;

/**
 * This class implements Plant class which extends the LivingBeing superclass
 */
public class Plant extends LivingBeing {
    
     /**
     * This method will override the update method of LivingBeing superclass and run the update on the Living Being object.
     * @param arr 2d Living Being Grid
     * @param row The current row of the object
     * @param col The current column of the object
     */
    @Override
    public void update(LivingBeing[][] arr, int row, int col) {
        addAge();
        Simulation simulation = new Simulation();
        SecureRandom random = new SecureRandom();
        int num = 3 + random.nextInt(8);
        if((Simulation.getCycleCount()) == num)
        {
           while (true) { 
                int i = 0 + random.nextInt(arr.length - 1);
                int j = 0 + random.nextInt(arr[row].length - 1);
                if (arr[i][j] == null) {
                    simulation.instantiateRandomPlant(i, j);
                    break;
                }
           }
        }
    }
    
    /**
     * Override the toString() method 
     * @return string value *
     */
    @Override
    public String toString() {
        return "*";
        
    }

}
