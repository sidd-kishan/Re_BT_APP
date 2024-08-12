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

public final class _$$Lambda$PicturePreviewActivity$a5nLn2iN4Zdw1HgJtil8LcrnM5k
implements OnQueryDataResultListener {
    private final PicturePreviewActivity f$0;

    public /* synthetic */ _$$Lambda$PicturePreviewActivity$a5nLn2iN4Zdw1HgJtil8LcrnM5k(PicturePreviewActivity picturePreviewActivity) {
        this.f$0 = picturePreviewActivity;
    }

    public final void onComplete(List list, int n, boolean bl) {
        this.f$0.lambda$loadMoreData$2$PicturePreviewActivity(list, n, bl);
    }
}
