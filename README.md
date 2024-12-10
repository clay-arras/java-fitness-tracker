# Personal Project: Fitness Tracker

## Purpose of the Project
The application is meant as a gym tracker that documents your workouts. This project is of interest for me because I know many of my friends go to the gym, but that don’t necessarily have a tracker that they can use. This is bad for gains because sometimes you might forget what you lifted last workout, and either go too heavy or too light on this workout. Therefore, the intended audience of this project is people who are looking for a quick and reliable fitness tracker to achieve their fitness goals.

The project is a basic query database where users can store workout information, which is saved between the times that the Java application is running. We can make this with the following system of classes and methods, which is meant to provide a rough guideline of how the project will be implemented. However, this is subject to change.  

### Application structure

**Class** ListOfWorkout

- **Function** Add Workout
- **Function** Delete Workout
- **Function** Edit Workout
- **Class** Interface Metrics
    - **Function** Find Max Volume
    - **Function** Find Max 1RM
- **~~Class Graphs~~**
    - **~~Function Graph Exercise~~**

**Class** Workout

- **Field** ListOfExercise
- **~~Function Get Total Volume~~**
- ~~Abstract~~ **Class** Exercise
    - **Field** ExerciseName
    - **Field** Reps
    - **Field** Sets
    - **Field Weight**
    - **Function** Calculate Volume
    - **Function** Calculate 1RM
- ~~Example Leg Exercise~~
- ~~Example Chest Exercise~~
- ~~Example Arms Exercise~~

### Handle input
- Main function
  - One function to choose options
  - One function for each of the options
- Some way to handle adding exercises
- Some way to display exercises

### User stories

As a user, I want to be able to view my history of workouts

As a user, I want to be able to add workouts

As a user, I want to be able to delete workouts

As a user, I want to be able to edit workouts

As a user, I want to be able to calculate metrics

As a user, I want to be able to save workout data (if I so choose)

As a user, I want to be able to load previous workout data (if I so choose)


## Instructions for Grader
How to generate the first of the two required actions that are related to the required user story "add multiple Xs to a Y" (e.g., click the button labelled "Add an X", or select the menu item labelled "Add an X", or type <ctrl>+N on the keyboard to add an X,...)
- In main menu, press `Add workouts`. In the text box, enter how many exercises and hit enter. Then replace the `NAME`, `SETS`, `REPS`, and `WEIGHT` fields. Click `Save Workout` and `BACK` once you are done.
 
How to generate the second of the two required actions
- In main menu, press `View metrics`. Enter the name of the exercise you want to see metrics of... i.e. `Dumbbell curls`. A popup will tell you the metrics

Where to find the visual component that was added to your project (e.g., background image, image added to button)
- In main menu, there is an image of a dumbbell. Additionally, when you add a workout, you also see an image

How does the user save the state of the application to file
- In main menu, press `Save workout`

How does the user load the state of the application from file
- In main menu, press `Load workouts`

## Phase 4: Task 2
Sun Apr 07 15:20:37 PDT 2024 \
Initialized tracker \
Sun Apr 07 15:20:37 PDT 2024 \
Added workout to tracker \
Sun Apr 07 15:20:37 PDT 2024 \
Added workout to tracker \
Sun Apr 07 15:20:50 PDT 2024 \
Added workout to tracker \
Sun Apr 07 15:20:59 PDT 2024 \
Removed workout at index 1 from tracker \
Sun Apr 07 15:21:15 PDT 2024 \
Fetched Leg Curls's volume from tracker with value of 1540 \
Sun Apr 07 15:21:15 PDT 2024 \
Fetched Leg Curls's 1RM from tracker with value of 25.384615384615383 \
