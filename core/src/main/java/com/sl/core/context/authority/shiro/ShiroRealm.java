package com.sl.core.context.authority.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {





        //String userName = (String) token.getPrincipal();
        //String password = new String((char[]) token.getCredentials());
        //
        //System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        //User user = userMapper.findByUserName(userName);
        //
        //if (user == null) {
        //    throw new UnknownAccountException("用户名或密码错误！");
        //}
        //if (!password.equals(user.getPassword())) {
        //    throw new IncorrectCredentialsException("用户名或密码错误！");
        //}
        //if (user.getStatus().equals("0")) {
        //    throw new LockedAccountException("账号已被锁定,请联系管理员！");
        //}
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        //return info;
        //
        //
        //
        //
        //
        //UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
        //String username = authcToken.getUsername();
        //
        //UserService userService = IocKit.getInstance(UserService.class);
        //User user = userService.findByUserName(username);
        //if (null == user) {
        //    throw new AuthenticationException("用户名或者密码错误");
        //}
        //if (user.getAudit_status()!=null&&user.getAudit_status()!=1){
        //    throw new AccountException("该用户未审核，请等待管理员审核");
        //}
        //if (user.getLocked()) {
        //    throw new LockedAccountException("该用户已被锁定");
        //}
        //Person person = user.getPerson();
        //LoginUser loginUser = new LoginUser();
        //loginUser.setUsername(user.getUsername());
        //loginUser.setUserId(user.getUser_id());
        //loginUser.setNickName(person.getNick_name());
        //loginUser.setOrgId(person.getOrg_id());
        //
        //return new SimpleAuthenticationInfo(loginUser, user.getPassword(),getName());





        return null;
    }
}
