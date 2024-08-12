/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.AsyncQueryHandler
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  com.lianhezhuli.btnotification.mtk.service.T9Service
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import com.lianhezhuli.btnotification.mtk.service.T9Service;

/*
 * Exception performing whole class analysis ignored.
 */
private class T9Service.MyAsyncQueryHandler
extends AsyncQueryHandler {
    final T9Service this$0;

    public T9Service.MyAsyncQueryHandler(T9Service t9Service, ContentResolver contentResolver) {
        this.this$0 = t9Service;
        super(contentResolver);
    }

    protected void onQueryComplete(int n, Object object, Cursor cursor) {
        T9Service.access$000((T9Service)this.this$0, (Cursor)cursor);
    }
}
