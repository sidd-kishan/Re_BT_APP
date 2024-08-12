/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  com.luck.picture.lib.PictureExternalPreviewActivity$SimpleFragmentAdapter
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.entity.LocalMedia;

public final class _$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$QMCBWC0MjLmlbl_DaCykGwK77ig
implements View.OnLongClickListener {
    private final PictureExternalPreviewActivity.SimpleFragmentAdapter f$0;
    private final String f$1;
    private final LocalMedia f$2;

    public /* synthetic */ _$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$QMCBWC0MjLmlbl_DaCykGwK77ig(PictureExternalPreviewActivity.SimpleFragmentAdapter simpleFragmentAdapter, String string, LocalMedia localMedia) {
        this.f$0 = simpleFragmentAdapter;
        this.f$1 = string;
        this.f$2 = localMedia;
    }

    public final boolean onLongClick(View view) {
        return this.f$0.lambda$instantiateItem$2$PictureExternalPreviewActivity$SimpleFragmentAdapter(this.f$1, this.f$2, view);
    }
}
