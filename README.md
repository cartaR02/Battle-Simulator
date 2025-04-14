# BattleSimulator

A turn-based Pokémon-style battle simulator written in Java using Swing for the GUI. Players can choose a Pokémon and battle against a computer-controlled opponent using a variety of attack types, each with different damage and accuracy values.

---

## Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Features](#features)
- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Troubleshooting](#troubleshooting)
- [License](#license)

---

## Introduction

BattleSimulator is a GUI-based game that allows users to select a Pokémon and use different attack types to defeat a randomly chosen opponent. The game includes three Pokémon types: Rat, Snake, and Turtle, each with unique stats.

---

## Installation

1. Make sure you have Java Development Kit (JDK) installed (version 8 or above recommended).
2. Clone or download this repository.
3. Place the `BattleSimulator.java` file into your Java project folder.

---

## How to Run

1. Open the file in an IDE like IntelliJ, Eclipse, or compile via terminal: javac BattleSimulator.java
2. Then run the compiled class: java BattleSimulator

---

## Usage

- When the application starts, choose your Pokémon by clicking one of the three buttons: **Rat**, **Snake**, or **Turtle**.
- After selecting your Pokémon, click **Confirm** to lock in your choice.
- The computer will automatically select its Pokémon.
- Use the attack buttons:
- **Strong Attack**
- **Medium Attack**
- **Weak Attack**
- **Effect Attack**

Each attack has different accuracy and damage. After each turn, the computer will respond with an attack of its own.

- The health of both the player and the computer is shown at the bottom.
- The battle continues until one side's HP drops to 0.
- A win or loss message will be displayed, and the game will close after 5 seconds.

---

## Features

- GUI-based Pokémon battle simulation
- 3 Pokémon with unique stats
- Turn-based combat system
- Randomized AI opponent and move selection
- Health and accuracy tracking
- Win/loss detection and display

---

## Dependencies

- Java AWT and Swing libraries (bundled with standard JDK)

---

## Configuration

No external configuration needed. All Pokémon stats and game logic are hardcoded into the `BattleSimulator.java` file.

---

## Troubleshooting

- **GUI doesn't open**: Ensure you're running the compiled class properly and using a Java version that supports Swing.
- **Buttons not responding**: Make sure you click **Confirm** after selecting a Pokémon to enable attacks.
- **Game closes immediately**: Likely due to either side reaching 0 HP; watch the health labels for progress.

---

## License

This project is for educational use only. No license specified.

