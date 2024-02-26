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