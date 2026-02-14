# FactoryRobotHazardAnalyzer
## Application Overview
The **Factory Robot Hazard Analyzer** is a console-based Java application that evaluates the **hazard risk score** of a factory robot based on:
- **Arm Precision**
- **Worker Density**
- **Machinery State**

The application validates inputs, calculates risk, and handles invalid scenarios using **custom exceptions**, demonstrating **Core Java**, **OOP**, and **Exception Handling** concepts.

---

## Tech Stack
- **Language:** Java
- **Type:** Console Application
- **Concepts:** OOP, Validation, Exception Handling, Modular Design
- **Process:** UC-wise development + GitFlow (feature branch per UC)

---

## Project Structure (Packages)
This project uses simple top-level packages:
- `app` — Console entry point and user interaction
- `domain` — Domain models and enums
- `service` — Validation and hazard calculation logic
- `exception` — Custom exception(s) for invalid scenarios
- `util` — Console input helpers

---

## Use Case Implementation Summary (UC1–UC8)

### UC1: Display Static Hazard Message
**Goal:** Display a static message indicating the purpose of the system.  
**What was implemented:**
- Created the class `FactoryRobotHazardAnalyzer`
- Printed **"Factory Robot Hazard Analyzer"** to the console
- Program exits after displaying the message

Key Concepts:
- `main()` method
- Print statements
- Program entry basics

---

### UC2: Accept Robot Hazard Inputs
**Goal:** Accept inputs required for hazard analysis from the user.  
**Inputs:**
- Arm Precision
- Worker Density
- Machinery State

What was implemented:
- Read all 3 inputs using `Scanner`
- Echoed back the user inputs
- No validation done in this UC

Key Concepts:
- `Scanner`
- Primitive + string input handling
- Console interaction

---

### UC3: Calculate Hazard Risk Score (No Validation)
**Goal:** Calculate and display the hazard risk score using the formula (assuming inputs valid).  
What was implemented:
- Implemented hazard risk computation
- Printed hazard risk score after taking inputs
- No validation checks

Key Concepts:
- Arithmetic expressions
- Basic business logic
- Method return values (conceptually)

---

### UC4: Introduce Validation Using Conditional Logic
**Goal:** Validate input ranges using `if-else`.  
What was implemented:
- Validated each input range
- If invalid, printed an error message
- If valid, proceeded to calculate risk

Key Concepts:
- Conditional statements
- Defensive programming
- Input validation

Drawback Noted:
- Validation cluttered `main()`
- No standard error handling

---

### UC5: Refactor Validation into a Separate Method
**Goal:** Move hazard calculation and validation into a separate method.  
What was implemented:
- `main()` calls `calculateHazardRisk(...)`
- Method validates inputs
- Method returns hazard score
- Cleaner, minimal `main()`

Key Concepts:
- Method abstraction
- Parameter passing
- Separation of concerns

---

### UC6: Introduce Custom Exception – RobotSafetyException
**Goal:** Handle invalid scenarios using a custom exception.  
What was implemented:
- Created `RobotSafetyException extends Exception`
- Validation throws `RobotSafetyException` when invalid
- `main()` catches exception and prints the message

Key Concepts:
- Custom exceptions
- `throw` / `throws`
- `try-catch`

Requirement Followed:
- Exception message displayed clearly

---

### UC7: Machinery State Risk Mapping
**Goal:** Map machinery state into risk factor using structured logic.  
Supported machinery states:
- **Worn**
- **Faulty**
- **Critical**

What was implemented:
- Mapped machinery state to a numeric risk factor
- Used risk factor inside hazard calculation
- Threw exception for unsupported machinery state

Key Concepts:
- Business rule encapsulation
- String comparison / structured mapping
- Controlled exception flow

---

### UC8: Fully Modular & OOPS-Compliant Hazard Analyzer
**Goal:** Deliver a clean, modular, extensible hazard analysis system.  
What was implemented:
- Inputs collected in `main()`
- Business logic handled in `RobotHazardAuditor` (or service layer)
- Validation via exception-based flow
- Clean output display
- Modular architecture using packages and SRP

Key Concepts:
- Encapsulation
- Modularity
- Single Responsibility Principle
- Reusability and maintainability

---

## OOP Principles Demonstrated
- **Encapsulation:** Scenario and processing logic stored inside classes
- **Abstraction:** User interacts via methods, not internal logic
- **Single Responsibility:** Each class has a single clear job
- **Extensibility:** Machinery mapping and logic can be extended easily

---

## GitFlow Development Process
This project was implemented UC-wise using GitFlow:
- One feature branch per UC
- UC branch merged into `develop`
- Feature branches kept using:
  - `git flow feature finish -k <feature-name>`
- Meaningful commits with consistent message format:
  - `[Devraj]: UCx - ...`

---

## How to Run
1. Open project in IntelliJ / Eclipse / VS Code
2. Run:
   - `app.FactoryRobotHazardAnalyzerApp`
3. Follow console prompts and view hazard risk output

---

## Notes
- Input validation ensures safety and avoids invalid scoring.
- Custom exception handling demonstrates structured error handling.
- Modular structure follows OOP and clean-code practices.

