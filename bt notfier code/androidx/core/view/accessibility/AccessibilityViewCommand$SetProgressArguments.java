/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand;

public static final class AccessibilityViewCommand.SetProgressArguments
extends AccessibilityViewCommand.CommandArguments {
    public float getProgress() {
        return this.mBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
    }
}
