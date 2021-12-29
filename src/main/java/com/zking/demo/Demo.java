package com.zking.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Demo {

    public static void main(String[] args) {
        //1.读取加载shiro.ini配置文件
        IniSecurityManagerFactory ini=new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        //2.创建SecurityManager安全管理器
        SecurityManager securityManager = ini.getInstance();
        //3.将SecurityManager委托给SecurityUtils管理
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取主体
        Subject subject = SecurityUtils.getSubject();
        //创建令牌进行登录判断
        UsernamePasswordToken token=new UsernamePasswordToken(
                "zs","123"
        );
        //进行登录判断
        try {
            subject.login(token);//需要捕获异常
            System.out.println("登录成功！");
            /*//身份验证（角色判断）
            if(subject.hasRole("emp")){
                System.out.println("员工，");
            }
            if(subject.hasRole("man")){
                System.out.println("经理，");
            }
            if(subject.hasRole("ceo")){
                System.out.println("董事长");
            }*/

            //判断权限
            if(subject.isPermitted("user:view")){
                System.out.println("具备查询所有的权限");
            }

        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误！");
        } catch (UnknownAccountException e){
            System.out.println("账号不存在！");
        }


    }
}
