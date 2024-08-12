/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputContentInfo
 *  androidx.core.view.inputmethod.EditorInfoCompat
 *  androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
 *  androidx.core.view.inputmethod.InputContentInfoCompat
 */
package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    @Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(InputConnection inputConnection, EditorInfo object, InputContentInfoCompat inputContentInfoCompat, int n, Bundle bundle) {
        int n2;
        int n3;
        int n4;
        ClipDescription clipDescription;
        block7: {
            clipDescription = inputContentInfoCompat.getDescription();
            String[] stringArray = EditorInfoCompat.getContentMimeTypes((EditorInfo)object);
            n4 = stringArray.length;
            n3 = 0;
            for (n2 = 0; n2 < n4; ++n2) {
                if (!clipDescription.hasMimeType(stringArray[n2])) continue;
                n2 = 1;
                break block7;
            }
            n2 = 0;
        }
        if (n2 == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 25) {
            return inputConnection.commitContent((InputContentInfo)inputContentInfoCompat.unwrap(), n, bundle);
        }
        n4 = EditorInfoCompat.getProtocol((EditorInfo)object);
        if (n4 != 2) {
            n2 = n3;
            if (n4 != 3) {
                n2 = n3;
                if (n4 != 4) {
                    return false;
                }
            }
        } else {
            n2 = 1;
        }
        clipDescription = new Bundle();
        object = n2 != 0 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY;
        clipDescription.putParcelable((String)object, (Parcelable)inputContentInfoCompat.getContentUri());
        object = n2 != 0 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY;
        clipDescription.putParcelable((String)object, (Parcelable)inputContentInfoCompat.getDescription());
        object = n2 != 0 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY;
        clipDescription.putParcelable((String)object, (Parcelable)inputContentInfoCompat.getLinkUri());
        object = n2 != 0 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY;
        clipDescription.putInt((String)object, n);
        object = n2 != 0 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY;
        clipDescription.putParcelable((String)object, (Parcelable)bundle);
        object = n2 != 0 ? COMMIT_CONTENT_INTEROP_ACTION : COMMIT_CONTENT_ACTION;
        return inputConnection.performPrivateCommand((String)object, (Bundle)clipDescription);
    }

    public static InputConnection createWrapper(InputConnection inputConnection, EditorInfo editorInfo, OnCommitContentListener onCommitContentListener) {
        if (inputConnection == null) throw new IllegalArgumentException("inputConnection must be non-null");
        if (editorInfo == null) throw new IllegalArgumentException("editorInfo must be non-null");
        if (onCommitContentListener == null) throw new IllegalArgumentException("onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new /* Unavailable Anonymous Inner Class!! */;
        }
        if (EditorInfoCompat.getContentMimeTypes((EditorInfo)editorInfo).length != 0) return new /* Unavailable Anonymous Inner Class!! */;
        return inputConnection;
    }

    /*
     * WARNING - void declaration
     */
    static boolean handlePerformPrivateCommand(String string, Bundle bundle, OnCommitContentListener onCommitContentListener) {
        void var1_4;
        block9: {
            ResultReceiver resultReceiver;
            int n;
            int n2 = 0;
            if (bundle == null) {
                return false;
            }
            if (TextUtils.equals((CharSequence)COMMIT_CONTENT_ACTION, (CharSequence)string)) {
                n = 0;
            } else {
                if (!TextUtils.equals((CharSequence)COMMIT_CONTENT_INTEROP_ACTION, (CharSequence)string)) return false;
                n = 1;
            }
            string = n != 0 ? COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY : COMMIT_CONTENT_RESULT_RECEIVER_KEY;
            try {
                resultReceiver = (ResultReceiver)bundle.getParcelable(string);
                string = n != 0 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY;
            }
            catch (Throwable throwable) {
                string = null;
                break block9;
            }
            try {
                Uri uri = (Uri)bundle.getParcelable(string);
                string = n != 0 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY;
                ClipDescription clipDescription = (ClipDescription)bundle.getParcelable(string);
                string = n != 0 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY;
                Uri uri2 = (Uri)bundle.getParcelable(string);
                string = n != 0 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY;
                int n3 = bundle.getInt(string);
                string = n != 0 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY;
                bundle = (Bundle)bundle.getParcelable(string);
                n = n2;
                if (uri != null) {
                    n = n2;
                    if (clipDescription != null) {
                        string = new InputContentInfoCompat(uri, clipDescription, uri2);
                        n = onCommitContentListener.onCommitContent((InputContentInfoCompat)string, n3, bundle) ? 1 : 0;
                    }
                }
                if (resultReceiver == null) return n != 0;
            }
            catch (Throwable throwable) {
                string = resultReceiver;
                break block9;
            }
            resultReceiver.send(n, null);
            return n != 0;
        }
        if (string == null) throw var1_4;
        string.send(0, null);
        throw var1_4;
    }
}
