# 14th Task
Create a class according to your variant from the list below.
Using the Lombok library, implement set and get methods, constructors with arguments, a default constructor, and an overridden toString() method.
The class should contain a public static method getInstance() and a static field instance, the value of which will be returned by the getInstance method.
The main method should create an array of class objects using:
 a default constructor
 a constructor that receives all parameters
 2 objects obtained by calling the getInstance method
Output the identifiers of all objects in the array to the console using a for loop.

Create a Stadium class that will have the following fields:
name: name of the stadium;
capacity: number of seats in the stadium;
currentAttendance: current number of spectators in the stadium;
home Team: The home team playing in this stadium
away Team: the away team that the home team is playing against.

The Stadium class must have the following public methods: addAttendies(int count): a method that increases the number of spectators in the stadium by count (if there are free places);
decreaseAttendance(): A method that decreases the number of spectators in the stadium by 100 (the number of viewers cannot become negative); 
changeHome Team(String teamName): A method that changes the home team to a team with the name teamName;
changeAway Team(String teamName): method that changes the away team to the team named teamName
