/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.ForegroundInfo
 */
package androidx.work;

import android.content.Context;
import androidx.work.ForegroundInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public interface ForegroundUpdater {
    public ListenableFuture<Void> setForegroundAsync(Context var1, UUID var2, ForegroundInfo var3);
}
