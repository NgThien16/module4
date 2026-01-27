package org.example.demo_email.service;

import org.example.demo_email.entity.MailSetting;
import org.example.demo_email.repository.IMailSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSettingService implements IMailSettingService {

    @Autowired
    private IMailSettingRepository repository;

    @Override
    public MailSetting getSetting() {
        MailSetting setting = repository.getSetting();
        if (setting == null) {
            setting = new MailSetting();
            setting.setLanguage("English");
            setting.setPageSize(25);
            setting.setSpamFilter(false);
            setting.setSignature("");
            repository.save(setting);
        }
        return setting;
    }

    @Override
    public void save(MailSetting mailSetting) {
        repository.save(mailSetting);
    }
}
