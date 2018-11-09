# Root Test (Track Driving History)

### Problem Statement

Let's write some code to track driving history for people.
The code will process an input file. You can either choose to accept the input via stdin (e.g. if you're using Ruby `cat input.txt | ruby yourcode.rb`), or as a file name given on the command line (e.g. `ruby yourcode.rb input.txt`). You can use any programming language that you want. Please choose a language that allows you to best demonstrate your programming ability.

Each line in the input file will start with a command. There are two possible commands.

The first command is Driver, which will register a new Driver in the app. Example:

`Driver Dan`

The second command is Trip, which will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example:

`Trip Dan 07:15 07:45 17.3`

Discard any trips that average a speed of less than 5 mph or greater than 100 mph.

Generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.

Example input:
```
Driver Dan
Driver Alex
Driver Bob
Trip Dan 07:15 07:45 17.3
Trip Dan 06:12 06:32 21.8
Trip Alex 12:01 13:16 42.0
```

Expected output:
```
Alex: 42 miles @ 34 mph
Dan: 39 miles @ 47 mph
Bob: 0 miles
```


### Structure
```
 ------- src/
 -------------jar
 -------------|-----------root.jar                    #Executable jar file
 ------------root
 -------------|-----------DirvierTrip.java            #Mainly logical class
 -------------|-----------MainTest.java               #Main test class
 -------------|-----------Trip.java                   #Trip pojo
 -------------|-----------input.txt                   #Main test input txt
 ------------test
 -------------|-----------TripTestNeg.java            #Positive test class 
 -------------|-----------TripTestPos.java            #Negative test class
 -------------|-----------input_neg.txt               #Positive test input txt
 -------------|-----------input_pos.txt               #Negative test input txt
```

### Method: (root.DriverTrip) 
```
- readFile              #Read the file to get the data  
- splitLines            #Read each line of data is processed
- splitDriver           #Handling driver data
- splitTrip             #Handling trip data
- dateDiff              #Calculate the number of minutes between two times
- sortDriverTrip        #Sort the output by most miles driven to least.
- outputRes             #output the result data
```

### Note
Running the Main method requires passing the absolute path of a file as a parameter

### Deployment
Project can be run in any Java 1.8 and JUnit 4 compatible IDE.  Download zip file or clone onto local machine, open in IDE and run.
or Download root.jar, run jar in mac or windows
Open Termial, Go to your ".jar" file directory.
```
java -jar root.jar [****Url of your input file****]
``` 
### Testing
Test with JUnit, including parameter test, boundary test, logic test, numerical test, detailed reference to TripTestNeg and TripTestNeg classes.

### Built With
Java + Junit

### Maid
1. Read incoming file data.
2. Analyze each line and analyze the attribution of each line of data (Driver or Trip).
4. Parse the Driver string as the map key.
5. Parsing or merging the Trip string and load it into the Trip class as the value of the map according to the given rules (time validation, mph validation...).
6. Descending by driverMiles property of the Trip class in the value of the map.
7. Print List and get data.

 
