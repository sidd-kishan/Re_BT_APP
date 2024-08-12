/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.ActiveResources$DequeuedResourceCallback
 *  com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference
 *  com.bumptech.glide.load.engine.EngineResource
 *  com.bumptech.glide.load.engine.EngineResource$ResourceListener
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.ActiveResources;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

final class ActiveResources {
    private static final int MSG_CLEAN_REF = 1;
    final Map<Key, ResourceWeakReference> activeEngineResources;
    private volatile DequeuedResourceCallback cb;
    private Thread cleanReferenceQueueThread;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Handler mainHandler = new Handler(Looper.getMainLooper(), (Handler.Callback)new /* Unavailable Anonymous Inner Class!! */);
    private ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    ActiveResources(boolean bl) {
        this.activeEngineResources = new HashMap<Key, ResourceWeakReference>();
        this.isActiveResourceRetentionAllowed = bl;
    }

    private ReferenceQueue<EngineResource<?>> getReferenceQueue() {
        Thread thread;
        if (this.resourceReferenceQueue != null) return this.resourceReferenceQueue;
        this.resourceReferenceQueue = new ReferenceQueue();
        this.cleanReferenceQueueThread = thread = new Thread((Runnable)new /* Unavailable Anonymous Inner Class!! */, "glide-active-resources");
        thread.start();
        return this.resourceReferenceQueue;
    }

    void activate(Key key, EngineResource<?> resourceWeakReference) {
        if ((key = this.activeEngineResources.put(key, resourceWeakReference = new ResourceWeakReference(key, resourceWeakReference, this.getReferenceQueue(), this.isActiveResourceRetentionAllowed))) == null) return;
        key.reset();
    }

    void cleanReferenceQueue() {
        while (!this.isShutdown) {
            try {
                ResourceWeakReference resourceWeakReference = (ResourceWeakReference)this.resourceReferenceQueue.remove();
                this.mainHandler.obtainMessage(1, (Object)resourceWeakReference).sendToTarget();
                resourceWeakReference = this.cb;
                if (resourceWeakReference == null) continue;
                resourceWeakReference.onResourceDequeued();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void cleanupActiveReference(ResourceWeakReference resourceWeakReference) {
        Util.assertMainThread();
        this.activeEngineResources.remove(resourceWeakReference.key);
        if (!resourceWeakReference.isCacheable) return;
        if (resourceWeakReference.resource == null) return;
        EngineResource engineResource = new EngineResource(resourceWeakReference.resource, true, false);
        engineResource.setResourceListener(resourceWeakReference.key, this.listener);
        this.listener.onResourceReleased(resourceWeakReference.key, engineResource);
    }

    void deactivate(Key key) {
        if ((key = this.activeEngineResources.remove(key)) == null) return;
        key.reset();
    }

    EngineResource<?> get(Key key) {
        ResourceWeakReference resourceWeakReference = this.activeEngineResources.get(key);
        if (resourceWeakReference == null) {
            return null;
        }
        key = (EngineResource)resourceWeakReference.get();
        if (key != null) return key;
        this.cleanupActiveReference(resourceWeakReference);
        return key;
    }

    void setDequeuedResourceCallback(DequeuedResourceCallback dequeuedResourceCallback) {
        this.cb = dequeuedResourceCallback;
    }

    void setListener(EngineResource.ResourceListener resourceListener) {
        this.listener = resourceListener;
    }

    void shutdown() {
        this.isShutdown = true;
        Object object = this.cleanReferenceQueueThread;
        if (object == null) {
            return;
        }
        ((Thread)object).interrupt();
        try {
            this.cleanReferenceQueueThread.join(TimeUnit.SECONDS.toMillis(5L));
            if (!this.cleanReferenceQueueThread.isAlive()) return;
            object = new RuntimeException("Failed to join in time");
            throw object;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
