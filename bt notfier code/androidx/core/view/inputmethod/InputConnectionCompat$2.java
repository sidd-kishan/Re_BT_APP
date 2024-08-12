/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputConnectionWrapper
 *  androidx.core.view.inputmethod.InputConnectionCompat
 *  androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener
 */
package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.core.view.inputmethod.InputConnectionCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class InputConnectionCompat.2
extends InputConnectionWrapper {
    final InputConnectionCompat.OnCommitContentListener val$listener;

    InputConnectionCompat.2(InputConnection inputConnection, boolean bl, InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        this.val$listener = onCommitContentListener;
        super(inputConnection, bl);
    }

    public boolean performPrivateCommand(String string, Bundle bundle) {
        if (!InputConnectionCompat.handlePerformPrivateCommand((String)string, (Bundle)bundle, (InputConnectionCompat.OnCommitContentListener)this.val$listener)) return super.performPrivateCommand(string, bundle);
        return true;
    }
}
