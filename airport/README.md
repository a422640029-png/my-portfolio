# ✈️ Gaza International Airport Management System

A robust, Object-Oriented Java application designed to manage airport operations, flight scheduling, passenger validation, employee management, and automated file-based data ingestion.

---

## 📌 Features & Core Architecture

### 1. Object-Oriented Design (OOP)
* **Inheritance & Hierarchy:** Built on a base `person` class, extended by `employy` (for staff) and `travilar` (for passengers). Staff members are further specialized into `Pilot` and `flightAtendant`.
* **Polymorphism & Encapsulation:** Overridden `displayInfo()` methods across all entities to output detailed profile data securely and cleanly.

### 2. Custom Exception Handling & Pre-Flight Validations
The system enforces strict real-time business logic before allowing flight departure (`lunchLight()`):
* **`ExpiredPassportExption`:** Validates passenger passport expiration years.
* **`OverSeatsExcption`:** Prevents booking beyond the maximum allocated flight capacity.
* **`NoPIlot`:** Blocks flight takeoff if no pilot has been assigned.
* **`MinimumAttendantsExcption`:** Ensures the mandatory cabin crew requirement (2 flight attendants) is met.
* **`NoPASSENGER`:** Ensures a flight cannot depart empty without registered passengers.

### 3. File I/O & Batch Data Processing
* **Automated Data Loading:** The `ReadData()` method reads passenger manifests directly from text files (`passenger.txt`), parses structured data (`|` delimiter), validates seating limits dynamically, and registers valid travelers into the airport system in batches.

### 4. Interactive Console CLI & Reporting
* **CLI Menu (`main.java`):** An interactive 9-option menu for flight creation, passenger registration, staff assignment, takeoff simulation, and system reporting.
* **Daily Report Generation:** `GazaAirPort.genarateDailyReport()` compiles and formats all system state details (registered persons, active flights, flight crew, and passenger manifests) into structured ASCII tables.

---

## 🏗️ Class Structure

| Class / Enum | Description |
| :--- | :--- |
| **`person`** | Base class containing shared traits: Name, ID, Nationality. |
| **`employy`** | Extends `person`; adds salary, bonuses, and unique employee IDs. |
| **`Pilot`** | Extends `employy`; stores flight hours, licenses, and certifications. |
| **`flightAtendant`** | Extends `employy`; tracks spoken languages and completed trip counts. |
| **`travilar`** | Extends `person`; handles passport ID, expiration date, and flight destination. |
| **`airFlight`** | Core engine managing flight state, seat caps, pilot/attendant assignments, and file ingestion. |
| **`GazaAirPort`** | Central repository storing all people and

