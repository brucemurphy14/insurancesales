drop table auto_rating;
drop table home_rating;
DROP TABLE Auto_Policy;
DROP TABLE Home_Policy;
DROP TABLE Car;
DROP TABLE Home;
DROP TABLE ACCIDENT_LISTING;
drop table policy_holder;
DROP TABLE client;
DROP TABLE users;
DROP TABLE ADDRESS;
DROP TABLE policy;

CREATE TABLE ADDRESS (
                         address_id INT NOT NULL AUTO_INCREMENT,
                         street_address VARCHAR(32),
                         province VARCHAR(32),
                         city VARCHAR(20),
                         zip_code VARCHAR(6),
                         location_type varchar(20) CHECK (location_type = 'Dense Urban' OR location_type = 'Urban' OR location_type = 'Rural'),
                         PRIMARY KEY (address_id)
);

CREATE TABLE users (
                       username VARCHAR(45) NOT NULL,
                       password VARCHAR(64) NOT NULL,
                       role VARCHAR(45) NOT NULL,
                       enabled TINYINT(4) DEFAULT NULL,
                       PRIMARY KEY (`username`)
);

CREATE TABLE Home (
                      HOME_ID INT NOT NULL AUTO_INCREMENT,
                      policy_number INT,
                      age_since_built FLOAT(2),
                      type_of_dwelling VARCHAR(20),
                      heating_type VARCHAR(17),
                      PRIMARY KEY (`HOME_ID`)
);


CREATE TABLE Car (
                     VIN_NUMBER INT NOT NULL AUTO_INCREMENT,
                     policy_number INT,
                     vehicle_worth float,
                     vehicle_make VARCHAR(32),
                     vehicle_model VARCHAR(32),
                     vehicle_year INT,
                     PRIMARY KEY (`VIN_number`)
);

create table auto_rating(
                            auto_rating_id INT NOT NULL,
                            driver_age_25_or_under_rate float,
                            driver_age_other_rate float,
                            location_rate_dense_urban FLOAT,
                            location_rate_urban float,
                            location_rate_rural float,
                            driver_0_accident_last_5_years_rate float,
                            driver_1_accidents_last_5_years_rate float,
                            driver_2_accidents_last_5_years_rate float,
                            car_11_years_or_older_rate FLOAT,
                            car_older_than_5_years_rate FLOAT,
                            car_other_age_rate FLOAT,
                            base_premium_rate FLOAT,
                            PRIMARY KEY (auto_rating_id)
);

create table home_rating(
                            home_rating_id int NOT NULL,
                            dwelling_type_single_dwelling_rate float,
                            dwelling_type_apartment_rate float,
                            dwelling_type_bungalow_rate float,
                            dwelling_type_single_attached_rate float,
                            home_age_under_25_rate FLOAT,
                            home_age_25_or_over_rate FLOAT,
                            home_age_50_or_over_rate FLOAT,
                            heating_type_electric_rate FLOAT,
                            heating_type_oil_rate FLOAT,
                            heating_type_wood_rate float,
                            heating_type_gas_rate float,
                            heating_type_other_rate float,
                            base_premium_rate FLOAT,
                            tax_rate FLOAT,
                            primary key (home_rating_id)
);

CREATE TABLE POLICY (
                        policy_number INT NOT NULL AUTO_INCREMENT,
                        client_id INT NOT NULL,
                        policy_type VARCHAR(32),
                        term_price float,
                        primary key (policy_number)
);

CREATE TABLE Home_Policy (
                             policy_number INT NOT NULL,
                             client_id INT NOT NULL,
                             home_id INT NOT NULL,
                             PRIMARY KEY (client_id , home_id),
                             FOREIGN KEY (home_id)
                                 REFERENCES Home (home_id),
                             FOREIGN KEY (client_id)
                                 REFERENCES POLICY (POLICY_NUMBER)
);

CREATE TABLE Auto_Policy (
                             policy_number INT NOT NULL,
                             client_id INT NOT NULL,
                             VIN_NUMBER INT NOT NULL,
                             PRIMARY KEY (client_id , policy_number),
                             FOREIGN KEY (VIN_NUMBER)
                                 REFERENCES Car (VIN_NUMBER),
                             FOREIGN KEY (client_id)
                                 REFERENCES POLICY (policy_number)
);

CREATE TABLE client (
                        client_id INT NOT NULL AUTO_INCREMENT,
                        main_insured_first_name VARCHAR(32),
                        main_insured_last_name VARCHAR(32),
                        home_policy_number INT,
                        auto_policy_number INT,
                        address_id INT,
                        username VARCHAR(45) NOT NULL,
                        client_birthday date,
                        PRIMARY KEY (`client_id`),
                        FOREIGN KEY (username) REFERENCES users (username),
                        FOREIGN KEY (address_id) REFERENCES ADDRESS (address_id)
);

create table policy_holder(
                              policy_holder_id int NOT NULL auto_increment,
                              policy_number int ,
                              client_id int ,
                              foreign key (policy_number) references policy (policy_number),
                              foreign key (client_id) references client (client_id),
                              primary key (policy_holder_id, policy_number, client_id)
);

CREATE TABLE accident_listing (
                                  accident_id INT NOT NULL AUTO_INCREMENT,
                                  client_id INT NOT NULL,
                                  accident_date DATE,
                                  at_fault BOOL,
                                  PRIMARY KEY (accident_id),
                                  FOREIGN KEY (client_id)
                                      REFERENCES Client (client_id)
);