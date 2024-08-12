/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Data
 */
package androidx.work;

import android.content.Context;
import androidx.work.Data;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public interface ProgressUpdater {
    public ListenableFuture<Void> updateProgress(Context var1, UUID var2, Data var3);
}
