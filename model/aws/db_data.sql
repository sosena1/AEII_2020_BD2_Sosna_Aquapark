insert into aquaparkattraction (attractionId, maxUsers, name) values (1, 20, 'Pool');
insert into aquaparkattraction (attractionId, maxUsers, name) values (2, 30, 'Slide');
insert into aquaparkattraction (attractionId, maxUsers, name) values (3, 30, 'Big pool');

insert into aquaparkattractiongate (gateId, attractionId) values (1, 1);
insert into aquaparkattractiongate (gateId, attractionId) values (2, 2);
insert into aquaparkattractiongate (gateId, attractionId) values (3, 3);
insert into aquaparkattractiongate (gateId, attractionId) values (4, 3);
insert into aquaparkattractiongate (gateId, attractionId) values (5, 2);

insert into clientidentificator (identificatorId, isInUse) values (1, 0);
insert into clientidentificator (identificatorId, isInUse) values (2, 0);
insert into clientidentificator (identificatorId, isInUse) values (3, 0);
insert into clientidentificator (identificatorId, isInUse) values (4, 0);
insert into clientidentificator (identificatorId, isInUse) values (5, 0);
insert into clientidentificator (identificatorId, isInUse) values (6, 0);
insert into clientidentificator (identificatorId, isInUse) values (7, 0);

insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (1, 1, '2020-08-06', '11:00', 2, 1);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (2, 0, '2020-08-06', '13:00', 2, 1);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (3, 1, '2020-08-09', '11:40', 2, 2);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (4, 0, '2020-08-09', '13:50', 2, 2);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (5, 1, '2020-08-09', '08:40', 1, 3);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (6, 0, '2020-08-09', '11:50', 1, 3);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (7, 1, '2020-08-09', '17:45', 3, 4);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (8, 0, '2020-08-09', '18:53', 3, 4);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (9, 1, '2020-08-09', '09:52', 5, 5);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (10, 0, '2020-08-09', '13:38', 2, 6);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (11, 0, '2020-08-09', '13:40', 2, 7);
insert into aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) values (12, 0, '2020-08-09', '15:39', 3, 6);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (13, 1, '2020-08-22', '15:31:23', 4, 7);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (14, 0, '2020-08-22', '15:38:00', 4, 7);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (15, 1, '2020-08-22', '15:34:32', 3, 4);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (16, 0, '2020-08-22', '15:51:00', 4, 4);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (17, 1, '2020-08-22', '15:51:00', 1, 4);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (18, 0, '2020-08-22', '16:23:00', 1, 4);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (19, 0, '2020-08-22', '15:39:46', 1, 2);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (20, 1, '2020-08-24', '07:00:00', 1, 2);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (21, 0, '2020-08-24', '07:55:00', 1, 2);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (22, 1, '2020-08-24', '12:35:00', 1, 5);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (23, 0, '2020-08-24', '12:56:00', 1, 5);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (24, 1, '2020-08-24', '12:56:00', 3, 5);
INSERT INTO aquapark_db.aquaparkattractiongateevent (eventId, isEntering, date, time, gateId, identificatorId) VALUES (25, 0, '2020-08-24', '13:07:00', 3, 5);


insert into gender (genderId, genderName) values (1, 'Female');
insert into gender (genderId, genderName) values (2, 'Male');
insert into gender (genderId, genderName) values (3, 'N/A');

insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (1, 'Jakub', 'Klimek', '3 Canary Place', '749084822', '1i395p30KU0LlQNo77t1', 'Landon', 'a5578f19a88cf24804565e18aee31c6c', '93139441283', '1955-05-12', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (2, 'Michał', 'Jankowski', '490 Gale Avenue', '930174978', '6E3L8j9452npx88rh144', 'Rodolfo', '6d8a2d3ff406bdcf7b0d6d294b8ae886', '57557309332', '1994-05-13', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (3, 'Michał', 'Sosna', '755 Duke Terrace', '569692874', '33P4BSaS1r8cv1614104', 'Theo', '9f2a3f3976b7c63f36a50a55866cf4c6', '01057686270', '1971-08-10', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (4, 'Kamil', 'Sitarski', '75 Elka Lane', '056062630', '5RCpr3al974Va2Ko7685', 'Zonia', '69653d46dc2815eec32c916f2b8cceb3', '72813884844', '1998-06-12', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (5, 'Kassey', 'Kobierski', '7280 Russell Drive', '908392332', '363977F1j7L3k6B7dsB3', 'Sherman', '0a871370f7e41a5aaab529b70ec1f274', '20187632915', '1988-09-02', 1);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (6, 'Wain', 'Foss', '861 Upham Drive', '179955264', 'F5B51d62WRT7V9047F28', 'Cindie', '29cf5237600ce404d86bb7ffaf7e8a6a', '23186618323', '1921-08-04', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (7, 'Jaquelin', 'Reboul', '8 Delaware Junction', '619535243', 's7t6w3P831m33J31271o', 'Bethel', 'a7b76fd3ada7b0e6d02c049eddb97ea8', '42585405712', '2005-07-16', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (8, 'Tamara', 'Gibben', '82 Hallows Drive', '796073444', 'XmOs2gg87Ks7iv8AVkZP', 'Mellie', 'ce785eebfaad24ecabdb839f9d7a73f7', '65283193734', '1956-03-01', 1);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (9, 'Mead', 'Sowle', '3 High Crossing Junction', '625283530', '5x139Iv916gW7123F28D', 'Newton', '394e1d5bcfc17c4299620a4a68b612bc', '40087205549', '1961-06-18', 2);
insert into user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (10, 'Ramsey', 'Randal', '86 Forster Pass', '414392355', '8XM98NCEzce74O9X5B0l', 'Charmaine', '44deed40d07f73c20996ff673d393fea', '08352120086', '2003-01-23', 2);
INSERT INTO aquapark_db.user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) VALUES (11, 'Jerzy', 'Dzenta', 'Sosnowo Sosienna 4', '+48 666 432 666', 'none', 'Fizyka123', 'a9875424ef89a629d85e9dde9c01d6a9', '82123143243', '1981-12-31', 2);
INSERT INTO aquapark_db.user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) VALUES (12, 'Agnieszka', 'Niemieszka', 'Zabrze Wolnosci 17', '+48 777 432 666', 'none', 'ANiemieszka', '476ffaf9ca80d80f160d375cbd41101b', '88033143243', '1988-03-31', 1);
INSERT INTO aquapark_db.user (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) VALUES (13, 'Szymek', 'Przepiórka', 'Gliwice Zwyciestwa 15', '+48 342 432 666', 'none', 'SPrzepiora', '586a60a6279923f8a9ce3d287acf2e3b', '07092743243', '2007-09-27', 2);


insert into employee (employeeId, userId) values (1, 5);
insert into employee (employeeId, userId) values (2, 4);
insert into employee (employeeId, userId) values (3, 2);
insert into employee (employeeId, userId) values (4, 8);
insert into employee (employeeId, userId) values (5, 9);

insert into client (clientId, ownsAccount, userId) values (1, 1, 1);
insert into client (clientId, ownsAccount, userId) values (2, 1, 3);
insert into client (clientId, ownsAccount, userId) values (3, 1, 5);
insert into client (clientId, ownsAccount, userId) values (4, 1, 7);
insert into client (clientId, ownsAccount, userId) values (5, 1, 10);
insert into client (clientId, ownsAccount, userId) values (6, 1, 4);
insert into client (clientId, ownsAccount, userId) values (7, 1, 6);
INSERT INTO aquapark_db.client (clientId, ownsAccount, userId) VALUES (8, 1, 11);
INSERT INTO aquapark_db.client (clientId, ownsAccount, userId) VALUES (9, 1, 12);
INSERT INTO aquapark_db.client (clientId, ownsAccount, userId) VALUES (10, 1, 13);

insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (1, '2020-05-06', '10:30', '13:30', 50.50, 1, 1);
insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (2, '2020-07-09', '11:30', '14:00', 17.30, 2, 2);
insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (3, '2020-07-11', '08:30', '12:00', 10.20, 3, 2);
insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (4, '2020-07-21', '09:30', '13:00', 20.60, 5, 4);
insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (5, '2020-07-18', '17:30', '19:00', 9.80, 4, 3);
insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (6, '2020-07-23', '10:30', '13:00', 22.60, 7, 6);
insert into visit (visitId, date, startTime, endTime, value, identificatorId, clientId) values (7, '2020-07-23', '10:30', '13:00', 12.80, 6, 7);
INSERT INTO aquapark_db.visit (visitId, date, startTime, endTime, value, identificatorId, clientId) VALUES (8, '2020-08-22', '15:31:11', '15:38:00', 97.20000, 7, 8);
INSERT INTO aquapark_db.visit (visitId, date, startTime, endTime, value, identificatorId, clientId) VALUES (9, '2020-08-22', '15:33:56', '16:23:00', 585.60000, 4, 9);
INSERT INTO aquapark_db.visit (visitId, date, startTime, endTime, value, identificatorId, clientId) VALUES (10, '2020-08-24', '07:00:00', '07:55:00', 561.00000, 2, 9);
INSERT INTO aquapark_db.visit (visitId, date, startTime, endTime, value, identificatorId, clientId) VALUES (11, '2020-08-24', '12:35:00', '13:07:00', 392.40000, 5, 10);

insert into conditions (conditionId, weekendOnly, childOnly, seniorOnly) values (1, 1, 0, 0);
insert into conditions (conditionId, weekendOnly, childOnly, seniorOnly) values (2, 0, 1, 0);
insert into conditions (conditionId, weekendOnly, childOnly, seniorOnly) values (3, 0, 0, 1);
insert into conditions (conditionId, weekendOnly, childOnly, seniorOnly) values (4, 0, 0, 0);

insert into pricelist (priceListId, validityStartDate, employeeId) values (1, '2019-05-31', 2);
insert into pricelist (priceListId, validityStartDate, employeeId) values (2, '2019-07-02', 1);
insert into pricelist (priceListId, validityStartDate, employeeId) values (3, '2019-10-16', 2);
insert into pricelist (priceListId, validityStartDate, employeeId) values (4, '2020-04-20', 2);

insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (1, 'Pool', 174.06, 'Pool price/All', 1, 4, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (2, 'Slide', 72.18, 'Slide price/All', 2, 4, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (3, 'Pool', 20.00, 'Pool price/Weekend', 3, 1, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (4, 'Pool', 5.00, 'Pool price/Child', 3, 2, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (5, 'Pool', 7.30, 'Pool price/Senior', 3, 3, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (6, 'Pool', 10.20, 'Pool price/All', 3, 4, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (7, 'Slide', 30.00, 'Slide price/Weekend', 3, 1, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (8, 'Slide', 15.00, 'Slide price/Child', 3, 2, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (9, 'Slide', 15.00, 'Slide price/Senior', 3, 3, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (10, 'Slide', 15.00, 'Slide price/All', 3, 4, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (11, 'Big pool', 20.00, 'Big pool price/Weekend', 3, 1, 3);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (12, 'Big pool', 10.20, 'Big pool price/Child', 3, 2, 3);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (13, 'Big pool', 5.50, 'Big pool price/Senior', 3, 3, 3);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (14, 'Big pool', 16.20, 'Big pool price/All', 3, 4, 3);

insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (15, 'Pool WKND', 5.00, 'Pool price/Weekend', 4, 1, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (16, 'Pool CHLD', 5.20, 'Pool price/Child', 4, 2, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (17, 'Pool SNR', 7.30, 'Pool price/Senior', 4, 3, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (18, 'Pool ALL', 10.20, 'Pool price/All', 4, 4, 1);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (19, 'Slide WKND', 12.00, 'Slide price/Weekend', 4, 1, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (20, 'Slide CHLD', 14.00, 'Slide price/Child', 4, 2, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (21, 'Slide SNR', 13.00, 'Slide price/Senior', 4, 3, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (22, 'Slide ALL', 15.00, 'Slide price/All', 4, 4, 2);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (23, 'Big pool WKND', 8.35, 'Big pool price/Weekend', 4, 1, 3);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (24, 'Big pool CHLD', 10.20, 'Big pool price/Child', 4, 2, 3);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (25, 'Big pool SNR', 5.50, 'Big pool price/Senior', 4, 3, 3);
insert into pricelistitem (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (26, 'Big pool ALL', 16.20, 'Big pool price/All', 4, 4, 3);


insert into role (roleId, roleName) values (1, 'Cashier');
insert into role (roleId, roleName) values (2, 'Gate');
insert into role (roleId, roleName) values (3, 'Maintainer');
insert into role (roleId, roleName) values (4, 'Analyst');
insert into role (roleId, roleName) values (5, 'PriceManager');
insert into role (roleId, roleName) values (6, 'Owner');
insert into role (roleId, roleName) values (7, 'SuperUser');

insert into role_has_employee (roleId, employeeId) values (5, 1);
insert into role_has_employee (roleId, employeeId) values (1, 2);
insert into role_has_employee (roleId, employeeId) values (2, 2);
insert into role_has_employee (roleId, employeeId) values (3, 2);
insert into role_has_employee (roleId, employeeId) values (4, 2);
insert into role_has_employee (roleId, employeeId) values (5, 2);
insert into role_has_employee (roleId, employeeId) values (6, 2);
insert into role_has_employee (roleId, employeeId) values (7, 2);
insert into role_has_employee (roleId, employeeId) values (3, 3);
insert into role_has_employee (roleId, employeeId) values (5, 4);
insert into role_has_employee (roleId, employeeId) values (5, 5);

insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (1, 'Cleaning big pool', '2019-08-31', 2, 3);
insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (2, 'Water change', '2020-02-09', 2, 3);
insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (3, 'Repair of big pool', '2019-07-21', 1, 3);
insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (4, 'Modernization of slide', '2020-02-22', 2, 2);
insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (5, 'Water quality test of slide', '2019-11-14', 2, 2);
insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (6, 'Repair of big pool', '2020-01-22', 4, 3);
insert into aquaparkattractionmaintenance (attractionMaintenanceId, description, date, employeeId, attractionId) values (7, 'Cleaning of big pool', '2012-10-14', 5, 3);

insert into aquaparkattractionusage (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (1, 2, 1, 1, 1, 2);
insert into aquaparkattractionusage (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (2, 2, 1, 2, 3, 4);
insert into aquaparkattractionusage (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (3, 1, 2, 3, 5, 6);
insert into aquaparkattractionusage (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (4, 3, 2, 4, 7, 8);
insert into aquaparkattractionusage (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (5, 2, 3, 5, 9, 10);