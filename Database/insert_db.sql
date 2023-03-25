
INSERT INTO roles (roleName, createBy, updateBy)
VALUES ('admin', 'system', 'system'),
       ('customer', 'system', 'system');

INSERT INTO customers (email, password, customerName, phone, address, roleId, createBy, updateBy)
VALUES ('customer1@example.com', 'password1', 'Customer One', '123-456-7890', '123 Main St, Anytown USA', 2, 'system', 'system'),
       ('customer2@example.com', 'password2', 'Customer Two', '456-789-0123', '456 Maple Ave, Anytown USA', 2, 'system', 'system');

INSERT INTO categories (categoryName, createBy, updateBy)
VALUES ('Category 1', 'system', 'system'),
       ('Category 2', 'system', 'system');

INSERT INTO suppliers (supplierName, address, phone, email, createBy, updateBy)
VALUES ('Supplier 1', '789 Oak St, Anytown USA', '555-123-4567', 'supplier1@example.com', 'system', 'system'),
       ('Supplier 2', '456 Pine Ave, Anytown USA', '555-987-6543', 'supplier2@example.com', 'system', 'system');

INSERT INTO products (productName, price, discountPrice, discountQuantity, discountStatus, hotStatus, sellingStatus, descriptions, weight, categoryId, supplierId, quantityInstock, productStatus, imageUrl, createBy, updateBy)
VALUES ('TV', 499.99, NULL, NULL, 0, 1, 1, '55-inch Smart TV', 50.0, 1, 1, 100, 1, 'https://example.com/tv.jpg', 'system', 'system'),
       ('Smartphone', 699.99, NULL, NULL, 0, 0, 1, '128GB, 5G', 0.3, 1, 1, 50, 1, 'https://example.com/smartphone.jpg', 'system', 'system'),
       ('Laptop', 899.99, 799.99, 5, 1, 1, 1, '16GB RAM, 512GB SSD', 3.0, 1, 1, 25, 1, 'https://example.com/laptop.jpg', 'system', 'system'),
       ('T-Shirt', 19.99, NULL, NULL, 0, 0, 1, '100% cotton, blue', 0.2, 2, 1, 200, 1, 'https://example.com/tshirt.jpg', 'system', 'system'),
       ('Jeans', 59.99, NULL, NULL, 0, 0, 1, 'Slim fit, black', 0.8, 2, 1, 100, 1, 'https://example.com/jeans.jpg', 'system', 'system');

INSERT INTO productImages (imageUrl, productId, createBy, updateBy)
VALUES ('http://example.com/image1.jpg', 1, 'system', 'system'),
       ('http://example.com/image2.jpg', 2, 'system', 'system');

INSERT INTO orders (customerId, status, shippingAddress, shippingFee, totalAmount, paymentMethod, paymentStatus, createBy, updateBy)
VALUES (1, 'processing', '123 Main St, Anytown, USA', 5.00, 25.00, 'credit card', 'pending', 'John Doe', 'John Doe');

INSERT INTO orderDetails (orderId, productId, priceSell, quantity, createBy, updateBy)
VALUES (1, 1, 10.00, 2, 'John Doe', 'John Doe'),
       (1, 2, 2.50, 3, 'John Doe', 'John Doe');
