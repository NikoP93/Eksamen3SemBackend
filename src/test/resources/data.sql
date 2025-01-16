-- Insert Stations
INSERT INTO station (stationID, latitude, longitude) VALUES (1, 55.41, 12.34);
INSERT INTO station (stationID, latitude, longitude) VALUES (2, 55.67, 12.56);
INSERT INTO station (stationID, latitude, longitude) VALUES (3, 55.64, 12.61);

-- Insert Pizzas
INSERT INTO pizza (pizzaID, title, price) VALUES (1, 'Margherita', 90);
INSERT INTO pizza (pizzaID, title, price) VALUES (2, 'Pepperoni', 100);
INSERT INTO pizza (pizzaID, title, price) VALUES (3, 'Hawaiian', 105);
INSERT INTO pizza (pizzaID, title, price) VALUES (4, 'Vegetarian', 95);
INSERT INTO pizza (pizzaID, title, price) VALUES (5, 'Four Cheese', 110);

-- Insert Drones
INSERT INTO drone (droneID, serialuuid, status, stationidfk) VALUES (1, 1234, 'Operating', 1);
INSERT INTO drone (droneID, serialuuid, status, stationidfk) VALUES (2, 5678, 'Operating', 2);
INSERT INTO drone (droneID, serialuuid, status, stationidfk) VALUES (3, 9999, 'OutOfOperation', 1);

-- Insert Deliveries
INSERT INTO delivery (deliveryID, adress, expectedDeliveryTime, pizzaidfk, droneidfk)
VALUES (1, 'Jensgade 1', CURRENT_TIMESTAMP + INTERVAL '30' MINUTE, 1, NULL);

INSERT INTO delivery (deliveryID, adress, expectedDeliveryTime, pizzaidfk, droneidfk)
VALUES (2, 'Kurtgade 3', CURRENT_TIMESTAMP + INTERVAL '30' MINUTE, 2, 1);

INSERT INTO delivery (deliveryID, adress, expectedDeliveryTime, pizzaidfk, droneidfk)
VALUES (3, 'Kurtgade 3', CURRENT_TIMESTAMP + INTERVAL '30' MINUTE, 2, 1);
