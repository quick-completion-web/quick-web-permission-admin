package tech.guyi.web.quick.permission.admin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.guyi.web.quick.permission.admin.handler.PermissionHandler;
import tech.guyi.web.quick.permission.admin.handler.defaults.DefaultPermissionChecker;
import tech.guyi.web.quick.permission.admin.supplier.AuthorizationCurrentSupplier;
import tech.guyi.web.quick.permission.admin.supplier.defaults.DefaultAuthorizationCurrentSupplier;

@Configuration
public class PermissionAdminAutoConfiguration {

    @Bean
    public PermissionHandler permissionHandler(){
        return new PermissionHandler();
    }

    @Bean
    @ConditionalOnMissingBean(DefaultPermissionChecker.class)
    public DefaultPermissionChecker defaultPermissionChecker(){
        return new DefaultPermissionChecker();
    }

    @Bean
    @ConditionalOnMissingBean(AuthorizationCurrentSupplier.class)
    public DefaultAuthorizationCurrentSupplier defaultAuthorizationCurrentSupplier(){
        return new DefaultAuthorizationCurrentSupplier();
    }

}
