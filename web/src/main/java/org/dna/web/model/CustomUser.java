package org.dna.web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Specialization of Spring's User to carry the entityId.
 *
 * Created by andrea on 25/08/16.
 */
public class CustomUser extends User {

    private final long entityId;

    public CustomUser(long entityId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.entityId = entityId;
    }

    public CustomUser(long entityId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                      boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.entityId = entityId;
    }

    public long getEntityId() {
        return entityId;
    }
}
