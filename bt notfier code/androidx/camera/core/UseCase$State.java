/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

static final class UseCase.State
extends Enum<UseCase.State> {
    private static final UseCase.State[] $VALUES;
    public static final /* enum */ UseCase.State ACTIVE;
    public static final /* enum */ UseCase.State INACTIVE;

    static {
        UseCase.State state;
        ACTIVE = new UseCase.State();
        INACTIVE = state = new UseCase.State();
        $VALUES = new UseCase.State[]{ACTIVE, state};
    }

    public static UseCase.State valueOf(String string) {
        return Enum.valueOf(UseCase.State.class, string);
    }

    public static UseCase.State[] values() {
        return (UseCase.State[])$VALUES.clone();
    }
}
