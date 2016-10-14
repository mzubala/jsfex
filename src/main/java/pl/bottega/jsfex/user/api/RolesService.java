package pl.bottega.jsfex.user.api;

import pl.bottega.jsfex.user.model.Role;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by maciuch on 14.10.16.
 */
public class RolesService {

    private static final Collection<Role> ROLES = new LinkedList<>();

    static {
        ROLES.add(new Role(1l, "admin"));
        ROLES.add(new Role(2l, "manager"));
        ROLES.add(new Role(3l, "staff"));
    }

    public Collection<Role> getRoles() {
        return ROLES;
    }

}
