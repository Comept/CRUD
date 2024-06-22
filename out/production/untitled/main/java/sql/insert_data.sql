INSERT INTO users (username, password_hash, email) VALUES
    ('ali1','asasas','asas1@email.com'),
    ('ali2','asasas','asas2@email.com'),
    ('ali3','asasas','asas3@email.com'),
    ('ali4','asasas','asas4@email.com'),
    ('ali5','asasas','asas5@email.com');

INSERT INTO chats (chat_name, is_group) VALUES
    ('chat1', TRUE),
    ('chat2', FALSE);

INSERT INTO chatParticipants (chat_id, user_id, role) VALUES
    (1, 2, 'admin'),
    (1, 1, 'member'),
    (1, 3, 'member'),
    (1, 4, 'member');

INSERT INTO messages (chat_id, sender_id, message_text) VALUES
    (1,1, 'qweqeqwe'),
    (1,2, 'regregergerg'),
    (1,1, 'qweqeqwe'),
    (1,2, 'cxv'),
    (1,1, 'qweqeqwe'),
    (1,2, 'regregergerg');

INSERT INTO contacts (user_id, contact_id) VALUES
    (1, 2),
    (1, 3);