/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Fragment
 *  android.os.Bundle
 *  org.greenrobot.eventbus.util.ErrorDialogConfig
 *  org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
 *  org.greenrobot.eventbus.util.ErrorDialogFragments$Honeycomb
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import android.app.Fragment;
import android.os.Bundle;
import org.greenrobot.eventbus.util.ErrorDialogConfig;
import org.greenrobot.eventbus.util.ErrorDialogFragmentFactory;
import org.greenrobot.eventbus.util.ErrorDialogFragments;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

public static class ErrorDialogFragmentFactory.Honeycomb
extends ErrorDialogFragmentFactory<Fragment> {
    public ErrorDialogFragmentFactory.Honeycomb(ErrorDialogConfig errorDialogConfig) {
        super(errorDialogConfig);
    }

    protected Fragment createErrorFragment(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
        throwableFailureEvent = new ErrorDialogFragments.Honeycomb();
        throwableFailureEvent.setArguments(bundle);
        return throwableFailureEvent;
    }
}
