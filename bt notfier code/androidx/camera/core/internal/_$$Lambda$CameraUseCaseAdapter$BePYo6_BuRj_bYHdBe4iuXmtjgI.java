/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.internal.CameraUseCaseAdapter
 */
package androidx.camera.core.internal;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import java.util.List;

public final class _$$Lambda$CameraUseCaseAdapter$BePYo6_BuRj_bYHdBe4iuXmtjgI
implements Runnable {
    private final List f$0;

    public /* synthetic */ _$$Lambda$CameraUseCaseAdapter$BePYo6_BuRj_bYHdBe4iuXmtjgI(List list) {
        this.f$0 = list;
    }

    @Override
    public final void run() {
        CameraUseCaseAdapter.lambda$notifyAttachedUseCasesChange$0((List)this.f$0);
    }
}
