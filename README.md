# Dungeon-Dragon-Java
Exercice to train on Java
Role of Game.java:
Game Flow Management:

It likely controls the primary loop for the game, handling user inputs, transitions between different game states, and the overall progression of gameplay.
Integration of Components:

The class serves as a bridge between various elements, such as characters, items, and game logic.
Core Mechanics Implementation:

This will include combat systems, random event generation, and interactions between the player and the environment.

Design Observations:
Structure:
Based on its name and convention, it may act as a controller, orchestrating interactions between the models (e.g., player or enemy) and the views (text-based outputs).
Design Patterns:
State Pattern: If the game supports different states (e.g., menus, combat, exploration), this pattern is likely utilized.
Command Pattern: To interpret and execute user inputs effectively.
Technologies and Practices:
Java Standard Library: For handling collections, I/O operations, and basic utilities.
Encapsulation: The game logic is likely divided into methods for readability and maintainability.
