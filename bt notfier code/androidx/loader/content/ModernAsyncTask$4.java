/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.loader.content.ModernAsyncTask$Status
 */
package androidx.loader.content;

import androidx.loader.content.ModernAsyncTask;

/*
 * Exception performing whole class analysis ignored.
 */
static class ModernAsyncTask.4 {
    static final int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ModernAsyncTask.Status.values().length];
        $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = nArray;
        try {
            nArray[ModernAsyncTask.Status.RUNNING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ModernAsyncTask.4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[ModernAsyncTask.Status.FINISHED.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
