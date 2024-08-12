/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 */
package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;
import java.io.FileNotFoundException;

private static class MediaStoreFileLoader.FilePathFetcher
implements DataFetcher<File> {
    private static final String[] PROJECTION = new String[]{"_data"};
    private final Context context;
    private final Uri uri;

    MediaStoreFileLoader.FilePathFetcher(Context context, Uri uri) {
        this.context = context;
        this.uri = uri;
    }

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<File> getDataClass() {
        return File.class;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority object, DataFetcher.DataCallback<? super File> dataCallback) {
        Cursor cursor = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
        object = null;
        Object var3_5 = null;
        if (cursor != null) {
            object = var3_5;
            try {
                if (cursor.moveToFirst()) {
                    object = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                }
            }
            finally {
                cursor.close();
            }
        }
        if (TextUtils.isEmpty((CharSequence)object)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to find file path for: ");
            ((StringBuilder)object).append(this.uri);
            dataCallback.onLoadFailed((Exception)new FileNotFoundException(((StringBuilder)object).toString()));
        } else {
            dataCallback.onDataReady((Object)new File((String)object));
        }
    }
}
