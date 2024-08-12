/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.database.Cursor
 *  android.net.Uri
 *  android.util.Log
 *  com.lianhezhuli.btnotification.mtk.map.SmsContentObserver
 *  com.lianhezhuli.btnotification.mtk.map.SmsController
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.lianhezhuli.btnotification.mtk.map.SmsContentObserver;
import com.lianhezhuli.btnotification.mtk.map.SmsController;
import java.util.HashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public class SmsContentObserver.DatabaseMonitor
extends Thread {
    public static final int MONITER_TYPE_ONLY_QUERY = 0;
    public static final int MONITER_TYPE_QUERY_AND_NOTIFY = 1;
    private int mQueryType;
    final SmsContentObserver this$0;

    public SmsContentObserver.DatabaseMonitor(SmsContentObserver smsContentObserver, int n) {
        this.this$0 = smsContentObserver;
        this.mQueryType = 0;
        this.mQueryType = n;
    }

    private void query() {
        synchronized (this) {
            this.queryMessage(SmsContentObserver.access$000((SmsContentObserver)this.this$0));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("query: size->");
            stringBuilder.append(SmsContentObserver.access$000((SmsContentObserver)this.this$0).size());
            Log.i((String)"MessageObserver", (String)stringBuilder.toString());
            return;
        }
    }

    private void queryAndNotify() {
        synchronized (this) {
            try {
                HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
                this.queryMessage(hashMap);
                Object object = new StringBuilder();
                ((StringBuilder)object).append("database has been changed, mType is  previous size is ");
                ((StringBuilder)object).append(SmsContentObserver.access$000((SmsContentObserver)this.this$0).size());
                ((StringBuilder)object).append("current size is ");
                ((StringBuilder)object).append(hashMap.size());
                Log.i((String)"MessageObserver", (String)((StringBuilder)object).toString());
                if (SmsContentObserver.access$000((SmsContentObserver)this.this$0).size() < hashMap.size()) {
                    object = hashMap.entrySet().iterator();
                    while (object.hasNext()) {
                        Long l = (Long)((Map.Entry)object.next()).getKey();
                        String string = this.revertMailboxType(hashMap.get(l));
                        if (SmsContentObserver.access$000((SmsContentObserver)this.this$0).containsKey(l) || string == null || !string.equals("inbox")) continue;
                        SmsController smsController = SmsContentObserver.access$100((SmsContentObserver)this.this$0);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("telecom/msg/");
                        stringBuilder.append(string);
                        smsController.onMessageEvent(l, stringBuilder.toString(), 1);
                        l = new Intent();
                        l.setAction("com.lianhezhuli.btnotification.SMS_RECEIVED");
                        SmsContentObserver.access$200().sendBroadcast((Intent)l);
                    }
                } else {
                    for (Map.Entry entry : SmsContentObserver.access$000((SmsContentObserver)this.this$0).entrySet()) {
                        Object object2;
                        CharSequence charSequence;
                        object = (Long)entry.getKey();
                        if (!hashMap.containsKey(object)) {
                            charSequence = this.revertMailboxType((Integer)SmsContentObserver.access$000((SmsContentObserver)this.this$0).get(object));
                            object2 = SmsContentObserver.access$100((SmsContentObserver)this.this$0);
                            entry = new StringBuilder();
                            ((StringBuilder)((Object)entry)).append("telecom/msg/");
                            ((StringBuilder)((Object)entry)).append((String)charSequence);
                            object2.onMessageEvent((Long)object, ((StringBuilder)((Object)entry)).toString(), 2);
                            continue;
                        }
                        entry = this.revertMailboxType((Integer)entry.getValue());
                        object2 = this.revertMailboxType(hashMap.get(object));
                        if (object2 == null || entry == null || ((String)((Object)entry)).equals(object2) || ((String)object2).equals("deleted")) continue;
                        object2 = SmsContentObserver.access$100((SmsContentObserver)this.this$0);
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("telecom/msg/");
                        ((StringBuilder)charSequence).append((String)((Object)entry));
                        object2.onMessageEvent((Long)object, ((StringBuilder)charSequence).toString(), 3);
                    }
                }
                SmsContentObserver.access$002((SmsContentObserver)this.this$0, hashMap);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void queryMessage(HashMap<Long, Integer> hashMap) {
        Throwable throwable22222;
        Cursor cursor2;
        Cursor cursor;
        block6: {
            cursor = null;
            cursor2 = null;
            try {
                block7: {
                    try {
                        Cursor cursor3 = SmsContentObserver.access$200().getContentResolver().query(Uri.parse((String)"content://sms/"), new String[]{"_id", "type"}, null, null, null);
                        if (cursor3 != null) {
                            while (true) {
                                cursor2 = cursor3;
                                cursor = cursor3;
                                if (!cursor3.moveToNext()) break;
                                cursor2 = cursor3;
                                cursor = cursor3;
                                hashMap.put(cursor3.getLong(0), cursor3.getInt(1));
                            }
                        }
                        if (cursor3 == null) return;
                        cursor = cursor3;
                        break block6;
                    }
                    catch (Exception exception) {
                        if (cursor == null) break block7;
                        cursor2 = cursor;
                        cursor.close();
                    }
                }
                if (cursor == null) return;
            }
            catch (Throwable throwable22222) {}
        }
        cursor.close();
        return;
        if (cursor2 == null) throw throwable22222;
        cursor2.close();
        throw throwable22222;
    }

    private String revertMailboxType(int n) {
        if (n == 1) return "inbox";
        if (n == 2) return "sent";
        if (n == 3) return "draft";
        if (n == 4) return "outbox";
        return "deleted";
    }

    @Override
    public void run() {
        int n = this.mQueryType;
        if (n == 0) {
            try {
                this.query();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (1 == n) {
            try {
                this.queryAndNotify();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid monitor type:");
            stringBuilder.append(this.mQueryType);
            Log.i((String)"MessageObserver", (String)stringBuilder.toString());
        }
    }
}
