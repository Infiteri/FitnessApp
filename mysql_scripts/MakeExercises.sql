-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create exercises table
CREATE TABLE IF NOT EXISTS exercises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    muscles VARCHAR(255) NOT NULL
);

-- Create workouts table (linked to user, no direct exercise_id)
CREATE TABLE IF NOT EXISTS workouts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    workout_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Create workout_exercises table (junction with intensity + description)
CREATE TABLE IF NOT EXISTS workout_exercises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    workout_id INT NOT NULL,
    exercise_id INT NOT NULL,
    intensity TINYINT NOT NULL,
    description TEXT,
    FOREIGN KEY (workout_id) REFERENCES workouts(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (exercise_id) REFERENCES exercises(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT IGNORE INTO exercises (name, muscles)
VALUES
("PUSH-UP", "CHEST TRICEPS SHOULDERS"),
("PULL-UP", "BACK BICEPS"),
("DIP", "CHEST TRICEPS SHOULDERS");
