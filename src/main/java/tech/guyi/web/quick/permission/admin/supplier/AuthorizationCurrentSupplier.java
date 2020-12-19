package tech.guyi.web.quick.permission.admin.supplier;

import tech.guyi.web.quick.permission.authorization.AuthorizationInfo;
import tech.guyi.web.quick.permission.handler.entry.HandlerRequest;

import java.util.Optional;

public interface AuthorizationCurrentSupplier {

    Optional<AuthorizationInfo> current(HandlerRequest request);

}
