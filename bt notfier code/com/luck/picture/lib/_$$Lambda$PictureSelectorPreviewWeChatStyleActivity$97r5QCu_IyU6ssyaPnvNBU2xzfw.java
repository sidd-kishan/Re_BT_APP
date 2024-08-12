/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity
 *  com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter$OnItemClickListener
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib;

import android.view.View;
import com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity;
import com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter;
import com.luck.picture.lib.entity.LocalMedia;

public final class _$$Lambda$PictureSelectorPreviewWeChatStyleActivity$97r5QCu_IyU6ssyaPnvNBU2xzfw
implements PictureWeChatPreviewGalleryAdapter.OnItemClickListener {
    private final PictureSelectorPreviewWeChatStyleActivity f$0;

    public /* synthetic */ _$$Lambda$PictureSelectorPreviewWeChatStyleActivity$97r5QCu_IyU6ssyaPnvNBU2xzfw(PictureSelectorPreviewWeChatStyleActivity pictureSelectorPreviewWeChatStyleActivity) {
        this.f$0 = pictureSelectorPreviewWeChatStyleActivity;
    }

    public final void onItemClick(int n, LocalMedia localMedia, View view) {
        this.f$0.lambda$initWidgets$0$PictureSelectorPreviewWeChatStyleActivity(n, localMedia, view);
    }
}
