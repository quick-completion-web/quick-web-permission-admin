package tech.guyi.web.quick.permission.admin.entry;

public interface Permission {

    String getId();

    String getKey();

    String getName();

    String getPath();

    String getIcon();

    String getMethod();

    boolean isMenu();

}
