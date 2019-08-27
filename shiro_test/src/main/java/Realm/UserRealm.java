package Realm;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserRealm extends AuthorizingRealm {
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取权限权限列表
		 Iterator<String> iter = principals.fromRealm(getName()).iterator();
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                info.addStringPermissions(Arrays.asList("q1","q2","q3"));   //数据库查询你结果
                return info;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// 进行登陆操作
		 try {
	            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
	            String name = token.getUsername();
	            String password = new String(token.getPassword());
	            if (true) {  //改为是否用户名密码正确
	                return new SimpleAuthenticationInfo(name,password, getName());
	            }
	            return null;
	        } catch (Exception e) {
	            return null;
	        }
	}
}