/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.view.Gravity
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.gifdecoder.GifDecoder
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.gif.GifDrawable$GifState
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameCallback
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

public class GifDrawable
extends Drawable
implements GifFrameLoader.FrameCallback,
Animatable {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible = true;
    private int loopCount;
    private int maxLoopCount = -1;
    private Paint paint;
    private final GifState state;

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int n, int n2, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.get((Context)context), gifDecoder, n, n2, transformation, bitmap)));
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int n, int n2, Bitmap bitmap) {
        this(context, gifDecoder, transformation, n, n2, bitmap);
    }

    GifDrawable(GifState gifState) {
        this.state = (GifState)Preconditions.checkNotNull((Object)gifState);
    }

    GifDrawable(GifFrameLoader gifFrameLoader, Paint paint) {
        this(new GifState(gifFrameLoader));
        this.paint = paint;
    }

    private Drawable.Callback findCallback() {
        Drawable.Callback callback = this.getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable)callback).getCallback();
        }
        return callback;
    }

    private Rect getDestRect() {
        if (this.destRect != null) return this.destRect;
        this.destRect = new Rect();
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint != null) return this.paint;
        this.paint = new Paint(2);
        return this.paint;
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        Preconditions.checkArgument((boolean)(this.isRecycled ^ true), (String)"You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.frameLoader.getFrameCount() == 1) {
            this.invalidateSelf();
        } else {
            if (this.isRunning) return;
            this.isRunning = true;
            this.state.frameLoader.subscribe((GifFrameLoader.FrameCallback)this);
            this.invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.frameLoader.unsubscribe((GifFrameLoader.FrameCallback)this);
    }

    public void draw(Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply((int)119, (int)this.getIntrinsicWidth(), (int)this.getIntrinsicHeight(), (Rect)this.getBounds(), (Rect)this.getDestRect());
            this.applyGravity = false;
        }
        canvas.drawBitmap(this.state.frameLoader.getCurrentFrame(), null, this.getDestRect(), this.getPaint());
    }

    public ByteBuffer getBuffer() {
        return this.state.frameLoader.getBuffer();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public Bitmap getFirstFrame() {
        return this.state.frameLoader.getFirstFrame();
    }

    public int getFrameCount() {
        return this.state.frameLoader.getFrameCount();
    }

    public int getFrameIndex() {
        return this.state.frameLoader.getCurrentIndex();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameLoader.getFrameTransformation();
    }

    public int getIntrinsicHeight() {
        return this.state.frameLoader.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.state.frameLoader.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.state.frameLoader.getSize();
    }

    boolean isRecycled() {
        return this.isRecycled;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    public void onFrameReady() {
        int n;
        if (this.findCallback() == null) {
            this.stop();
            this.invalidateSelf();
            return;
        }
        this.invalidateSelf();
        if (this.getFrameIndex() == this.getFrameCount() - 1) {
            ++this.loopCount;
        }
        if ((n = this.maxLoopCount) == -1) return;
        if (this.loopCount < n) return;
        this.stop();
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.frameLoader.clear();
    }

    public void setAlpha(int n) {
        this.getPaint().setAlpha(n);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.getPaint().setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.state.frameLoader.setFrameTransformation(transformation, bitmap);
    }

    void setIsRunning(boolean bl) {
        this.isRunning = bl;
    }

    public void setLoopCount(int n) {
        int n2 = -1;
        if (n <= 0 && n != -1) {
            if (n != 0) throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (n == 0) {
            n = this.state.frameLoader.getLoopCount();
            if (n == 0) {
                n = n2;
            }
            this.maxLoopCount = n;
        } else {
            this.maxLoopCount = n;
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        Preconditions.checkArgument((boolean)(this.isRecycled ^ true), (String)"Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = bl;
        if (!bl) {
            this.stopRunning();
        } else {
            if (!this.isStarted) return super.setVisible(bl, bl2);
            this.startRunning();
        }
        return super.setVisible(bl, bl2);
    }

    public void start() {
        this.isStarted = true;
        this.resetLoopCount();
        if (!this.isVisible) return;
        this.startRunning();
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument((boolean)(this.isRunning ^ true), (String)"You cannot restart a currently running animation.");
        this.state.frameLoader.setNextStartFromFirstFrame();
        this.start();
    }

    public void stop() {
        this.isStarted = false;
        this.stopRunning();
    }
}
