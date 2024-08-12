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

public final class _$$Lambda$PictureImageGridAdapter$PgVgZMJtlqgUy4Fuo95Ra5c5haQ
implements View.OnClickListener {
    private final PictureImageGridAdapter f$0;
    private final LocalMedia f$1;
    private final String f$2;
    private final int f$3;
    private final PictureImageGridAdapter.ViewHolder f$4;

    public /* synthetic */ _$$Lambda$PictureImageGridAdapter$PgVgZMJtlqgUy4Fuo95Ra5c5haQ(PictureImageGridAdapter pictureImageGridAdapter, LocalMedia localMedia, String string, int n, PictureImageGridAdapter.ViewHolder viewHolder) {
        this.f$0 = pictureImageGridAdapter;
        this.f$1 = localMedia;
        this.f$2 = string;
        this.f$3 = n;
        this.f$4 = viewHolder;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$2$PictureImageGridAdapter(this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
