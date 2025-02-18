-- Insert Users
INSERT INTO users (id, email, password) VALUES (1, 'user1@example.com', 'password1');
INSERT INTO users (id, email, password) VALUES (2, 'user2@example.com', 'password2');
INSERT INTO users (id, email, password) VALUES (3, 'user3@example.com', 'password3');

-- Insert Profiles
INSERT INTO profiles (id, user_id, profile_picture, created_at) VALUES (1, 1, 'profile_pic1.jpg', '2025-02-18T00:00:00');
INSERT INTO profiles (id, user_id, profile_picture, created_at) VALUES (2, 2, 'profile_pic2.jpg', '2025-02-18T00:00:00');
INSERT INTO profiles (id, user_id, profile_picture, created_at) VALUES (3, 3, 'profile_pic3.jpg', '2025-02-18T00:00:00');

-- Insert Roles
INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_MODERATOR');

-- Insert Posts
INSERT INTO posts (id, profile_id, banner_img, title, text, published, published_at) VALUES (1, 1, 'banner1.jpg', 'Post Title 1', 'Post Text 1', true, '2025-02-18T00:00:00');
INSERT INTO posts (id, profile_id, banner_img, title, text, published, published_at) VALUES (2, 2, 'banner2.jpg', 'Post Title 2', 'Post Text 2', true, '2025-02-18T00:00:00');
INSERT INTO posts (id, profile_id, banner_img, title, text, published, published_at) VALUES (3, 3, 'banner3.jpg', 'Post Title 3', 'Post Text 3', true, '2025-02-18T00:00:00');

-- Insert Comments
INSERT INTO comments (id, profile_id, post_id, text, pushed_at) VALUES (1, 1, 1, 'Comment Text 1', '2025-02-18T00:00:00');
INSERT INTO comments (id, profile_id, post_id, text, pushed_at) VALUES (2, 2, 2, 'Comment Text 2', '2025-02-18T00:00:00');
INSERT INTO comments (id, profile_id, post_id, text, pushed_at) VALUES (3, 3, 3, 'Comment Text 3', '2025-02-18T00:00:00');

-- Insert Reactions
INSERT INTO reactions (id, profile_id, post_id, created_at) VALUES (1, 1, 1, '2025-02-18T00:00:00');
INSERT INTO reactions (id, profile_id, post_id, created_at) VALUES (2, 2, 2, '2025-02-18T00:00:00');
INSERT INTO reactions (id, profile_id, post_id, created_at) VALUES (3, 3, 3, '2025-02-18T00:00:00');

-- Insert Questions
INSERT INTO questions (id, profile_id, text, published_at) VALUES (1, 1, 'Question Title 1', '2025-02-18T00:00:00');
INSERT INTO questions (id, profile_id, text, published_at) VALUES (2, 2, 'Question Title 2', '2025-02-18T00:00:00');
INSERT INTO questions (id, profile_id, text, published_at) VALUES (3, 3, 'Question Title 3', '2025-02-18T00:00:00');

-- Insert Answers
INSERT INTO answers (id, profile_id, question_id, text, published_at) VALUES (1, 1, 1, 'Answer Text 1', '2025-02-18T00:00:00');
INSERT INTO answers (id, profile_id, question_id, text, published_at) VALUES (2, 2, 2, 'Answer Text 2', '2025-02-18T00:00:00');
INSERT INTO answers (id, profile_id, question_id, text, published_at) VALUES (3, 3, 3, 'Answer Text 3', '2025-02-18T00:00:00');

-- Insert Saved Posts
INSERT INTO saved_posts (id, profile_id, post_id, saved_at) VALUES (1, 1, 1, '2025-02-18T00:00:00');
INSERT INTO saved_posts (id, profile_id, post_id, saved_at) VALUES (2, 2, 2, '2025-02-18T00:00:00');
INSERT INTO saved_posts (id, profile_id, post_id, saved_at) VALUES (3, 3, 3, '2025-02-18T00:00:00');

-- Insert Follows
INSERT INTO follows (id, user_src_id, user_trg_id) VALUES (1, 1, 2);
INSERT INTO follows (id, user_src_id, user_trg_id) VALUES (2, 2, 1);
INSERT INTO follows (id, user_src_id, user_trg_id) VALUES (3, 1, 3);
INSERT INTO follows (id, user_src_id, user_trg_id) VALUES (4, 3, 1);
INSERT INTO follows (id, user_src_id, user_trg_id) VALUES (5, 2, 3);
INSERT INTO follows (id, user_src_id, user_trg_id) VALUES (6, 3, 2);

-- Insert Notifications
INSERT INTO notifications (id, profile_id, type, reference_id, is_read, created_at) VALUES (1, 1, 'REACTION', 1, false, '2025-02-18T00:00:00');
INSERT INTO notifications (id, profile_id, type, reference_id, is_read, created_at) VALUES (2, 2, 'COMMENT', 2, false, '2025-02-18T00:00:00');
INSERT INTO notifications (id, profile_id, type, reference_id, is_read, created_at) VALUES (3, 3, 'ANSWER', 3, false, '2025-02-18T00:00:00');