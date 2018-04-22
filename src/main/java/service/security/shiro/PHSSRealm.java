package service.security.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * PHSS Realm
 *
 * @author Arthur.Lee (https://github.com/SolitudeRA)
 */

@Service
public class PHSSRealm extends AuthorizingRealm {
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof PHSSToken;
    }

    /**
     * Token authenticating
     *
     * @param authenticationToken Token from client
     * @return Authentication result
     * @throws AuthenticationException Authentication error status
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        PHSSToken token = (PHSSToken) authenticationToken;
        boolean
        return null;
    }

    /**
     * Token authorizing
     *
     * @param principalCollection collection of principals
     * @return Permission status
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
