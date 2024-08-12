/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.mtk.data;

import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public abstract class MessageBody {
    private String mContent = null;
    private String mSender = null;
    private int mTimestamp = 0;

    public abstract void genXmlBuff(XmlSerializer var1) throws IllegalArgumentException, IllegalStateException, IOException;

    public String getContent() {
        return this.mContent;
    }

    String getSender() {
        return this.mSender;
    }

    int getTimestamp() {
        return this.mTimestamp;
    }

    public void setContent(String string) {
        this.mContent = string;
    }

    public void setSender(String string) {
        this.mSender = string;
    }

    public void setTimestamp(int n) {
        this.mTimestamp = n;
    }
}
