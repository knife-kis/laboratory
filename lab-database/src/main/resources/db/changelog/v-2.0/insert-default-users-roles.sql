INSERT INTO `users` (`last_name`, `password`)
    VALUE   ('admin', '$2a$10$uedJ6jkBS08x5mxZY6gV6.LAKSd202CiVutxz5VDq3TIyj9alkmIq'),
        ('guest', '$2a$10$uedJ6jkBS08x5mxZY6gV6.LAKSd202CiVutxz5VDq3TIyj9alkmIq');
GO

INSERT INTO `roles` (`name`)
VALUE ('ADMIN'), ('GUEST');
GO

INSERT INTO `users_roles`(`user_id`, `role_id`)
SELECT (SELECT id FROM `users` WHERE `last_name` = 'admin'), (SELECT id FROM `roles` WHERE `name` = 'ADMIN')
UNION ALL
SELECT (SELECT id FROM `users` WHERE `last_name` = 'guest'), (SELECT id FROM `roles` WHERE `name` = 'GUEST');
GO
