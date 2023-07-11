
create database ogani3;
use ogani3;

CREATE TABLE User (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255),
  role INT DEFAULT 0
);

CREATE TABLE Customer (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(50),
    username VARCHAR(255),
    FOREIGN KEY (username) REFERENCES User(username) ON DELETE SET NULL
);

CREATE TABLE Employee (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255),
    username VARCHAR(255),
    FOREIGN KEY (username) REFERENCES User(username) ON DELETE SET NULL
);

CREATE TABLE Category (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE Product (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    importPrice DOUBLE,
    exportPrice DOUBLE,
    discountPrice DOUBLE,
    weight DOUBLE,
    descriptions VARCHAR(1000),
    categoryId BIGINT,
    imageUrl VARCHAR(255),
    FOREIGN KEY (categoryId) REFERENCES Category(id)
);

CREATE TABLE ProductLot (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productId BIGINT,
    productionDate TIMESTAMP,
    expirationDate TIMESTAMP,
    quantity INT,
    FOREIGN KEY (productId) REFERENCES Product(id)
);

CREATE TABLE ProductImage (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(255),
    position INT,
    productId BIGINT,
    FOREIGN KEY (productId) REFERENCES Product(id)
);

CREATE TABLE Supplier (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(50)
);

CREATE TABLE Orders (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  productLotId BIGINT,
  price DOUBLE,
  quantity INT,
  username VARCHAR(255),
  orderDate TIMESTAMP,
  status INT DEFAULT 0,
  FOREIGN KEY (productLotId) REFERENCES ProductLot(id),
  FOREIGN KEY (username) REFERENCES User(username)
);

CREATE TABLE Purchase (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    purchaseDate TIMESTAMP,
    supplierId BIGINT,
    FOREIGN KEY (supplierId) REFERENCES Supplier(id)
);

CREATE TABLE PurchaseDetail (
    purchaseId BIGINT,
    productLotId BIGINT,
    quantity INT,
    PRIMARY KEY (purchaseId, productLotId),
    FOREIGN KEY (purchaseId) REFERENCES Purchase(id),
    FOREIGN KEY (productLotId) REFERENCES ProductLot(id)
);

CREATE TABLE Sale (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    saleDate TIMESTAMP,
    totalMoney DOUBLE,
    customerId BIGINT,
    paymentMethod INT,
    FOREIGN KEY (customerId) REFERENCES Customer(id)
);

CREATE TABLE SaleDetail (
    saleId BIGINT,
    productLotId BIGINT,
    quantity INT,
    paymentPrice DOUBLE,
    PRIMARY KEY (saleId, productLotId),
    FOREIGN KEY (saleId) REFERENCES Sale(id),
    FOREIGN KEY (productLotId) REFERENCES ProductLot(id)
);

