insert into AQUAPARKATTRACTION (attractionId, maxUsers, name) values (1, 20, 'Pool');
insert into AQUAPARKATTRACTION (attractionId, maxUsers, name) values (2, 30, 'Slide');
insert into AQUAPARKATTRACTION (attractionId, maxUsers, name) values (3, 30, 'Big pool');

insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (1, 1);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (2, 2);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (5, 2);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (3, 3);
insert into AQUAPARKATTRACTIONGATE (gateId, attractionId) values (4, 3);

insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (1, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (2, 1);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (3, 0);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (4, 1);
insert into CLIENTIDENTIFICATOR (identificatorId, isInUse) values (5, 1);

insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (1, 1, '2017-01-09', '16:03', 1, 2);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (2, 0, '2017-01-09', '18:30', 1, 2);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (3, 1, '2019-06-19', '12:31', 1, 4);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (4, 0, '2019-06-19', '13:47', 2, 4);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (5, 1, '2018-10-08', '15:44', 2, 5);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (6, 0, '2018-10-08', '18:17', 1, 5);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (7, 1, '2019-11-03', '08:17', 2, 3);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (8, 0, '2019-11-03', '10:20', 2, 3);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (9, 1, '2019-01-11', '15:30', 1, 1);
insert into AQUAPARKATTRACTIONGATEEVENT (eventId, isEntering, date, time, gateId, identificatorId) values (10, 0, '2019-01-11', '18:20', 2, 1);

insert into GENDER (genderId, genderName) values (0, 'Female');
insert into GENDER (genderId, genderName) values (1, 'Male');
insert into GENDER (genderId, genderName) values (2, 'N/A');

insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (1, 'Mariel', 'Elener', '3 Canary Place', '749084822', 'Perfect swimmer', 'Landon', 'fvVbgTDC492', '93139441283', '1929-05-12', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (2, 'Mic', 'Meert', '490 Gale Avenue', '930174978', 'Perfect swimmer', 'Rodolfo', 'NvcdTBDF729', '57557309332', '1994-05-13', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (3, 'Aloin', 'Hew', '755 Duke Terrace', '569692874', 'Swims quite well', 'Theo', 'coeWasgIuP072', '01057686270', '1971-08-10', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (4, 'Kassi', 'McCuaig', '75 Elka Lane', '056062630', 'Cannot swim', 'Zonia', 'SXfQ173', '72813884844', '2000-04-01', 0);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (5, 'Kassey', 'Kobierski', '7280 Russell Drive', '908392332', 'Perfect swimmer', 'Sherman', 'sdYb203', '20187632915', '1988-09-02', 0);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (6, 'Wain', 'Foss', '861 Upham Drive', '179955264', 'Swims quite well', 'Cindie', 'oplzSD747', '23186618323', '1971-08-04', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (7, 'Test', 'Test', 'Test', '619535243', 'TEST acc', 'TEST', 'TEST', '0000000000', '2018-07-16', 2);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (8, 'Tamara', 'Gibben', '82 Hallows Drive', '796073444', 'Perfect swimmer', 'Mellie', 'EgNpYAvDao101', '65283193734', '1956-03-01', 0);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (9, 'Mead', 'Sowle', '3 High Crossing Junction', '625283530', 'Perfect swimmer', 'Newton', 'lRHyXID467', '40087205549', '1961-06-18', 1);
insert into USER (userId, firstName, lastName, address, contactNumber, otherInformation, userName, password, pesel, birthDate, genderId) values (10, 'Ramsey', 'Randal', '86 Forster Pass', '414392355', 'Cannot swim', 'Charmaine', 'ryCnN277', '08352120086', '2008-01-23', 1);

insert into EMPLOYEE (employeeId, userId) values (1, 5);
insert into EMPLOYEE (employeeId, userId) values (2, 7);
insert into EMPLOYEE (employeeId, userId) values (3, 2);

insert into CLIENT (clientId, ownsAccount, userId) values (1, 0, 1);
insert into CLIENT (clientId, ownsAccount, userId) values (2, 1, 3);
insert into CLIENT (clientId, ownsAccount, userId) values (3, 1, 5);
insert into CLIENT (clientId, ownsAccount, userId) values (4, 0, 7);
insert into CLIENT (clientId, ownsAccount, userId) values (5, 1, 10);

insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (1, '2017-01-09', '16:03', '18:30', 28.56, 2, 3);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (2, '2019-06-19', '12:31', '13:47', 19.97, 4, 1);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (3, '2018-10-08', '15:44', '18:17', 43.62, 5, 2);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (4, '2019-11-03', '08:17', '10:20', 15.18, 3, 2);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (5, '2019-01-11', '15:30', '18:20', 31.44, 1, 5);

insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (1, 1, 0, 0);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (2, 0, 1, 0);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (3, 0, 0, 1);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (4, 0, 0, 0);

insert into PRICELIST (priceListId, validityStartDate, employeeId) values (1, '2019-05-31', 2);
insert into PRICELIST (priceListId, validityStartDate, employeeId) values (2, '2019-07-02', 1);
insert into PRICELIST (priceListId, validityStartDate, employeeId) values (3, '2019-10-16', 2);

insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (1, 'Pool', 174.06, 'Pool price', 1, 4, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (2, 'Slide', 72.18, 'Slide price', 2, 4, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (3, 'Pool', 20.00, 'Pool price', 3, 1, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (4, 'Pool', 5.00, 'Pool price', 3, 2, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (5, 'Pool', 7.30, 'Pool price', 3, 3, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (6, 'Pool', 10.20, 'Pool price', 3, 4, 1);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (7, 'Slide', 30.00, 'Slide price', 3, 1, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (8, 'Slide', 15.00, 'Slide price', 3, 2, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (9, 'Slide', 15.00, 'Slide price', 3, 3, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (10, 'Slide', 15.00, 'Slide price', 3, 4, 2);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (11, 'Big pool', 20.00, 'Big pool price', 3, 1, 3);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (12, 'Big pool', 10.20, 'Big pool price', 3, 2, 3);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (13, 'Big pool', 5.50, 'Big pool price', 3, 3, 3);
insert into PRICELISTITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (14, 'Big pool', 16.20, 'Big pool price', 3, 4, 3);

insert into ROLE (roleId, roleName) values (1, 'Cashier');
insert into ROLE (roleId, roleName) values (2, 'Gate');
insert into ROLE (roleId, roleName) values (3, 'AnonymousClient');
insert into ROLE (roleId, roleName) values (4, 'Client');
insert into ROLE (roleId, roleName) values (5, 'Cleaner');
insert into ROLE (roleId, roleName) values (6, 'Analyst');
insert into ROLE (roleId, roleName) values (7, 'SuperUser');
insert into ROLE (roleId, roleName) values (8, 'Owner');
insert into ROLE (roleId, roleName) values (9, 'PriceChanger');

insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (5, 1);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (1, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (2, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (5, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (6, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (7, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (9, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (8, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (3, 3);

insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (1, 'Cleaning', '2019-08-31', 2, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (2, 'Water change', '2020-02-09', 2, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (3, 'Repair', '2019-07-21', 1, 3);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (4, 'Modernization', '2020-02-22', 2, 2);
insert into AQUAPARKATTRACTIONMAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (5, 'Water quality test', '2019-11-14', 2, 2);

insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (1, 1, 1, 1, 1, NULL);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (2, 1, 1, 1, 2, 1);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (3, 2, 2, 2, 3, NULL);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (4, 2, 2, 2, 4, 2);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (5, 3, 3, 3, 5, NULL);
insert into AQUAPARKATTRACTIONUSAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (6, 3, 3, 3, 6, 3);