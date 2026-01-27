package org.example.demo_email.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mail_setting")
public class MailSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String language;

    @Column(name = "page_size")
    private int pageSize;

    @Column(name = "spam_filter")
    private boolean spamFilter;

    @Column(columnDefinition = "TEXT")
    private String signature;

    public MailSetting() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
