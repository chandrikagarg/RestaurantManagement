CREATE TABLE restaurant_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_name VARCHAR(255),
    location VARCHAR(255),
    maximum_capacity INT
);

INSERT INTO restaurant_details (restaurant_name, location, maximum_capacity)
VALUES ('test', 'sabji mandi', 4);
