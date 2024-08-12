/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.Logger
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.Logger;
import java.util.List;

public abstract class InputMerger {
    private static final String TAG = Logger.tagWithPrefix((String)"InputMerger");

    public static InputMerger fromClassName(String string) {
        try {
            InputMerger inputMerger = (InputMerger)Class.forName(string).newInstance();
            return inputMerger;
        }
        catch (Exception exception) {
            Logger logger = Logger.get();
            String string2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble instantiating + ");
            stringBuilder.append(string);
            logger.error(string2, stringBuilder.toString(), new Throwable[]{exception});
            return null;
        }
    }

    public abstract Data merge(List<Data> var1);
}
