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

@ListenerClass(method={@ListenerMethod(defaultReturn="true", name="onEditorAction", parameters={"android.widget.TextView", "int", "android.view.KeyEvent"}, returnType="boolean")}, setter="setOnEditorActionListener", targetType="android.widget.TextView", type="android.widget.TextView.OnEditorActionListener")
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface OnEditorAction {
    public int[] value() default {-1};
}
