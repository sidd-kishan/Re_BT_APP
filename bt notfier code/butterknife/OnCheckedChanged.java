/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.internal.ListenerClass
 *  butterknife.internal.ListenerMethod
 */
package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@ListenerMethod(name="onCheckedChanged", parameters={"android.widget.CompoundButton", "boolean"})}, setter="setOnCheckedChangeListener", targetType="android.widget.CompoundButton", type="android.widget.CompoundButton.OnCheckedChangeListener")
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface OnCheckedChanged {
    public int[] value() default {-1};
}
