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
  - III.II - [Records](#chap3.2)
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

### <a name="chap3.2">III.II - Record</a>