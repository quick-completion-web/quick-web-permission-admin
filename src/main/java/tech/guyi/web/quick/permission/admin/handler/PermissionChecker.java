package tech.guyi.web.quick.permission.admin.handler;

import org.springframework.http.HttpStatus;
import tech.guyi.web.quick.permission.admin.entry.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionChecker {

    HttpStatus check(String url, String method, Set<Permission> permissions);

}
