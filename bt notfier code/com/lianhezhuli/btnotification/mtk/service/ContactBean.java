/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.mtk.service;

import java.io.Serializable;

public class ContactBean
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int contactId;
    private String formattedNumber;
    private String lookUpKey;
    private String name;
    private String number;
    private String photo;
    private Long photoId;
    private String pinyin;
    private int selected = 0;
    private String sortKey;
    private String sortLetters;

    public static long getSerialversionuid() {
        return 1L;
    }

    public int getContactId() {
        return this.contactId;
    }

    public String getFormattedNumber() {
        return this.formattedNumber;
    }

    public String getLookUpKey() {
        return this.lookUpKey;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number.replaceAll(" ", "");
    }

    public String getPhoto() {
        return this.photo;
    }

    public Long getPhotoId() {
        return this.photoId;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public int getSelected() {
        return this.selected;
    }

    public String getSortKey() {
        return this.sortKey;
    }

    public String getSortLetters() {
        return this.sortLetters;
    }

    public void setContactId(int n) {
        this.contactId = n;
    }

    public void setFormattedNumber(String string) {
        this.formattedNumber = string;
    }

    public void setLookUpKey(String string) {
        this.lookUpKey = string;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setNumber(String string) {
        this.number = string;
    }

    public void setPhoto(String string) {
        this.photo = string;
    }

    public void setPhotoId(Long l) {
        this.photoId = l;
    }

    public void setPinyin(String string) {
        this.pinyin = string;
    }

    public void setSelected(int n) {
        this.selected = n;
    }

    public void setSortKey(String string) {
        this.sortKey = string;
    }

    public void setSortLetters(String string) {
        this.sortLetters = string;
    }
}
