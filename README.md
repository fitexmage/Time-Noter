# Time-Noter
The project is written in Java 1.8.0. It is a software helping people take notes for their events.

# File structure

## /data
### /data/account.json
Store account information
### /data/friend.json
Store friend information
### /data/personalInfo.json
Store personal information
### /data/recommendation.json
Store recommendation information
### /data/schedule.json
Store schedule information

## /src/main/java/timenoter
###  /src/main/java/timenoter/Data.java
Store all the persistent data
### /src/main/java/timenoter/Message.java
Provide a method to post message
### /src/main/java/timenoter/TimeNoter.java
Main class
### /src/main/java/timenoter/User.java
Store all the data for the current user
### /src/main/java/timenoter/friend
Functionality for adding friends and sharing schedule with them
### /src/main/java/timenoter/login
Functionality for logining
### /src/main/java/timenoter/nav
Main interface
### /src/main/java/timenoter/recommendation
Functionality for recommendation
### /src/main/java/timenoter/schedule
Functionality for listing the schedule
### /src/main/java/timenoter/user
Functionality for showing personal information

# Dependency
### jackson-annotations-2.6.2.jar
### jackson-core-2.6.2.jar
### jackson-databind-2.6.7.1.jar

# Test
* Username: test
* Password: test
