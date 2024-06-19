DROP TABLE IF EXISTS ChatParticipants;
DROP TABLE IF EXISTS Contacts;
DROP TABLE IF EXISTS Files;
DROP TABLE IF EXISTS Messages;
DROP TABLE IF EXISTS Chats;
DROP TABLE IF EXISTS Users;

-- Таблица пользователей
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица чатов
CREATE TABLE Chats (
    chat_id SERIAL PRIMARY KEY,
    chat_name VARCHAR(100),
    is_group BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица участников чатов
CREATE TABLE ChatParticipants (
    chat_id INT REFERENCES Chats(chat_id) ON DELETE CASCADE,
    user_id INT REFERENCES Users(user_id) ON DELETE CASCADE,
    role VARCHAR(20) DEFAULT 'member',
    joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (chat_id, user_id)
);

-- Таблица сообщений
CREATE TABLE Messages (
    message_id SERIAL PRIMARY KEY,
    chat_id INT REFERENCES Chats(chat_id) ON DELETE CASCADE,
    sender_id INT REFERENCES Users(user_id) ON DELETE CASCADE,
    message_text TEXT,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица контактов
CREATE TABLE Contacts (
    user_id INT REFERENCES Users(user_id) ON DELETE CASCADE,
    contact_id INT REFERENCES Users(user_id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, contact_id)
);

-- Таблица файлов
CREATE TABLE Files (
    file_id SERIAL PRIMARY KEY,
    message_id INT REFERENCES Messages(message_id) ON DELETE CASCADE,
    file_path VARCHAR(255) NOT NULL,
    file_type VARCHAR(50),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);