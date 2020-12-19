package tech.guyi.web.quick.permission.admin.supplier.defaults;

import tech.guyi.web.quick.permission.admin.supplier.AuthorizationCurrentSupplier;
import tech.guyi.web.quick.permission.authorization.AuthorizationCurrent;
import tech.guyi.web.quick.permission.authorization.AuthorizationInfo;
import tech.guyi.web.quick.permission.handler.entry.HandlerRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class DefaultAuthorizationCurrentSupplier implements AuthorizationCurrentSupplier {

    @Resource
    private List<AuthorizationCurrent> current;

    @Override
    public Optional<AuthorizationInfo> current(HandlerRequest request) {
        return this.current.stream()
                .filter(current -> current.currentKey().isPresent())
                .findFirst()
                .flatMap(AuthorizationCurrent::current);
    }

}
