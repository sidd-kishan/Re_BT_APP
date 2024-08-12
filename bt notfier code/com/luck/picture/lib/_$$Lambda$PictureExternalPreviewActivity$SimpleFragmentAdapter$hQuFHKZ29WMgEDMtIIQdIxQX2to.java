/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  com.luck.picture.lib.PictureExternalPreviewActivity$SimpleFragmentAdapter
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib;

import android.view.View;
import android.view.ViewGroup;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.entity.LocalMedia;

public final class _$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$hQuFHKZ29WMgEDMtIIQdIxQX2to
implements View.OnClickListener {
    private final LocalMedia f$0;
    private final String f$1;
    private final ViewGroup f$2;

    public /* synthetic */ _$$Lambda$PictureExternalPreviewActivity$SimpleFragmentAdapter$hQuFHKZ29WMgEDMtIIQdIxQX2to(LocalMedia localMedia, String string, ViewGroup viewGroup) {
        this.f$0 = localMedia;
        this.f$1 = string;
        this.f$2 = viewGroup;
    }

    public final void onClick(View view) {
        PictureExternalPreviewActivity.SimpleFragmentAdapter.lambda$instantiateItem$4((LocalMedia)this.f$0, (String)this.f$1, (ViewGroup)this.f$2, (View)view);
    }
}
