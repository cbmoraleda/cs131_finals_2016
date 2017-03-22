# CS 197 IPSE Midterms Branch
* This is a repository for the Midterms on CS 197 Industry Practices in Software Engineering under Mr. Roy Canseco.
* The repository is a library of Numerical Method algorithms along with sample problems that can be used as demo for the algorithms.

# What is the Midterms?

* The Midterm exam/challenge/machine problem or whatever is to refactor the library in such a way that it can be used and reused like a real package. Kinda like how google's tensorflow works where you have the libraries and sample demos using the libraries inside the repository.

## Midterm Goals

1. Consolidate test files
    * Create a single repository where all the files are placed.
2. Bug tracking (issues/features)
    * Each team should have a point person to look at the issues and report it to their respective group.
3. Duplication removal + code cleaning
    * merge files
    * run tests successfully after mergin in jenkins
4. Presentation
    * Presentation of the project in class
    * Jenkins must be working by that time.

## Explanation of what we are going to do.

1. Each problem has a **main program** and **libraries** used for solving the problem. What we did before was **create a test for the main program running the library**. That is **not what we are supposed to do** for the midterms. 
2. Analyzing the directory, one would see that **all problems are inside** the `demos`. The purpose of the **problems** were to provide **sample programs** showing that the **library was working**. The project that we are working on is **the libraries of the numericala method algorithms** and not **the programs for the problem branches**.
3. So initially, given this directory, each problem branch **must import their respective libraries used from the folder containing the library**.
    * e.g. Your problem uses Clare Tan's `Euler method` You must **remove the local copy of Clare Tan's Euler method on the problem directory** and **import the method/function/class from Clare Tan's folder** i.e.

~~~

ClareTan
    - eulermethod.java
demo
    -problem
        - eulermethod.java
        - main.java
~~~

~~~{.java}
// main.java
/* instead of using this*/
import eulermethod.java;
~~~

~~~{.java}
//main.java
/* use this*/
import ClareTan.eulermethod //i don't think that's how you import in java but you get the picture
~~~
4. Each of us created test files for our branches. We must now consolidate them by **assigning them to each proper file**. What do I mean by this?
    * Say you have a file named `testCase.java` containing test files for `main.java` and `eulermethod.java` on your test folder before in your own directory.
    * Since the directory given has now placed your test files in where they should be, it would now be easier to distribute them.
    * From your `testCase.java` for `main.java` and `eulermethod.java`, you will now create a file `mainTest.java` and `eulermethodTest.java`. You must distribute the test cases from `testCase.java` to `mainTest.java` and `eulermethodTest.java`.
    * It was discussed in **3** that the `eulermethod.java` being used is the one located in **Clare Tan's Folder**. With that logic, then it follows that `eulermethodTest.java` should also be in Clare Tan's Folder. i.e.

* From before you had a directory like this
~~~
src
    - main
        - java
            - ClareTan
                - eulermethod.java
            - Demo
                - Problem
                    - eulermethod.java
                    - main.java
    - test
        - java
            - ClareTan
            - Demo
                - Problem
                    - testcase.java
                
~~~
* You should now have
~~~
src
    - main
        - java
            - ClareTan
                - eulermethod.java
            - Demo
                - Problem
                    - main.java  // notice that eulermethod has been deleted since you are using the one in claretan but you can skip this for now
    - test
        - java
            - ClareTan
                - eulermethodtest.java
            - Demo
                - Problem
                    - maintest.java
~~~

4. Now that you have done that, you must **add the problems as test case**. By this I mean, each main program is about **showing that the method can solve a problem**. The problem obtained was **obtained from the PDF final exam**. So now, you must **add those problems as test case for the libraries**.
    * e.g. say `Clare Tan's` library solves for an ODE and **was used in solving the ODE in problem 1**. Then you must put **problem 1** as a **test case for CLARE TAN's Library. i.e.
~~~
src
    - main
        - java
            - ClareTan
                - eulermethod.java
            - Demo
                - Problem
                    - main.java
    - test
        - java
            - ClareTan
                - eulermethodtest.java //put the problem as test case here
            - Demo
                - Problem
                    - maintest.java
~~~
