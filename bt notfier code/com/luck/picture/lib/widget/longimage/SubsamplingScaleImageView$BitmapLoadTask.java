/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  com.luck.picture.lib.widget.longimage.DecoderFactory
 *  com.luck.picture.lib.widget.longimage.ImageDecoder
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.luck.picture.lib.widget.longimage.DecoderFactory;
import com.luck.picture.lib.widget.longimage.ImageDecoder;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis ignored.
 */
private static class SubsamplingScaleImageView.BitmapLoadTask
extends AsyncTask<Void, Void, Integer> {
    private Bitmap bitmap;
    private final WeakReference<Context> contextRef;
    private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
    private Exception exception;
    private final boolean preview;
    private final Uri source;
    private final WeakReference<SubsamplingScaleImageView> viewRef;

    SubsamplingScaleImageView.BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean bl) {
        this.viewRef = new WeakReference<SubsamplingScaleImageView>(subsamplingScaleImageView);
        this.contextRef = new WeakReference<Context>(context);
        this.decoderFactoryRef = new WeakReference<DecoderFactory<? extends ImageDecoder>>(decoderFactory);
        this.source = uri;
        this.preview = bl;
    }

    protected Integer doInBackground(Void ... decoderFactory) {
        block3: {
            int n;
            try {
                String string = this.source.toString();
                Context context = (Context)this.contextRef.get();
                decoderFactory = (DecoderFactory)this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
                if (context == null) return null;
                if (decoderFactory == null) return null;
                if (subsamplingScaleImageView == null) return null;
                SubsamplingScaleImageView.access$5100((SubsamplingScaleImageView)subsamplingScaleImageView, (String)"BitmapLoadTask.doInBackground", (Object[])new Object[0]);
                this.bitmap = ((ImageDecoder)decoderFactory.make()).decode(context, this.source);
                n = SubsamplingScaleImageView.access$5200((SubsamplingScaleImageView)subsamplingScaleImageView, (Context)context, (String)string);
            }
            catch (OutOfMemoryError outOfMemoryError) {
                Log.e((String)SubsamplingScaleImageView.access$5400(), (String)"Failed to load bitmap - OutOfMemoryError", (Throwable)outOfMemoryError);
                this.exception = new RuntimeException(outOfMemoryError);
                break block3;
            }
            catch (Exception exception) {
                Log.e((String)SubsamplingScaleImageView.access$5400(), (String)"Failed to load bitmap", (Throwable)exception);
                this.exception = exception;
                break block3;
            }
            return n;
        }
        return null;
    }

    protected void onPostExecute(Integer n) {
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
        if (subsamplingScaleImageView == null) return;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && n != null) {
            if (this.preview) {
                SubsamplingScaleImageView.access$6000((SubsamplingScaleImageView)subsamplingScaleImageView, (Bitmap)bitmap);
            } else {
                SubsamplingScaleImageView.access$6100((SubsamplingScaleImageView)subsamplingScaleImageView, (Bitmap)bitmap, (int)n, (boolean)false);
            }
        } else {
            if (this.exception == null) return;
            if (SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView) == null) return;
            if (this.preview) {
                SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView).onPreviewLoadError(this.exception);
            } else {
                SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView).onImageLoadError(this.exception);
            }
        }
    }
}
