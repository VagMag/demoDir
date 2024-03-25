CREATE TABLE directory
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE directory_value
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    "key"        VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NOT NULL,
    directory_id BIGINT,
    FOREIGN KEY (directory_id) REFERENCES directory (id)
);
INSERT INTO directory (name) VALUES
                                 ('Dictionary 1'),
                                 ('Dictionary 2'),
                                 ('Dictionary 3');
-- Добавление значений в справочник 1
INSERT INTO directory_value ("key", name, directory_id) VALUES
                                                          ('key1', 'Value 1', 1),
                                                          ('key2', 'Value 2', 1),
                                                          ('key3', 'Value 3', 1);

-- Добавление значений в справочник 2
INSERT INTO directory_value ("key", name, directory_id) VALUES
                                                          ('key4', 'Value 4', 2),
                                                          ('key5', 'Value 5', 2),
                                                          ('key6', 'Value 6', 2);

-- Добавление значений в справочник 3
INSERT INTO directory_value ("key", name, directory_id) VALUES
                                                          ('key7', 'Value 7', 3),
                                                          ('key8', 'Value 8', 3),
                                                          ('key9', 'Value 9', 3);

