# Backpack Manager

## Problem Description

The project aims to solve the following problem:

1. **Build a backpack** that contains several objects, including a water bottle, cell phone, laptop, and others;
2. **Each object can have actions** such as: Open, Close, Turn On, Turn Off, etc.;
3. **Objects can be added and removed from the backpack**;
4. **Objects can have 3 sizes**: SMALL, MEDIUM, and LARGE;
5. **Objects must have a weight assigned to them**;
6. **The backpack must not weigh more than 3 kg**.

### Rules:
- **Class `Item`**:
    - Should contain attributes `name`, `weight`, and `size`.
    - Implement methods that print to the console for actions like `Open`, `Close`, `Turn On`, and `Turn Off`.

- **Class `Backpack`**:
    - Should contain methods to add and remove objects.
    - Ensure that the total weight of the objects in the backpack does not exceed the 3 kg limit.

- **Main**:
    - Should test object creation and backpack manipulation, adding and removing objects while respecting the weight restrictions.

## Implemented Features

- **Object Creation**: Objects can be created with name, weight, and size (SMALL, MEDIUM, LARGE).
- **Object Actions**: Each object has actions such as open, close, turn on, and turn off, which are displayed in the console.
- **Adding and Removing Objects in the Backpack**: The backpack allows adding and removing objects while respecting the maximum allowed weight of 3 kg.
- **Weight Validation**: The backpack automatically checks if the total weight of the objects exceeds the limit, throwing an exception if necessary.

## Technologies Used

- **Java 21**
- **Spring Boot** for the application framework
- **Vaadin** for the user interface
- **JUnit 5** and **Mockito** for testing

## Project Structure

- `com.example.backpack_manager.backend.entity`: Contains domain classes like `Item` and `Backpack`.
- `com.example.backpack_manager.backend.service`: Implements the logic for adding and removing objects from the backpack and checking the weight.
- `com.example.backpack_manager.ui.views`: Contains the graphical user interface (UI) built with Vaadin.
- `com.example.backpack_manager.services`: Includes unit tests to validate the system's behavior.

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/backpack-manager.git