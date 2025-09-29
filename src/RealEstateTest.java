/**
 * Test class for RealEstate and Panel classes
 * Contains sample data provided by the teacher and demonstrates functionality
 */
public class RealEstateTest {
    
    public static void main(String[] args) {
        System.out.println("=== Real Estate Management System Test ===\n");
        
        // Create RealEstate objects based on teacher's sample data
        System.out.println("1. Creating RealEstate objects:");
        System.out.println("--------------------------------");
        
        RealEstate[] realEstates = {
            new RealEstate("Budapest", 250000, 100, 4, Genre.CONDOMINIUM),
            new RealEstate("Debrecen", 220000, 120, 5, Genre.FAMILYHOUSE),
            new RealEstate("Nyíregyháza", 110000, 60, 2, Genre.FARM),
            new RealEstate("Nyíregyháza", 250000, 160, 6, Genre.FAMILYHOUSE),
            new RealEstate("Kisvárda", 150000, 50, 2, Genre.CONDOMINIUM),
            new RealEstate("Nyíregyháza", 150000, 68, 4, Genre.CONDOMINIUM)
        };
        
        for (int i = 0; i < realEstates.length; i++) {
            System.out.println((i + 1) + ". " + realEstates[i]);
        }
        
        // Create Panel objects based on teacher's sample data
        System.out.println("\n2. Creating Panel objects:");
        System.out.println("-------------------------");
        
        Panel[] panels = {
            new Panel("Budapest", 180000, 70, 3, Genre.CONDOMINIUM, 4, false),
            new Panel("Debrecen", 120000, 35, 2, Genre.CONDOMINIUM, 0, true),
            new Panel("Tiszaújváros", 120000, 750, 3, Genre.CONDOMINIUM, 10, false),
            new Panel("Nyíregyháza", 170000, 80, 3, Genre.CONDOMINIUM, 7, false)
        };
        
        for (int i = 0; i < panels.length; i++) {
            System.out.println((i + 1) + ". " + panels[i]);
        }
        
        // Test discount functionality
        System.out.println("\n3. Testing discount functionality:");
        System.out.println("---------------------------------");
        RealEstate testProperty = new RealEstate("Budapest", 200000, 80, 3, Genre.CONDOMINIUM);
        System.out.println("Original property: " + testProperty);
        testProperty.makeDiscount(10);
        System.out.println("After 10% discount: " + testProperty);
        
        // Test Panel-specific methods
        System.out.println("\n4. Testing Panel-specific methods:");
        System.out.println("----------------------------------");
        Panel testPanel = panels[0];
        System.out.println("Test panel: " + testPanel);
        System.out.println("Room price (without modifiers): " + testPanel.roomprice());
        
        // Test hasSameAmount method
        System.out.println("\n5. Testing hasSameAmount method:");
        System.out.println("-------------------------------");
        RealEstate compareProperty = new RealEstate("Budapest", 180000, 70, 3, Genre.CONDOMINIUM);
        System.out.println("Panel: " + testPanel);
        System.out.println("Compare with: " + compareProperty);
        System.out.println("Same amount? " + testPanel.hasSameAmount(compareProperty));
        
        // Test city price modifiers
        System.out.println("\n6. Testing city price modifiers:");
        System.out.println("-------------------------------");
        RealEstate[] cityTests = {
            new RealEstate("Budapest", 100000, 50, 2, Genre.CONDOMINIUM),
            new RealEstate("Debrecen", 100000, 50, 2, Genre.CONDOMINIUM),
            new RealEstate("Nyíregyháza", 100000, 50, 2, Genre.CONDOMINIUM),
            new RealEstate("Other City", 100000, 50, 2, Genre.CONDOMINIUM)
        };
        
        for (RealEstate property : cityTests) {
            System.out.println(property.getCity() + " - Base: 5,000,000, Total: " + property.getTotalPrice());
        }
        
        // Test floor and insulation modifiers for panels
        System.out.println("\n7. Testing Panel floor and insulation modifiers:");
        System.out.println("-----------------------------------------------");
        Panel[] floorTests = {
            new Panel("Budapest", 100000, 50, 2, Genre.CONDOMINIUM, 1, false), // Floor 0-2: +5%
            new Panel("Budapest", 100000, 50, 2, Genre.CONDOMINIUM, 5, false), // Normal floor
            new Panel("Budapest", 100000, 50, 2, Genre.CONDOMINIUM, 10, false), // Floor 10: -5%
            new Panel("Budapest", 100000, 50, 2, Genre.CONDOMINIUM, 5, true)  // Insulated: +5%
        };
        
        for (Panel panel : floorTests) {
            System.out.println("Floor " + panel.getFloor() + 
                             ", Insulated: " + panel.isInsulated() + 
                             " - Total: " + panel.getTotalPrice());
        }
        
        System.out.println("\n=== Test completed successfully! ===");
    }
}