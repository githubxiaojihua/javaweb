package com.xiaojihua.bean;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * 实现HttpSessionActivationListener，来实现bean 在sesion中的钝化和活化
 * 当服务器正常关闭的情况下session并不会销毁，而是将相关内容写如到了磁盘，这个就是
 * 钝化，当服务器启动的时候会从磁盘中读取session这就是活化。
 *
 * session在浏览器关闭的时候并不会销毁，只是消失，信息仍然存在与服务器中。
 * session的销毁只有在非正常关闭服务器，session超时(tomcat中设置），或者手动设置invlidate的时候
 * 才会销毁
 *
 * 注意当bean要实现活化钝化的时候应该实现seriablizble接口
 *
 * 一开始是没有办法使用活化的因为：
 * 序列化的文件存放到了Using CATALINA_BASE:   "C:\Users\Administrator\.IntelliJIdea2018.1\system\tomcat\Unnamed_javaWeb"
 * 对应的项目文件中，
 * 而在项目启动的时候会清空，这个目录因此，就不会有活化因为找不到相关文件
 * 解决方法是指定序列化的地址：
 * 在${TOMCAT_HOME}/conf 下的context.xml文件的Context节点下添加以下内容:
 * <Manager className="org.apache.catalina.session.PersistentManager" saveOnRestart="true">
 *     <Store className="org.apache.catalina.session.FileStore" directory="D:\Develop\Tomcat\apache-tomcat-8.0.53\conf\Session"/>
 * </Manager>
 * 将上面的directory的目录换到别的地方，就可以了
 *
 * 同样这个listener也不需要配置web.xml
 *
 */
public class C02User2 implements HttpSessionActivationListener,Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public C02User2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public C02User2() {
    }

    //钝化
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("session中的bean放到了磁盘中（钝化）");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("从服务器磁盘中把数据活化到session中（活化）");
    }
}
