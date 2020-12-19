package tech.guyi.web.quick.permission.admin.handler;

import org.springframework.http.HttpStatus;
import tech.guyi.web.quick.permission.admin.entry.Admin;
import tech.guyi.web.quick.permission.admin.supplier.AuthorizationCurrentSupplier;
import tech.guyi.web.quick.permission.handler.AuthorizationHandler;
import tech.guyi.web.quick.permission.handler.entry.HandlerRequest;

import javax.annotation.Resource;

public class PermissionHandler implements AuthorizationHandler {

    @Resource
    private PermissionChecker checker;
    @Resource
    private AuthorizationCurrentSupplier currentSupplier;

    @Override
    public HttpStatus handle(HandlerRequest request) {
        return this.currentSupplier.current(request)
                .map(Admin.class::cast)
                .map(admin -> {
                    if (admin.isSuperAdmin()){
                        return HttpStatus.OK;
                    }
                    return checker.check(request.getPath(),request.getMethod(),admin.getPermissions());
                })
                .orElse(HttpStatus.UNAUTHORIZED);
    }

}
