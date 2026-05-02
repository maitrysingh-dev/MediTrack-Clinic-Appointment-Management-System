JVM Report
Class Loader

Loads .class files into memory.

Types:

Bootstrap ClassLoader
Extension ClassLoader
Application ClassLoader
Runtime Data Areas
Heap

Stores objects and instance variables.

Stack

Stores method frames, local variables, references.

Method Area

Stores class metadata, static variables, constants.

PC Register

Stores current instruction address.

Execution Engine

Responsible for executing bytecode.

Includes:

Interpreter
JIT Compiler
Garbage Collector
JIT Compiler vs Interpreter

Interpreter:

Executes line by line
Slower

JIT:

Compiles bytecode to native machine code
Faster execution
Write Once Run Anywhere

Java compiles source code into bytecode. JVM on different operating systems executes same bytecode.