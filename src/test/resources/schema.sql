-- Create Station Table
CREATE TABLE station (
                         stationID INT AUTO_INCREMENT PRIMARY KEY,
                         latitude DOUBLE NOT NULL,
                         longitude DOUBLE NOT NULL
);

-- Create Pizza Table
CREATE TABLE pizza (
                       pizzaID INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       price INT NOT NULL
);

-- Create Drone Table
CREATE TABLE drone (
                       droneID INT AUTO_INCREMENT PRIMARY KEY,
                       serialuuid INT NOT NULL,
                       status VARCHAR(50) NOT NULL,
                       stationidfk INT,
                       FOREIGN KEY (stationidfk) REFERENCES station(stationID)
);

-- Create Delivery Table
CREATE TABLE delivery (
                          deliveryID INT AUTO_INCREMENT PRIMARY KEY,
                          adress VARCHAR(255) NOT NULL,
                          expectedDeliveryTime TIMESTAMP NOT NULL,
                          actualDeliveryTime TIMESTAMP NULL,
                          pizzaidfk INT,
                          doneidfk INT,
                          FOREIGN KEY (pizzaidfk) REFERENCES pizza(pizzaID),
                          FOREIGN KEY (doneidfk) REFERENCES drone(droneID)
);
