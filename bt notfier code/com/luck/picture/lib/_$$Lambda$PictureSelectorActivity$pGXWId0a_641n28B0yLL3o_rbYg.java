/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import java.util.List;

public final class _$$Lambda$PictureSelectorActivity$pGXWId0a_641n28B0yLL3o_rbYg
implements OnQueryDataResultListener {
    private final PictureSelectorActivity f$0;
    private final long f$1;

    public /* synthetic */ _$$Lambda$PictureSelectorActivity$pGXWId0a_641n28B0yLL3o_rbYg(PictureSelectorActivity pictureSelectorActivity, long l) {
        this.f$0 = pictureSelectorActivity;
        this.f$1 = l;
    }

    public final void onComplete(List list, int n, boolean bl) {
        this.f$0.lambda$loadMoreData$1$PictureSelectorActivity(this.f$1, list, n, bl);
    }
}
