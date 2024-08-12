/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.request;

public interface Request {
    public void begin();

    public void clear();

    public boolean isCancelled();

    public boolean isComplete();

    public boolean isEquivalentTo(Request var1);

    public boolean isFailed();

    public boolean isPaused();

    public boolean isResourceSet();

    public boolean isRunning();

    public void pause();

    public void recycle();
}
