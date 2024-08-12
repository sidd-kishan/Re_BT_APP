/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.os.AsyncTask
 *  android.util.Log
 *  com.luck.picture.lib.widget.longimage.ImageRegionDecoder
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$Tile
 */
package com.luck.picture.lib.widget.longimage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import com.luck.picture.lib.widget.longimage.ImageRegionDecoder;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis ignored.
 */
private static class SubsamplingScaleImageView.TileLoadTask
extends AsyncTask<Void, Void, Bitmap> {
    private final WeakReference<ImageRegionDecoder> decoderRef;
    private Exception exception;
    private final WeakReference<SubsamplingScaleImageView.Tile> tileRef;
    private final WeakReference<SubsamplingScaleImageView> viewRef;

    SubsamplingScaleImageView.TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, SubsamplingScaleImageView.Tile tile) {
        this.viewRef = new WeakReference<SubsamplingScaleImageView>(subsamplingScaleImageView);
        this.decoderRef = new WeakReference<ImageRegionDecoder>(imageRegionDecoder);
        this.tileRef = new WeakReference<SubsamplingScaleImageView.Tile>(tile);
        SubsamplingScaleImageView.Tile.access$4002((SubsamplingScaleImageView.Tile)tile, (boolean)true);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected Bitmap doInBackground(Void ... object) {
        SubsamplingScaleImageView.Tile tile;
        block6: {
            ImageRegionDecoder imageRegionDecoder;
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
                imageRegionDecoder = (ImageRegionDecoder)this.decoderRef.get();
                tile = (SubsamplingScaleImageView.Tile)this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !SubsamplingScaleImageView.Tile.access$400((SubsamplingScaleImageView.Tile)tile)) break block6;
                SubsamplingScaleImageView.access$5100((SubsamplingScaleImageView)subsamplingScaleImageView, (String)"TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", (Object[])new Object[]{SubsamplingScaleImageView.Tile.access$4100((SubsamplingScaleImageView.Tile)tile), SubsamplingScaleImageView.Tile.access$4300((SubsamplingScaleImageView.Tile)tile)});
                object = SubsamplingScaleImageView.access$5700((SubsamplingScaleImageView)subsamplingScaleImageView);
                synchronized (object) {
                }
            }
            catch (OutOfMemoryError outOfMemoryError) {
                Log.e((String)SubsamplingScaleImageView.access$5400(), (String)"Failed to decode tile - OutOfMemoryError", (Throwable)outOfMemoryError);
                this.exception = new RuntimeException(outOfMemoryError);
                return null;
            }
            catch (Exception exception) {
                Log.e((String)SubsamplingScaleImageView.access$5400(), (String)"Failed to decode tile", (Throwable)exception);
                this.exception = exception;
                return null;
            }
            {
                SubsamplingScaleImageView.access$5800((SubsamplingScaleImageView)subsamplingScaleImageView, (Rect)SubsamplingScaleImageView.Tile.access$4100((SubsamplingScaleImageView.Tile)tile), (Rect)SubsamplingScaleImageView.Tile.access$5000((SubsamplingScaleImageView.Tile)tile));
                if (SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)subsamplingScaleImageView) == null) return imageRegionDecoder.decodeRegion(SubsamplingScaleImageView.Tile.access$5000((SubsamplingScaleImageView.Tile)tile), SubsamplingScaleImageView.Tile.access$4300((SubsamplingScaleImageView.Tile)tile));
                SubsamplingScaleImageView.Tile.access$5000((SubsamplingScaleImageView.Tile)tile).offset(SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)subsamplingScaleImageView).left, SubsamplingScaleImageView.access$5300((SubsamplingScaleImageView)subsamplingScaleImageView).top);
                return imageRegionDecoder.decodeRegion(SubsamplingScaleImageView.Tile.access$5000((SubsamplingScaleImageView.Tile)tile), SubsamplingScaleImageView.Tile.access$4300((SubsamplingScaleImageView.Tile)tile));
            }
        }
        if (tile == null) return null;
        SubsamplingScaleImageView.Tile.access$4002((SubsamplingScaleImageView.Tile)tile, (boolean)false);
        return null;
    }

    protected void onPostExecute(Bitmap bitmap) {
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView)this.viewRef.get();
        SubsamplingScaleImageView.Tile tile = (SubsamplingScaleImageView.Tile)this.tileRef.get();
        if (subsamplingScaleImageView == null) return;
        if (tile == null) return;
        if (bitmap != null) {
            SubsamplingScaleImageView.Tile.access$502((SubsamplingScaleImageView.Tile)tile, (Bitmap)bitmap);
            SubsamplingScaleImageView.Tile.access$4002((SubsamplingScaleImageView.Tile)tile, (boolean)false);
            SubsamplingScaleImageView.access$5900((SubsamplingScaleImageView)subsamplingScaleImageView);
        } else {
            if (this.exception == null) return;
            if (SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView) == null) return;
            SubsamplingScaleImageView.access$5600((SubsamplingScaleImageView)subsamplingScaleImageView).onTileLoadError(this.exception);
        }
    }
}
