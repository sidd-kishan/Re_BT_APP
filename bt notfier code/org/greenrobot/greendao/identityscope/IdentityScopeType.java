/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.identityscope;

public final class IdentityScopeType
extends Enum<IdentityScopeType> {
    private static final IdentityScopeType[] $VALUES;
    public static final /* enum */ IdentityScopeType None;
    public static final /* enum */ IdentityScopeType Session;

    static {
        IdentityScopeType identityScopeType;
        Session = new IdentityScopeType();
        None = identityScopeType = new IdentityScopeType();
        $VALUES = new IdentityScopeType[]{Session, identityScopeType};
    }

    public static IdentityScopeType valueOf(String string) {
        return Enum.valueOf(IdentityScopeType.class, string);
    }

    public static IdentityScopeType[] values() {
        return (IdentityScopeType[])$VALUES.clone();
    }
}
