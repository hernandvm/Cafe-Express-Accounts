# Cafe Express Accounts Management System

## Project Overview
A Java-based console application for managing student and faculty express card accounts. This system allows users to create accounts, make deposits, purchase meals, and track meal usage through an interactive menu-driven interface.

## Features
- **Dual Account Types**: Support for both Student and Faculty express accounts
- **Account Management**: Create new accounts and log into existing ones
- **Financial Operations**: 
  - Make deposits with bonus rewards
  - Purchase meals at account-specific rates
  - Track account balances
- **Meal Management**: 
  - Purchase meals in bulk
  - Use meals (swipe functionality)
  - Track remaining meal counts
- **Input Validation**: Robust error handling for user inputs

## Account Types & Benefits

### Student Accounts
- Meal price: $10.00 per meal
- Deposit bonus: $2.00 bonus for every $200 deposited above $500
- Base bonus threshold: $500

### Faculty Accounts  
- Meal price: $8.00 per meal
- Deposit bonus: 1% bonus on all deposits
- No minimum deposit requirement for bonuses


## Key Classes & Methods

### ExpAcct (Main Class)
- `main()` - Program entry point
- `subMenu()` - Account management interface
- Input validation methods for deposits and meal purchases
- Menu display and selection handlers

### ExpressAccount (Abstract Base Class)
- `makeDeposit()` - Abstract method for deposits
- `purchaseMeals()` - Meal purchasing logic
- `haveMeal()` - Meal usage functionality
- Getters/setters for account properties

### StudentExpressAccount & FacultyExpressAccount
- Implement account-specific bonus structures
- Set account-specific meal prices
- Override `makeDeposit()` with type-specific bonus calculations

## How to Run

### Prerequisites
- Java JDK 8 or higher
- BlueJ IDE (recommended) or any Java development environment

### Compilation and Execution
1. Open the project in BlueJ
2. Compile all Java files
3. Run the `ExpAcct` class
4. Follow the menu prompts to interact with the system

### Alternative: Command Line
```bash
javac *.java
java ExpAcct
```

## Usage Instructions
  1. **Main Menu Options**:
      - Create a new account (Student or Faculty)
      - Log into existing account
      - Exit the system
  
  2. **Account Management (After login)**:
      - Make a deposit (with automatic bonuses)
      - Purchase meals (system ensures sufficient funds)
      - Have a meal (deducts from meal count)
      - Log out
  
  3. **Account Information Display**:
      - Account type and number
      - Current balance
      - Remaining meal count

## Input Validation
  - Menu selections must be valid numeric choices
  - Deposits must be positive amounts
  - Meal purchases must be positive integers
  - Account numbers must exist in the system

## Technical Details
  - Data Structure: Uses ArrayList to manage multiple accounts
  - Input Handling: Scanner-based with exception handling
  - Financial Calculations: Rounded to 2 decimal places
  - Object-Oriented Design: Inheritance and polymorphism

## Author
  Victor Hernandez Jr  
  Lafayette College  
  CS150 Project 2, Fall 2022

## Academic Context
This project was developed for CS150 (Data Structures & Algorithms) at Lafayette College, demonstrating object-oriented programming principles, inheritance, polymorphism, and user interface design.

## Version
September 27, 2022


