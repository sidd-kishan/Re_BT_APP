/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.fragment.app.Fragment
 *  org.greenrobot.eventbus.util.ErrorDialogConfig
 *  org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
 *  org.greenrobot.eventbus.util.ErrorDialogFragments$Support
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import org.greenrobot.eventbus.util.ErrorDialogConfig;
import org.greenrobot.eventbus.util.ErrorDialogFragmentFactory;
import org.greenrobot.eventbus.util.ErrorDialogFragments;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

public static class ErrorDialogFragmentFactory.Support
extends ErrorDialogFragmentFactory<Fragment> {
    public ErrorDialogFragmentFactory.Support(ErrorDialogConfig errorDialogConfig) {
        super(errorDialogConfig);
    }

    protected Fragment createErrorFragment(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
        throwableFailureEvent = new ErrorDialogFragments.Support();
        throwableFailureEvent.setArguments(bundle);
        return throwableFailureEvent;
    }
}
