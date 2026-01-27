package org.example.demo_email.repository;

import org.example.demo_email.entity.MailSetting;

public interface IMailSettingRepository {
    MailSetting getSetting();
    void save(MailSetting mailSetting);
}
