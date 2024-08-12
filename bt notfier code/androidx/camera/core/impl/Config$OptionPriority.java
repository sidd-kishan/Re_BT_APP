/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl;

public static final class Config.OptionPriority
extends Enum<Config.OptionPriority> {
    private static final Config.OptionPriority[] $VALUES;
    public static final /* enum */ Config.OptionPriority ALWAYS_OVERRIDE;
    public static final /* enum */ Config.OptionPriority OPTIONAL;
    public static final /* enum */ Config.OptionPriority REQUIRED;

    static {
        Config.OptionPriority optionPriority;
        ALWAYS_OVERRIDE = new Config.OptionPriority();
        REQUIRED = new Config.OptionPriority();
        OPTIONAL = optionPriority = new Config.OptionPriority();
        $VALUES = new Config.OptionPriority[]{ALWAYS_OVERRIDE, REQUIRED, optionPriority};
    }

    public static Config.OptionPriority valueOf(String string) {
        return Enum.valueOf(Config.OptionPriority.class, string);
    }

    public static Config.OptionPriority[] values() {
        return (Config.OptionPriority[])$VALUES.clone();
    }
}
