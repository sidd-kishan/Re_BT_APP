/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.format.Time
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.text.format.Time;
import java.io.UnsupportedEncodingException;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class MessageListItem {
    private int AttachSize;
    private String DateTime;
    private long MsgHandle;
    private int OrignalMsgSize;
    private String RecipientAddr;
    private String RecipientName;
    private int RecipientStatus;
    private String SenderAddr;
    private String SenderName;
    private String Subject;
    private boolean bPriority;
    private boolean bProtected;
    private boolean bText;
    private ArrayList<String> mMessageItemFeildList = null;
    private int read;

    private String convertMillisToUtc(long l) {
        Time time = new Time();
        time.set(l);
        return time.toString().substring(0, 15);
    }

    private String encode(String object) {
        if (object == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object = new StringCharacterIterator((String)object);
        char c = ((StringCharacterIterator)object).current();
        while (c != '\uffff') {
            if (c == '<') {
                stringBuilder.append("&lt;");
            } else if (c == '>') {
                stringBuilder.append("&gt;");
            } else if (c == '\"') {
                stringBuilder.append("&quot;");
            } else if (c == '\'') {
                stringBuilder.append("&apos;");
            } else if (c == '&') {
                stringBuilder.append("&amp;");
            } else {
                stringBuilder.append(c);
            }
            c = ((StringCharacterIterator)object).next();
        }
        return stringBuilder.toString();
    }

    public ArrayList<String> getMessageItem() {
        ArrayList<String> arrayList = this.mMessageItemFeildList;
        if (arrayList != null) {
            return arrayList;
        }
        arrayList = new ArrayList();
        this.mMessageItemFeildList = arrayList;
        arrayList.add(0, String.valueOf(this.MsgHandle));
        this.mMessageItemFeildList.add(1, this.Subject);
        this.mMessageItemFeildList.add(2, this.DateTime);
        this.mMessageItemFeildList.add(3, this.SenderName);
        this.mMessageItemFeildList.add(4, this.SenderAddr);
        this.mMessageItemFeildList.add(5, this.RecipientName);
        this.mMessageItemFeildList.add(6, this.RecipientAddr);
        this.mMessageItemFeildList.add(7, "SMS_GSM");
        this.mMessageItemFeildList.add(8, String.valueOf(this.OrignalMsgSize));
        this.mMessageItemFeildList.add(9, String.valueOf(this.bText));
        this.mMessageItemFeildList.add(10, String.valueOf(this.RecipientStatus));
        this.mMessageItemFeildList.add(11, String.valueOf(this.AttachSize));
        this.mMessageItemFeildList.add(12, String.valueOf(this.bPriority));
        this.mMessageItemFeildList.add(13, String.valueOf(this.read));
        this.mMessageItemFeildList.add(14, String.valueOf(true));
        this.mMessageItemFeildList.add(15, String.valueOf(this.bProtected));
        return this.mMessageItemFeildList;
    }

    public void set(String string, long l, String string2, String string3, String string4, String string5, String string6, int n, int n2, boolean bl, int n3, int n4, int n5, boolean bl2) {
        synchronized (this) {
            this.setSubject(string);
            this.setDatetime(l);
            this.SenderAddr = string2;
            this.SenderName = string3;
            this.RecipientName = string5;
            this.RecipientAddr = string6;
            this.RecipientStatus = n3;
            this.OrignalMsgSize = n2;
            this.bText = bl;
            this.bPriority = false;
            this.read = n5;
            this.bProtected = bl2;
            return;
        }
    }

    public void setAttachSize() {
        this.AttachSize = 0;
    }

    public void setDatetime(long l) {
        this.DateTime = this.convertMillisToUtc(l);
    }

    public void setHandle(long l) {
        this.MsgHandle = l;
    }

    public void setMsgType() {
    }

    public void setPriority() {
        this.bPriority = false;
    }

    public void setProtected() {
        this.bProtected = false;
    }

    public void setReadStatus(int n) {
        this.read = n;
    }

    public void setRecipientAddr(String string) {
        this.RecipientAddr = string;
    }

    public void setRecipientName(String string) {
        this.RecipientName = this.encode(string);
    }

    public void setRecipientStatus(int n) {
        this.RecipientStatus = n;
    }

    public void setSenderAddr(String string) {
        this.SenderAddr = string;
    }

    public void setSenderName(String string) {
        this.SenderName = this.encode(string);
    }

    public void setSize(int n) {
        this.OrignalMsgSize = n;
    }

    public void setSubject(String object) {
        if (object == null) {
            return;
        }
        String string = this.encode((String)object);
        if (((Object)(object = (Object)string.getBytes())).length > 254) {
            try {
                this.Subject = string = new String((byte[])object, 0, 253, "utf-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {}
        } else {
            this.Subject = string;
        }
    }

    public void setText(boolean bl) {
        this.bText = bl;
    }
}
