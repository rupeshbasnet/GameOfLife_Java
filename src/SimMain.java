/**
 * This is the Main Class which will call the Simulation, Screen and Controller.
 * @author Rupesh
 */
public class SimMain {
     public static void main (String[] args) {
        
            Simulation theSimulation = new Simulation();
            theSimulation.constr();
            
            System.out.println("create a obj of simulation");
            Screen theScreen = new Screen();
            System.out.println("create a obj of the screen");
            Controller theController = new Controller(theSimulation, theScreen);
            theController.updater(theSimulation);
            System.out.println("create a obj of the controller");
            
            theScreen.setVisible(true);
    }  
}
