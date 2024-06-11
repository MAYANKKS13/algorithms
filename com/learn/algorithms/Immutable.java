package com.learn.algorithms;

import java.util.*;

/*
How to create Immutable class in Java?
Immutable class in java means that once an object is created,
we cannot change its content. In Java, all the wrapper classes
(like Integer, Boolean, Byte, Short) and String class is immutable.
We can create our own immutable class as well.
Prior to going ahead do go through characteristics of immutability
in order to have a good understanding while implementing the same.
Following are the requirements:

1. The class must be declared as final so that child classes can’t be created.
2. Data members in the class must be declared private so that direct access is not allowed.
3. Data members in the class must be declared as final so that we can’t change the value of it after object creation.
4. A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
5. Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
 */
public class Immutable {
    public static void main(String[] args) {
        Student student = new Student("kumar", 123, new HashMap<>());
        System.out.println(student.getMetadata());
        System.out.println(student.getName());
        System.out.println(student.getRegNo());
    }
}

// An immutable class
final class Student { // must be final

    // Member attributes of final class
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    // Constructor of immutable class
    // Parameterized constructor
    public Student(String name, int regNo,
                   Map<String, String> metadata)
    {

        // This keyword refers to current instance itself
        this.name = name;
        this.regNo = regNo;

        // Creating Map object with reference to HashMap
        // Declaring object of string type
        Map<String, String> tempMap = new HashMap<>();

        // Iterating using for-each loop
        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.metadata = tempMap;
    }

    // Ensure that the class is not subclassable
    private Student() {
        throw new AssertionError();
    }

    // Method 1
    public String getName() { return name; }

    // Method 2
    public int getRegNo() { return regNo; }

    // Method 3
    // User -defined type
    // To get meta data
    public Map<String, String> getMetadata()
    {

        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

// another example
final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<Student> students;

    public ImmutableClass(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        // Make a defensive copy of the list to ensure immutability
        this.students = Collections.unmodifiableList(new ArrayList<>(students));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        // Return an unmodifiable view of the list to ensure immutability
        return Collections.unmodifiableList(students);
    }

    // Ensure that the class is not subclassable
    private ImmutableClass() {
        throw new AssertionError();
    }
}