/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  org.greenrobot.eventbus.util.ErrorDialogConfig
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import android.os.Bundle;
import java.io.Serializable;
import org.greenrobot.eventbus.util.ErrorDialogConfig;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

public abstract class ErrorDialogFragmentFactory<T> {
    protected final ErrorDialogConfig config;

    protected ErrorDialogFragmentFactory(ErrorDialogConfig errorDialogConfig) {
        this.config = errorDialogConfig;
    }

    protected abstract T createErrorFragment(ThrowableFailureEvent var1, Bundle var2);

    protected String getMessageFor(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
        int n = this.config.getMessageIdForThrowable(throwableFailureEvent.throwable);
        return this.config.resources.getString(n);
    }

    protected String getTitleFor(ThrowableFailureEvent throwableFailureEvent, Bundle bundle) {
        return this.config.resources.getString(this.config.defaultTitleId);
    }

    protected T prepareErrorFragment(ThrowableFailureEvent throwableFailureEvent, boolean bl, Bundle bundle) {
        if (throwableFailureEvent.isSuppressErrorUi()) {
            return null;
        }
        if (!(bundle = bundle != null ? (Bundle)bundle.clone() : new Bundle()).containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle.putString("de.greenrobot.eventbus.errordialog.title", this.getTitleFor(throwableFailureEvent, bundle));
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            bundle.putString("de.greenrobot.eventbus.errordialog.message", this.getMessageFor(throwableFailureEvent, bundle));
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", bl);
        }
        if (!bundle.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.config.defaultEventTypeOnDialogClosed != null) {
            bundle.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", (Serializable)this.config.defaultEventTypeOnDialogClosed);
        }
        if (bundle.containsKey("de.greenrobot.eventbus.errordialog.icon_id")) return this.createErrorFragment(throwableFailureEvent, bundle);
        if (this.config.defaultDialogIconId == 0) return this.createErrorFragment(throwableFailureEvent, bundle);
        bundle.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.config.defaultDialogIconId);
        return this.createErrorFragment(throwableFailureEvent, bundle);
    }
}
