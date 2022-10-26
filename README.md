# robotic_rovers

## Prerequisites
java 11

maven 3.8.6

## Tests and Deployment steps
- Try to download the source code of the project from github or just clone the project using a git command
- To test the application, make sure you are in the root directory of the 
project and run the following maven command:
mvn test

- To deploy the application you need to generate the jar file as follows

  1)From the root directory of the project, run the following command: mvn clean package

  2)To execute the program, please run the command: java -jar target/rover-1.0-jar-with-dependencies.jar "filePath of commands"