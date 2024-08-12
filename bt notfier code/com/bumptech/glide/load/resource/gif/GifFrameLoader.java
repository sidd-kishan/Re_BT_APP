/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.SystemClock
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestBuilder
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.gifdecoder.GifDecoder
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader$DelayTarget
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameCallback
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader$FrameLoaderCallback
 *  com.bumptech.glide.load.resource.gif.GifFrameLoader$OnEveryFrameListener
 *  com.bumptech.glide.request.RequestOptions
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.signature.ObjectKey
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks = new ArrayList<FrameCallback>();
    private DelayTarget current;
    private Bitmap firstFrame;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;

    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int n, int n2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with((Context)glide.getContext()), gifDecoder, null, GifFrameLoader.getRequestBuilder(Glide.with((Context)glide.getContext()), n, n2), transformation, bitmap);
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.requestManager = requestManager;
        requestManager = handler;
        if (handler == null) {
            requestManager = new Handler(Looper.getMainLooper(), (Handler.Callback)new FrameLoaderCallback(this));
        }
        this.bitmapPool = bitmapPool;
        this.handler = requestManager;
        this.requestBuilder = requestBuilder;
        this.gifDecoder = gifDecoder;
        this.setFrameTransformation(transformation, bitmap);
    }

    private static Key getFrameSignature() {
        return new ObjectKey((Object)Math.random());
    }

    private int getFrameSize() {
        return Util.getBitmapByteSize((int)this.getCurrentFrame().getWidth(), (int)this.getCurrentFrame().getHeight(), (Bitmap.Config)this.getCurrentFrame().getConfig());
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager requestManager, int n, int n2) {
        return requestManager.asBitmap().apply(RequestOptions.diskCacheStrategyOf((DiskCacheStrategy)DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(n, n2));
    }

    private void loadNextFrame() {
        DelayTarget delayTarget;
        if (!this.isRunning) return;
        if (this.isLoadPending) return;
        if (this.startFromFirstFrame) {
            boolean bl = this.pendingTarget == null;
            Preconditions.checkArgument((boolean)bl, (String)"Pending target must be null when starting from the first frame");
            this.gifDecoder.resetFrameIndex();
            this.startFromFirstFrame = false;
        }
        if ((delayTarget = this.pendingTarget) != null) {
            this.pendingTarget = null;
            this.onFrameReady(delayTarget);
            return;
        }
        this.isLoadPending = true;
        int n = this.gifDecoder.getNextDelay();
        long l = SystemClock.uptimeMillis();
        long l2 = n;
        this.gifDecoder.advance();
        this.next = new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), l + l2);
        this.requestBuilder.apply(RequestOptions.signatureOf((Key)GifFrameLoader.getFrameSignature())).load((Object)this.gifDecoder).into((Target)this.next);
    }

    private void recycleFirstFrame() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap == null) return;
        this.bitmapPool.put(bitmap);
        this.firstFrame = null;
    }

    private void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        this.loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    void clear() {
        this.callbacks.clear();
        this.recycleFirstFrame();
        this.stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.requestManager.clear((Target)delayTarget);
            this.current = null;
        }
        if ((delayTarget = this.next) != null) {
            this.requestManager.clear((Target)delayTarget);
            this.next = null;
        }
        if ((delayTarget = this.pendingTarget) != null) {
            this.requestManager.clear((Target)delayTarget);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        delayTarget = delayTarget != null ? delayTarget.getResource() : this.firstFrame;
        return delayTarget;
    }

    int getCurrentIndex() {
        DelayTarget delayTarget = this.current;
        int n = delayTarget != null ? delayTarget.index : -1;
        return n;
    }

    Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    int getFrameCount() {
        return this.gifDecoder.getFrameCount();
    }

    Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    int getHeight() {
        return this.getCurrentFrame().getHeight();
    }

    int getLoopCount() {
        return this.gifDecoder.getTotalIterationCount();
    }

    int getSize() {
        return this.gifDecoder.getByteSize() + this.getFrameSize();
    }

    int getWidth() {
        return this.getCurrentFrame().getWidth();
    }

    void onFrameReady(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener = this.onEveryFrameListener;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.onFrameReady();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, (Object)delayTarget).sendToTarget();
            return;
        }
        if (!this.isRunning) {
            this.pendingTarget = delayTarget;
            return;
        }
        if (delayTarget.getResource() != null) {
            this.recycleFirstFrame();
            onEveryFrameListener = this.current;
            this.current = delayTarget;
            for (int i = this.callbacks.size() - 1; i >= 0; --i) {
                this.callbacks.get(i).onFrameReady();
            }
            if (onEveryFrameListener != null) {
                this.handler.obtainMessage(2, (Object)onEveryFrameListener).sendToTarget();
            }
        }
        this.loadNextFrame();
    }

    void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.transformation = (Transformation)Preconditions.checkNotNull(transformation);
        this.firstFrame = (Bitmap)Preconditions.checkNotNull((Object)bitmap);
        this.requestBuilder = this.requestBuilder.apply(new RequestOptions().transform(transformation));
    }

    void setNextStartFromFirstFrame() {
        Preconditions.checkArgument((boolean)(this.isRunning ^ true), (String)"Can't restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget == null) return;
        this.requestManager.clear((Target)delayTarget);
        this.pendingTarget = null;
    }

    void setOnEveryFrameReadyListener(OnEveryFrameListener onEveryFrameListener) {
        this.onEveryFrameListener = onEveryFrameListener;
    }

    void subscribe(FrameCallback frameCallback) {
        if (this.isCleared) throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        if (this.callbacks.contains(frameCallback)) throw new IllegalStateException("Cannot subscribe twice in a row");
        boolean bl = this.callbacks.isEmpty();
        this.callbacks.add(frameCallback);
        if (!bl) return;
        this.start();
    }

    void unsubscribe(FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (!this.callbacks.isEmpty()) return;
        this.stop();
    }
}
