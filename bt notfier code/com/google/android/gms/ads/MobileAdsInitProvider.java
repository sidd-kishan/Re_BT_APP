/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzbht
 */
package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzbht;

public class MobileAdsInitProvider
extends ContentProvider {
    private final zzbht zza = new zzbht();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zza.attachInfo(context, providerInfo);
    }

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
        return false;
    }

    public Cursor query(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string, String[] stringArray) {
        return 0;
    }
}
