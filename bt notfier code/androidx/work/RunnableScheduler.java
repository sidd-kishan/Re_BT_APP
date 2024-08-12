/*
 * Decompiled with CFR 0.152.
 */
package androidx.work;

public interface RunnableScheduler {
    public void cancel(Runnable var1);

    public void scheduleWithDelay(long var1, Runnable var3);
}
