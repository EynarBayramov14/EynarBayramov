# Design Rationale Report for Real Estate Application System

## Introduction
This document explains the reasoning of the design decision mainly focusing on how and why that certain decision is made so that a robust, scalable, and maintainable model can be achieved.

## High-Level Overview
The class diagram represents a real estate application system with multiple actors like Buyers, Sellers, Agents, and Admins interacting with Property and User management systems.

## Design Principles and Decisions

### 1. Single Responsibility Principle (SRP)
- Each class has a single specific responsibility:
  - User-related operations like authentication and user management are handled by **UserManager**.
  - **PropertyManager** focuses mainly on property-related tasks such as adding, removing, and searching properties.
  - **Seller**, **Buyer**, **Agent**, and **Admin** handle role-specific actions.

This decision ensures that changes in one part of the system do not affect the other parts.

### 2. Open/Closed Principle
In the system, classes are designed to be valid for extension but cannot be modified.
- The **PropertyManager** and **UserManager** classes use maps and methods which can be enlarged with new features without changing the existing code.
- **Buyer**, **Seller**, **Agent**, and **Admin** can be extended with additional methods when needed.

### 3. Dependency Inversion Principle
- High-level modules like **CommandHandler** rely on abstractions (**UserManager**, **PropertyManager**) rather than concrete implementations.

This approach facilitates testing and maintainability of the system, ensuring that the dependency between high-level components and low-level classes is decoupled.

### 4. Encapsulation and Data Hiding
- In all classes, getters and setters are used to make private attributes accessible.

As a result, encapsulation ensures that internal states are not open for direct modification and unintended side effects are avoided.
- Example: Attributes like **username** and **password** in **User** are accessed through getters and setters to limit the control only by their usage.

### 5. Separation of Concerns
The system separates fundamental concerns into different classes:
- **CommandHandler** acts as a controller that arranges interactions between different managers and role-based classes.
- **RealEstateApp** and **Application** classes serve as entry points, following the principle of separating application initialization from the core logic.

### 6. Use of Manager Pattern
- The **UserManager** and **PropertyManager** classes adopt the Manager pattern to centralize operations related to Users and Properties.

Centralizing helps to simplify maintenance and confirm consistency in data handling.

### 7. Adherence to DRY
The system uses encapsulation to avoid duplication and increase the maintainability of the system:
- Shared functionalities, such as loading and saving data, are encapsulated in specific methods (**loadUsersFromFile** in **UserManager** and **loadPropertiesFromFile** in **PropertyManager**).

### 8. Scalability and Extendibility
Scalability is maintained by separating functionality into distinct classes:
- Adding a new role (e.g., **Inspector**) would demand minimal changes to the system (only creating a new class and relating it with **CommandHandler**).
- Property-related features can be enlarged by extending **PropertyManager** with new methods without affecting other parts of the system.

## Architectural Justification

### Use of MVC Pattern
The design follows the MVC architectural pattern:
- **Model**: **User**, **Property**, **UserManager**, and **PropertyManager** classes manage the main data and operations.
- **View**: Role-specific menus implicitly (e.g., **showBuyerMenu**, **showSellerMenu**) act as pseudo-views.
- **Controller**: **CommandHandler** handles interactions between Models and Views.

This separation achieves better modularity and testability.

## Multiplicity Decisions
Multiplicities were designed to reflect real-world relationships:
- **UserManager** manages `0..*` users since a system initially would have no users.
- **PropertyManager** manages `0..*` properties, allowing the system to work with any number of properties.
- Associations between **CommandHandler** and other classes like **Admin**, **Agent**, **Seller**, and **Buyer** are `1`, since each role is coupled with the handler.

## Trade-offs and Alternatives

### Simplicity vs. Flexibility:
- While the current design is flexible, introducing interfaces for classes like **Manager** could further decouple implementations; however, this was avoided to maintain simplicity.

### Centralized vs. Distributed Control:
- The use of **CommandHandler** centralizes control, but as the system grows, its functionality could be disturbed. Distributing responsibilities among more controllers can avoid this problem.

## References
- Robert C. Martin, "Clean Code: A Handbook of Agile Software Craftsmanship."
- Craig Larman, "Applying UML and Patterns."
- Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides, "Design Patterns: Elements of Reusable Object-Oriented Software."

## Conclusion
The class diagram was designed to balance scalability, modularity, and follow the design principles. Principles of SRP, OCP, and SoC are used to ensure maintainability and extensibility while minimizing coupling and maximizing cohesion. Decisions are rooted in design patterns and principles to create a robust foundation for the real estate application system.
