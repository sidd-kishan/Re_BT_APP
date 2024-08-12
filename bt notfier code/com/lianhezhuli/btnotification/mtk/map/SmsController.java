/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteException
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.telephony.SmsManager
 *  android.telephony.SmsMessage
 *  android.util.Xml
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.map.BMessage
 *  com.lianhezhuli.btnotification.mtk.map.BTMapService
 *  com.lianhezhuli.btnotification.mtk.map.MessageList
 *  com.lianhezhuli.btnotification.mtk.map.MessageListItem
 *  com.lianhezhuli.btnotification.mtk.map.SmsContentObserver
 *  com.lianhezhuli.btnotification.mtk.map.SmsController$1
 *  com.lianhezhuli.btnotification.mtk.map.VCard
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.utils.PermissionCheckUtils
 *  com.lianhezhuli.btnotification.utils.ToastUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Xml;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.map.BMessage;
import com.lianhezhuli.btnotification.mtk.map.BTMapService;
import com.lianhezhuli.btnotification.mtk.map.MessageList;
import com.lianhezhuli.btnotification.mtk.map.MessageListItem;
import com.lianhezhuli.btnotification.mtk.map.SmsContentObserver;
import com.lianhezhuli.btnotification.mtk.map.SmsController;
import com.lianhezhuli.btnotification.mtk.map.VCard;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.utils.PermissionCheckUtils;
import com.lianhezhuli.btnotification.utils.ToastUtils;
import com.orhanobut.logger.Logger;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

public class SmsController {
    private static final int ADDRESS_COLUMN = 3;
    private static final int BODY_COLUMN = 7;
    private static final int DATE_COLUMN = 2;
    private static final String[] DEFAULT_PROJECTION = new String[]{"_id", "subject", "date", "address", "status", "read", "person", "body", "thread_id", "type", "read"};
    private static final int ID_COLUMN = 0;
    private static final int INVALID_VALUE_ID = -1;
    public static final String MESSAGE_STATUS_SEND_ACTION = "SmsController.action.SEND_MESSAGE";
    private static final int READ_COLUMN = 5;
    private static final int STATUS_COLUMN = 4;
    private static final int TYPE_COLUMN = 9;
    public static String mAddress = null;
    public static String mPerson = null;
    private final String EXTRA_MESSAGE_ID;
    private final String MESSAGE_STATUS_DELIVERED_ACTION;
    private final String MESSAGE_STATUS_SENT_ACTION;
    private final int MESSAGE_TYPE_DELETE;
    private final int SMS_READ_STATUS;
    private final int SMS_UNREAD_STATUS;
    private final String TAG;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final HashMap<Long, Integer> mDeleteFolder = new HashMap();

    public SmsController(Context context) {
        this.TAG = "MAP-SmsController";
        this.MESSAGE_STATUS_SENT_ACTION = "SmsController.action.SENT_RESULT";
        this.MESSAGE_STATUS_DELIVERED_ACTION = "SmsController.action.DELIVERED_RESULT";
        this.EXTRA_MESSAGE_ID = "SmsController.action.SENT_MESSAGE_ID";
        this.SMS_READ_STATUS = 1;
        this.SMS_UNREAD_STATUS = 0;
        this.MESSAGE_TYPE_DELETE = 100;
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        context = new IntentFilter();
        context.addAction("SmsController.action.SENT_RESULT");
        context.addAction("SmsController.action.DELIVERED_RESULT");
        context.addAction(MESSAGE_STATUS_SEND_ACTION);
        1 var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        this.mContext.registerReceiver((BroadcastReceiver)var2_2, (IntentFilter)context);
        context = new SmsContentObserver(this);
        this.mContentResolver.registerContentObserver(Uri.parse((String)"content://sms/"), false, (ContentObserver)context);
        this.mContentResolver.registerContentObserver(Uri.parse((String)"content://mms-sms/conversataions"), false, (ContentObserver)context);
    }

    static /* synthetic */ void access$000(SmsController smsController, Intent intent, int n) {
        smsController.handleSentResult(intent, n);
    }

    static /* synthetic */ void access$100(SmsController smsController, Intent intent, int n) {
        smsController.handleDeliverResult(intent, n);
    }

    private MessageListItem composeMessageItem(Cursor cursor, int n, int n2) {
        MessageListItem messageListItem = new MessageListItem();
        int n3 = this.revertLoadStatus(cursor.getInt(4));
        if (n3 == -1) {
            return null;
        }
        n2 = this.revertReadStatus(cursor.getInt(5));
        if (n2 == -1) {
            return null;
        }
        boolean bl = cursor.getString(7) != null;
        String string = cursor.getString(2);
        messageListItem.setHandle(cursor.getLong(0) | 0x1000000000000000L);
        messageListItem.setSubject(null);
        messageListItem.setDatetime(Long.valueOf(string).longValue());
        string = cursor.getString(3);
        mPerson = Util.getContactName((Context)this.mContext, (String)string);
        if (n == 1) {
            messageListItem.setSenderAddr(string);
            messageListItem.setSenderName(mPerson);
        } else {
            messageListItem.setRecipientAddr(string);
            messageListItem.setRecipientName(mPerson);
        }
        messageListItem.setMsgType();
        if (cursor.getString(7) != null) {
            messageListItem.setSize(cursor.getString(7).length());
        } else {
            messageListItem.setSize(0);
        }
        messageListItem.setText(bl);
        messageListItem.setRecipientStatus(n3);
        messageListItem.setAttachSize();
        messageListItem.setReadStatus(n2);
        messageListItem.setProtected();
        messageListItem.setPriority();
        return messageListItem;
    }

    private int convertMailboxType(String string) {
        if (string == null) {
            return -1;
        }
        if (string.equals("inbox")) {
            return 1;
        }
        if (string.equals("outbox")) {
            return 4;
        }
        if (string.equals("failed")) {
            return 5;
        }
        if (string.equals("sent")) {
            return 2;
        }
        if (string.equals("draft")) {
            return 3;
        }
        if (!string.equals("deleted")) return -1;
        return 100;
    }

    private boolean doesPhoneNumberMatch(String string, String string2, String string3) {
        boolean bl = string2 == null && string3 == null;
        if (string == null) {
            return false;
        }
        if (bl) {
            return true;
        }
        if (string2 != null && this.doesPhoneNumberMatch(string.split(";"), string2.split(";"))) {
            return true;
        }
        if (string3 == null) return false;
        if (!this.isPhoneNumber(string3)) return false;
        return string.contains(string3);
    }

    private boolean doesPhoneNumberMatch(String[] stringArray, String[] stringArray2) {
        if (stringArray == null) return false;
        if (stringArray2 == null) return false;
        if (stringArray.length == 0) return false;
        if (stringArray2.length == 0) {
            return false;
        }
        int n = stringArray2.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray2[n2];
            for (String string2 : stringArray) {
                if (string2.indexOf(string) != 0) return true;
                if (!string.contains(string2)) continue;
                return true;
            }
            ++n2;
        }
        return false;
    }

    private String getEventType(int n) {
        if (n == 1) return "NewMessage";
        if (n == 2) return "MessageDeleted";
        if (n == 3) return "MessageShift";
        return null;
    }

    private Uri getMailboxUri(int n) {
        if (n == 1) return Uri.parse((String)"content://sms/inbox");
        if (n == 2) return Uri.parse((String)"content://sms/sent");
        if (n == 3) return Uri.parse((String)"content://sms/draft");
        if (n == 4) return Uri.parse((String)"content://sms/outbox");
        if (n == 5) return Uri.parse((String)"content://sms/failed");
        return null;
    }

    private void handleDeliverResult(Intent object, int n) {
        Object object2 = (byte[])object.getExtras().get("pdu");
        long l = object.getLongExtra("SmsController.action.SENT_MESSAGE_ID", -1L);
        Uri uri = ContentUris.withAppendedId((Uri)Uri.parse((String)"content://sms/"), (long)l);
        object = new StringBuilder();
        ((StringBuilder)object).append("handleDeliverResult: id is ");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(" pdu is empty? ");
        boolean bl = object2 == null;
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append("result is ");
        ((StringBuilder)object).append(n);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        if (object2 == null) return;
        if (n != -1) return;
        try {
            object = SmsMessage.createFromPdu((byte[])object2);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            outOfMemoryError.printStackTrace();
            object = null;
        }
        if (object == null) {
            return;
        }
        object2 = this.mContentResolver.query(uri, new String[]{"_id"}, null, null, null);
        if (object2 != null && object2.moveToFirst()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(object.getStatus()));
            this.mContentResolver.update(uri, contentValues, null, null);
            Logger.i((String)"update status", (Object[])new Object[0]);
        }
        if (object2 == null) return;
        object2.close();
    }

    private void handleSentResult(Intent object, int n) {
        int n2 = object.getIntExtra("errorCode", 0);
        long l = object.getLongExtra("SmsController.action.SENT_MESSAGE_ID", -1L);
        object = new StringBuilder();
        ((StringBuilder)object).append("handleSentResult:result is ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", error is ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", id is ");
        ((StringBuilder)object).append(l);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        Object object2 = ContentUris.withAppendedId((Uri)Uri.parse((String)"content://sms/"), (long)l);
        object = this.mContentResolver.query((Uri)object2, new String[]{"type"}, null, null, null);
        if (object == null) {
            return;
        }
        if (!object.moveToFirst()) {
            object.close();
            return;
        }
        if (n == -1) {
            n = object.getInt(0);
            if (n == 4) {
                Logger.i((String)"the sms is in outbox", (Object[])new Object[0]);
                this.moveMessageToFolder(this.mContext, (Uri)object2, 2, n2, -1);
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("the message is not in outbox:");
                ((StringBuilder)object2).append(n);
                Logger.i((String)((StringBuilder)object2).toString(), (Object[])new Object[0]);
            }
        } else {
            this.moveMessageToFolder(this.mContext, (Uri)object2, 5, n2, 128);
        }
        object.close();
    }

    private boolean isPhoneNumber(String string) {
        int n = string.length();
        boolean bl = false;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4;
            if (n2 >= n) {
                if (n3 <= 0) return bl;
                bl = true;
                return bl;
            }
            char c = string.charAt(n2);
            if (Character.isDigit(c)) {
                n4 = n3 + 1;
            } else {
                n4 = n3;
                if (c != '*') {
                    n4 = n3;
                    if (c != '#') {
                        n4 = n3;
                        if (c != 'N') {
                            n4 = n3;
                            if (c != '.') {
                                n4 = n3;
                                if (c != ';') {
                                    n4 = n3;
                                    if (c != '-') {
                                        n4 = n3;
                                        if (c != '(') {
                                            n4 = n3;
                                            if (c != ')') {
                                                if (c == ' ') {
                                                    n4 = n3;
                                                } else {
                                                    if (c != '+') return false;
                                                    if (n3 != 0) return false;
                                                    n4 = n3;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ++n2;
            n3 = n4;
        }
    }

    private void moveMessageToFolder(Context context, Uri uri, int n, int n2, int n3) {
        boolean bl;
        block8: {
            switch (n) {
                default: {
                    return;
                }
                case 5: 
                case 6: {
                    n2 = 1;
                    break;
                }
                case 2: 
                case 4: {
                    n2 = 0;
                    bl = true;
                    break block8;
                }
                case 1: 
                case 3: {
                    n2 = 0;
                }
            }
            bl = false;
        }
        context = new ContentValues(3);
        context.put("type", Integer.valueOf(n));
        context.put("status", Integer.valueOf(n3));
        if (n2 != 0) {
            context.put("read", Integer.valueOf(0));
        } else if (bl) {
            context.put("read", Integer.valueOf(1));
        }
        this.mContentResolver.update(uri, (ContentValues)context, null, null);
    }

    private String normalizeString(String string) {
        if (string == null) return null;
        if (string.length() != 0) return string.replaceAll(" ", "").replaceAll("-", "");
        return null;
    }

    private int revertLoadStatus(int n) {
        return 0;
    }

    private int revertReadStatus(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return -1;
    }

    public void clearDeletedMessage() {
        Logger.i((String)"clearDeletedMessage()", (Object[])new Object[0]);
        Uri.parse((String)"content://sms/");
        Iterator<Map.Entry<Long, Integer>> iterator = this.mDeleteFolder.entrySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mDeleteFolder.clear();
                return;
            }
            Long l = iterator.next().getKey();
            Uri uri = ContentUris.withAppendedId((Uri)Uri.parse((String)"content://sms/"), (long)l);
            l = this.mContentResolver.query(uri, new String[]{"type"}, null, null, null);
            if (l != null && l.moveToFirst() && l.getInt(0) == 100) {
                try {
                    this.mContentResolver.delete(uri, null, null);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    // empty catch block
                }
            }
            if (l == null) continue;
            l.close();
        }
    }

    public boolean deleteMessage(long l) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("deleteMessage():id is ");
        charSequence.append(l);
        charSequence = charSequence.toString();
        boolean bl = false;
        Logger.i((String)charSequence, (Object[])new Object[0]);
        MainService mainService = MainService.getInstance();
        charSequence = ContentUris.withAppendedId((Uri)Uri.parse((String)"content://sms/"), (long)l);
        Cursor cursor = this.mContentResolver.query((Uri)charSequence, new String[]{"type"}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int n = cursor.getInt(0);
            if (n == 100) {
                this.mContentResolver.delete((Uri)charSequence, null, null);
                this.mDeleteFolder.remove(l);
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", Integer.valueOf(100));
                this.mContentResolver.update((Uri)charSequence, contentValues, null, null);
                this.mDeleteFolder.put(l, n);
                Logger.i((String)"succeed", (Object[])new Object[0]);
            }
            mainService.sendMapResult(String.valueOf(5));
            bl = true;
            cursor.close();
        } else {
            Logger.i((String)"the message does not exist in SMS provider", (Object[])new Object[0]);
            mainService.sendMapResult(String.valueOf(-5));
        }
        return bl;
    }

    public BMessage getMessage(long l) {
        Logger.i((String)"getMessage()", (Object[])new Object[0]);
        Object object = ContentUris.withAppendedId((Uri)Uri.parse((String)"content://sms/"), (long)(l &= 0xFFFFFFFFFFFFFFFL));
        Cursor cursor = this.mContentResolver.query((Uri)object, DEFAULT_PROJECTION, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String string = cursor.getString(7);
            object = cursor.getString(3);
            int n = cursor.getInt(9);
            String string2 = new String();
            Object object2 = new String();
            if (n == 1) {
                this.normalizeString((String)object);
            } else {
                this.normalizeString((String)object);
                object2 = object;
                object = string2;
            }
            BMessage bMessage = new BMessage();
            bMessage.reset();
            string2 = new VCard();
            string2.setTelephone((String)object);
            bMessage.setOrignator(string2.toString());
            bMessage.setContent(string);
            string2.reset();
            string2.setTelephone((String)object2);
            bMessage.addRecipient(string2.toString());
            bMessage.setReadStatus(this.revertReadStatus(cursor.getInt(5)));
            cursor.close();
            return bMessage;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("find no record for the request : id is ");
        ((StringBuilder)object).append(l);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        return null;
    }

    public MessageList getMessageList(int n, int n2, String charSequence) {
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("permission READ_SMS == ");
        charSequence2.append(PermissionCheckUtils.check((String[])new String[]{"android.permission.READ_SMS"}));
        charSequence2 = charSequence2.toString();
        boolean bl = false;
        Logger.e((String)charSequence2, (Object[])new Object[0]);
        if (!PermissionCheckUtils.check((String[])new String[]{"android.permission.READ_SMS"})) {
            ToastUtils.showLong((Context)MApplication.getInstance(), (int)2131755126);
            return null;
        }
        int n3 = this.convertMailboxType((String)charSequence);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        String[] stringArray = DEFAULT_PROJECTION;
        if (n3 != 100) {
            charSequence2 = this.getMailboxUri(n3);
            charSequence = charSequence2;
            if (charSequence2 == null) {
                Logger.i((String)"unrecognized mailbox uri", (Object[])new Object[0]);
                return null;
            }
        } else {
            charSequence = Uri.parse((String)"content://sms/");
        }
        try {
            charSequence2 = this.mContentResolver.query((Uri)charSequence, stringArray, stringBuilder.toString(), arrayList.toArray(new String[arrayList.size()]), "date DESC");
            if (charSequence2 == null) {
                return null;
            }
        }
        catch (SQLiteException sQLiteException) {
            sQLiteException.printStackTrace();
            Logger.i((String)"fail to query", (Object[])new Object[0]);
            return null;
        }
        charSequence = new MessageList();
        int n4 = 0;
        while (charSequence2.moveToNext() && (n == 0 || charSequence.getCurrentSize() < n)) {
            if (charSequence2.getInt(5) == 1) {
                bl = true;
            }
            charSequence2.getString(3);
            if (n > 0) {
                charSequence.addMessageItem(this.composeMessageItem((Cursor)charSequence2, n3, n2));
            }
            ++n4;
            charSequence.addSize(1);
        }
        charSequence2.close();
        if (bl) {
            charSequence.setNewMessage();
        }
        charSequence.addSize(n4);
        return charSequence;
    }

    public void onMessageEvent(Long l, String charSequence, int n) {
        if ("MessageDeleted".equals(this.getEventType(n))) {
            BTMapService.mKeys.add(l);
        }
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onMessageEvent arrived: ");
        ((StringBuilder)object).append(this.getEventType(n));
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        XmlSerializer xmlSerializer = Xml.newSerializer();
        object = new StringWriter();
        try {
            xmlSerializer.setOutput((Writer)object);
            xmlSerializer.startDocument("UTF-8", false);
            xmlSerializer.startTag(null, "MAP-event-report");
            xmlSerializer.attribute(null, "version", "1.0");
            xmlSerializer.startTag(null, "event");
            xmlSerializer.attribute(null, "type", this.getEventType(n));
            xmlSerializer.attribute(null, "handle", String.valueOf(l | 0x1000000000000000L));
            xmlSerializer.attribute(null, "folder", (String)charSequence);
            xmlSerializer.attribute(null, "msg_type", "SMS_GSM");
            xmlSerializer.endTag(null, "event");
            xmlSerializer.endTag(null, "MAP-event-report");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
        }
        catch (Exception exception) {
            Logger.e((String)"error occurred while creating xml file", (Object[])new Object[0]);
        }
        l = MainService.getInstance();
        try {
            object = ((StringWriter)object).toString().getBytes("UTF-8");
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(String.valueOf(7));
            ((StringBuilder)charSequence).append(" 2 0 ");
            ((StringBuilder)charSequence).append(String.valueOf(((Object)object).length));
            ((StringBuilder)charSequence).append(" ");
            l.sendMapDResult(((StringBuilder)charSequence).toString());
            l.sendMapData((byte[])object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
    }

    public void onStop() {
        this.clearDeletedMessage();
    }

    public boolean pushMessage(String string, String object) {
        if (object == null) {
            return false;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Start to Push message, the telephone is:");
        charSequence.append(string);
        charSequence.append(" and the text is:");
        charSequence.append((String)object);
        Logger.i((String)charSequence.toString(), (Object[])new Object[0]);
        long l = -1L;
        String string2 = "\n";
        charSequence = object;
        if (object != null) {
            charSequence = object;
            if (!((String)object).equals("\n")) {
                charSequence = ((String)object).trim();
            }
        }
        object = ((String)charSequence).equals("") ? string2 : charSequence;
        string = this.normalizeString(string);
        charSequence = new ContentValues();
        charSequence.put("type", 4);
        charSequence.put("date", System.currentTimeMillis());
        charSequence.put("address", string);
        charSequence.put("read", 1);
        charSequence.put("body", (String)object);
        charSequence.put("status", 64);
        charSequence.put("seen", 0);
        charSequence = this.mContentResolver.insert(Uri.parse((String)"content://sms/"), (ContentValues)charSequence);
        long l2 = l;
        if (charSequence != null) {
            charSequence = this.mContentResolver.query((Uri)charSequence, new String[]{"_id"}, null, null, null);
            l2 = l;
            if (charSequence != null) {
                l2 = l;
                if (charSequence.moveToFirst()) {
                    l2 = charSequence.getLong(0);
                    charSequence.close();
                }
            }
        }
        if (string == null) return true;
        charSequence = SmsManager.getDefault();
        if (object == null) {
            return false;
        }
        ArrayList arrayList = charSequence.divideMessage((String)object);
        object = new ArrayList(arrayList.size());
        ArrayList<PendingIntent> arrayList2 = new ArrayList<PendingIntent>(arrayList.size());
        int n = 0;
        while (true) {
            if (n >= arrayList.size()) {
                charSequence.sendMultipartTextMessage(string, null, arrayList, arrayList2, (ArrayList)object);
                return true;
            }
            string2 = new Intent("SmsController.action.SENT_RESULT");
            Intent intent = new Intent("SmsController.action.DELIVERED_RESULT");
            string2.putExtra("SmsController.action.SENT_MESSAGE_ID", l2);
            intent.putExtra("SmsController.action.SENT_MESSAGE_ID", l2);
            if (n == arrayList.size() - 1) {
                string2.putExtra("SmsController.action.FINAL_MESSAGE", true);
                intent.putExtra("SmsController.action.FINAL_MESSAGE", true);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                ((ArrayList)object).add(PendingIntent.getBroadcast((Context)this.mContext, (int)0, (Intent)intent, (int)0x14000000));
                arrayList2.add(PendingIntent.getBroadcast((Context)this.mContext, (int)n, (Intent)string2, (int)0x14000000));
            } else {
                ((ArrayList)object).add(PendingIntent.getBroadcast((Context)this.mContext, (int)0, (Intent)intent, (int)0x10000000));
                arrayList2.add(PendingIntent.getBroadcast((Context)this.mContext, (int)n, (Intent)string2, (int)0x10000000));
            }
            ++n;
        }
    }

    public boolean setMessageStatus(long l, int n) {
        MainService mainService = MainService.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMessageStatus():id is ");
        stringBuilder.append(l);
        stringBuilder.append(", state is ");
        stringBuilder.append(n);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        Uri uri = ContentUris.withAppendedId((Uri)Uri.parse((String)"content://sms/"), (long)l);
        if (n == -1) {
            Logger.i((String)"the status to be set is invalid", (Object[])new Object[0]);
            return false;
        }
        stringBuilder = this.mContentResolver.query(uri, new String[]{"read"}, null, null, null);
        if (stringBuilder != null && stringBuilder.moveToFirst()) {
            if (stringBuilder.getInt(0) == n) {
                Logger.i((String)"state is same, no need to update", (Object[])new Object[0]);
                mainService.sendMapResult(String.valueOf(-5));
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("read", Integer.valueOf(n));
                this.mContentResolver.update(uri, contentValues, null, null);
                mainService.sendMapResult(String.valueOf(5));
            }
            stringBuilder.close();
        } else {
            mainService.sendMapResult(String.valueOf(-5));
        }
        return true;
    }
}
