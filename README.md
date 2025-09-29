# Real Estate Management System

## Overview
This Java project implements a real estate management system with classes for managing different types of properties including regular real estate and panel apartments.

## Project Structure
```
RealEstate/
├── src/
│   ├── Genre.java              # Enum for property types
│   ├── PropertyInterface.java   # Interface for property operations
│   ├── RealEstate.java         # Main real estate class
│   ├── PanelInterface.java     # Interface for panel operations
│   ├── Panel.java              # Panel apartment class (extends RealEstate)
│   └── RealEstateTest.java     # Test class with sample data
└── README.md                   # This file
```

## Classes and Interfaces

### 1. Genre Enum
Defines three types of properties:
- `FAMILYHOUSE`
- `CONDOMINIUM` 
- `FARM`

### 2. PropertyInterface
Interface with methods:
- `makeDiscount(int percentage)` - Applies discount to price per sqm
- `getTotalPrice()` - Calculates total property price
- `averageSqmPerRoom()` - Calculates average square meters per room

### 3. RealEstate Class
Main class representing a property with:
- **Fields**: city, price (per sqm), sqm, numberOfRooms, genre
- **City Price Modifiers**:
  - Budapest: +30%
  - Debrecen: +20%
  - Nyíregyháza: +15%
  - Other cities: no modifier

### 4. PanelInterface
Interface for panel-specific operations:
- `hasSameAmount(RealEstate other)` - Compares total prices
- `roomprice()` - Calculates average room price without modifiers

### 5. Panel Class
Extends RealEstate with additional features:
- **Additional Fields**: floor, isInsulated
- **Price Modifiers**:
  - Floors 0-2: +5%
  - Floor 10: -5%
  - Insulated: +5%

## Sample Data Used (From Teacher)
The test class uses the following sample data:

### RealEstate Objects:
```
REALESTATE#Budapest#250000#100#4#CONDOMINIUM
REALESTATE#Debrecen#220000#120#5#FAMILYHOUSE
REALESTATE#Nyíregyháza#110000#60#2#FARM
REALESTATE#Nyíregyháza#250000#160#6#FAMILYHOUSE
REALESTATE#Kisvárda#150000#50#2#CONDOMINIUM
REALESTATE#Nyíregyháza#150000#68#4#CONDOMINIUM
```

### Panel Objects:
```
PANEL#Budapest#180000#70#3#CONDOMINIUM#4#no
PANEL#Debrecen#120000#35#2#CONDOMINIUM#0#yes
PANEL#Tiszaújváros#120000#750#3#CONDOMINIUM#10#no
PANEL#Nyíregyháza#170000#80#3#CONDOMINIUM#7#no
```

## How to Run

1. **Compile the project:**
   ```bash
   cd src
   javac *.java
   ```

2. **Run the test:**
   ```bash
   java RealEstateTest
   ```

## Test Results

### Compilation
✅ All classes compile without errors

### Sample Output
The test demonstrates:
1. Creation of RealEstate objects with correct price calculations
2. Creation of Panel objects with floor and insulation modifiers
3. Discount functionality
4. Panel-specific methods (roomprice, hasSameAmount)
5. City price modifiers verification
6. Floor and insulation modifier verification

### Key Test Results:
- **Budapest property** (base: 25,000,000) → Total: 32,500,000 (+30%)
- **Debrecen property** (base: 26,400,000) → Total: 31,680,000 (+20%)
- **Panel with floor 0-2** → +5% modifier applied
- **Panel with floor 10** → -5% modifier applied
- **Insulated panel** → +5% modifier applied

## Features Implemented

✅ **Problem 1**: RealEstate class with all required fields and Genre enum  
✅ **Problem 2**: PropertyInterface implementation with all methods  
✅ **Problem 3**: Panel class with PanelInterface implementation  

### Tested Functionality:
- ✅ City-based price modifiers
- ✅ Discount application
- ✅ Average square meters per room calculation
- ✅ Panel-specific price modifiers (floor, insulation)
- ✅ Room price calculation without modifiers
- ✅ Total price comparison between properties

## Author
Created by: Dxminick-alt  
GitHub: https://github.com/Dxminick-alt/realestate