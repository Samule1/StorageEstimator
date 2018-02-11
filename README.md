# StorageEstimator

## How to run

What you have just cloned is an eclipse project and could be imported and
executed as such. If you instead wish to run the app using the command line
follow the instructions below.

Oh yes btw, you will need java 8 to be able to build this project.

Here is how to build and run from the command line:

1. Clone the repository.
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
