/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.util.Log
 *  com.luck.picture.lib.widget.longimage.DecoderFactory
 *  com.luck.picture.lib.widget.longimage.ImageRegionDecoder
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.luck.picture.lib.widget.longimage.DecoderFactory;
import com.luck.picture.lib.widget.longimage.ImageRegionDecoder;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis ignored.
 */
private static class SubsamplingScaleImageView.TilesInitTask
extends AsyncTask<Void, Void, int[]> {
    private final WeakReference<Context> contextRef;
    private ImageRegionDecoder decoder;
    private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
    private Exception exception;
    private final Uri source;
    private final WeakReference<SubsamplingScaleImageView> viewRef;

    SubsamplingScaleImageView.TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
        this.viewRef = new WeakReference<SubsamplingScaleImageView>(subsamplingScaleImageView);
        this.contextRef = new WeakReference<Context>(context);
        this.decoderFactoryRef = new WeakReference<DecoderFactory<? extends ImageRegionDecoder>>(decoderFactory);
        this.source = uri;
    }

    protected int[] doInBackground(Void ... subsamplingScaleImageView) {
        block2: {
            int n;
            int n2;
            int n3;
            try {
                String string = this.source.toString();
                Context context = (Context)this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory)this.decoderFactoryRef.get();
                subsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
                if (context == null) return null;
                if (decoderFactory == null) return null;
                if (subsamplingScaleImageView == null) return null;
                SubsamplingScaleImageView.access$5100((SubsamplingScaleImageView)subsamplingScaleImageView, (String)"TilesInitTask.doInBackground", (Object[])new Object[0]);
                decoderFactory = (ImageRegionDecoder)decoderFactory.make();
                this.decoder = decoderFactory;
                decoderFactory = decoderFactory.init(context, this.source);
                n3 = decoderFactory.x;
                n2 = decoderFactory.y;
                n = SubsamplingScaleImageView.access$5200((SubsamplingScaleImageView)subsamplingScaleImageView, (Context)context, (String)string);
                if (SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)subsamplingScaleImageView) == null) return new int[]{n3, n2, n};
                n3 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)subsamplingScaleImageView).width();
                n2 = SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)subsamplingScaleImageView).height();
            }
            catch (Exception exception) {
                Log.e((String)SubsamplingScaleImageView.access$5400(), (String)"Failed to initialise bitmap decoder", (Throwable)exception);
                this.exception = exception;
                break block2;
            }
            return new int[]{n3, n2, n};
        }
        return null;
    }

    protected void onPostExecute(int[] nArray) {
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
        if (subsamplingScaleImageView == null) return;
        ImageRegionDecoder imageRegionDecoder = this.decoder;
        if (imageRegionDecoder != null && nArray != null && nArray.length == 3) {
            SubsamplingScaleImageView.access$5500((SubsamplingScaleImageView)subsamplingScaleImageView, (ImageRegionDecoder)imageRegionDecoder, (int)nArray[0], (int)nArray[1], (int)nArray[2]);
        } else {
            if (this.exception == null) return;
            if (SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView) == null) return;
            SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView).onImageLoadError(this.exception);
        }
    }
}
