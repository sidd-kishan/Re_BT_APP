/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.Preview
 *  androidx.camera.core.impl.PreviewConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$SessionError
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;

public final class _$$Lambda$Preview$mBIi_1TxOEtDykjYmpiDigz40hs
implements SessionConfig.ErrorListener {
    private final Preview f$0;
    private final String f$1;
    private final PreviewConfig f$2;
    private final Size f$3;

    public /* synthetic */ _$$Lambda$Preview$mBIi_1TxOEtDykjYmpiDigz40hs(Preview preview, String string, PreviewConfig previewConfig, Size size) {
        this.f$0 = preview;
        this.f$1 = string;
        this.f$2 = previewConfig;
        this.f$3 = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.lambda$createPipeline$0$Preview(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
