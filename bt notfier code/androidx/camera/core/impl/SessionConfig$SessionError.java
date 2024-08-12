/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class SessionConfig.SessionError
extends Enum<SessionConfig.SessionError> {
    private static final SessionConfig.SessionError[] $VALUES;
    public static final /* enum */ SessionConfig.SessionError SESSION_ERROR_SURFACE_NEEDS_RESET;
    public static final /* enum */ SessionConfig.SessionError SESSION_ERROR_UNKNOWN;

    static {
        SessionConfig.SessionError sessionError;
        SESSION_ERROR_SURFACE_NEEDS_RESET = new SessionConfig.SessionError();
        SESSION_ERROR_UNKNOWN = sessionError = new SessionConfig.SessionError();
        $VALUES = new SessionConfig.SessionError[]{SESSION_ERROR_SURFACE_NEEDS_RESET, sessionError};
    }

    public static SessionConfig.SessionError valueOf(String string) {
        return Enum.valueOf(SessionConfig.SessionError.class, string);
    }

    public static SessionConfig.SessionError[] values() {
        return (SessionConfig.SessionError[])$VALUES.clone();
    }
}
