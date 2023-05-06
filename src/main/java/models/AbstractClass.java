package models;

public class AbstractClass {
    public void echo() {
        System.out.println(this instanceof ChildClass);
    }
}
