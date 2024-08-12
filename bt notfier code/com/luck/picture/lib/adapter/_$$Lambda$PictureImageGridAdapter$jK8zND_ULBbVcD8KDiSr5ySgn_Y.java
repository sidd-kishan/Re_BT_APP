/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter$ViewHolder
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.adapter;

import android.view.View;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.entity.LocalMedia;

public final class _$$Lambda$PictureImageGridAdapter$jK8zND_ULBbVcD8KDiSr5ySgn_Y
implements View.OnClickListener {
    private final PictureImageGridAdapter f$0;
    private final LocalMedia f$1;
    private final PictureImageGridAdapter.ViewHolder f$2;
    private final String f$3;

    public /* synthetic */ _$$Lambda$PictureImageGridAdapter$jK8zND_ULBbVcD8KDiSr5ySgn_Y(PictureImageGridAdapter pictureImageGridAdapter, LocalMedia localMedia, PictureImageGridAdapter.ViewHolder viewHolder, String string) {
        this.f$0 = pictureImageGridAdapter;
        this.f$1 = localMedia;
        this.f$2 = viewHolder;
        this.f$3 = string;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$1$PictureImageGridAdapter(this.f$1, this.f$2, this.f$3, view);
    }
}
