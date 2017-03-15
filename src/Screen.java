import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * This class implements the Screen and constructs the GUI for the user to 
 * interact and give output.
 */
public class Screen extends JFrame{

   private JButton nextButton = new JButton("Next Cycle");
   private JTextField forwardCycle = new JTextField("1", 5);
   private JLabel increaseCycle = new JLabel("Increase Cycle : ");
   private JTextField currentCycle = new JTextField("0",5);
   private JLabel cycleLabel = new JLabel("Current Cycle :");
   JPanel gridPanel = new JPanel();
   JPanel displayPanel = new JPanel();
   JPanel screenPanel[][];
   JPanel newPanel = new JPanel();
   ImageIcon plant = new ImageIcon(this.getClass().getResource("/Images/grass.png"));
   ImageIcon hervivore = new ImageIcon(this.getClass().getResource("/Images/Hervivore.png"));
   ImageIcon carnivore = new ImageIcon(this.getClass().getResource("/Images/Carnivore.png"));
   
   /**
    * This constructor will construct the ScreenPanel and initialize the JFrame.
    */
   Screen() {
       screenPanel = new JPanel[10][10];
       gridPanel.setLayout(new GridLayout(10, 10));
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(700,600);
       
         for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                screenPanel[i][j] = new JPanel();
                    screenPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                gridPanel.add(screenPanel[i][j]);
            }
        }
       displayPanel.add(gridPanel);
       newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
       newPanel.add(nextButton);
       newPanel.add(Box.createRigidArea(new Dimension(0,10)));
       
       newPanel.add(increaseCycle);
       newPanel.add(forwardCycle);
       newPanel.add(Box.createRigidArea(new Dimension(0,10)));
       
       newPanel.add(cycleLabel);
       newPanel.add(Box.createRigidArea(new Dimension(0,0)));
       newPanel.add(currentCycle);
       displayPanel.add(newPanel);
       this.add(displayPanel);
       this.setVisible(true);
   }
   
   /**
    * This returns the input of the user for the forward cycle and also gives an error dialog box if the user inputs 
    * cycle that is less than 0
    * @return forward cycle integer
    */
   public int getForwardCycle() {
       if (Integer.parseInt(forwardCycle.getText()) > 0)
       {
            return Integer.parseInt(forwardCycle.getText());
       } else {
            displayErrorMessage("Increase Cycle needs to be greater than 0");
            return 0;
       }
   }
   
   /**
    * This sets the TextField currentCycle to the parameter integer cycle
    * @param cycle integer for the cycle count
    */
   public void setcurrentCycle(int cycle) {
       currentCycle.setText(Integer.toString(cycle));
   }
   
   /**
    * This will alert the controller that the Next Button is pressed.
    * @param listenForNextButton 
    */
    void addNextButtonListener (ActionListener listenForNextButton) {
        nextButton.addActionListener(listenForNextButton); 
    }
    
    /**
     * This method will update the screenPanel based on the row, column and the 
     * toString() of the LivingBeing instance.
     * @param row int value of the row of the LivingBeing Grid
     * @param col int value of the column of the LivingBeing Grid
     * @param name toString() value of the LivingBeing Instance
     */
    void updateGUI(int row, int col, String name) {
        if (name == "*") 
            screenPanel[row][col].add(new JLabel(plant, JLabel.CENTER)); 
        if (name == "&") 
            screenPanel[row][col].add(new JLabel(hervivore, JLabel.CENTER)); 
        if (name == "@") 
            screenPanel[row][col].add(new JLabel(carnivore, JLabel.CENTER)); 
    }
    
    /**
     * This will refresh the Icons as we update through the cycle.
     */
    void clearGUI () {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    screenPanel[i][j].removeAll();
                    screenPanel[i][j].updateUI();   
            }
        } 
    }    
    
    /**
     * This will display the errorMessage if there is any exceptions
     * @param errorMessage The String error Message
     */
    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
}

