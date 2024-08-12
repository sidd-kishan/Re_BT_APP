/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.util.Base64
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 */
package com.lianhezhuli.btnotification.mtk.data;

import android.graphics.Bitmap;
import android.util.Base64;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlSerializer;

public class NotificationMessageBody
extends MessageBody {
    private String mAppId = null;
    private String mIcon = null;
    private String mTickerText = null;
    private String mTitle = null;

    public void genXmlBuff(XmlSerializer xmlSerializer) throws IllegalArgumentException, IllegalStateException, IOException {
        xmlSerializer.startTag(null, "body");
        if (this.getSender() != null) {
            xmlSerializer.startTag(null, "sender");
            xmlSerializer.text(this.getSender());
            xmlSerializer.endTag(null, "sender");
        }
        if (this.getAppID() != null) {
            xmlSerializer.startTag(null, "appId");
            xmlSerializer.text(this.getAppID());
            xmlSerializer.endTag(null, "appId");
        }
        if (this.getIcon() != null) {
            xmlSerializer.startTag(null, "icon");
            xmlSerializer.cdsect(this.getIcon());
            xmlSerializer.endTag(null, "icon");
        }
        if (this.getTitle() != null) {
            xmlSerializer.startTag(null, "title");
            xmlSerializer.cdsect(this.getTitle());
            xmlSerializer.endTag(null, "title");
        }
        if (this.getContent() != null) {
            xmlSerializer.startTag(null, "content");
            xmlSerializer.cdsect(this.getContent());
            xmlSerializer.endTag(null, "content");
        }
        if (this.getTickerText() != null) {
            xmlSerializer.startTag(null, "ticker_text");
            xmlSerializer.cdsect(this.getTickerText());
            xmlSerializer.endTag(null, "ticker_text");
        }
        if (this.getTimestamp() != 0) {
            xmlSerializer.startTag(null, "timestamp");
            xmlSerializer.text(String.valueOf(this.getTimestamp()));
            xmlSerializer.endTag(null, "timestamp");
        }
        xmlSerializer.endTag(null, "body");
    }

    public String getAppID() {
        return this.mAppId;
    }

    String getIcon() {
        return this.mIcon;
    }

    public String getTickerText() {
        return this.mTickerText;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setAppID(String string) {
        this.mAppId = string;
    }

    public void setIcon(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)byteArrayOutputStream);
        this.mIcon = Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)0);
    }

    public void setTickerText(String string) {
        this.mTickerText = string;
    }

    public void setTitle(String string) {
        this.mTitle = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (this.getSender() != null) {
            stringBuilder.append(this.getSender());
        }
        stringBuilder.append(", ");
        if (this.getIcon() != null) {
            stringBuilder.append(this.getIcon());
        }
        stringBuilder.append(", ");
        if (this.getIcon() != null) {
            stringBuilder.append(this.getAppID());
        }
        stringBuilder.append(", ");
        if (this.getTitle() != null) {
            stringBuilder.append(this.getTitle());
        }
        stringBuilder.append(", ");
        if (this.getContent() != null) {
            stringBuilder.append(this.getContent());
        }
        stringBuilder.append(", ");
        if (this.getTickerText() != null) {
            stringBuilder.append(this.getTickerText());
        }
        stringBuilder.append(", ");
        if (this.getTimestamp() != 0) {
            stringBuilder.append(String.valueOf(this.getTimestamp()));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
