package org.example.demo_email.service;

import org.example.demo_email.entity.MailSetting;

public interface IMailSettingService {
    MailSetting getSetting();
    void save(MailSetting mailSetting);
}
