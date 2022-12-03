# Chemistry Calculator

**Overview**

The goal of this project is to develop a comprehensive chemistry calculator that aids student's chemistry studying by balancing chemical equations. The program solve the equation by using matrixes. The program implement a fraction type to store the different values in the matrix.

**Abstract**

The program has two parts, the GUI and the backend. 
The backend uses two customized data types, Chemical and Fraction. The Fraction type contains a denomniator and numerator, and also supports addition, subtraction, multiplication, and division. The Chemical type contains the count of each element of the Chemical. A list of Strings is first converted into a list of Chemicals using a stack. Then, the list chemicals is balanced using matrix operations with fraction coefficients. The fraction coefficients is converted into integer coefficients and then sent to the GUI.
The GUI will obtain a list of Strings that the user inputs. the list of strings will be sent to the backend and a list of integers (the coefficients) will be obtainde.

**How to use**

Install JavaFX, and run GUI::Main.
