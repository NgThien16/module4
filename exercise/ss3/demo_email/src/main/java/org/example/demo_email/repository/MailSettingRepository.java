package org.example.demo_email.repository;

import org.example.demo_email.entity.MailSetting;
import org.example.demo_email.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class MailSettingRepository implements IMailSettingRepository {

    @Override
    public MailSetting getSetting() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.createQuery("from MailSetting", MailSetting.class)
                .setMaxResults(1)
                .uniqueResult();
    }

    @Override
    public void save(MailSetting mailSetting) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(mailSetting);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
