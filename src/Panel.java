/**
 * Panel class that extends RealEstate and implements PanelInterface
 * Represents panel apartments with additional floor and insulation information
 */
public class Panel extends RealEstate implements PanelInterface {
    private int floor;
    private boolean isInsulated;
    
    /**
     * Default constructor
     */
    public Panel() {
        super();
    }
    
    /**
     * Constructor with all parameters
     * @param city The city where the property is located
     * @param price The price per square meter
     * @param sqm The area in square meters
     * @param numberOfRooms The number of rooms
     * @param genre The genre of the property
     * @param floor The floor number
     * @param isInsulated Whether the apartment has external insulation
     */
    public Panel(String city, double price, int sqm, double numberOfRooms, Genre genre, int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        this.floor = floor;
        this.isInsulated = isInsulated;
    }
    
    // Getters and Setters
    public int getFloor() {
        return floor;
    }
    
    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    public boolean isInsulated() {
        return isInsulated;
    }
    
    public void setInsulated(boolean insulated) {
        isInsulated = insulated;
    }
    
    /**
     * Calculates and returns the total price of the panel apartment
     * Overrides the parent method to include floor and insulation modifiers:
     * - Floors 0-2: +5%
     * - Floor 10: -5%
     * - Insulated: +5%
     * @return The total price as an integer
     */
    @Override
    public int getTotalPrice() {
        double basePrice = super.getTotalPrice(); // Get price with city modifier
        double modifier = 1.0;
        
        // Floor modifier
        if (floor >= 0 && floor <= 2) {
            modifier += 0.05; // +5%
        } else if (floor == 10) {
            modifier -= 0.05; // -5%
        }
        
        // Insulation modifier
        if (isInsulated) {
            modifier += 0.05; // +5%
        }
        
        return (int) (basePrice * modifier);
    }
    
    /**
     * Checks if the given RealEstate has the same total price
     * @param other The RealEstate object to compare with
     * @return true if both have the same total price, false otherwise
     */
    @Override
    public boolean hasSameAmount(RealEstate other) {
        return this.getTotalPrice() == other.getTotalPrice();
    }
    
    /**
     * Calculates the average price per room without any modifiers
     * @return The average room price as an integer
     */
    @Override
    public int roomprice() {
        if (numberOfRooms == 0) {
            return 0;
        }
        // Calculate base price without city, floor, or insulation modifiers
        double basePrice = price * sqm;
        return (int) (basePrice / numberOfRooms);
    }
    
    /**
     * Returns a string representation of the panel apartment
     * @return String containing panel apartment details
     */
    @Override
    public String toString() {
        return String.format("Panel{city='%s', price=%.2f, sqm=%d, numberOfRooms=%.1f, genre=%s, floor=%d, isInsulated=%s, totalPrice=%d, avgSqmPerRoom=%.2f}",
                city, price, sqm, numberOfRooms, genre, floor, isInsulated, getTotalPrice(), averageSqmPerRoom());
    }
}