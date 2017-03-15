/**
 * This class will implement the LivingBeing superclass.
 */
public abstract class LivingBeing {
    protected boolean living;
    protected int currentAge;
    protected boolean hasUpdated;
    
    /**
     * This constructor will construct the LivingBeing with the specification of Living as true
     * hasupdated as false and the currentAge of the object as 0.
     */
    public LivingBeing() {
        living = true;
        hasUpdated = false;
        currentAge = 0;
    }
    
    /**
     * Returns the value of Living
     * @return Boolean value of living
     */
    public boolean isLiving() {
        return living;
    }
    
    /**
     * Returns the value of CurrentAge
     * @return Integer value of current age.
     */
    public int getCurrentAge() {
        return currentAge;
    }
    
    /**
     * Adds the age of the object by 1.
     */
    public void addAge() {
        currentAge++;
    }
    
    /**
     * Returns the boolean value of HasUpdated
     * @return Boolean value hasupdated
     */
    public boolean hasAlreadyUpdated() {
        return hasUpdated;
    }
    
    /**
     * Sets the value of hasUpdate based on the Value
     * @param value boolean value 
     */
    public void setHasAlreadyUpdated(boolean value) {
        hasUpdated = value;
    }
    
    /**
     * Resets the hasupdated value of false
     */
    public void resetFlag() {
        hasUpdated = false;
    }
    
    public abstract void update(LivingBeing[][] arr, int row, int col);

}
