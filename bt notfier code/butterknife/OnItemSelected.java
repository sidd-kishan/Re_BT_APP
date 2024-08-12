/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.OnItemSelected$Callback
 *  butterknife.internal.ListenerClass
 */
package butterknife;

import butterknife.OnItemSelected;
import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=Callback.class, setter="setOnItemSelectedListener", targetType="android.widget.AdapterView<?>", type="android.widget.AdapterView.OnItemSelectedListener")
@Retention(value=RetentionPolicy.CLASS)
@Target(value={ElementType.METHOD})
public @interface OnItemSelected {
    public Callback callback() default Callback.ITEM_SELECTED;

    public int[] value() default {-1};
}
