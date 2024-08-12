/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.internal.ListenerMethod
 */
package butterknife;

import butterknife.internal.ListenerMethod;

public static final class OnTextChanged.Callback
extends Enum<OnTextChanged.Callback> {
    private static final OnTextChanged.Callback[] $VALUES;
    @ListenerMethod(name="afterTextChanged", parameters={"android.text.Editable"})
    public static final /* enum */ OnTextChanged.Callback AFTER_TEXT_CHANGED;
    @ListenerMethod(name="beforeTextChanged", parameters={"java.lang.CharSequence", "int", "int", "int"})
    public static final /* enum */ OnTextChanged.Callback BEFORE_TEXT_CHANGED;
    @ListenerMethod(name="onTextChanged", parameters={"java.lang.CharSequence", "int", "int", "int"})
    public static final /* enum */ OnTextChanged.Callback TEXT_CHANGED;

    static {
        OnTextChanged.Callback callback;
        TEXT_CHANGED = new OnTextChanged.Callback();
        BEFORE_TEXT_CHANGED = new OnTextChanged.Callback();
        AFTER_TEXT_CHANGED = callback = new OnTextChanged.Callback();
        $VALUES = new OnTextChanged.Callback[]{TEXT_CHANGED, BEFORE_TEXT_CHANGED, callback};
    }

    public static OnTextChanged.Callback valueOf(String string) {
        return Enum.valueOf(OnTextChanged.Callback.class, string);
    }

    public static OnTextChanged.Callback[] values() {
        return (OnTextChanged.Callback[])$VALUES.clone();
    }
}
