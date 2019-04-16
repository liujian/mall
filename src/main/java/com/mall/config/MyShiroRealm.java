package com.mall.config;

import com.mall.pc.sys.domen.Permission;
import com.mall.pc.sys.domen.Role;
import com.mall.pc.sys.domen.SysUser;
import com.mall.pc.sys.service.RoleService;
import com.mall.pc.sys.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private SysUserService sysUserService;

    @Resource
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser SysUser = (SysUser) principals.getPrimaryPrincipal();
        Role role = sysUserService.getRole(SysUser.getRoleId());
        //authorizationInfo.addRole(role);
        for (Permission p : roleService.getPermissions(role.getId())) {
            authorizationInfo.addStringPermission(p.getPermCode());
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String loginName = (String) token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过loginname从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser sysUser = sysUserService.findByLoginName(loginName);
        System.out.println("----->>user=" + sysUser);
        if (sysUser == null) {
            return null;
        }
        if ("FORBIDDEN".equals(sysUser.getState())) {//账户冻结
            throw new LockedAccountException();
        }
        Role role = sysUserService.getRole(sysUser.getRoleId());
        if ("FORBIDDEN".equals(role.getState())) {
            throw new AccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser, //用户名
                sysUser.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
