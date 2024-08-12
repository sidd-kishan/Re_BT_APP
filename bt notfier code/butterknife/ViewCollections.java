/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Property
 *  android.view.View
 *  butterknife.Action
 *  butterknife.Setter
 */
package butterknife;

import android.util.Property;
import android.view.View;
import butterknife.Action;
import butterknife.Setter;
import java.util.List;

public final class ViewCollections {
    private ViewCollections() {
    }

    public static <T extends View> void run(T t, Action<? super T> action) {
        action.apply(t, 0);
    }

    @SafeVarargs
    public static <T extends View> void run(T t, Action<? super T> ... actionArray) {
        int n = actionArray.length;
        int n2 = 0;
        while (n2 < n) {
            actionArray[n2].apply(t, 0);
            ++n2;
        }
    }

    public static <T extends View> void run(List<T> list, Action<? super T> action) {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            action.apply((View)list.get(n2), n2);
            ++n2;
        }
    }

    @SafeVarargs
    public static <T extends View> void run(List<T> list, Action<? super T> ... actionArray) {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            int n3 = actionArray.length;
            for (int i = 0; i < n3; ++i) {
                actionArray[i].apply((View)list.get(n2), n2);
            }
            ++n2;
        }
    }

    public static <T extends View> void run(T[] TArray, Action<? super T> action) {
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            action.apply(TArray[n2], n2);
            ++n2;
        }
    }

    @SafeVarargs
    public static <T extends View> void run(T[] TArray, Action<? super T> ... actionArray) {
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            int n3 = actionArray.length;
            for (int i = 0; i < n3; ++i) {
                actionArray[i].apply(TArray[n2], n2);
            }
            ++n2;
        }
    }

    public static <T extends View, V> void set(T t, Property<? super T, V> property, V v) {
        property.set(t, v);
    }

    public static <T extends View, V> void set(T t, Setter<? super T, V> setter, V v) {
        setter.set(t, v, 0);
    }

    public static <T extends View, V> void set(List<T> list, Property<? super T, V> property, V v) {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            property.set(list.get(n2), v);
            ++n2;
        }
    }

    public static <T extends View, V> void set(List<T> list, Setter<? super T, V> setter, V v) {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            setter.set((View)list.get(n2), v, n2);
            ++n2;
        }
    }

    public static <T extends View, V> void set(T[] TArray, Property<? super T, V> property, V v) {
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            property.set(TArray[n2], v);
            ++n2;
        }
    }

    public static <T extends View, V> void set(T[] TArray, Setter<? super T, V> setter, V v) {
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            setter.set(TArray[n2], v, n2);
            ++n2;
        }
    }
}
