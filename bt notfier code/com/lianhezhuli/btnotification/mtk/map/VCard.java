/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.util.Log;

public class VCard {
    private static final String BEGIN = "BEGIN:VCARD";
    private static final String CRLF = "\r\n";
    private static final String EMAIL = "EMAIL";
    private static final String END = "END:VCARD";
    private static final String FORMAT_NAME = "FN";
    private static final String NAME = "N";
    private static final String SEPRATOR = ":";
    public static final String TELEPHONE = "TEL";
    private static final String VERSION = "VERSION";
    private static final String VERSION_21 = "2.1";
    private static final String VERSION_30 = "3.0";
    private String mEmail;
    private String mFormatName;
    private String mName;
    private String mTelephone;
    private String mVersion = "2.1";

    public VCard() {
        this.mVersion = VERSION_21;
    }

    public VCard(String string) {
        this.mVersion = !string.equals(VERSION_21) && !string.equals(VERSION_30) ? VERSION_21 : string;
    }

    private void log(String string) {
        if (string == null) return;
        Log.v((String)"VCard", (String)string);
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getFormatName() {
        return this.mFormatName;
    }

    public String getName() {
        return this.mName;
    }

    public String getTelephone() {
        return this.mTelephone;
    }

    public void parse(String string) {
        if (string == null) {
            return;
        }
        String[] stringArray = string.split(CRLF);
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            Object object = stringArray[n2].split(SEPRATOR);
            if (((String[])object).length >= 2) {
                string = object[0].trim();
                object = object[1].trim();
                if (string.equals(NAME)) {
                    this.mName = object;
                } else if (string.equals(FORMAT_NAME)) {
                    this.mFormatName = object;
                } else if (string.equals(TELEPHONE)) {
                    this.mTelephone = object;
                } else if (string.equals(EMAIL)) {
                    this.mEmail = object;
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("unrecognized key:");
                    ((StringBuilder)object).append(string);
                    this.log(((StringBuilder)object).toString());
                }
            }
            ++n2;
        }
    }

    public void reset() {
        this.mEmail = null;
        this.mTelephone = null;
        this.mFormatName = null;
        this.mName = null;
    }

    public void setEmail(String string) {
        this.mEmail = string;
    }

    public void setFormatName(String string) {
        this.mFormatName = string;
    }

    public void setName(String string) {
        this.mName = string;
    }

    public void setTelephone(String string) {
        this.mTelephone = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BEGIN);
        stringBuilder.append(CRLF);
        stringBuilder.append(VERSION);
        stringBuilder.append(SEPRATOR);
        stringBuilder.append(this.mVersion);
        stringBuilder.append(CRLF);
        stringBuilder.append(NAME);
        stringBuilder.append(SEPRATOR);
        String string = this.mName;
        if (string != null) {
            stringBuilder.append(string);
        }
        stringBuilder.append(CRLF);
        if (this.mVersion.equals(VERSION_30)) {
            stringBuilder.append(FORMAT_NAME);
            stringBuilder.append(SEPRATOR);
            if (this.mName != null) {
                stringBuilder.append(this.mFormatName);
            }
            stringBuilder.append(CRLF);
        }
        if (this.mTelephone != null) {
            stringBuilder.append(TELEPHONE);
            stringBuilder.append(SEPRATOR);
            stringBuilder.append(this.mTelephone);
            stringBuilder.append(CRLF);
        }
        if (this.mEmail != null) {
            stringBuilder.append(EMAIL);
            stringBuilder.append(SEPRATOR);
            stringBuilder.append(this.mEmail);
            stringBuilder.append(CRLF);
        }
        stringBuilder.append(END);
        return stringBuilder.toString();
    }
}
