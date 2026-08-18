INSERT INTO tasks(name, user_id) VALUES
('Learn Java Basics', 1),
('Build a REST API', 1);

INSERT INTO steps(title, description, is_completed, task_id) VALUES
('Understand OOP', 'Classes, objects, inheritance and polymorphism', TRUE, 1),
('Practice collections', 'List, Set, Map usage', TRUE, 1),
('Master streams', 'filter, map, collect pipelines', TRUE, 1),
('Scaffold the project', 'Create the Spring Boot project', TRUE, 2),
('Write controllers', 'Expose the REST endpoints', FALSE, 2),
('Plug the database', 'Connect JDBC to PostgreSQL', FALSE, 2);
