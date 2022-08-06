INSERT INTO category (description) VALUES ('American');
INSERT INTO category (description) VALUES ('Italian');
INSERT INTO category (description) VALUES ('Mexican');
INSERT INTO category (description) VALUES ('Fast Food');

INSERT INTO note (id, content) VALUES (1, 'content1');
INSERT INTO recipe (note_id, description, difficulty) VALUES (1, 'recipe1', 'EASY');
INSERT INTO recipe (description, difficulty) VALUES ('recipe2', 'MODERATE');
INSERT INTO recipe (description, difficulty) VALUES ('recipe3', 'EASY');
INSERT INTO recipe (description, difficulty) VALUES ('recipe4', 'KIND_OF_HARD');
