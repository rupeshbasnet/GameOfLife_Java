import java.awt.event.*;
/**
 * This class implements a Controller that handles the interaction between the 
 * Simulation and the Screen.
 */
public class Controller {
    private Simulation theSimulation;
    private Screen theScreen;
    /**
     * This constructs the Controller of the application with a specified Simulation,
     * and Screen.
     * @param theSimulation an object of Simulation
     * @param theScreen an object of the Screen
     */
    public Controller (Simulation theSimulation, Screen theScreen) {
           this.theScreen = theScreen;
           this.theSimulation = theSimulation;
           this.theScreen.addNextButtonListener(new CycleListener());
    }
    
    /**
     * This method will update the Screen based on parameter by using a nested
     * for-loop to go over all the elements of the parameter's 2d grid
     * @param theSimulation 
     */
    public void updater(Simulation theSimulation) {
        for (int row=0; row<theSimulation.getGrid().length; row++) {
            for (int column=0; column<theSimulation.getGrid()[row].length; column++) {
                if (theSimulation.getGrid()[row][column] != null){
                    theScreen.updateGUI(row, column, theSimulation.getGrid()[row][column].toString());
                }
            }
        }
    }
    /**
     * This inner class will implement the Action Listener and perform the next
     * action as the next button is pressed on the Screen
     */
    class CycleListener implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                    theScreen.clearGUI();
                    int i = 1;
                    while (i <= theScreen.getForwardCycle()) {
                        theSimulation.simulate();
                        System.out.println(theSimulation);
                        i++;
                    }
                    updater(theSimulation);
                    theScreen.setcurrentCycle(theSimulation.getCycleCount());
            }
    
    }
    }