/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  androidx.startup.AppInitializer
 *  androidx.startup.StartupException
 */
package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.startup.AppInitializer;
import androidx.startup.StartupException;

public final class InitializationProvider
extends ContentProvider {
    public int delete(Uri uri, String string, String[] stringArray) {
        throw new IllegalStateException("Not allowed.");
    }

    public String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    public boolean onCreate() {
        Context context = this.getContext();
        if (context == null) throw new StartupException("Context cannot be null");
        AppInitializer.getInstance((Context)context).discoverAndInitialize();
        return true;
    }

    public Cursor query(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2) {
        throw new IllegalStateException("Not allowed.");
    }

    public int update(Uri uri, ContentValues contentValues, String string, String[] stringArray) {
        throw new IllegalStateException("Not allowed.");
    }
}
