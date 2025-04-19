📸 Photo Management System  
*A clean, efficient Java backend for organizing and querying photos by tag, date, and location.*

- Upload and delete photos.
- Update photo details (name, tags, location).
- Search photos by:
  - Tag
  - Multiple tags
  - Date
  - Year
  - Date range
  - Location
  - Tag + Date
  - Tag + Location
  - Date + Location
  - Tag + Date + Location (combined)
- Check if a photo is taken at a specific location.
- Display and clear all photos.
- Get the count of stored photos.

---

## 🧠 Why Streams?

Initially, this project was implemented using multiple indexing maps and external loops. Although functional, the solution was less efficient and had high space complexity.

Refactoring with **Java Streams** provided:
- Cleaner and more concise code.
- Reduced boilerplate and conditional logic.
- One source of truth using just a `HashSet<Photo>`.

This approach uses **internal loops**, which are more declarative and easier to reason about.

---

## 📦 Project Structure

```bash
com.esraa.PhotoManagementSystem
│
├── Photo.java                  # Photo entity with fields: ID, name, location, tags, date
├── Location.java               # Location class (latitude, longitude or country/city)
├── PhotoManagerInterface.java  # Abstraction for the PhotoManager
└── PhotoManager.java           # Main logic class implementing the interface


---

## 🧪 Unit Testing

Comprehensive tests are included in `PhotoManagerTests.java` using **JUnit 5**.  
Test cases cover:

- Uploading photos
- Preventing duplicates
- Updating tags, name, and location
- Deleting photos
- Searching by:
  - Single tag
  - Multiple tags
  - Date / Date range
  - Year
  - Location
  - Combinations of tag, date, and location
- Checking if a photo was taken in a specific location
- Clearing the system
- Counting photos
- Displaying all photos

Tests validate both **positive and negative** scenarios to ensure reliability.

---

## ▶️ Running the Tests

Make sure you have Java and JUnit 5 set up.  
You can run the tests via your IDE or with Maven/Gradle:

```bash
# With Maven
mvn test

# With Gradle
./gradlew test

---

## 👩‍💻 Author

**Esraa** – Java Developer | Backend Enthusiast | Clean Code Advocate

I'm Esraa, a passionate developer with a strong love for backend systems, software architecture, and clean, maintainable code. I enjoy solving real-world problems with efficient, scalable Java solutions and have a deep interest in writing readable, testable, and well-structured code.

📌 Currently exploring:
- Java & Spring Boot
- System design & architecture patterns
- Stream APIs and functional programming in Java
- Unit testing with JUnit 5


🔗 Connect with me on:
- [LinkedIn](https://www.linkedin.com/in/esraa-refaat-kassem/)
- [GitHub](https://github.com/IsraaRefaat)
