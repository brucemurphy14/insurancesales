/*sets up the auto rating and home rating rates*/
insert into auto_rating VALUES (1,2.0,1, 1.5, 1.25, 1.0,  1.0, 1.25, 2.5,1.0,1.0,1.0, 750.0);
insert into home_rating VALUES (1, 1.0, 0.75, 1.0, 1.15, 1,1.25,1.5, 1.0, 2.0, 1.25,1.0,1.0, 500, 1.0);

/*creates login credentials*/
insert into users (username, password, role, enabled) values ('rfw', '1', 'CLIENT', TRUE);
insert into users (username, password, role, enabled) values ('ee', '1', 'CLIENT', TRUE);


/* creates the clients information */
insert into address (street_address, province, city, zip_code, location_type) VALUES ("37 peet street", "Newfoundland & Labrador", "St John's", "A1AB0", "Dense Urban");
/*insert into address (street_address, province, city, zip_code) VALUES ("11 yeet Buckmaster circle", "Triton", "Mt. Pearl", "A11BAS");*/

insert into client (main_insured_first_name, main_insured_last_name, home_policy_number, auto_policy_number, address_id, username, client_birthday)
values ("jimmy", "brown", 1, 1, 1, 'rfw', '1999-1-1');
/*
insert into client (main_insured_first_name, main_insured_last_name, home_policy_number, auto_policy_number, address_id, username, client_birthday)
values ("CARL", "WARNER", 2, 2, 2, 'ee', '1999-1-1');
*/

/*insert into accident_listing (client_id, accident_date, at_fault) VALUES (1,'1980-1-1', TRUE);
insert into accident_listing (client_id, accident_date, at_fault) VALUES (1,'2020-1-1', TRUE);
insert into accident_listing (client_id, accident_date, at_fault) VALUES (1,'2017-1-1', false);*/
insert into accident_listing (client_id, accident_date, at_fault) VALUES (1,'2018-1-1', false);


/*insert into accident_listing (client_id, accident_date, at_fault) VALUES (2,'2000-1-1', TRUE);*/


/* details about the insured house/car */
INSERT into home (policy_number, date_built, type_of_dwelling, heating_type) values (1, '1980-1-1', 'Detached', 'Oil');
insert into car (policy_number,vehicle_worth, vehicle_make, vehicle_model, vehicle_year) VALUES (1, 55000, "Honda", "Accord", 1999);

/*
INSERT into home (policy_number, age_since_built, type_of_dwelling, heating_type) values (2, 60.0, 'Bungalow', 'Wood');
insert into car (policy_number, vehicle_worth, vehicle_make, vehicle_model, vehicle_year) VALUES (0, 55000, "Mazda", "ZoomZoom",2007);
*/

/* creates the actual policy and links to client. decides if it is a home/auto policy */

insert into policy( start_date, client_id, policy_type, term_price) VALUES ( '2020-1-1', 1, "Auto", 5000);

insert into home_policy(policy_number, client_id, home_id) VALUES (1, 1,1);
insert into auto_policy(policy_number, client_id, vin_number) VALUES (1,1,1);



insert into policy_holder (client_id, policy_number) VALUES (1,1);

/*
insert into policy(client_id, policy_type, term_price) VALUES (2, "Auto", 0);
insert into home_policy(policy_number, client_id, home_id) VALUES (2, 2,2);
insert into auto_policy(policy_number, client_id, vin_number) VALUES (2,2,2);
insert into policy_holder (client_id, policy_number) VALUES (2,2);
 */