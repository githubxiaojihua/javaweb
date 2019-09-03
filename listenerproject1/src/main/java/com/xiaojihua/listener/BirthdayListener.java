package com.xiaojihua.listener;

import com.xiaojihua.dao.User;
import com.xiaojihua.service.BirthdayService;
import com.xiaojihua.utils.DateUtils;
import com.xiaojihua.utils.MailUtils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BirthdayListener implements ServletContextListener {
    BirthdayService service = new BirthdayService();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Timer timer = new Timer();
        System.out.println("开始发送邮件的时间：" + new Date().toLocaleString());
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                List<User> users = null;
                try {
                    users  = service.getUsers();
                    if(users != null){
                        for(User user : users){
                            String msg = "亲爱的" + user.getUsername() + ",生日快乐！";
                            MailUtils.sendMail(user.getEmail(),msg);
                            System.out.println(user.getUsername() + ":邮件发送成功！");
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            //注销这一句是调用了DateUtils的一些方法设置了从第二天凌晨0点开始，每隔一天的时间执行任务
            //这里为了测试使用后面那一句
        //},DateUtils.getDelayTime(),DateUtils.getOneDay());
        },4000,1000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
