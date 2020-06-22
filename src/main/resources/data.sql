DROP TABLE IF EXISTS filter_collection;

CREATE TABLE filter_collection (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              title VARCHAR(250) NOT NULL,
                              filters VARCHAR(250) NOT NULL
);

INSERT INTO filter_collection (id, title, filters) VALUES
(1, 'Filter 1', '[{"type":"1","comparator":"1","value":"1"}]'),
(2, 'Filter 2', '[{"type":"1","comparator":"1","value":"1"}]'),
(3, 'Filter 3', '[{"type":"1","comparator":"1","value":"1"}]');
