/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.inputmethod.InputContentInfo
 *  androidx.core.view.ContentInfoCompat
 *  androidx.core.view.ContentInfoCompat$Builder
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
 *  androidx.core.view.inputmethod.InputContentInfoCompat
 */
package androidx.appcompat.widget;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

class AppCompatReceiveContentHelper.1
implements InputConnectionCompat.OnCommitContentListener {
    final View val$view;

    AppCompatReceiveContentHelper.1(View view) {
        this.val$view = view;
    }

    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int n, Bundle bundle) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = false;
        Bundle bundle2 = bundle;
        if (n2 >= 25) {
            bundle2 = bundle;
            if ((n & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                }
                catch (Exception exception) {
                    Log.w((String)"ReceiveContent", (String)"Can't insert content from IME; requestPermission() failed", (Throwable)exception);
                    return false;
                }
                bundle2 = (InputContentInfo)inputContentInfoCompat.unwrap();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", (Parcelable)bundle2);
                bundle2 = bundle;
            }
        }
        if (ViewCompat.performReceiveContent((View)this.val$view, (ContentInfoCompat)(inputContentInfoCompat = new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle2).build())) != null) return bl;
        bl = true;
        return bl;
    }
}
