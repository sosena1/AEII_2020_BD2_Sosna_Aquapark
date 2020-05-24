package pl.bd.aquapark.dto;

import lombok.Data;
import pl.bd.aquapark.dao.Role;

public @Data class RoleDto {
    private Long roleId;

    private String roleName;

    public static RoleDto fromRole(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.roleId = role.getRoleId();
        roleDto.roleName = role.getRoleName();
        return roleDto;
    }
}
