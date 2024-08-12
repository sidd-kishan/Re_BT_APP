/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.AsyncQueryHandler
 *  android.content.Context
 *  android.content.Intent
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.IBinder
 *  android.provider.ContactsContract$CommonDataKinds$Phone
 *  com.lianhezhuli.btnotification.mtk.service.MAsyncTask
 *  com.lianhezhuli.btnotification.mtk.service.T9Service$MyAsyncQueryHandler
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.app.Service;
import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.provider.ContactsContract;
import com.lianhezhuli.btnotification.mtk.service.MAsyncTask;
import com.lianhezhuli.btnotification.mtk.service.T9Service;

public class T9Service
extends Service {
    private static final String LOGTAG = "T9Service";
    private AsyncQueryHandler asyncQuery;

    static /* synthetic */ void access$000(T9Service t9Service, Cursor cursor) {
        t9Service.querying(cursor);
    }

    private void querying(Cursor cursor) {
        MAsyncTask.startRequestServerData((Context)this, (Handler)new /* Unavailable Anonymous Inner Class!! */, (Cursor)cursor);
    }

    protected void initSQL() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        this.asyncQuery.startQuery(0, null, uri, new String[]{"_id", "display_name", "data1", "sort_key", "contact_id"}, null, null, "sort_key COLLATE LOCALIZED asc");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onRebind(Intent intent) {
    }

    public void onStart(Intent intent, int n) {
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        System.out.println("T9Service-begin");
        this.asyncQuery = new MyAsyncQueryHandler(this, this.getContentResolver());
        this.initSQL();
        return super.onStartCommand(intent, n, n2);
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
