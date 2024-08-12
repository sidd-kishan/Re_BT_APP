/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.OnTextChanged$Callback
 *  butterknife.internal.ListenerClass
 */
package butterknife;

import butterknife.OnTextChanged;
import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=Callback.class, remover="removeTextChangedListener", setter="addTextChangedListener", targetType="android.widget.TextView", type="android.text.TextWatcher")
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface OnTextChanged {
    public Callback callback() default Callback.TEXT_CHANGED;

    public int[] value() default {-1};
}
