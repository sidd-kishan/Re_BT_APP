/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.DialogFragment
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.os.Bundle
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.util.ErrorDialogManager
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.util.ErrorDialogManager;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ErrorDialogManager.HoneycombManagerFragment
extends Fragment {
    protected Bundle argumentsForErrorDialog;
    private EventBus eventBus;
    private Object executionScope;
    protected boolean finishAfterDialog;

    public static void attachTo(Activity object, Object object2, boolean bl, Bundle bundle) {
        FragmentManager fragmentManager = object.getFragmentManager();
        ErrorDialogManager.HoneycombManagerFragment honeycombManagerFragment = (ErrorDialogManager.HoneycombManagerFragment)fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
        object = honeycombManagerFragment;
        if (honeycombManagerFragment == null) {
            object = new ErrorDialogManager.HoneycombManagerFragment();
            fragmentManager.beginTransaction().add((Fragment)object, "de.greenrobot.eventbus.error_dialog_manager").commit();
            fragmentManager.executePendingTransactions();
        }
        object.finishAfterDialog = bl;
        object.argumentsForErrorDialog = bundle;
        object.executionScope = object2;
    }

    public void onEventMainThread(ThrowableFailureEvent throwableFailureEvent) {
        if (!ErrorDialogManager.access$000((Object)this.executionScope, (ThrowableFailureEvent)throwableFailureEvent)) {
            return;
        }
        ErrorDialogManager.checkLogException((ThrowableFailureEvent)throwableFailureEvent);
        FragmentManager fragmentManager = this.getFragmentManager();
        fragmentManager.executePendingTransactions();
        DialogFragment dialogFragment = (DialogFragment)fragmentManager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        if ((throwableFailureEvent = (DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(throwableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog)) == null) return;
        throwableFailureEvent.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
    }

    public void onPause() {
        this.eventBus.unregister((Object)this);
        super.onPause();
    }

    public void onResume() {
        EventBus eventBus;
        super.onResume();
        this.eventBus = eventBus = ErrorDialogManager.factory.config.getEventBus();
        eventBus.register((Object)this);
    }
}
