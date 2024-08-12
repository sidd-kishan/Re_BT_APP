/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputConnectionWrapper
 *  android.view.inputmethod.InputContentInfo
 *  androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
 *  androidx.core.view.inputmethod.InputContentInfoCompat
 */
package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

class InputConnectionCompat.1
extends InputConnectionWrapper {
    final InputConnectionCompat.OnCommitContentListener val$listener;

    InputConnectionCompat.1(InputConnection inputConnection, boolean bl, InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        this.val$listener = onCommitContentListener;
        super(inputConnection, bl);
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int n, Bundle bundle) {
        if (!this.val$listener.onCommitContent(InputContentInfoCompat.wrap((Object)inputContentInfo), n, bundle)) return super.commitContent(inputContentInfo, n, bundle);
        return true;
    }
}
