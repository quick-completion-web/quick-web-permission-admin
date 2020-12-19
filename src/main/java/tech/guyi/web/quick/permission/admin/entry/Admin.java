package tech.guyi.web.quick.permission.admin.entry;

import tech.guyi.web.quick.permission.authorization.AuthorizationInfo;

import java.util.Set;
import java.util.stream.Collectors;

public interface Admin extends AuthorizationInfo {

    boolean isSuperAdmin();

    Set<Permission> getPermissions();

    default Set<Permission> getMenus(){
        return this.getPermissions()
                .stream()
                .filter(Permission::isMenu)
                .collect(Collectors.toSet());
    }

}
