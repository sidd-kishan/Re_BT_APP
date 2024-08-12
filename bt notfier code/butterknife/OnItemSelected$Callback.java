/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.internal.ListenerMethod
 */
package butterknife;

import butterknife.internal.ListenerMethod;

public static final class OnItemSelected.Callback
extends Enum<OnItemSelected.Callback> {
    private static final OnItemSelected.Callback[] $VALUES;
    @ListenerMethod(name="onItemSelected", parameters={"android.widget.AdapterView<?>", "android.view.View", "int", "long"})
    public static final /* enum */ OnItemSelected.Callback ITEM_SELECTED;
    @ListenerMethod(name="onNothingSelected", parameters={"android.widget.AdapterView<?>"})
    public static final /* enum */ OnItemSelected.Callback NOTHING_SELECTED;

    static {
        OnItemSelected.Callback callback;
        ITEM_SELECTED = new OnItemSelected.Callback();
        NOTHING_SELECTED = callback = new OnItemSelected.Callback();
        $VALUES = new OnItemSelected.Callback[]{ITEM_SELECTED, callback};
    }

    public static OnItemSelected.Callback valueOf(String string) {
        return Enum.valueOf(OnItemSelected.Callback.class, string);
    }

    public static OnItemSelected.Callback[] values() {
        return (OnItemSelected.Callback[])$VALUES.clone();
    }
}
