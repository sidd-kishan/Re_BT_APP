/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$MediaScannerConnectionClient
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.luck.picture.lib.PictureMediaScannerConnection$ScanListener
 */
package com.luck.picture.lib;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.PictureMediaScannerConnection;

public class PictureMediaScannerConnection
implements MediaScannerConnection.MediaScannerConnectionClient {
    private ScanListener mListener;
    private final MediaScannerConnection mMs;
    private final String mPath;

    public PictureMediaScannerConnection(Context context, String string) {
        this.mPath = string;
        context = new MediaScannerConnection(context.getApplicationContext(), (MediaScannerConnection.MediaScannerConnectionClient)this);
        this.mMs = context;
        context.connect();
    }

    public PictureMediaScannerConnection(Context context, String string, ScanListener scanListener) {
        this.mListener = scanListener;
        this.mPath = string;
        context = new MediaScannerConnection(context.getApplicationContext(), (MediaScannerConnection.MediaScannerConnectionClient)this);
        this.mMs = context;
        context.connect();
    }

    public void onMediaScannerConnected() {
        if (TextUtils.isEmpty((CharSequence)this.mPath)) return;
        this.mMs.scanFile(this.mPath, null);
    }

    public void onScanCompleted(String string, Uri uri) {
        this.mMs.disconnect();
        string = this.mListener;
        if (string == null) return;
        string.onScanFinish();
    }
}
