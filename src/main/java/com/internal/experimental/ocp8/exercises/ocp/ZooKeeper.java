package com.internal.experimental.ocp8.exercises.ocp;

import java.util.HashMap;
import java.util.Map;

class FoodFactory {

    static Food getFood(String animalName) {
        Map<String, Food> foodMap = new HashMap<String, Food>();
        foodMap.put("zebra", new Hay(100));
        foodMap.put("rabbit", new Pellets(5));
        foodMap.put("goat", new Pellets(30));
        foodMap.put("polar bear", new Fish(10));

        if (!foodMap.containsKey(animalName)) {
            // Good practice to throw an exception if no matching subclass could be found
            throw new UnsupportedOperationException("Unsupported animal: " + animalName);
        } else {
            return foodMap.get(animalName);
        }
    }
}

/*
switch(animalName) {
case "zebra": return new Hay(100);
case "rabbit": return new Pellets(5);
case "goat": return new Pellets(30);
case "polar bear": return new Fish(10);
}*/

public class ZooKeeper {
    public static void main(String[] args) {

        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}

abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}

class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }
}

class Pellets extends Food {
    public Pellets(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Pellets eaten: " + getQuantity());
    }
}

class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Fish eaten: " + getQuantity());
    }
}