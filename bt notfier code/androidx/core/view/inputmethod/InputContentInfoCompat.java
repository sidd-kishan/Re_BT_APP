/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl
 *  androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatBaseImpl
 *  androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
 */
package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final class InputContentInfoCompat {
    private final InputContentInfoCompatImpl mImpl;

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.mImpl = Build.VERSION.SDK_INT >= 25 ? new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2) : new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }

    public static InputContentInfoCompat wrap(Object object) {
        if (object == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 25) return new InputContentInfoCompat((InputContentInfoCompatImpl)new InputContentInfoCompatApi25Impl(object));
        return null;
    }

    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }
}
