# Time-Noter
The project is written in Java 1.8.0 using MVC. It is a software helping people take notes for their events.

# File structure

## /data
* ### /data/account.json
Store account information
* ### /data/friend.json
Store friend information
* ### /data/personalInfo.json
Store personal information
* ### /data/recommendation.json
Store recommendation information
* ### /data/schedule.json
Store schedule information
   
   
## /src/main/java/timenoter
* ###  /src/main/java/timenoter/Timenoter
Main class
* ###  /src/main/java/timenoter/UIController
Connect controller and view, manage element and method on view
* ###  /src/main/java/timenoter/controller
Connect model and UIController, control the process
* ###  /src/main/java/timenoter/model
Read and write data
* ###  /src/main/java/timenoter/util
Utility functions

## /src/main/resources/fxml
* ### /src/main/resources/fxml/ConfirmUI.fxml
Register comfirmation interface
* ### /src/main/resources/fxml/DailyScheduleUI.fxml
Daily schedule interface
* ### /src/main/resources/fxml/FriendUI.fxml
Friend interface
* ### /src/main/resources/fxml/LoginUI.fxml
Login interface
* ### /src/main/resources/fxml/NavUI.fxml
Navagation interface
* ### /src/main/resources/fxml/RecommendationUI.fxml
Recommendation interface
* ### /src/main/resources/fxml/RegisterUI.fxml
Register interface
* ### /src/main/resources/fxml/ScheduleUI.fxml
Schedule interface
* ### /src/main/resources/fxml/UserUI.fxml
User information interface

# Dependency
### jackson-annotations-2.6.2.jar
### jackson-core-2.6.2.jar
### jackson-databind-2.6.7.1.jar

# Test
* Username: test
* Password: test
