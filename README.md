# Java's good practices

------

Good practices from basic to advanced notions in Java.
Regarding Rémi Forax's course : https://www-igm.univ-mlv.fr/~forax/ens/java-avance/cours/pdf/ 

------

## Summary

- I - [Introduction](#chap1)
- II - [Execution Environment](#chap2)
- III - [Basic Notions](#chap3)
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

![](.\data\java_environment_architecture.png)

## <a name="chap3">III - Basic Notions</a>

