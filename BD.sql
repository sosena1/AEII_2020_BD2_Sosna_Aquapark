insert into AQUAPARK_ATTRACTION (attractionId, maxUsers, name) values (3, 20, 'Pool');
insert into AQUAPARK_ATTRACTION (attractionId, maxUsers, name) values (4, 30, 'Slide');
insert into AQUAPARK_ATTRACTION (attractionId, maxUsers, name) values (5, 30, 'Big pool');

insert into AQUAPARK_ATTRACTION_GATE (gateId, attractionId) values (5, 4);
insert into AQUAPARK_ATTRACTION_GATE (gateId, attractionId) values (2, 3);
insert into AQUAPARK_ATTRACTION_GATE (gateId, attractionId) values (2, 5);
insert into AQUAPARK_ATTRACTION_GATE (gateId, attractionId) values (2, 5);

insert into AQUAPARK_ATTRACTION_GATE_EVENT (eventId, isEntering, date, time, gateId, identificatorId) values (1, 1, '1/9/2005', '6:03 AM', 2, 2);
insert into AQUAPARK_ATTRACTION_GATE_EVENT (eventId, isEntering, date, time, gateId, identificatorId) values (2, 0, '11/20/2017', '6:30 PM', 5, 4);
insert into AQUAPARK_ATTRACTION_GATE_EVENT (eventId, isEntering, date, time, gateId, identificatorId) values (3, 0, '6/19/2019', '10:31 AM', 5, 4);
insert into AQUAPARK_ATTRACTION_GATE_EVENT (eventId, isEntering, date, time, gateId, identificatorId) values (4, 0, '10/8/2006', '1:47 PM', 2, 4);
insert into AQUAPARK_ATTRACTION_GATE_EVENT (eventId, isEntering, date, time, gateId, identificatorId) values (5, 1, '10/20/2007', '5:17 PM', 5, 2);

insert into AQUAPARK_ATTRACTION_MAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (1, 'Cleaning', '8/31/2019', 2, 5);
insert into AQUAPARK_ATTRACTION_MAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (2, 'Water change', '2/9/2020', 2, 5);
insert into AQUAPARK_ATTRACTION_MAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (3, 'Repair', '7/21/2019', 1, 5);
insert into AQUAPARK_ATTRACTION_MAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (4, 'Modernization', '2/22/2020', 2, 4);
insert into AQUAPARK_ATTRACTION_MAINTENANCE (attractionMaintenanceId, description, date, employeeId, attractionId) values (5, 'Water quality test', '11/14/2019', 2, 4);

insert into AQUAPARK_ATTRACTION_USAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (1, 3, 1, 2, 1, 1);
insert into AQUAPARK_ATTRACTION_USAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (2, 5, 2, 1, 1, 1);
insert into AQUAPARK_ATTRACTION_USAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (3, 3, 2, 1, 1, 1);
insert into AQUAPARK_ATTRACTION_USAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (4, 3, 3, 1, 1, 1);
insert into AQUAPARK_ATTRACTION_USAGE (usageId, attractionId, priceListItemId, visitId, enteringEventId, leavingEventId) values (5, 3, 2, 1, 1, 1);

insert into CLIENT (clientId, ownsAccount, userId) values (1, 0, 1);
insert into CLIENT (clientId, ownsAccount, userId) values (2, 1, 3);
insert into CLIENT (clientId, ownsAccount, userId) values (3, 1, 5);
insert into CLIENT (clientId, ownsAccount, userId) values (4, 0, 7);
insert into CLIENT (clientId, ownsAccount, userId) values (5, 1, 10);

insert into CLIENT_IDENTIFICATOR (identificatorId, isInUse) values (2, 0);
insert into CLIENT_IDENTIFICATOR (identificatorId, isInUse) values (5, 1);
insert into CLIENT_IDENTIFICATOR (identificatorId, isInUse) values (3, 0);
insert into CLIENT_IDENTIFICATOR (identificatorId, isInUse) values (3, 1);
insert into CLIENT_IDENTIFICATOR (identificatorId, isInUse) values (4, 1);

insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (2, 0, 0, 0);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (1, 0, 1, 1);
insert into CONDITIONS (conditionId, weekendOnly, childOnly, seniorOnly) values (3, 0, 0, 1);

insert into EMPLOYEE (employeeId, userId) values (1, 5);
insert into EMPLOYEE (employeeId, userId) values (2, 7);
insert into EMPLOYEE (employeeId, userId) values (3, 2);

insert into GENDER (genderId, genderName) values (0, 'Female');
insert into GENDER (genderId, genderName) values (1, 'Male');

insert into PRICE_LIST (priceListId, validityStartDate, employeeId) values (1, '5/31/2019', 2);
insert into PRICE_LIST (priceListId, validityStartDate, employeeId) values (2, '7/2/2019', 1);
insert into PRICE_LIST (priceListId, validityStartDate, employeeId) values (3, '10/16/2019', 2);

insert into PRICE_LIST_ITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (1, 'Pool', 174.06, 'Pool price', 1, 2, 3);
insert into PRICE_LIST_ITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (2, 'Big pool', 72.18, 'Big pool price', 2, 3, 4);
insert into PRICE_LIST_ITEM (priceListItemId, name, value, description, priceListId, conditionalId, attractionId) values (3, 'Slide', 6.20, 'Slide price', 3, 2, 5);

insert into ROLE (roleId, roleName) values (1, 'Cleaner');
insert into ROLE (roleId, roleName) values (2, 'Cashier');
insert into ROLE (roleId, roleName) values (3, 'Lifeguard');

insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (1, 2);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (2, 1);
insert into ROLE_HAS_EMPLOYEE (roleId, employeeId) values (3, 2);

insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (1, 'Mariel', 'Elener', '3 Canary Place', '749084822', '1i395p30KU0LlQNo77t1', 'Landon', 'fvVbgTDC492', '93139441283', '5/12/1929', 1);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (2, 'Mic', 'Meert', '490 Gale Avenue', '930174978', '6E3L8j9452npx88rh144', 'Rodolfo', 'NvcdTBDF729', '57557309332', '5/13/1994', 1);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (3, 'Aloin', 'Hew', '755 Duke Terrace', '569692874', '33P4BSaS1r8cv1614104', 'Theo', 'coeWasgIuP072', '01057686270', '8/10/1971', 1);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (4, 'Kassi', 'McCuaig', '75 Elka Lane', '056062630', '5RCpr3al974Va2Ko7685', 'Zonia', 'SXfQ173', '72813884844', '4/1/2019', 0);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (5, 'Kassey', 'Kobierski', '7280 Russell Drive', '908392332', '363977F1j7L3k6B7dsB3', 'Sherman', 'sdYb203', '20187632915', '9/2/1988', 0);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (6, 'Wain', 'Foss', '861 Upham Drive', '179955264', 'F5B51d62WRT7V9047F28', 'Cindie', 'oplzSD747', '23186618323', '8/4/1921', 1);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (7, 'Jaquelin', 'Reboul', '8 Delaware Junction', '619535243', 's7t6w3P831m33J31271o', 'Bethel', 'YxMnFhSUv630', '42585405712', '7/16/2018', 0);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (8, 'Tamara', 'Gibben', '82 Hallows Drive', '796073444', 'XmOs2gg87Ks7iv8AVkZP', 'Mellie', 'EgNpYAvDao101', '65283193734', '3/1/1956', 0);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (9, 'Mead', 'Sowle', '3 High Crossing Junction', '625283530', '5x139Iv916gW7123F28D', 'Newton', 'lRHyXID467', '40087205549', '6/18/1961', 1);
insert into USER (userId, first_name, last_name, address, contactNumber, otherInformation, userName, password, pesel, birthDate, gender) values (10, 'Ramsey', 'Randal', '86 Forster Pass', '414392355', '8XM98NCEzce74O9X5B0l', 'Charmaine', 'ryCnN277', '08352120086', '1/23/2008', 1);

insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (1, '1/9/2005', '6:03 AM', '8:24 AM', 28.56, 4, 3);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (2, '11/20/2017', '6:30 PM', '8:01 PM', 19.97, 2, 1);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (3, '6/19/2019', '10:31 AM', '12:40 PM', 443.62, 3, 2);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (4, '10/8/2006', '1:47 PM', '4:10 PM', 15.18, 4, 2);
insert into VISIT (visitId, date, startTime, endTime, value, identificatorId, clientId) values (5, '10/20/2007', '5:17 PM', '7:07 PM', 31.44, 5, 5);
