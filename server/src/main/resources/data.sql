-- Insert Users
INSERT INTO users (email, password) VALUES ('user1@example.com', 'password1');
INSERT INTO users (email, password) VALUES ('user2@example.com', 'password2');
INSERT INTO users (email, password) VALUES ('user3@example.com', 'password3');

-- Insert Profiles
INSERT INTO profiles (user_id, profile_picture, created_at) VALUES (1, 'profile_pic1.jpg', '2025-02-18T00:00:00');
INSERT INTO profiles (user_id, profile_picture, created_at) VALUES (2, 'profile_pic2.jpg', '2025-02-18T00:00:00');
INSERT INTO profiles (user_id, profile_picture, created_at) VALUES (3, 'profile_pic3.jpg', '2025-02-18T00:00:00');

-- Insert Roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_MODERATOR');

-- Insert Posts
INSERT INTO posts (profile_id, banner_img, title, content, published, published_at) VALUES 
(1, 'banner1.jpg', 'Post Title 1', 'Post Content 1', true, '2025-02-18T00:00:00'),
(2, 'banner2.jpg', 'Post Title 2', 'Post Content 2', true, '2025-02-18T00:00:00'),
(3, 'banner3.jpg', 'Post Title 3', 'Post Content 3', true, '2025-02-18T00:00:00');

-- Insert Comments
INSERT INTO comments (profile_id, post_id, content, pushed_at) VALUES (1, 1, 'Comment Content 1', '2025-02-18T00:00:00');
INSERT INTO comments (profile_id, post_id, content, pushed_at) VALUES (2, 2, 'Comment Content 2', '2025-02-18T00:00:00');
INSERT INTO comments (profile_id, post_id, content, pushed_at) VALUES (3, 3, 'Comment Content 3', '2025-02-18T00:00:00');

-- Insert Reactions
INSERT INTO reactions (profile_id, post_id, created_at) VALUES (1, 1, '2025-02-18T00:00:00');
INSERT INTO reactions (profile_id, post_id, created_at) VALUES (2, 2, '2025-02-18T00:00:00');
INSERT INTO reactions (profile_id, post_id, created_at) VALUES (3, 3, '2025-02-18T00:00:00');

-- Insert Questions
INSERT INTO questions (profile_id, content, published_at) VALUES (1, 'Question Content 1', '2025-02-18T00:00:00');
INSERT INTO questions (profile_id, content, published_at) VALUES (2, 'Question Content 2', '2025-02-18T00:00:00');
INSERT INTO questions (profile_id, content, published_at) VALUES (3, 'Question Content 3', '2025-02-18T00:00:00');

-- Insert Answers
INSERT INTO answers (profile_id, question_id, content, published_at) VALUES (1, 1, 'Answer Content 1', '2025-02-18T00:00:00');
INSERT INTO answers (profile_id, question_id, content, published_at) VALUES (2, 2, 'Answer Content 2', '2025-02-18T00:00:00');
INSERT INTO answers (profile_id, question_id, content, published_at) VALUES (3, 3, 'Answer Content 3', '2025-02-18T00:00:00');

-- Insert Saved Posts
INSERT INTO saved_posts (profile_id, post_id, saved_at) VALUES (1, 1, '2025-02-18T00:00:00');
INSERT INTO saved_posts (profile_id, post_id, saved_at) VALUES (2, 2, '2025-02-18T00:00:00');
INSERT INTO saved_posts (profile_id, post_id, saved_at) VALUES (3, 3, '2025-02-18T00:00:00');

-- Insert Follows
INSERT INTO follows (user_src_id, user_trg_id) VALUES (1, 2);
INSERT INTO follows (user_src_id, user_trg_id) VALUES (2, 1);
INSERT INTO follows (user_src_id, user_trg_id) VALUES (1, 3);
INSERT INTO follows (user_src_id, user_trg_id) VALUES (3, 1);
INSERT INTO follows (user_src_id, user_trg_id) VALUES (2, 3);
INSERT INTO follows (user_src_id, user_trg_id) VALUES (3, 2);

-- Insert Notifications
INSERT INTO notifications (profile_id, type, reference_id, is_read, created_at) VALUES (1, 'REACTION', 1, false, '2025-02-18T00:00:00');
INSERT INTO notifications (profile_id, type, reference_id, is_read, created_at) VALUES (2, 'COMMENT', 2, false, '2025-02-18T00:00:00');
INSERT INTO notifications (profile_id, type, reference_id, is_read, created_at) VALUES (3, 'ANSWER', 3, false, '2025-02-18T00:00:00');