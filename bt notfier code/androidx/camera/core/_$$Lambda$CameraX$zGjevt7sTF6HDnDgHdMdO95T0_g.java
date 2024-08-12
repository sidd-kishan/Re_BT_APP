/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.camera.core.CameraX
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 */
package androidx.camera.core;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$CameraX$zGjevt7sTF6HDnDgHdMdO95T0_g
implements AsyncFunction {
    private final CameraX f$0;
    private final Context f$1;

    public /* synthetic */ _$$Lambda$CameraX$zGjevt7sTF6HDnDgHdMdO95T0_g(CameraX cameraX, Context context) {
        this.f$0 = cameraX;
        this.f$1 = context;
    }

    public final ListenableFuture apply(Object object) {
        return CameraX.lambda$initializeInstanceLocked$2((CameraX)this.f$0, (Context)this.f$1, (Void)((Void)object));
    }
}
