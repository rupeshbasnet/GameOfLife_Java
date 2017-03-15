# GameOfLife_Java
A Java project to simulate behaviours of living beings (Animals and Plants) inside a 2D grid. The behaviours in this simulation includes die, eat or give birth. These behaviours cooresponds to the specific living being. The project uses the fundamental object oriented programming principles such as, inheritance, polymorphism, abstration, encapsulation. It uses the Java MVC (Model View Control) design pattern approach.  

## Model: 

### LivingBeing.java 
Implements an abstract superclass, LivingBeing.

### Animal.java
Implements the abstract subclass, Animal which is the subclass of LivingBeing.

### Plant.java
Implements the subclass, Plant which is also the subclass of LivingBeing.

### Herbivore.java
Implements the subclass, Herbivore which is the subclass of Animal and consists of all the traits of a herbivore.

### Carnivore.java
Implements the subclass, Carnivore which is the subclass of Aninmal and consists of all the traits of a carnivore.

### Simulation.java
A seperate class that randomly populates a 2D grid of LivingBeings at the start of the application. The class also updates the entire grid on every cycle. Each cycle can be considered as a time measure in this simulation. 

## View: 

### Screen.java
Implements the Screen class which constructs the GUI for the user to interact and gives output to the user.

## Control: 

### Controller.java
A Controller class that handles the interactions between the Simulation and the Screen classes. 

## Main: 

### SimMain.java
The main class. 

# Demo:

![Demo](https://cloud.githubusercontent.com/assets/26423462/23931470/a4175374-0908-11e7-8ac5-a39641fc0024.gif)
