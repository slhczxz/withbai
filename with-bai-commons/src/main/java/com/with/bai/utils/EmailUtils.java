package com.with.bai.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import jdk.nashorn.internal.objects.annotations.ScriptClass;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailUtils {
    @Autowired
    Email email;

    public void send(String subject, String msg, String... toList) {
        try {
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(toList);
            email.setSSLOnConnect(true);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }


}
