/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter
 *  com.luck.picture.lib.entity.LocalMediaFolder
 */
package com.luck.picture.lib.adapter;

import android.view.View;
import com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter;
import com.luck.picture.lib.entity.LocalMediaFolder;

public final class _$$Lambda$PictureAlbumDirectoryAdapter$A0GR_Ws1OIsHan7WkWhrO__kt08
implements View.OnClickListener {
    private final PictureAlbumDirectoryAdapter f$0;
    private final LocalMediaFolder f$1;
    private final int f$2;

    public /* synthetic */ _$$Lambda$PictureAlbumDirectoryAdapter$A0GR_Ws1OIsHan7WkWhrO__kt08(PictureAlbumDirectoryAdapter pictureAlbumDirectoryAdapter, LocalMediaFolder localMediaFolder, int n) {
        this.f$0 = pictureAlbumDirectoryAdapter;
        this.f$1 = localMediaFolder;
        this.f$2 = n;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$0$PictureAlbumDirectoryAdapter(this.f$1, this.f$2, view);
    }
}
