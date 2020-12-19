package tech.guyi.web.quick.permission.admin.handler.defaults;

import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import tech.guyi.web.quick.permission.admin.entry.Permission;
import tech.guyi.web.quick.permission.admin.handler.PermissionChecker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;

public class DefaultPermissionChecker implements PermissionChecker {

    private final Queue<AntPathMatcher> pathMatchers = new LinkedList<>();

    private boolean match(Permission permission, String url, String method) {
        AntPathMatcher matcher = pathMatchers.poll();
        if (matcher == null){
            matcher = new AntPathMatcher();
        }
        boolean check =  matcher.match(permission.getPath(), url);
        check = check && (StringUtils.isEmpty(permission.getMethod()) || Pattern.matches(permission.getMethod(), method));
        pathMatchers.add(matcher);
        return check;
    }

    @Override
    public HttpStatus check(String url, String method, Set<Permission> permissions) {
        return permissions.stream()
                .anyMatch(permission -> this.match(permission,url,method)) ?
                HttpStatus.OK : HttpStatus.FORBIDDEN;
    }

}
