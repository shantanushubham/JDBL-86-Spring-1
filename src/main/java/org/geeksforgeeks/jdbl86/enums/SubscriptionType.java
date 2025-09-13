package org.geeksforgeeks.jdbl86.enums;

public enum SubscriptionType {
    NOT_SUBSCRIBED("Not Subscribed"), // 0 // Cant issue books
    PLUS("Plus"), // 1 - 3
    PRO("Pro"), // 2 - 7
    PREMIUM("Premium"); // 3 - 14

    private String name;

    SubscriptionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
