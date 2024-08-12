/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.Log
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.util.ExceptionToResourceMapping
 */
package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.util.ExceptionToResourceMapping;

public class ErrorDialogConfig {
    int defaultDialogIconId;
    final int defaultErrorMsgId;
    Class<?> defaultEventTypeOnDialogClosed;
    final int defaultTitleId;
    EventBus eventBus;
    boolean logExceptions = true;
    final ExceptionToResourceMapping mapping;
    final Resources resources;
    String tagForLoggingExceptions;

    public ErrorDialogConfig(Resources resources, int n, int n2) {
        this.resources = resources;
        this.defaultTitleId = n;
        this.defaultErrorMsgId = n2;
        this.mapping = new ExceptionToResourceMapping();
    }

    public ErrorDialogConfig addMapping(Class<? extends Throwable> clazz, int n) {
        this.mapping.addMapping(clazz, n);
        return this;
    }

    public void disableExceptionLogging() {
        this.logExceptions = false;
    }

    EventBus getEventBus() {
        EventBus eventBus = this.eventBus;
        if (eventBus != null) return eventBus;
        eventBus = EventBus.getDefault();
        return eventBus;
    }

    public int getMessageIdForThrowable(Throwable throwable) {
        Object object = this.mapping.mapThrowable(throwable);
        if (object != null) {
            return (Integer)object;
        }
        object = EventBus.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No specific message ressource ID found for ");
        stringBuilder.append(throwable);
        Log.d((String)object, (String)stringBuilder.toString());
        return this.defaultErrorMsgId;
    }

    public void setDefaultDialogIconId(int n) {
        this.defaultDialogIconId = n;
    }

    public void setDefaultEventTypeOnDialogClosed(Class<?> clazz) {
        this.defaultEventTypeOnDialogClosed = clazz;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setTagForLoggingExceptions(String string) {
        this.tagForLoggingExceptions = string;
    }
}
