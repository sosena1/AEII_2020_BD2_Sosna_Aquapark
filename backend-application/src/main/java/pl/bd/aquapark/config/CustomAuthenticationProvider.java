package pl.bd.aquapark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.bd.aquapark.Roles;
import pl.bd.aquapark.dao.Client;
import pl.bd.aquapark.dao.Employee;
import pl.bd.aquapark.dao.Role;
import pl.bd.aquapark.dao.User;
import pl.bd.aquapark.repository.UserRepository;
import pl.bd.aquapark.util.SecurityUtil;

import java.util.*;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("AUTHENTICATION PROCEDURE");
        String name = authentication.getName();
        String password = SecurityUtil.toMd5(authentication.getCredentials().toString());

        Optional<User> userOptional = userRepository.findUserByUserNameAndPassword(name, password);
        System.out.println("Login: " + name + ", " + password);
        if (!userOptional.isPresent()) {
            System.out.println("Login fail");
            throw new BadCredentialsException("Authentication failed");
        } else {
            System.out.println("user id: " + userOptional.get().getUserId());
        }

        User user = userOptional.get();
        Client client = user.getClient();
        Employee employee = user.getEmployee();
        Set<Roles> roleList = new HashSet<>();

        if (client != null) {
            System.out.println("Is client with id: " + client.getClientId());
            if (client.getOwnsAccount()) {
                roleList.add(Roles.CLIENT);
            } else {
                throw new DisabledException("Cannot log in as anonymous client");
            }
        }

        if (employee != null) {
            System.out.println("Is employee with id: " + employee.getEmployeeId());
            List<Role> roles = employee.getRoles();
            for (Role role : roles) { //OOP is for noobs
                System.out.println(role);
                String roleString = role.getRoleName().toLowerCase();
                switch (roleString) {
                    case "cashier":
                        roleList.add(Roles.CASHIER);
                        break;
                    case "gate":
                        roleList.add(Roles.GATE);
                        break;
                    case "analyst":
                        roleList.add(Roles.ANALYST);
                        break;
                    case "maintainer":
                        roleList.add(Roles.MAINTAINER);
                    case "pricemanager":
                        roleList.add(Roles.PRICELIST_MAINTAINER);
                        break;
                    case "superuser":
                        roleList.add(Roles.SUPER_USER);
                    case "owner":
                        roleList.add(Roles.CASHIER);
                        roleList.add(Roles.OWNER);
                        roleList.add(Roles.GATE);
                        roleList.add(Roles.ANALYST);
                        roleList.add(Roles.MAINTAINER);
                        roleList.add(Roles.PRICELIST_MAINTAINER);
                        break;
                    default:
                        System.out.println("Role does not exists: " + roleString);
                        throw new BadCredentialsException("Authentication failed. Unexpected rolename: " + roleString);
                }
            }
        }

        System.out.println("Roles: " + Arrays.toString(roleList.toArray()));


        return new UsernamePasswordAndIdToken(name, password, (int) (long) user.getUserId(), roleList); //ale quality castowanie
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
