/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  com.luck.picture.lib.PicturePreviewActivity
 *  com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity
 *  com.luck.picture.lib.PictureVideoPlayActivity
 *  com.luck.picture.lib.tools.DoubleUtils
 */
package com.luck.picture.lib.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity;
import com.luck.picture.lib.PictureVideoPlayActivity;
import com.luck.picture.lib.tools.DoubleUtils;

public class JumpUtils {
    public static void startPicturePreviewActivity(Context context, boolean bl, Bundle bundle, int n) {
        if (DoubleUtils.isFastDoubleClick()) return;
        Intent intent = new Intent();
        Class clazz = bl ? PictureSelectorPreviewWeChatStyleActivity.class : PicturePreviewActivity.class;
        intent.setClass(context, clazz);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        } else {
            ((Activity)context).startActivityForResult(intent, n);
        }
    }

    public static void startPictureVideoPlayActivity(Context context, Bundle bundle, int n) {
        if (DoubleUtils.isFastDoubleClick()) return;
        Intent intent = new Intent();
        intent.setClass(context, PictureVideoPlayActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(0x10000000);
            context.startActivity(intent);
        } else {
            ((Activity)context).startActivityForResult(intent, n);
        }
    }
}
