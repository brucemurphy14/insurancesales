
DROP TABLE AUTO_POLICY;
DROP TABLE HOME_POLICY;
DROP TABLE POLICY;
DROP TABLE POLICY_FACTORY;
DROP TABLE AUTO_POLICY_RATE;
DROP TABLE HOME_POLICY_RATE;
DROP TABLE Car;
DROP TABLE HOME;
DROP TABLE ACCIDENT_LISTING;
DROP TABLE CLIENT;
DROP TABLE USERS;
DROP TABLE ADDRESS;

CREATE table ADDRESS (
                         address_id INT NOT NULL AUTO_INCREMENT,
                         street_address VARCHAR(32),
                         province VARCHAR(20),
                         city VARCHAR(20),
                         zip_code VARCHAR(6),
                         primary key (address_id)
);

CREATE TABLE users (
                       `user_id` int(11) NOT NULL AUTO_INCREMENT,
                       `username` varchar(45) NOT NULL,
                       `password` varchar(64) NOT NULL,
                       `role` varchar(45) NOT NULL,
                       `enabled` tinyint(4) DEFAULT NULL,
                       PRIMARY KEY (`user_id`)
);

CREATE TABLE Client (
                        client_id int NOT NULL AUTO_INCREMENT,
                        main_insured_first_name VARCHAR(32),
                        main_insured_last_name VARCHAR(32),
                        home_policy_number int ,
                        auto_policy_number int,
                        address_id int,
                        user_id int(11) NOT NULL,

                        PRIMARY KEY (`client_id`),
                        foreign key (user_id) REFERENCES USERS(USER_id),
                        foreign key (ADDRESS_ID) REFERENCES ADDRESS(ADDRESS_ID)

);


CREATE TABLE ACCIDENT_LISTING(
                                 accident_id int NOT NULL AUTO_INCREMENT,
                                 client_id int NOT NULL,
                                 accident_date date,
                                 at_fault bool,
                                 PRIMARY KEY (ACCIDENT_ID),
                                 Foreign KEY (client_id) REFERENCES CLIENT(CLIENT_ID)
);



CREATE TABLE Home (
                      HOME_ID int NOT NULL AUTO_INCREMENT,
                      policy_number int ,
                      age_since_built float(2),
                      type_of_dwelling varchar(20),
                      heating_type varchar(17),
                      primary key (`HOME_ID`)
);


CREATE TABLE Car (
                     VIN_NUMBER INT NOT NULL AUTO_INCREMENT,
                     policy_number int,
                     vehicle_make varchar(32),
                     vehicle_model varchar(32),
                     vehicle_year int,
                     PRIMARY KEY (`VIN_number`)
);




CREATE TABLE auto_policy_rate (
                                  auto_policy_rate_ID INT NOT NULL auto_increment,
                                  base_premium_rate float,
                                  driver_age_25_under_rate float,
                                  driver_age_other_rate float,
                                  2_or_more_accidents_last_5_years_rate float,
                                  1_accident_last_5_years_rate float,
                                  no_accidents_rate float,
                                  car_11_years_or_older_rate float,
                                  car_older_than_5_years_rate float,
                                  car_other_age_rate float,
                                  PRIMARY KEY (AUTO_POLICY_RATE_ID)
);

CREATE TABLE HOME_POLICY_RATE(
                                 home_policy_rate_id INT NOT NULL auto_increment,
                                 base_premium_rate float,
                                 tax_rate float,
                                 home_age_25_or_over_rate float,
                                 home_age_50_or_over_rate float,
                                 oil_heat_rate float,
                                 wood_heat_rate float,
                                 other_heat_rate float,
                                 PRIMARY KEY (HOME_POLICY_RATE_ID)
);



CREATE TABLE POLICY_FACTORY (
                                policy_factory_id int NOT NULL AUTO_INCREMENT,
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
                                replacement_cost_value float(2),
                                injury_liability_limit float(2),
                                injury_deductible float(2),
                                contents_liability_limit float(2),
                                contents_deductible float(2),
                                rating_details_auto int NOT NULL,
                                rating_details_home int NOT NULL,

                                PRIMARY KEY (`policy_FACTORY_ID`),
                                FOREIGN KEY (rating_details_auto) REFERENCES auto_policy_rate(AUTO_POLICY_rate_id),
                                FOREIGN KEY (rating_details_home) REFERENCES HOME_policy_rate(HOME_POLICY_rate_id),
                                FOREIGN KEY (client_id) REFERENCES Client(client_id)
);




CREATE TABLE POLICY (
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
                        replacement_cost_value float(2),
                        injury_liability_limit float(2),
                        injury_deductible float(2),
                        contents_liability_limit float(2),
                        contents_deductible float(2),
                        policy_factory_id INT not null,
                        primary key (policy_number),
                        foreign key (policy_factory_id) REFERENCES POLICY_FACTORY(POLICY_FACTORY_ID)
);
CREATE TABLE Home_Policy (
                             policy_number int NOT NULL,
                             client_id int NOT NULL,
                             home_id int NOT NULL,
                             primary key (client_id, home_id),
                             foreign key (home_id) REFERENCES Home(home_id),
                             foreign key (client_id) REFERENCES POLICY(policy_number)
);

CREATE TABLE Auto_Policy (
                             policy_number int NOT NULL,
                             client_id int NOT NULL,
                             VIN_NUMBER int NOT NULL,
                             primary key (client_id, policy_number),
                             foreign key (VIN_NUMBER) REFERENCES CAR(VIN_NUMBER),
                             foreign key (client_id) REFERENCES POLICY(POLICY_NUMBER)
);