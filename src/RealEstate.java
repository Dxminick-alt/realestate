/**
 * RealEstate class representing a real estate property
 */
public class RealEstate implements PropertyInterface {
    protected String city;
    protected double price; // price per square meter
    protected int sqm; // square meters
    protected double numberOfRooms;
    protected Genre genre;
    
    /**
     * Default constructor
     */
    public RealEstate() {
    }
    
    /**
     * Constructor with all parameters
     * @param city The city where the property is located
     * @param price The price per square meter
     * @param sqm The area in square meters
     * @param numberOfRooms The number of rooms
     * @param genre The genre of the property
     */
    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }
    
    // Getters and Setters
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getSqm() {
        return sqm;
    }
    
    public void setSqm(int sqm) {
        this.sqm = sqm;
    }
    
    public double getNumberOfRooms() {
        return numberOfRooms;
    }
    
    public void setNumberOfRooms(double numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    
    public Genre getGenre() {
        return genre;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    /**
     * Reduces the price per square meter by the specified percentage
     * @param percentage The discount percentage as an integer
     */
    @Override
    public void makeDiscount(int percentage) {
        this.price = this.price * (100 - percentage) / 100.0;
    }
    
    /**
     * Calculates and returns the total price of the property
     * Price is influenced by city location:
     * - Budapest: +30%
     * - Debrecen: +20%
     * - Nyíregyháza: +15%
     * @return The total price as an integer
     */
    @Override
    public int getTotalPrice() {
        double basePrice = price * sqm;
        double multiplier = 1.0;
        
        switch (city.toLowerCase()) {
            case "budapest":
                multiplier = 1.30;
                break;
            case "debrecen":
                multiplier = 1.20;
                break;
            case "nyíregyháza":
                multiplier = 1.15;
                break;
            default:
                multiplier = 1.0;
                break;
        }
        
        return (int) (basePrice * multiplier);
    }
    
    /**
     * Calculates the average square meters per room
     * @return The average square meters per room as a double
     */
    @Override
    public double averageSqmPerRoom() {
        if (numberOfRooms == 0) {
            return 0.0;
        }
        return sqm / numberOfRooms;
    }
    
    /**
     * Returns a string representation of the property
     * @return String containing property details
     */
    @Override
    public String toString() {
        return String.format("RealEstate{city='%s', price=%.2f, sqm=%d, numberOfRooms=%.1f, genre=%s, totalPrice=%d, avgSqmPerRoom=%.2f}",
                city, price, sqm, numberOfRooms, genre, getTotalPrice(), averageSqmPerRoom());
    }
}