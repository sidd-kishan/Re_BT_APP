/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Log
 *  com.bumptech.glide.load.ImageHeaderParser
 *  com.bumptech.glide.load.ImageHeaderParserUtils
 *  com.bumptech.glide.load.data.mediastore.FileService
 *  com.bumptech.glide.load.data.mediastore.ThumbnailQuery
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 */
package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.mediastore.FileService;
import com.bumptech.glide.load.data.mediastore.ThumbnailQuery;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver);
    }

    private String getPath(Uri uri) {
        if ((uri = this.query.query(uri)) == null) return null;
        try {
            if (!uri.moveToFirst()) return null;
            String string = uri.getString(0);
            return string;
        }
        finally {
            if (uri != null) {
                uri.close();
            }
        }
    }

    private boolean isValid(File file) {
        boolean bl = this.service.exists(file) && 0L < this.service.length(file);
        return bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    int getOrientation(Uri uri) {
        Throwable throwable2;
        Object object;
        block12: {
            Object object2;
            Object object3;
            block13: {
                int n;
                InputStream inputStream;
                object3 = null;
                object2 = null;
                object = null;
                try {
                    inputStream = this.contentResolver.openInputStream(uri);
                    object = inputStream;
                    object3 = inputStream;
                    object2 = inputStream;
                    n = ImageHeaderParserUtils.getOrientation(this.parsers, (InputStream)inputStream, (ArrayPool)this.byteArrayPool);
                    if (inputStream == null) return n;
                }
                catch (Throwable throwable2) {
                    break block12;
                }
                catch (NullPointerException nullPointerException) {
                    object2 = object3;
                    object3 = nullPointerException;
                    break block13;
                }
                catch (IOException iOException) {
                    // empty catch block
                    break block13;
                }
                try {
                    inputStream.close();
                    return n;
                }
                catch (IOException iOException) {
                    return n;
                }
            }
            object = object2;
            {
                if (Log.isLoggable((String)TAG, (int)3)) {
                    object = object2;
                    object = object2;
                    StringBuilder stringBuilder = new StringBuilder();
                    object = object2;
                    stringBuilder.append("Failed to open uri: ");
                    object = object2;
                    stringBuilder.append(uri);
                    object = object2;
                    Log.d((String)TAG, (String)stringBuilder.toString(), (Throwable)object3);
                }
                if (object2 == null) return -1;
            }
            try {
                ((InputStream)object2).close();
                return -1;
            }
            catch (IOException iOException) {
                return -1;
            }
        }
        if (object == null) throw throwable2;
        try {}
        catch (IOException iOException) {
            throw throwable2;
        }
        ((InputStream)object).close();
        throw throwable2;
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        Object object = this.getPath(uri);
        if (TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        if (!this.isValid((File)(object = this.service.get((String)object)))) {
            return null;
        }
        object = Uri.fromFile((File)object);
        try {
            InputStream inputStream = this.contentResolver.openInputStream((Uri)object);
            return inputStream;
        }
        catch (NullPointerException nullPointerException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NPE opening uri: ");
            stringBuilder.append(uri);
            stringBuilder.append(" -> ");
            stringBuilder.append(object);
            throw (FileNotFoundException)new FileNotFoundException(stringBuilder.toString()).initCause(nullPointerException);
        }
    }
}
