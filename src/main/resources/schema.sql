CREATE TABLE Client (
                        client_id int NOT NULL AUTO_INCREMENT,
                        main_insured_name VARCHAR(32),
                        home_policy_number int ,
                        auto_policy_number int,
                        address varchar(32),
                        PRIMARY KEY (`client_id`)
);

CREATE TABLE Home_Policy (
                             policy_number int NOT NULL AUTO_INCREMENT,
                             client_id int NOT NULL,
                             main_insured_name VARCHAR(32),
                             other_insured_names VARCHAR(150),
                             start_date DATE,
                             end_date DATE,
                             base_premium float(2),
                             tax float(2),
                             total_premium float(2),
                             replacement_cost_value float(2),
                             injury_liability_limit float(2),
                             injury_deductible float(2),
                             contents_liability_limit float(2),
                             contents_deductible float(2),
                             PRIMARY KEY (`policy_number`),
                             FOREIGN KEY (`client_id`)
                                 REFERENCES Client (`client_id`)
);

CREATE TABLE Auto_Policy (
                             policy_number int NOT NULL AUTO_INCREMENT,
                             client_id int NOT NULL,
                             main_insured_name VARCHAR(32),
                             start_date DATE,
                             end_date DATE,
                             base_premium float(2),
                             tax float(2),
                             total_premium float(2),
                             driver_age float(2),
                             number_of_accidents_last_5_years int,
                             address varchar(32),
                             PRIMARY KEY (`policy_number`),
                             FOREIGN KEY (`client_id`)
                                 REFERENCES Client (`client_id`)
);


CREATE TABLE Home (
                      policy_number int NOT NULL AUTO_INCREMENT,
                      age_since_built float(2),
                      type_of_dwelling varchar(20),
                      heating_type varchar(17),
                      primary key (`policy_number`),
                      foreign key (`policy_number`)
                          REFERENCES Home_Policy (`policy_number`)
);


CREATE TABLE Car (
                     policy_number int NOT NULL AUTO_INCREMENT,
                     vehicle_make varchar(32),
                     vehicle_model varchar(32),
                     vehicle_year int,
                     PRIMARY KEY (`policy_number`),
                     foreign key (`policy_number`)
                         REFERENCES Auto_Policy (`policy_number`)
);