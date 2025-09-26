package org.example;

/**
 * Class representing sports equipment with several properties.
 */
public class SportEquipment {
    /**
     * Constructor to create a SportEquipment object.
     *
     * @param name     the name of the equipment
     * @param type     the type/category of the equipment
     * @param weight   the weight of the equipment
     * @param price    the price of the equipment
     * @param quantity the available quantity in stock
     */
    private String name;
    private String type;
    private double weight;
    private double price;
    private int quantity;

    public SportEquipment(String name, String type, double weight, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the name of this equipment.
     *
     * @return the name of the equipment
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of this equipment.
     *
     * @return the type of the equipment
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the weight of this equipment.
     *
     * @return the weight in kilograms
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the price of this equipment.
     *
     * @return the price value
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the available quantity of this equipment.
     *
     * @return the quantity in stock
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a string representation of this {@code SportEquipment} object.
     * The string includes all field values in a readable format.
     *
     * @return a formatted string with all properties
     */
    @Override
    public String toString() {
        return "<name=" + name +
                ", type=" + type +
                ", weight=" + weight +
                ", price=" + price +
                ", quantity=" + quantity + ">";
    }

    /**
     * Checks whether this object is equal to another object.
     * Two {@code SportEquipment} objects are considered equal
     * if all their fields are identical.
     *
     * @param obj the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SportEquipment)) return false;
        SportEquipment other = (SportEquipment) obj;
        return Double.compare(other.weight, weight) == 0 &&
                Double.compare(other.price, price) == 0 &&
                quantity == other.quantity &&
                name.equals(other.name) &&
                type.equals(other.type);
    }
}
