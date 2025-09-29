/**
 * Interface for property-related operations
 */
public interface PropertyInterface {
    /**
     * Reduces the price per square meter by the specified percentage
     * @param percentage The discount percentage as an integer
     */
    void makeDiscount(int percentage);
    
    /**
     * Calculates and returns the total price of the property
     * @return The total price as an integer
     */
    int getTotalPrice();
    
    /**
     * Calculates the average square meters per room
     * @return The average square meters per room as a double
     */
    double averageSqmPerRoom();
}