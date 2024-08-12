/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.core.app.RemoteInput
 */
package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.RemoteInput;
import java.util.HashSet;
import java.util.Set;

public static final class RemoteInput.Builder {
    private boolean mAllowFreeFormTextInput = true;
    private final Set<String> mAllowedDataTypes = new HashSet<String>();
    private CharSequence[] mChoices;
    private int mEditChoicesBeforeSending = 0;
    private final Bundle mExtras = new Bundle();
    private CharSequence mLabel;
    private final String mResultKey;

    public RemoteInput.Builder(String string) {
        if (string == null) throw new IllegalArgumentException("Result key can't be null");
        this.mResultKey = string;
    }

    public RemoteInput.Builder addExtras(Bundle bundle) {
        if (bundle == null) return this;
        this.mExtras.putAll(bundle);
        return this;
    }

    public RemoteInput build() {
        return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public RemoteInput.Builder setAllowDataType(String string, boolean bl) {
        if (bl) {
            this.mAllowedDataTypes.add(string);
        } else {
            this.mAllowedDataTypes.remove(string);
        }
        return this;
    }

    public RemoteInput.Builder setAllowFreeFormInput(boolean bl) {
        this.mAllowFreeFormTextInput = bl;
        return this;
    }

    public RemoteInput.Builder setChoices(CharSequence[] charSequenceArray) {
        this.mChoices = charSequenceArray;
        return this;
    }

    public RemoteInput.Builder setEditChoicesBeforeSending(int n) {
        this.mEditChoicesBeforeSending = n;
        return this;
    }

    public RemoteInput.Builder setLabel(CharSequence charSequence) {
        this.mLabel = charSequence;
        return this;
    }
}
