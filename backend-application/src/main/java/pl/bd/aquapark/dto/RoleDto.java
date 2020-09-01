package pl.bd.aquapark.dto;

import pl.bd.aquapark.dao.Role;

public class RoleDto {
    private Long roleId;

    private String roleName;

    public RoleDto() {
    }

    public static RoleDto fromRole(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.roleId = role.getRoleId();
        roleDto.roleName = role.getRoleName();
        return roleDto;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleDto)) return false;
        final RoleDto other = (RoleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        final Object this$roleName = this.getRoleName();
        final Object other$roleName = other.getRoleName();
        if (this$roleName == null ? other$roleName != null : !this$roleName.equals(other$roleName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoleDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        final Object $roleName = this.getRoleName();
        result = result * PRIME + ($roleName == null ? 43 : $roleName.hashCode());
        return result;
    }

    public String toString() {
        return "RoleDto(roleId=" + this.getRoleId() + ", roleName=" + this.getRoleName() + ")";
    }
}
