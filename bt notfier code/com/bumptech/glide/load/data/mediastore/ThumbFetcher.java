/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.data.ExifOrientationStream
 *  com.bumptech.glide.load.data.mediastore.ThumbFetcher$ImageThumbnailQuery
 *  com.bumptech.glide.load.data.mediastore.ThumbFetcher$VideoThumbnailQuery
 *  com.bumptech.glide.load.data.mediastore.ThumbnailQuery
 *  com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 */
package com.bumptech.glide.load.data.mediastore;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.data.mediastore.ThumbnailQuery;
import com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher
implements DataFetcher<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final ThumbnailStreamOpener opener;

    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    private static ThumbFetcher build(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        ArrayPool arrayPool = Glide.get((Context)context).getArrayPool();
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.get((Context)context).getRegistry().getImageHeaderParsers(), thumbnailQuery, arrayPool, context.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return ThumbFetcher.build(context, uri, (ThumbnailQuery)new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return ThumbFetcher.build(context, uri, (ThumbnailQuery)new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream openThumbInputStream() throws FileNotFoundException {
        InputStream inputStream = this.opener.open(this.mediaStoreImageUri);
        int n = inputStream != null ? this.opener.getOrientation(this.mediaStoreImageUri) : -1;
        InputStream inputStream2 = inputStream;
        if (n == -1) return inputStream2;
        inputStream2 = new ExifOrientationStream(inputStream, n);
        return inputStream2;
    }

    public void cancel() {
    }

    /*
     * Enabled force condition propagation
     */
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream == null) return;
        try {
            inputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority object, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            object = this.openThumbInputStream();
            this.inputStream = object;
        }
        catch (FileNotFoundException fileNotFoundException) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                Log.d((String)TAG, (String)"Failed to find thumbnail file", (Throwable)fileNotFoundException);
            }
            dataCallback.onLoadFailed((Exception)fileNotFoundException);
            return;
        }
        dataCallback.onDataReady(object);
    }
}
