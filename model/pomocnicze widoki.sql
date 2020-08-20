create or replace view employe_info as select role.roleName, user.firstName, user.lastName, user.userName, user.password from role, role_has_employee, employee, user where role.roleId = role_has_employee.roleId and employee.employeeId = role_has_employee.employeeId and user.userId = employee.employeeId;

