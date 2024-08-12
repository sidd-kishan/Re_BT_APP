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

public final class _$$Lambda$PictureSelectorActivity$m1jFH1RwEpgszVh9qeAwJuTMpok
implements OnQueryDataResultListener {
    private final PictureSelectorActivity f$0;

    public /* synthetic */ _$$Lambda$PictureSelectorActivity$m1jFH1RwEpgszVh9qeAwJuTMpok(PictureSelectorActivity pictureSelectorActivity) {
        this.f$0 = pictureSelectorActivity;
    }

    public final void onComplete(List list, int n, boolean bl) {
        this.f$0.lambda$initPageModel$3$PictureSelectorActivity(list, n, bl);
    }
}
