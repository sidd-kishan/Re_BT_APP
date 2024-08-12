/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.mtk.data.NoDataException
 */
package com.lianhezhuli.btnotification.mtk.data;

import com.lianhezhuli.btnotification.mtk.data.NoDataException;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public class MessageHeader {
    private String mAction = null;
    private String mCategory = null;
    private int mMsgId = 0;
    private String mSubType = null;

    public void genXmlBuff(XmlSerializer xmlSerializer) throws IllegalArgumentException, IllegalStateException, IOException, NoDataException {
        if (this.getCategory() == null) throw new NoDataException();
        if (this.getSubType() == null) throw new NoDataException();
        if (this.getMsgId() == 0) throw new NoDataException();
        if (this.getAction() == null) throw new NoDataException();
        xmlSerializer.startTag(null, "header");
        xmlSerializer.startTag(null, "category");
        xmlSerializer.text(this.getCategory());
        xmlSerializer.endTag(null, "category");
        xmlSerializer.startTag(null, "subType");
        xmlSerializer.text(this.getSubType());
        xmlSerializer.endTag(null, "subType");
        xmlSerializer.startTag(null, "msgId");
        xmlSerializer.text(String.valueOf(this.getMsgId()));
        xmlSerializer.endTag(null, "msgId");
        xmlSerializer.startTag(null, "action");
        xmlSerializer.text(this.getAction());
        xmlSerializer.endTag(null, "action");
        xmlSerializer.endTag(null, "header");
    }

    String getAction() {
        return this.mAction;
    }

    String getCategory() {
        return this.mCategory;
    }

    public int getMsgId() {
        return this.mMsgId;
    }

    public String getSubType() {
        return this.mSubType;
    }

    public void setAction(String string) {
        this.mAction = string;
    }

    public void setCategory(String string) {
        this.mCategory = string;
    }

    public void setMsgId(int n) {
        this.mMsgId = n;
    }

    public void setSubType(String string) {
        this.mSubType = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getCategory());
        stringBuilder.append(this.getSubType());
        stringBuilder.append(this.getMsgId());
        stringBuilder.append(this.getAction());
        return stringBuilder.toString();
    }
}
