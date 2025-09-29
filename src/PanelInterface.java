/**
 * Interface for panel-specific operations
 */
public interface PanelInterface {
    /**
     * Checks if the given RealEstate has the same total price
     * @param other The RealEstate object to compare with
     * @return true if both have the same total price, false otherwise
     */
    boolean hasSameAmount(RealEstate other);
    
    /**
     * Calculates the average price per room without modifiers
     * @return The average room price as an integer
     */
    int roomprice();
}