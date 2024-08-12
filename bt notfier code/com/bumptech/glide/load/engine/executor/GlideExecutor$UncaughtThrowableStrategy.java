/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine.executor;

public static interface GlideExecutor.UncaughtThrowableStrategy {
    public static final GlideExecutor.UncaughtThrowableStrategy DEFAULT;
    public static final GlideExecutor.UncaughtThrowableStrategy IGNORE;
    public static final GlideExecutor.UncaughtThrowableStrategy LOG;
    public static final GlideExecutor.UncaughtThrowableStrategy THROW;

    static {
        IGNORE = new /* Unavailable Anonymous Inner Class!! */;
        LOG = new /* Unavailable Anonymous Inner Class!! */;
        THROW = new /* Unavailable Anonymous Inner Class!! */;
        DEFAULT = LOG;
    }

    public void handle(Throwable var1);
}
