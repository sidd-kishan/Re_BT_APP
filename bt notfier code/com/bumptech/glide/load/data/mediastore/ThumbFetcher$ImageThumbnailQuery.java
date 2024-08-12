/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.MediaStore$Images$Thumbnails
 *  com.bumptech.glide.load.data.mediastore.ThumbnailQuery
 */
package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bumptech.glide.load.data.mediastore.ThumbnailQuery;

static class ThumbFetcher.ImageThumbnailQuery
implements ThumbnailQuery {
    private static final String[] PATH_PROJECTION = new String[]{"_data"};
    private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
    private final ContentResolver contentResolver;

    ThumbFetcher.ImageThumbnailQuery(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public Cursor query(Uri object) {
        object = object.getLastPathSegment();
        return this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{object}, null);
    }
}
