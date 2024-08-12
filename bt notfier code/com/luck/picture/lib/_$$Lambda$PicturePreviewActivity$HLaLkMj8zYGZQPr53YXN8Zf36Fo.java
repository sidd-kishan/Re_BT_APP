/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PicturePreviewActivity
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import java.util.List;

public final class _$$Lambda$PicturePreviewActivity$HLaLkMj8zYGZQPr53YXN8Zf36Fo
implements OnQueryDataResultListener {
    private final PicturePreviewActivity f$0;

    public /* synthetic */ _$$Lambda$PicturePreviewActivity$HLaLkMj8zYGZQPr53YXN8Zf36Fo(PicturePreviewActivity picturePreviewActivity) {
        this.f$0 = picturePreviewActivity;
    }

    public final void onComplete(List list, int n, boolean bl) {
        this.f$0.lambda$loadData$1$PicturePreviewActivity(list, n, bl);
    }
}
