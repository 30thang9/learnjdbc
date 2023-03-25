CREATE DATABASE ogani;
USE ogani;
CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    roleName VARCHAR(50) NOT NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    customerName VARCHAR(255) NULL,
    phone VARCHAR(50) NULL,
    address VARCHAR(1000) NULL,
    roleId BIGINT NOT NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (roleId) REFERENCES roles(id)
);

CREATE TABLE categories (
    id BIGINT NOT NULL AUTO_INCREMENT,
    categoryName VARCHAR(255) NOT NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE suppliers (
    id BIGINT NOT NULL AUTO_INCREMENT,
    supplierName VARCHAR(255) NOT NULL,
    address VARCHAR(1000) NULL,
    phone VARCHAR(50) NULL,
    email VARCHAR(255) NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE products (
    id BIGINT NOT NULL AUTO_INCREMENT,
    productName VARCHAR(255) NULL,
    price DECIMAL(10,2) NULL,
    discountPrice DECIMAL(10,2) DEFAULT NULL,
    discountQuantity INT NULL,
    discountStatus BIT DEFAULT 0,
    hotStatus BIT DEFAULT 0,
    sellingStatus BIT DEFAULT 0,
    descriptions VARCHAR(1000) NULL,
    weight FLOAT NULL,
    categoryId BIGINT NOT NULL,
    supplierId BIGINT NOT NULL,
    quantityInstock BIGINT NULL,
    productStatus BIT DEFAULT 0,
    imageUrl VARCHAR(255) NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (categoryId) REFERENCES categories(id),
    FOREIGN KEY (supplierId) REFERENCES suppliers(id)
);

CREATE TABLE productImages (
    id BIGINT NOT NULL AUTO_INCREMENT,
    imageUrl VARCHAR(255) NOT NULL,
    productId BIGINT NOT NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (productId) REFERENCES products(id)
);

CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    customerId BIGINT NOT NULL,
    orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL,
    shippingAddress VARCHAR(1000) NOT NULL,
    shippingFee DECIMAL(10,2) NOT NULL,
    totalAmount DECIMAL(10,2) NOT NULL,
    paymentMethod VARCHAR(50) NOT NULL,
    paymentStatus VARCHAR(20) NOT NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (customerId) REFERENCES customers(id)
);

CREATE TABLE orderDetails (
    orderId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    priceSell DECIMAL(10,2) NULL,
    quantity INT NULL,
    createBy VARCHAR(50) NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateBy VARCHAR(50) NULL,
    updateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (orderId,productId),
    FOREIGN KEY (orderId) REFERENCES orders(id),
    FOREIGN KEY (productId) REFERENCES products(id)
);