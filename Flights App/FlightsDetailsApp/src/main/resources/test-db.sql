
CREATE TABLE seat_matrix (
	id INT NOT NULL,
	first_class VARCHAR(45),
	business VARCHAR (45),
	economy VARCHAR (45),
	PRIMARY KEY (id)
);

CREATE TABLE flight (
   flight_id INT  NOT NULL,
   flight_model VARCHAR (45),
   source VARCHAR (45),
   destination VARCHAR (45), 
   departure TIMESTAMP, 
   arrival TIMESTAMP, 
   hops INT,
   seats INT,
   PRIMARY KEY (flight_id),
   FOREIGN KEY (seats) REFERENCES seat_matrix(id)
); 

INSERT INTO flight VALUES(1, 'ING123', 'Bangalore', 'Delhi', '2020-06-01 09:00:00', '2020-06-01 11:45:00', 1, 101);

INSERT INTO seat_matrix VALUES (101, 40, 20, 10);