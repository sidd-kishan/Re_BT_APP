/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.PictureExternalPreviewActivity$SimpleFragmentAdapter
 *  com.luck.picture.lib.listener.OnImageCompleteCallback
 */
package com.luck.picture.lib;

import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.listener.OnImageCompleteCallback;

class PictureExternalPreviewActivity.SimpleFragmentAdapter.1
implements OnImageCompleteCallback {
    final PictureExternalPreviewActivity.SimpleFragmentAdapter this$1;

    PictureExternalPreviewActivity.SimpleFragmentAdapter.1(PictureExternalPreviewActivity.SimpleFragmentAdapter simpleFragmentAdapter) {
        this.this$1 = simpleFragmentAdapter;
    }

    public void onHideLoading() {
        this.this$1.this$0.dismissDialog();
    }

    public void onShowLoading() {
        this.this$1.this$0.showPleaseDialog();
    }
}
