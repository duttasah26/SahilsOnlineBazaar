CREATE TABLE Product
(
    ID    LONG PRIMARY KEY,
    NAME  VARCHAR(255),
    PRICE LONG
);

CREATE TABLE SHOPPINGCART
(
    UID BIGINT PRIMARY KEY AUTO_INCREMENT ,
    ID    LONG,
    NAME  VARCHAR(255),
    PRICE LONG
);