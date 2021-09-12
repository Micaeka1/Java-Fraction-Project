# PoP2 Project 2020-21 - Fraction
Java provides classes for working with several types of numbers, but it does not provide anything for working with fractions. Your task is to implement a Fraction API (Application Programmer's Interface). You should also write a small program that uses it.

# Purposes of this assignment
The purposes of this assignment include the following:

- To give you practice with creating classes.
- To give you practice reading the API.
- To give you more practice with string manipulation.
- To give you practice with unit testing.

# General idea of the assignment
You are to implement a Fraction API; in particular, you are to implement a number of methods in the file FractionImpl.java.

Create a package named fraction. The interface Fraction and the class FractionImpl will be inside this package. (Source files from which you can start are provided.) You do not need to and should not edit the file Fraction.java at all; this file contains the interface. This interface can be conceived of as a contract between the designer/future user of the FractionImpl class (the course staff!) and the programmer implementing this class (you!).

Note: although you are asked to implement a number of methods, the implementations, for the most part, should be quite short.

# The API
The following lists some information about your new class. As regards implementing the methods, there is no strict requirement on how a method needs to behave wherever the behavior is not specified by the description below; however, in all cases it is suggested that you think about what reasonable behavior would be, and attempt to implement it.

## Instance variables
The instance variables should consist of two private integers, known as the numerator and the denominator. Do not provide public accessors or mutators (getters or setters) for these instance variables; there is no reason for anything outside the FractionImpl class to know about them.

Note on access: Even though these instance variables are private, they are private to the class, not to an object. This means that any FractionImpl object can access the private variables of any other FractionImpl object; it's only outside this class that you cannot access them.

You should obey the following properties/invariants concerning the instance variables:

- Zero should be represented as 0/1.
- The denominator should never be zero.
- The denominator should never be negative. A negative number for the denominator may be given to the constructor to create a fraction, but a negative fraction should be represented internally with a negative numerator.

- The fraction should always be kept in reduced form, that is, the greatest common divisor (GCD) of the numerator instance variable and the denominator instance variable should be 1. (See the relevant note below.)

## Constructors
The following lists the constructors you should have. (Please note that Java does not allow constructors to be specified in an interface, hence the use of `FractionImpl`.)

| Constructor | How it uses its parameters|
| -------------|---------------------------|
| `public FractionImpl(int numerator, int denominator)`|Parameters are the numerator and the denominator. **Normalize** the fraction as you create it. For instance, if the parameters are `(8, -12)`, create a `Fraction` with numerator `-2` and denominator `3`. The constructor should throw an `ArithmeticException` if the denominator is zero. |
|`public FractionImpl(int wholeNumber)`|The parameter is the numerator and `1` is the implicit denominator. |
|`public FractionImpl(String fraction)` |The parameter is a `String` containing either a whole number, such as "5" or "-3", or a fraction, such as "8/-12". Allow blanks around (but not within) integers; thus, "10 /-4" should be handled, but "1 0 / -4" (where there is a space between the '1' and the '0') need not be. |

The constructor should throw an `ArithmeticException` if given a string representing a fraction whose denominator is zero.

You may find it helpful to look at the available String methods in the Java API.

**Notes:**
- Java allows you to have more than one constructor, so long as they have different numbers or types of parameters. For example, if you call new `FractionImpl(3)` you will get the second constructor listed above. A String is a string, though, so the third constructor will have to distinguish between "3" and "3/4".

- To throw an `Exception`, write a statement such as:

`throw new ArithmeticException("Divide by zero"); `

(The `String` parameter is optional.)

- The java method `Integer(string).parseInt()` will return the `int` equivalent of the string (assuming that the string represents a legal integer). Malformed input will cause it to throw a `NumberFormatException`.

