# Java's good practices

------

Good practices from basic to advanced notions in Java.
Regarding Rémi Forax's course : https://www-igm.univ-mlv.fr/~forax/ens/java-avance/cours/pdf/ 

------

## Summary

- I - [Introduction](#chap1)
- II - [Execution Environment](#chap2)
- III - [Basic Notions](#chap3)
  - III.I - [Types](#chap3.1)
  - III.II - [Classes](#chap3.2)
  - III.III - [Arrays](#chap3.3)
  - III.IV - [Package](#chap3.4)
  - III.V - [Java Bean](#chap3.5)
  - III.VI - [Conditions](#chap3.6)
  - III.VII - [String](#chap3.7)
  - III.VIII - [Formatting and Matching](#chap3.8)
- IV - [](#chap4)
- V - [](#chap5)
- VI - [](#chap6)
- VII - [](#chap7)
- VIII - [](#chap8)
- IX - [](#chap9)
- X - [](#chap10)

------

## <a name="chap1">I - Introduction</a>

**History of languages :**

- First languages (1960) : COBOL, FORTAN, LISP, ALGOL
- Structured/Imperative languages (1970) : C, Pascal
- Functional languages (1980/1990) :  SML, OCaml, Haskell 
- Object Oriented languages (1980/1990) : Smalltalk, C++, Java Objective C

**Imperative Language :** 
Execute commands, modify a state (memory case)

**Functional Language :** 
Execute functions, referential transparency (the return value of a function depends on the value of its parameters)

**Imperative vs Function language :**

| Imperative | Functional |
| :--------: | :--------: |
|   Class    |   Record   |
|   Method   |   Lambda   |
| Collection |   String   |
|    Loop    |   Stream   |

<u>**Java :**</u>
Created by James Gosling, Guy Steele and Bill Joy at SUN Microsystem in 1995. (based on C and Smalltalk).
<u>Credo :</u> "*Write Once Run Anywhere*".

#### Java versions :

*LTS = Long Time Support*

- Java 1.0 (1995) => OOP
- Java 1.5 (2004) => Parameterized types
- Java 1.8 LTS (2014) => Lambda, Stream
- Java 11 LTS (2018) => HTTP Client, String Methods
- Java 17 LTS (2021) => Record, Sealed types
- Java 21 LTS (2023) => Virtual Threads, Pattern Matching

Java is a **multi-paradigm** language (imperative, functional, generic, reflective, concurrent, OO, etc.).

------

## <a name="chap2">II - Execution Environment</a>

- **Java Bytecode**: Compiled from Java source code (`.class` files) by the Java compiler (`javac`).
- **Class Loader**: Loads Java classes into the JVM at runtime.
- **JVM (Java Virtual Machine)**: Executes the loaded bytecode.
- **JIT (Just-In-Time Compiler)**: Compiles bytecode into native machine code during execution for improved performance.
- **Java Standard Library**: Provides essential utilities and functionalities to the running application.
- **Garbage Collectors**: Manage memory by reclaiming memory used by objects no longer needed during the execution.
- **Java API (Application Programming Interface)**: Provides a set of pre-written code that can be used by developers to interact with the running application.

Supporting components:

- **JRE (Java Runtime Environment)**: Supports the execution environment, providing necessary libraries and JVM.
- **JDK (Java Development Kit)**: Used in the development phase to compile Java source code into bytecode (contains JRE).

<img src="https://javapapers.com/wp-content/uploads/2009/05/jvm-jre-jdk1.png" height="400">

**Compile :**

- `javac Foo.java` => Compile the java file and build the compiled file *Foo.class*. 
- `java Foo` => Execute the main code of Class Foo

NB : For the `javac` command, *Foo* is the name of the file and for the `java` command, *Foo* is the name of the Class.

- `java Foo.java` => Compile and execute at the same time, but only works with one class.

**Jshell :** 
**REPL** (**R**ead–**E**val–**P**rint **L**oop), allows to quickly try a functionality. Ex :

- jshell> var a = 3 
  a ==> 3 
- jshell> System.out.println(a)
  3

## <a name="chap3">III - Basic Notions</a>

In Java, Classes are written in CamelCase, variables and methods are written in camelCase.

### <a name="chap3.1">III.I - Types</a>

Java has two kind of types :

**Primitives Types :**

boolean, byte, chart, short, int, long, float, double (starts with lowercase).
Handled by their values. Ex :

```java
int i = 3;
int j = i; // copy 3
```

Values are stored directly in the Stack.

**Object Types :**

String, LocalDate, Pattern, int[], etc. (starts with uppercase).
Handled by their references. Ex :

```java
String s = "hello";
String s2 = s; // copy address to memory
```

Values are stored in the Heap and the references are stored in the Stack.

<img src="https://www.baeldung.com/wp-content/uploads/2018/07/java-heap-stack-diagram.png">

**Operator "==" :**

The "==" operator tests if two locations in stack memory are equal. For primitive types, it checks if the variable values are equal, and for object types, it checks if the addresses are equal.

```java
int i = 3;
int j = 4;
i == j // returns false
i == i // returns true

String s1 = "Hello";
String s2 = "Hello";
s1 == s2 // returns false
```

*In this example, "s1==s2" actually returns true. For more details, see the [String](#chap3.7) chapter.)*

**Default values :**

In java, all types have default values.

- boolean => false
- int,short => 0
- long/double => 0.0
- char => \0 (u0000)
- Object => null

**Processors :**

Processors have 4 types : 

- int 32bits
- int 64bits
- float 32bits
- float 64bits

*boolean, byte, short, char => int 32bits*

Compiler prohibits calculations between booleans, but for the byte, short and char :

```java
short s = 3;
short s2 = s + s; // doesn't compile because the result is an int
```

*byte, short, int, long, float* and *double* are all signed. *char* is the only unsigned type.
We use *"<<"* and *">>"* for the signed variables, and *">>>"* for the unsigned types. 

<img src="https://i.sstatic.net/S5kAd.png">

### <a name="chap3.2">III.II - Classes</a>

**Instantiations :**

In a method, the **this** keyword represents the object just before the '.' when calling the method.

```java
public class Point {
 	public double distanceToOrigin(Point this) {
 		return 0;
 	}
}
...
var p = new Point();
var value = p.returnZero(); // When returnZero is called, "this" == "p"
```

NB : We never write or see the "*Object this*" in parameter of the methods because the compiler adds it automatically. We can then just write the method returnZero() that way :

```java
public double distanceToOrigin() {
    return 0;
}
```

In **static** methods, the keyword "*this*" doesn't exist as static methods are unbound to instantiation and objects. Exemple :

```java
public record Taxi(boolean uber) {
 	public String name() { // "this" implicit
 		return this.uber? "Uber": "Hubert?";
 	}
 	public static String bar() { // "this" doesn't exit here
 		return "Hello Taxi";
 	}
}
…
new Taxi(true).name() // Uber
Taxi.bar() // Hello Taxi
```

The **main()** method is a special method which serves as an entry point into the program. It is defined that way inside a Class or a Record :

```java
public static void main(String[] args) {
	...
}
```

**Record :**

Immutable object considered as a tuple. We can create methods inside the Record just like for a Class. Records are created with the "*new*" keyword just like a classic object.

By default records have an all arguments constructor which is called *canonical constructor*. It is common to redefine the constructor to add checks and verifications. It exists a "compact" canonical constructor for this :

```java
public record Person(String name, int age) {
 	public Person(String name, int age) { // canonical constructor (automatically generated)
 		this.name = name;
 		this.age = age;
	}
}

public record Person(String name, int age) {
	public Person { // compact canonical constructor
 		Objects.requireNonNull(name, "name is null"); // Checks name is not null
   		if (age < 0) // Checks age is greater than 0
			throw new IllegalArgumentException("Age < 0");
    }
}
```

Compiler also generate automatically *equals()*, *hashCode()* and *toString()* method for Records. They can still be obviously overridden, with the "*@Override*" annotation.

Record also provides getters(), with the exact same name as the fields :

```java 
public record Person(String name, int age) {}
...
var p = new Person("toto", 1);
p.name() // toto
p.age // 1
```

**Fields :**

Inside a Class or a Record, fields are accessed with the keywork **this**, as long as it's written inside the curly brackets of the Class.

```java
public record Point(int x, int y) {
 	public double distanceToOrigin() {
 		return Math.sqrt(this.x * this.x + this.y * this.y); // "this.x" works here
 	}
}
...
var point = new Point(3, 4);
System.out.println(point.x); // doesn't compile
```

Like for the methods, "*this*" is implicit and doesn't need to be written inside the class, except when a parameter with the same name is being used, which usually happens in constructor :

```java 
public class Book(String name) {
    public Book(String name) {
        Objects.requireNonNull(name, "name is null");
        this.name = name; // We instantiate the field name with the given parameter name
    }
}
```

### <a name="chap3.3">III.III - Arrays</a>

As we've seen, arrays are Object Types in java. They can contains both primitives and objects types. We classically use the "*new*" keyword to create them.

```java
String[] array = new String[16]; // initialize with default values (0,false,0.0,null)
int[] array = new int[] { 2, 46, 78, 34 }; // creates with the given values
```

- Arrays have a fixed size, which can be seen with the **length** parameter. ex: `array.length`
- Arrays are mutable, we use "[" and "]" to modify their values. ex: `array[3] = 56;`
- We can't exceed length limits :

```java
var array = new int[12];
array[25] = … // throws ArrayIndexOutOfBoundsException
array[-1] = … // throws ArrayIndexOutOfBoundsException
```

**loop :**

Java proposes a compact version of the *for* loop, also known as *for-each*.

```java 
var array = ...

for(var i = 0; i < array.length; i++) { // classic for loop
 	var element = array[i];
 	...
}
for(var element: array) { // for-each loop
	...
}
```

### <a name="chap3.4">III.IV - Package</a>

In java, a library is composed of multiple packages. For example, the default library in Java JDK contains :

- java.lang => default classes of java
- java.util => useful classes, data structures and Collections
- java.util.regex => regular expression
- java.sql => basic classes to access DataBase
- java.io => For input/output
- java.nio.file => input/output on files *(do NOT use Files classes from java.io)*
- etc.

**Import :**

We find the import as the beginning of a file in java, it represents the classes and records we want to use from different packages than where our file is located.
In fact, java doesn't really "import" any files (unlike C or Python), it would be more precise to call it an "alias".

```java
public class Hello {
    public static void main(String[] args) {
 		var list = new java.util.ArrayList(); // Works !
 	}
}
// These two codes are equal
import java.util.ArrayList; // Indicate the alias for ArrayList to the compiler
public class Hello {
	public static void main(String[] args) {
 		var list = new ArrayList(); // Also works !
	}
}
```

### <a name="chap3.5">III.V - Java Bean</a>

A Java Bean is a special class with **getters** "and **setters**. This is mostly the only case in Java where we'll find a class that has getters and setters. Otherwise it will be considered as a very bad practice.

- setters => save values inside an object => *setXX()* (with XX being the value).
- getters => extract values from an object => *getXX()* or *isXX()*.

Java possesses many frameworks using the notion of Java Beans (EJB (Entreprise Java Beans)) :

- Web Services :  *Spring, JBoss, Quarkus, Micronaut...*
- Read DataBase line as an object : *Hibernate*
- Transform Objects from/to JSON : *Jackson, Gson*
- etc.

### <a name="chap3.6">III.VI - Conditions</a>

In java, conditions in if, while, for must be boolean (no *while(1)* like in C).

#### Switch :

C (compatible in java) switch : 

```java
int seats = …
String type;
switch(seats) {
	case 1:
		type = "small";
 		break;
 	case 4: {
 		System.out.println("debug");
 		type = "medium";
 		break;
 	}
 	default:
 		type = "big";
}
```

You should **never** forget the *break* keyword inside the switch condition, otherwise it will pass to the next case. You don't need a *break* in the *default* case as it's the last case of the switch (it can't pass to an other case).

Now let's see the the special java switch, a more compact switch using arrows ("->") that can also returns values :

```java
int seats = …
String type = switch(seats) {
	case 1, 2 -> "small";
 	case 3, 4, 5 -> {
 		System.out.println("debug");
 		yield "medium";
 	}
 	default -> "big";
}
```

For a return switch (a switch that returns a value), we don't to create a block with the "{ }" brackets, we can simply write the value. I you want to return the value inside a block, you will need to use the *yield* keyword.

The *default* case at the end is necessary in a switch for the program to compile.

### <a name="chap3.7">III.VII - String</a>

In Java, the *String* class represents a sequence of character. The class is immutable. I you want to change a character of the sequence, you will have to generate a new String (or java will do it for you in specific methods).

There are 2 types of String in java :

- Simple String, written between quotes. Ex : "This is an immutable char sequence"
- *Text block*, can be written on many lines between 3 quotes. Ex :
  """
  This is an
  immutable char
  sequence
  """

The special String characters are the same as in C :

- \n : Return to new line
- \r : Carriage return
- \t : Tabulation
- \\' : Simple quote
- \\" : Double quote
- \\ : Backslash

#### Memory :

String, as objects in java, are references to values in memory. The actual values (literals String) are stored in a dictionary/cache. What it means is that two different String defined with the same value (defined in " or """) will be equals, even in memory (with '=='). Ex : 

```java
String s = "hello";
String s2 = "hello";
s == s2 // true, unlike we've seen earlier
```

Even though, you should always use the *equals()* method to test the value of two String.

#### Methods :

Most common methods : 

- s.length() : Returns the size of the String
- s.charAt(index) : Get the character at the given index
- s.repeat(times) : Repeat the same String "times" times
- s1.compareTo(s2) : < 0 if s1 is smaller than s2, > 0 if s1 is bigger than s2, == 0 if s1 and s2 are equals
- s.startsWith(prefix) : Returns boolean if it starts with the given prefix
- s.endsWith(suffix) : Returns boolean if it ends with the given suffix
- s.indexOf(char) : Returns the index of the first occurrence of the given char, returns -1 if not found
- lastIndexOf(char) : Returns the index of the last occurrence of the given char, returns -1 if not found
- s.substring(start, end) : Returns the String between the indexes start and end
- s.substring(end) : *(equivalent to s.substring(0, end))*
- s.toLowerCase() : Converts all the characters of a String to lower case
- s.toUpperCase() : Converts all the characters of a String to upper case
- s.split(regex) : Splits the String in an array, given the regex in parameters
- String.join(delimiter, elements) : Joins the values of an array (elements) with a delimiter

##### Convert a String in primitive types :

- Boolean.parseBoolean(text)
- Integer.parseInt(text)
- Double.parseDouble(text)

##### Convert a primitive type into String :

2 ways. First, with a method :

- Boolean.toString(boolean value)
- Integer.toString(int value)
- Double.toString (double value)

Second, with the '+' operator and an empty String. Example :

```java
int value = 4;
String text = value + "";
```

#### Switch on String :

Just like a *if* condition, the switch uses the *hashCode()* and *equals()* methods to match the value with the case. In the end, the compilator will then test the equality of the hashed values, like this :

```java
return switch(vehicle) {
 case "bicycle" -> 10;
 case "car", "sedan" -> 20;
 default -> throw new IAE("unknown " + vehicle);
 };
```

This code above is equal to the following code :

```java
var index = switch(vehicle.hashCode()) {
 case -117759745 -> vehicle.equals("bicycle")? 0: -1;
 case 98260, -> vehicle.equals("car")? 1: -1;
 case 109313023 -> vehicle.equals("sedan") ? 1: -1;
 default -> -1;
 };
 return switch(index) {
 case 0 - > 10;
 case 1 - > 20;
 default - > throw new IAE(…);
 };

```

#### Concatenation :

As we said, a String is immutable, so one concatenation using the operator '+' reallocate a new String. If we make many concatenation in the same expression, Java will allocate only one String all the time :

```java
return type + " " + age; // 1 allocation
```

However, in a loop, java will reallocate a new String at each iteration, which is a terrible complexity for a code :

```java
var result = "";
 for(var s: array) {
 result = result + ":" + s; // 1 allocation at each iteration
 }
 return result;
```

To avoid this major problem, we use the class *StringBuilder*.

#### StringBuilder :

A StringBuilder is a class that provides an extensible character buffer.

```java
var builder = new StringBuilder();
for(var s: array) {
	builder.append(s);
	builder.append(":");
}
return builder.toString(); // Creates the String here
```

You can chain the *append()* calls, as the method returns itself (the StringBuilder).

```java
for(var s: array) {
	builder.append(s).append(":"); // We can then simplify the code above like this
}
```

!!! You should **NEVER** put a '+' operator in an *append()* method, as it will cancel the benefits of the StringBuilder !!!

The code we've seen is actually incorrect, as it will append a ':' separator at the end of the String, with no element after it. Here is a clean way to correct the code and to write a *join()* method :

```java
String join(String[] array) {
	var builder = new StringBuilder();
	var separator = "";
	for(var s: array) {
		builder.append(separator).append(s); // As the separator is empty, it will append.. nothing
		separator = ":";
	}
	return builder.toString();
}
```

### <a name="chap3.8">III.VIII - Formatting and Matching</a>

#### Regex :

A regular expression (regex) is a pattern of characters that describes a set of strings. **Pattern** *(java.util.regex.)* is a class that represents an automate build from a regex. **Matcher** is a class that skim trough the automate created on a text.

Example :

```java
Pattern pattern = Pattern.compile("a+"); // Pattern "a+", corresponds to one or many letters 'a'

Matcher matcher = pattern.matcher("aaaaab"); // Execute the pattern to the text "aaaaab"

matcher.matches(); // Matches the entire text (false here because of 'b')
matcher.lookingAt(); // Matches the beginning of the text (true here)
matcher.find(); // Matches somewhere in the text (true here)
matcher.start(); // Returns the start index of the current match
matcher.end(); // Returns the end index of the current match (exclusive)
matcher.group(); // Returns the matched substring
```

Many ways to compose patterns :

- word: hello
- repetition: +, *, ?
- conjunction/disjunction: a+b+, foo|bar
- characters: [abc], [a-z]
- classes: \d, \p{Digit}, \p{Alpha}
- capture: (a+)

List of examples :

```java
var pattern = Pattern.compile("a+");
pattern.matcher("aaa").matches(); // true - one or more 'a' characters

var pattern = Pattern.compile("[0-9]+\\.[0-9]*");
pattern.matcher("12.5").matches(); // true - decimal number with digits before the dot and optional digits after

var pattern = Pattern.compile("\\d+\\.\\d*");
pattern.matcher("24.").matches(); // true - decimal number with digits before the dot, optional digits after

var pattern = Pattern.compile("-?[0-9]+");
pattern.matcher("-14").matches(); // true - integer, optionally negative

var pattern = Pattern.compile("[A-Za-z][A-Za-z_0-9]*");
pattern.matcher("old_regex3").matches(); // true - valid identifier, starting with a letter, followed by letters, numbers, or underscores

var pattern = Pattern.compile("\\p{Alpha}\\w*");
pattern.matcher("old_regex3").matches(); // true - identifier starting with a letter and followed by alphanumeric characters or underscores
```