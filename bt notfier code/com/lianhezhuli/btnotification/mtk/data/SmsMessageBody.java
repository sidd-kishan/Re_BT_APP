/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 */
package com.lianhezhuli.btnotification.mtk.data;

import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public class SmsMessageBody
extends MessageBody {
    private String mNumber = null;

    public void genXmlBuff(XmlSerializer xmlSerializer) throws IllegalArgumentException, IllegalStateException, IOException {
        xmlSerializer.startTag(null, "body");
        if (this.getSender() != null) {
            xmlSerializer.startTag(null, "sender");
            xmlSerializer.text(this.getSender());
            xmlSerializer.endTag(null, "sender");
        }
        if (this.getNumber() != null) {
            xmlSerializer.startTag(null, "number");
            xmlSerializer.text(this.getNumber());
            xmlSerializer.endTag(null, "number");
        }
        if (this.getContent() != null) {
            xmlSerializer.startTag(null, "content");
            xmlSerializer.text(this.getContent());
            xmlSerializer.endTag(null, "content");
        }
        if (this.getTimestamp() != 0) {
            xmlSerializer.startTag(null, "timestamp");
            xmlSerializer.text(String.valueOf(this.getTimestamp()));
            xmlSerializer.endTag(null, "timestamp");
        }
        xmlSerializer.endTag(null, "body");
    }

    public String getNumber() {
        return this.mNumber;
    }

    public void setNumber(String string) {
        this.mNumber = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (this.getSender() != null) {
            stringBuilder.append(this.getSender());
        }
        stringBuilder.append(", ");
        if (this.getNumber() != null) {
            stringBuilder.append(this.getNumber());
        }
        stringBuilder.append(", ");
        if (this.getContent() != null) {
            stringBuilder.append(this.getContent());
        }
        stringBuilder.append(", ");
        if (this.getTimestamp() != 0) {
            stringBuilder.append(String.valueOf(this.getTimestamp()));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
