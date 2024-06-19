CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    class_name VARCHAR(50) NOT NULL,
    major VARCHAR(50) NOT NULL,
    hometown VARCHAR(50) NOT NULL,
    gender ENUM('Nam', 'Nữ', 'Khác') NOT NULL,
    average_mark DECIMAL(4,2) NOT NULL CHECK (average_mark >= 0 AND average_mark <= 10)
);
