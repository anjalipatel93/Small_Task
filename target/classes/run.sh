#!/bin/bash
# Compile the project
mvn clean install

# Run the Main class to start Player1 and Player2
java -cp target/your-project-jar-with-dependencies.jar com.example.Socket.Main
