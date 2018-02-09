This folder contains six examples presenting some of the challenges
faced by students for the assignment 1. Even if you did not face those
challenges, it might be a good idea to look at the code to find the
source of the errors.

Debugging is an essential skill. Developing this skill will make you
more productive and will make your software development activities
more pleasant.

As well, reading someone else's code is challenging at first. It
requires you to decipher how someone else is thinking. However, in the
industry, most of the time, you will be asked to work on existing
projects. Consequently, we strongly encourage you to practise reading
existing code.

The description of the assignment was rather formal. It was possibly
referring to terms that you were not familiar with. However, from a
programming point view, this application had two main components:
storing numerical data in a two-dimensional array and doing some
simple numerical calculations (essentially for loops and summations).

If you think about, our assignment 1 had lot in common with the
following, which is the basis for my six examples.

Problem: write a class, called Grades, that allows to store the grades
of the students for a given class. The constructor has a parameter
that specifies the number of grades to be stored. An object of the
class Grades has a method addGrade that allows to add a grade the
content of the object. The object also has method getAverage that
calculates the average grade of the class. The examples 05_Grades and
06_Grades are about this problem. That would be for part 1 of our
assignment 1. For part 2, you can imagine that for each student, we
store the grade for each question of an examination. Those grades
would correspond to the features in assignment 1. That latter part is
left as an exercise.

But first, let's work on the idea of storing examples into an object
of the class Samples. One of the first problems solving strategies that
you should consider is solving a simpler problem. Here, I have
isolated the requirement to store elements into an object. It is
easier to work on solving this problem in isolation, rather than
working on the problem in the context of the whole problem,
LinearRegression. Only when you are confident that your solution works
should you move to the next parts of the assignment.

01_Samples, 02_Samples, and 03_Samples are about storing elements into
an object of the class Samples. The content is built row by row.

01_Samples

The main methods will repeatedly make calls to the method addSample,
each time adding one row to the object Samples. Here, I had the idea
of making sure that every entry of the resulting matrix is unique so
that any problem can be easily detected (or at least that is what I was
expecting, more on that in the second example).

    double[] sample;
    sample = new double[NUMBER_OF_FEATURES];

    double value;
    value = 0.0;

    Samples training;
    training = new Samples(NUMBER_OF_SAMPLES, NUMBER_OF_FEATURES);

    for (int i=0; i<NUMBER_OF_SAMPLES; i++) {
        for (int j=0; j<NUMBER_OF_FEATURES; j++) {
          sample[j] = value;
          value = value + 1.0;
        }
        training.addSample(sample);
    }

    System.out.print(training);

I was expecting that the execution of the main method would produce
the following output:

 0.0,  1.0,  2.0,  3.0,  4.0
 5.0,  6.0,  7.0,  8.0,  9.0
10.0, 11.0, 12.0, 13.0, 14.0
15.0, 16.0, 17.0, 18.0, 19.0
20.0, 21.0, 22.0, 23.0, 24.0
25.0, 26.0, 27.0, 28.0, 29.0
30.0, 31.0, 32.0, 33.0, 34.0
35.0, 36.0, 37.0, 38.0, 39.0
40.0, 41.0, 42.0, 43.0, 44.0
45.0, 46.0, 47.0, 48.0, 49.0

However, it produces this:

45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0
45.0, 46.0, 47.0, 48.0, 49.0

Can you find why? What pattern(s) do you observe? The output has two
properties that are saying something about the nature of the
bug(s). What are those properties?

02_Samples

This example is more difficult to debug since it produces the right
output, but it illustrates a bad practice that could lead to severe
errors in the future. You would have been deducted marks for
this. What is this error or what are those errors?

 0.0,  1.0,  2.0,  3.0,  4.0
 5.0,  6.0,  7.0,  8.0,  9.0
10.0, 11.0, 12.0, 13.0, 14.0
15.0, 16.0, 17.0, 18.0, 19.0
20.0, 21.0, 22.0, 23.0, 24.0
25.0, 26.0, 27.0, 28.0, 29.0
30.0, 31.0, 32.0, 33.0, 34.0
35.0, 36.0, 37.0, 38.0, 39.0
40.0, 41.0, 42.0, 43.0, 44.0
45.0, 46.0, 47.0, 48.0, 49.0

03_Samples

This solution should be acceptable, but you are welcome to criticize
it.

04_Samples

Simply introduces the idea that each example should also have its
expected value.

05_Grades

Grades example described above with a programming error in it. What is
it? When looking at the output, what feature gives a clue about the
nature of the error?

06_Grades

The program has two severe errors. One of them you should have been
able to identify with the exercise 05_Grades, but the other is quite
tricky to find! That error produces a runtime error:

> java Main
Exception in thread "main" java.lang.NullPointerException
	at Grades.addGrade(Grades.java:14)
	at Main.main(Main.java:16)
