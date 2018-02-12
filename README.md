## StorageEstimator by Hampus Carlsson

### How to run

What you have just cloned is an eclipse project and could be imported and
executed as such. If you instead wish to run the app using the command line
follow the instructions below.

The project main can be found in StorageEstimator.java.

Oh yes btw, you will need java 8 to be able to build this project.

Here is how to build and run from the command line:

1. Clone the repository (or download the zip containing the project).
2. Enter the main directory of the project you just cloned. From here folders
like **src** and **bin** should be visible.
3. Open a new command line window in this directory.
4. Build the project by entering `javac -d bin/ -cp src src/main/StorageEstimator.java`
5. Finally, run the app by entering `java -cp bin main/StorageEstimator`

If the program started correctly you should see something very much like:
```
==========================================
*  Storage Estimator by Hampus Carlsson  *
==========================================

- Enter one image per row.
- Group images by entering G i, i, ... , i
  where i is an image index.
- Enter q on a new line to evaluate input.

Enter your input below this line -->
```

### Assumptions

Here are some of the assumptions that were made in writing this application.

* The total size of all the images for which the size is to be computed will
never exceed the maximum size of an integer.

* Other commands and file types may be added in the future. This is the reason
for having unique parser classes associated with each type/command.

* What constitutes valid input may change over time e.g JPG should now take
3 input parameters *width*, *height* and *level lower bound*.

* Other rules for evaluating the total storage may have to be added in the
future, in parallel to the existing one.

* Rules for calculating the storage of the existing types may change interdependently.
