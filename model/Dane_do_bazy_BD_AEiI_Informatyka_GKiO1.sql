insert into AQUAPARKATTRACTION (attractionId, maxUsers, name) values (1, 20, 'Pool');
insert into AQUAPARKATTRACTION (attractionId, maxUsers, name) values (2, 30, 'Slide');
insert into AQUAPARKATTRACTION (attractionId, maxUsers, name) values (3, 30, 'Big pool');

insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (1, 1);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (2, 2);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (3, 3);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (4, 3);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (5, 2);

insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (1, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (2, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (3, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (4, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (5, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (6, 0); 
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (7, 0);

insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (1, 1, '2020-08-06', '11:00', 2, 1);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (2, 0, '2020-08-06', '13:00', 2, 1);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (3, 1, '2020-08-09', '11:40', 2, 2);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (4, 0, '2020-08-09', '13:50', 2, 2);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (5, 1, '2020-08-09', '08:40', 1, 3);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (6, 0, '2020-08-09', '11:50', 1, 3);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (7, 1, '2020-08-09', '17:45', 3, 4);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (8, 0, '2020-08-09', '18:53', 3, 4);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (9, 1, '2020-08-09', '09:52', 5, 5);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (10, 0, '2020-08-09', '13:38', 2, 6); 
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (11, 0, '2020-08-09', '13:40', 2, 7);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (12, 0, '2020-08-09', '15:39', 3, 6);

insert into GENDER (genderId, genderName) values (1, 'Female');
insert into GENDER (genderId, genderName) values (2, 'Male');
insert into GENDER (genderId, genderName) values (3, 'N/A');

insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (1, 'Mariel', 'Elener', '3 Canary Place', '749084822', '1i395p30KU0LlQNo77t1', 'Landon', 'fvVbgTDC492', '93139441283', '1929-05-12', 2);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (2, 'Mic', 'Meert', '490 Gale Avenue', '930174978', '6E3L8j9452npx88rh144', 'Rodolfo', 'NvcdTBDF729', '57557309332', '1994-05-13', 2);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (3, 'Aloin', 'Hew', '755 Duke Terrace', '569692874', '33P4BSaS1r8cv1614104', 'Theo', 'coeWasgIuP072', '01057686270', '1971-08-10', 2);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (4, 'Kassi', 'McCuaig', '75 Elka Lane', '056062630', '5RCpr3al974Va2Ko7685', 'Zonia', 'SXfQ173', '72813884844', '2019-04-01', 3);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (5, 'Kassey', 'Kobierski', '7280 Russell Drive', '908392332', '363977F1j7L3k6B7dsB3', 'Sherman', 'sdYb203', '20187632915', '1988-09-02', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (6, 'Wain', 'Foss', '861 Upham Drive', '179955264', 'F5B51d62WRT7V9047F28', 'Cindie', 'oplzSD747', '23186618323', '1921-08-04', 2);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (7, 'Jaquelin', 'Reboul', '8 Delaware Junction', '619535243', 's7t6w3P831m33J31271o', 'Bethel', 'YxMnFhSUv630', '42585405712', '2018-07-16', 3);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (8, 'Tamara', 'Gibben', '82 Hallows Drive', '796073444', 'XmOs2gg87Ks7iv8AVkZP', 'Mellie', 'EgNpYAvDao101', '65283193734', '1956-03-01', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (9, 'Mead', 'Sowle', '3 High Crossing Junction', '625283530', '5x139Iv916gW7123F28D', 'Newton', 'lRHyXID467', '40087205549', '1961-06-18', 2);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (10, 'Ramsey', 'Randal', '86 Forster Pass', '414392355', '8XM98NCEzce74O9X5B0l', 'Charmaine', 'ryCnN277', '08352120086', '2008-01-23', 3);

insert into EMPLOYEE (employeeId, userId) values (1, 5);
insert into EMPLOYEE (employeeId, userId) values (2, 7);
insert into EMPLOYEE (employeeId, userId) values (3, 2);
insert into EMPLOYEE (employeeId, userId) values (4, 8); 
insert into EMPLOYEE (employeeId, userId) values (5, 9);

insert into CLIENT (clientId, ownsAccount, userId) values (1, 0, 1);
insert into CLIENT (clientId, ownsAccount, userId) values (2, 1, 3);
insert into CLIENT (clientId, ownsAccount, userId) values (3, 1, 5);
insert into CLIENT (clientId, ownsAccount, userId) values (4, 0, 7);
insert into CLIENT (clientId, ownsAccount, userId) values (5, 1, 10);
insert into CLIENT (clientId, ownsAccount, userId) values (6, 0, 4); 
insert into CLIENT (clientId, ownsAccount, userId) values (7, 1, 6);

insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (1, '2020-05-06', '10:30', '13:30', 50.50, 1, 1);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (2, '2020-07-09', '11:30', '14:00', 17.30, 2, 2);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (3, '2020-07-11', '08:30', '12:00', 10.20, 3, 2);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (4, '2020-07-21', '09:30', '13:00', 20.60, 5, 4); 
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (5, '2020-07-18', '17:30', '19:00', 9.80, 4, 3);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (6, '2020-07-23', '10:30', '13:00', 22.60, 7, 6);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (7, '2020-07-23', '10:30', '13:00', 12.80, 6, 7);

insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (1, 1, 0, 0);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (2, 0, 1, 0);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (3, 0, 0, 1);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (4, 0, 0, 0);

insert into PRICELIST (priceListId, validityStartDate, employeeId) values (1, '2019-05-31', 2);
insert into PRICELIST (priceListId, validityStartDate, employeeId) values (2, '2019-07-02', 1);
insert into PRICELIST (priceListId, validityStartDate, employeeId) values (3, '2019-10-16', 2);

insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (1, 'Pool', 174.06, 'Pool price/All', 1, 4, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (2, 'Slide', 72.18, 'Slide price/All', 2, 4, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (3, 'Pool', 20.00, 'Pool price/Weekend', 3, 1, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (4, 'Pool', 5.00, 'Pool price/Child', 3, 2, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (5, 'Pool', 7.30, 'Pool price/Senior', 3, 3, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (6, 'Pool', 10.20, 'Pool price/All', 3, 4, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (7, 'Slide', 30.00, 'Slide price/Weekend', 3, 1, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (8, 'Slide', 15.00, 'Slide price/Child', 3, 2, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (9, 'Slide', 15.00, 'Slide price/Senior', 3, 3, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (10, 'Slide', 15.00, 'Slide price/All', 3, 4, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (11, 'Big pool', 20.00, 'Big pool price/Weekend', 3, 1, 3);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (12, 'Big pool', 10.20, 'Big pool price/Child', 3, 2, 3);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (13, 'Big pool', 5.50, 'Big pool price/Senior', 3, 3, 3);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (14, 'Big pool', 16.20, 'Big pool price/All', 3, 4, 3);

insert into ROLE (roleId, roleName) values (1, 'Cashier');
insert into ROLE (roleId, roleName) values (2, 'Gate');
insert into ROLE (roleId, roleName) values (3, 'AnonymousClient');
insert into ROLE (roleId, roleName) values (4, 'Client');
insert into ROLE (roleId, roleName) values (5, 'Maintainer');
insert into ROLE (roleId, roleName) values (6, 'Analyst');
insert into ROLE (roleId, roleName) values (7, 'PriceManager');
insert into ROLE (roleId, roleName) values (8, 'Owner');
insert into ROLE (roleId, roleName) values (9, 'SuperUser');

insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (5, 1);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (1, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (2, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (5, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (6, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (7, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (8, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (3, 3);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (5, 4);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (5, 5);

insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (1, 'Cleaning', '2019-08-31', 2, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (2, 'Water change', '2020-02-09', 2, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (3, 'Repair', '2019-07-21', 1, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (4, 'Modernization', '2020-02-22', 2, 2);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (5, 'Water quality test', '2019-11-14', 2, 2);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (6, 'Repair', '2020-01-22', 4, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (7, 'Cleaning', '2012-10-14', 5, 3);

insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (1, 2, 1, 1, 1, 2);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (2, 2, 1, 2, 3, 4);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (3, 1, 2, 3, 5, 6);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (4, 3, 2, 4, 7, 8);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (5, 2, 3, 5, 9, 10);