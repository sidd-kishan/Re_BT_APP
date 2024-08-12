/*
 * Decompiled with CFR 0.152.
 */
package androidx.annotation;

public static final class RestrictTo.Scope
extends Enum<RestrictTo.Scope> {
    private static final RestrictTo.Scope[] $VALUES;
    @Deprecated
    public static final /* enum */ RestrictTo.Scope GROUP_ID;
    public static final /* enum */ RestrictTo.Scope LIBRARY;
    public static final /* enum */ RestrictTo.Scope LIBRARY_GROUP;
    public static final /* enum */ RestrictTo.Scope LIBRARY_GROUP_PREFIX;
    public static final /* enum */ RestrictTo.Scope SUBCLASSES;
    public static final /* enum */ RestrictTo.Scope TESTS;

    static {
        RestrictTo.Scope scope;
        LIBRARY = new RestrictTo.Scope();
        LIBRARY_GROUP = new RestrictTo.Scope();
        LIBRARY_GROUP_PREFIX = new RestrictTo.Scope();
        GROUP_ID = new RestrictTo.Scope();
        TESTS = new RestrictTo.Scope();
        SUBCLASSES = scope = new RestrictTo.Scope();
        $VALUES = new RestrictTo.Scope[]{LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, scope};
    }

    public static RestrictTo.Scope valueOf(String string) {
        return Enum.valueOf(RestrictTo.Scope.class, string);
    }

    public static RestrictTo.Scope[] values() {
        return (RestrictTo.Scope[])$VALUES.clone();
    }
}
