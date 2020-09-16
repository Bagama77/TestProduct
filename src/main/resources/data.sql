DROP TABLE IF EXISTS product;

CREATE TABLE PRODUCT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price double NOT NULL,
  date DATE not null
);

INSERT INTO PRODUCT (name, price, date) VALUES
('Product 1 ', 12.34, '1997-06-10'),
('Product 2', 30.40, '1998-01-01'),
('Product 3', 0.56, '1999-01-01');
