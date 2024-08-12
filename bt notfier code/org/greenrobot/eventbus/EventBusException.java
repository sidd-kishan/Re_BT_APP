/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.eventbus;

public class EventBusException
extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(String string) {
        super(string);
    }

    public EventBusException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public EventBusException(Throwable throwable) {
        super(throwable);
    }
}
