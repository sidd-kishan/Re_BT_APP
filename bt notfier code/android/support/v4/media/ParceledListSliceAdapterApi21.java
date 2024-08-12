/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    /*
     * WARNING - void declaration
     */
    static {
        block3: {
            void var0_2;
            try {
                sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            var0_2.printStackTrace();
        }
    }

    private ParceledListSliceAdapterApi21() {
    }

    static Object newInstance(List<MediaBrowser.MediaItem> list) {
        block4: {
            try {
                list = sConstructor.newInstance(list);
                break block4;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {
                // empty catch block
            }
            ((Throwable)((Object)list)).printStackTrace();
            list = null;
        }
        return list;
    }
}
