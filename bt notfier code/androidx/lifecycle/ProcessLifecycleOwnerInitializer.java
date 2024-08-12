/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  androidx.lifecycle.LifecycleDispatcher
 *  androidx.lifecycle.ProcessLifecycleOwner
 */
package androidx.lifecycle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.lifecycle.LifecycleDispatcher;
import androidx.lifecycle.ProcessLifecycleOwner;

public class ProcessLifecycleOwnerInitializer
extends ContentProvider {
    public int delete(Uri uri, String string, String[] stringArray) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        LifecycleDispatcher.init((Context)this.getContext());
        ProcessLifecycleOwner.init((Context)this.getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string, String[] stringArray) {
        return 0;
    }
}
