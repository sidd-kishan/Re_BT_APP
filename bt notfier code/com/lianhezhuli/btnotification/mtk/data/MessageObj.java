/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.BitmapFactory
 *  android.util.Base64
 *  android.util.Xml
 *  com.lianhezhuli.btnotification.mtk.data.CallMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageBody
 *  com.lianhezhuli.btnotification.mtk.data.MessageHeader
 *  com.lianhezhuli.btnotification.mtk.data.NoDataException
 *  com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody
 *  com.lianhezhuli.btnotification.mtk.data.SmsMessageBody
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.data;

import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Xml;
import com.lianhezhuli.btnotification.mtk.data.CallMessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageBody;
import com.lianhezhuli.btnotification.mtk.data.MessageHeader;
import com.lianhezhuli.btnotification.mtk.data.NoDataException;
import com.lianhezhuli.btnotification.mtk.data.NotificationMessageBody;
import com.lianhezhuli.btnotification.mtk.data.SmsMessageBody;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class MessageObj {
    public static final String ACTION = "action";
    public static final String ACTION_ADD = "add";
    public static final String ACTION_DEL = "delete";
    public static final String ACTION_DELALL = "deleteAll";
    public static final String ACTION_UPDATE = "update";
    public static final String APPID = "appId";
    public static final String BODY = "body";
    public static final String CATEGORY = "category";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_NOTI = "notification";
    public static final String CHARSET = "UTF-8";
    public static final String CONTENT = "content";
    public static final String HEADER = "header";
    public static final String ICON = "icon";
    private static final String LOG_TAG = "NcenterDataObj";
    public static final String MISSED_CALL_COUNT = "missed_call_count";
    public static final String MSGID = "msgId";
    public static final String NUMBER = "number";
    public static final String SENDER = "sender";
    public static final String SUBTYPE = "subType";
    public static final String SUBTYPE_BLOCK = "block_sender";
    public static final String SUBTYPE_MISSED_CALL = "missed_call";
    public static final String SUBTYPE_NOTI = "text";
    public static final String SUBTYPE_SMS = "sms";
    public static final String TICKER_TEXT = "ticker_text";
    public static final String TIEMSTAMP = "timestamp";
    public static final String TITLE = "title";
    private static final String XML_HEADER = "event_report";
    private MessageBody mDataBody;
    private MessageHeader mDataHeader;

    private void parseBody(XmlPullParser object, String string, MessageObj messageObj) throws XmlPullParserException, IOException {
        messageObj = messageObj.getDataBody();
        if (string.equals(CONTENT)) {
            messageObj.setContent(object.nextText());
        } else if (string.equals(TIEMSTAMP)) {
            messageObj.setTimestamp(Integer.parseInt(object.nextText()));
        } else if (string.equals(SENDER)) {
            messageObj.setSender(object.nextText());
        } else if (string.equals(APPID)) {
            ((NotificationMessageBody)messageObj).setAppID(object.nextText());
        } else if (string.equals(ICON)) {
            string = (NotificationMessageBody)messageObj;
            object = Base64.decode((String)object.nextText(), (int)0);
            string.setIcon(BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)((Object)object).length));
        } else if (string.equals(NUMBER)) {
            ((SmsMessageBody)messageObj).setNumber(object.nextText());
        } else {
            Logger.i((String)"parseBody()", (Object[])new Object[0]);
        }
    }

    private void parseHeader(XmlPullParser xmlPullParser, String string, MessageObj messageObj) throws XmlPullParserException, IOException {
        MessageHeader messageHeader = messageObj.getDataHeader();
        MessageBody messageBody = messageObj.getDataBody();
        if (string.equals(CATEGORY)) {
            messageHeader.setCategory(xmlPullParser.nextText());
        } else if (string.equals(SUBTYPE)) {
            messageHeader.setSubType(xmlPullParser.nextText());
        } else if (string.equals(MSGID)) {
            messageHeader.setMsgId(Integer.parseInt(xmlPullParser.nextText()));
        } else if (string.equals(ACTION)) {
            messageHeader.setAction(xmlPullParser.nextText());
        } else if (string.equals(BODY)) {
            if (messageHeader.getSubType().equals(SUBTYPE_NOTI)) {
                xmlPullParser = new NotificationMessageBody();
            } else if (messageHeader.getSubType().equals(SUBTYPE_SMS)) {
                xmlPullParser = new SmsMessageBody();
            } else if (messageHeader.getSubType().equals(SUBTYPE_BLOCK)) {
                xmlPullParser = new NotificationMessageBody();
            } else {
                xmlPullParser = messageBody;
                if (messageHeader.getSubType().equals(SUBTYPE_MISSED_CALL)) {
                    xmlPullParser = new CallMessageBody();
                }
            }
            messageObj.setDataBody((MessageBody)xmlPullParser);
        } else if (messageBody != null) {
            this.parseBody(xmlPullParser, string, messageObj);
        } else {
            Logger.i((String)"parseHeader()", (Object[])new Object[0]);
        }
    }

    public byte[] genXmlBuff() throws IllegalArgumentException, IllegalStateException, IOException, XmlPullParserException, NoDataException {
        StringWriter stringWriter = new StringWriter();
        MessageHeader messageHeader = this.getDataHeader();
        MessageBody messageBody = this.getDataBody();
        XmlSerializer xmlSerializer = Xml.newSerializer();
        xmlSerializer.setOutput(stringWriter);
        xmlSerializer.startDocument(CHARSET, true);
        xmlSerializer.startTag(null, XML_HEADER);
        if (messageHeader != null) {
            messageHeader.genXmlBuff(xmlSerializer);
        }
        if (messageBody != null) {
            messageBody.genXmlBuff(xmlSerializer);
        }
        if (messageHeader == null || messageBody == null) {
            Logger.i((String)"genXmlBuff() header or body is null", (Object[])new Object[0]);
        }
        xmlSerializer.endTag(null, XML_HEADER);
        xmlSerializer.endDocument();
        return stringWriter.toString().getBytes(CHARSET);
    }

    public MessageBody getDataBody() {
        return this.mDataBody;
    }

    public MessageHeader getDataHeader() {
        return this.mDataHeader;
    }

    public MessageObj parseXml(byte[] object) throws XmlPullParserException, IOException {
        object = new String((byte[])object);
        Charset.forName(CHARSET).encode((String)object);
        Logger.i((String)"parseXml()", (Object[])new Object[0]);
        object = new StringReader((String)object);
        MessageObj messageObj = new MessageObj();
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput((Reader)object);
        int n = xmlPullParser.getEventType();
        object = null;
        while (1 != n) {
            String string = xmlPullParser.getName();
            if (n == 2) {
                if (string.equals(HEADER)) {
                    object = new MessageHeader();
                    messageObj.setDataHeader((MessageHeader)object);
                } else if (object != null) {
                    this.parseHeader(xmlPullParser, string, messageObj);
                } else {
                    Logger.i((String)"parseXml()", (Object[])new Object[0]);
                }
            }
            n = xmlPullParser.next();
        }
        return messageObj;
    }

    public void setDataBody(MessageBody messageBody) {
        this.mDataBody = messageBody;
    }

    public void setDataHeader(MessageHeader messageHeader) {
        this.mDataHeader = messageHeader;
    }
}
