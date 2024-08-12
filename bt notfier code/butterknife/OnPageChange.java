/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.OnPageChange$Callback
 *  butterknife.internal.ListenerClass
 */
package butterknife;

import butterknife.OnPageChange;
import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=Callback.class, remover="removeOnPageChangeListener", setter="addOnPageChangeListener", targetType="androidx.viewpager.widget.ViewPager", type="androidx.viewpager.widget.ViewPager.OnPageChangeListener")
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface OnPageChange {
    public Callback callback() default Callback.PAGE_SELECTED;

    public int[] value() default {-1};
}
