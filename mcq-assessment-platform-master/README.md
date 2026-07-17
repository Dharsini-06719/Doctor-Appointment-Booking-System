# CyberLearn

CyberLearn is a Java Swing-based adaptive cybersecurity quiz application that adjusts question difficulty based on user performance. It provides an interactive learning experience with topic-based quizzes, persistent user profiles, and a MySQL-backed leaderboard.

## Features

- Adaptive quiz system with dynamic difficulty adjustment
- Topic-based cybersecurity quizzes
- User profile and high score tracking
- MySQL database integration using JDBC
- Skill level assessment (Beginner, Intermediate, Advanced)
- Clean Java Swing graphical interface
- Leaderboard displaying top scores

## Tech Stack

- Java
- Java Swing
- JDBC
- MySQL

## Project Structure

- `Main.java` – Application entry point and dashboard
- `QuizFrame.java` – Quiz user interface
- `HybridAdaptiveQuiz.java` – Adaptive quiz logic
- `DatabaseManager.java` – Database operations
- `Question.java` – Question model
- `TopicModule.java` – Topic management

## Database Setup

Create a MySQL database named `cyberlearn_db` and a `users` table:

```sql
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    highscore INT DEFAULT 0
);
```

Update the database credentials in `DatabaseManager.java` before running the application.

## Future Enhancements

- Timer-based quizzes
- Authentication with passwords
- Database-driven question management
- Performance analytics
- Randomized question selection
- Additional cybersecurity topics

## License

This project was developed for educational purposes.
