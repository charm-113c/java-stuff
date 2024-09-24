package samAndLambdas;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /**
         * Assume, in the following exercises, that the input is never null
         */
        /**
         * Ex 1: Define, in a single line, a lambda expression that implements a SAM of java.util.function
         * which takes in input a number and returns its squared value. Invoke it on a second line.
         */
        Function<Double, Double> f1 = x -> x*x;
        System.out.println(f1.apply(2.0));

        /**
         * Ex 2: Define, in a single line, a lambda expression that implements a SAM of java.util.function
         * which takes as input a string and prints it out. Invoke it on a second line.
         */
        Consumer<String> f2 = s -> System.out.println(s);
        f2.accept("Hello, World.");
        Consumer<String> f2_1 = System.out::println;
        f2_1.accept("Hello, World");

        /**
         * Ex 3: Define, in a single line, a lambda expression that implements a SAM of java.util.function
         * which takes as input a string and an int and returns an int which checks if the string 
         * has length equal to the given int. Invoke it in a second line.
         */
        BiPredicate<String, Integer> f3 = (s, i) ->  s.length() == i;
        f3.test("Hi", 2);

        /**
         * Ex 4: Define, in a single line, a lambda expression that implements a SAM of java.util.function
         * which doesn't take input and returns a randomly generated integer. Invoke it in a second line. 
         */
        Supplier<Integer> f4 = () -> (int)(Math.random()*Integer.MAX_VALUE);
        f4.get();

        /**
         * Ex 5: Define, in a single line, a lambda expression that implements a SAM of java.util.function
         * which takes as input a string and returns whether the string is empty or not. Invoke it in a 
         * second line.
         */
        Predicate<String> f5 = s -> s.isEmpty();
        Predicate<String> f5_1 = String::isEmpty;
        /**
         * In the second case, the compiler overloads the method isEmpty declaring and compiling:
         *  boolean isEmpty(String s) {
         *      return s.isEmpty();
         * }
         */
        f5.test("Hi");
        f5_1.test("");

        /**
         * Ex 6: Define a functional interface ElaborateString with the method elaborate which,
         * given in input a string, returns another string.
         * Then, write lambda expressions s.t.:
         * -The expression returns the string form of the length of the string
         * -The expression the five first chars of the string or, if it has length less than 5, the entire string.
         */
        ElaborateString f6_1 = s -> Integer.toString(s.length());
        ElaborateString f6_2 = s -> s.length() >= 5 ? s.substring(0, 5) : s; 
        f6_1.elaborate("Hi");
        f6_2.elaborate("MoreThanFiveCharsLong");
    }
}