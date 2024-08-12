/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.mtk.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BMessage {
    private static final String BEGINBBODY = "BEGIN:BBODY";
    private static final String BEGINBENV = "BEGIN:BENV";
    private static final String BEGINBMSG = "BEGIN:BMSG";
    private static final String BEGINMSG = "BEGIN:MSG";
    private static final String CHARSET = "CHARSET:UTF-8";
    public static final String CRLF = "\r\n";
    private static final String ENDBBODY = "END:BBODY";
    private static final String ENDBENV = "END:BENV";
    private static final String ENDBMSG = "END:BMSG";
    private static final String ENDMSG = "END:MSG";
    private static final String FOLDER = "FOLDER";
    private static final String LENGTH = "LENGTH";
    public static final String SEPRATOR = ":";
    private static final String STATUS = "STATUS";
    private static final String STATUSREAD = "READ";
    private static final String STATUSUNREAD = "UNREAD";
    private static final String TYPE = "TYPE:SMS_GSM";
    private static final String VERSION = "VERSION";
    private static final String VERSION_10 = "1.0";
    private String mBody;
    private ArrayList<Integer> mContentSize;
    private String mOrignator;
    private int mReadStatus;
    private ArrayList<String> mRecipient;
    private ArrayList<Integer> mRecipientSize;
    private long mWholeSize;

    public BMessage() {
        this.initCache();
    }

    private void initCache() {
        this.mRecipient = new ArrayList();
        this.mRecipientSize = new ArrayList();
        this.mContentSize = new ArrayList();
    }

    public boolean addRecipient(String string) {
        if (string == null) {
            return true;
        }
        this.mRecipientSize.add(string.length());
        this.mRecipient.add(string);
        return true;
    }

    public int getContentSize(int n) {
        if (n >= this.mContentSize.size()) return 0;
        return this.mContentSize.get(n);
    }

    public long getContentSize() {
        return this.mWholeSize;
    }

    public String getFinalRecipient() {
        if (this.mRecipient.size() <= 0) return null;
        ArrayList<String> arrayList = this.mRecipient;
        return arrayList.get(arrayList.size() - 1);
    }

    String getOrignator() {
        return this.mOrignator;
    }

    int getReadStatus() {
        return this.mReadStatus;
    }

    ArrayList<String> getRecipient() {
        return this.mRecipient;
    }

    public void reset() {
        this.mReadStatus = -1;
        this.mOrignator = null;
        ArrayList<Object> arrayList = this.mRecipientSize;
        if (arrayList != null) {
            arrayList.clear();
        }
        if ((arrayList = this.mRecipient) != null) {
            arrayList.clear();
        }
        if ((arrayList = this.mContentSize) != null) {
            arrayList.clear();
        }
        this.mWholeSize = 0L;
    }

    public boolean setContent(String string) {
        this.mBody = string;
        return true;
    }

    public boolean setContentSize(int n) {
        this.mWholeSize = n;
        this.mContentSize.add(n);
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean setContentSize(File file) {
        if (file == null) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int n = fileInputStream.available();
            this.mWholeSize = n;
            this.mContentSize.add(n);
            fileInputStream.close();
            return true;
        }
        catch (IOException iOException) {
            return true;
        }
    }

    public boolean setOrignator(String string) {
        this.mOrignator = string;
        return true;
    }

    public void setReadStatus(int n) {
        this.mReadStatus = n != 0 && n != 1 ? 1 : n;
    }

    /*
     * Unable to fully structure code
     */
    public String toString() {
        var1_1 = new StringBuilder();
        var1_1.append("BEGIN:BMSG");
        var1_1.append("\r\n");
        var1_1.append("VERSION");
        var1_1.append(":");
        var1_1.append("1.0");
        var1_1.append("\r\n");
        var1_1.append("STATUS");
        var1_1.append(":");
        if (this.getReadStatus() == 1) {
            var1_1.append("READ");
        } else {
            var1_1.append("UNREAD");
        }
        var1_1.append("\r\n");
        var1_1.append("TYPE:SMS_GSM");
        var1_1.append("\r\n");
        var1_1.append("FOLDER");
        var1_1.append(":");
        var1_1.append("\r\n");
        var1_1.append(this.getOrignator());
        var1_1.append("\r\n");
        var1_1.append("BEGIN:BENV");
        var1_1.append("\r\n");
        var1_1.append(this.getRecipient());
        var1_1.append("\r\n");
        var1_1.append("BEGIN:BBODY");
        var1_1.append("\r\n");
        var1_1.append("CHARSET:UTF-8");
        var1_1.append("\r\n");
        var1_1.append("LENGTH");
        var1_1.append(":");
        try {
            if (this.mBody == null) {
                this.mBody = "\n";
                var1_1.append("0");
            } else {
                var1_1.append(String.valueOf(this.mBody.getBytes("UTF-8").length));
            }
lbl68:
            // 3 sources

            while (true) {
                var1_1.append("\r\n");
                break;
            }
        }
        catch (Exception var2_2) {
            ** continue;
        }
        var1_1.append("BEGIN:MSG");
        var1_1.append("\r\n");
        var1_1.append(this.mBody);
        var1_1.append("\r\n");
        var1_1.append("END:MSG");
        var1_1.append("\r\n");
        var1_1.append("END:BBODY");
        var1_1.append("\r\n");
        var1_1.append("END:BENV");
        var1_1.append("\r\n");
        var1_1.append("END:BMSG");
        return var1_1.toString();
    }
}
