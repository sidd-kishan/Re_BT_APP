/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl.Config$_CC
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.OptionsBundle
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class MutableOptionsBundle
extends OptionsBundle
implements MutableConfig {
    private static final Config.OptionPriority DEFAULT_PRIORITY = Config.OptionPriority.OPTIONAL;

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        super(treeMap);
    }

    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(ID_COMPARE));
    }

    public static MutableOptionsBundle from(Config config) {
        TreeMap treeMap = new TreeMap(ID_COMPARE);
        Iterator iterator = config.listOptions().iterator();
        while (iterator.hasNext()) {
            Config.Option option = (Config.Option)iterator.next();
            Set set2 = config.getPriorities(option);
            ArrayMap arrayMap = new ArrayMap();
            for (Set set2 : set2) {
                arrayMap.put(set2, config.retrieveOptionWithPriority(option, (Config.OptionPriority)set2));
            }
            treeMap.put(option, (Map<Config.OptionPriority, Object>)arrayMap);
        }
        return new MutableOptionsBundle(treeMap);
    }

    public <ValueT> void insertOption(Config.Option<ValueT> option, Config.OptionPriority optionPriority, ValueT ValueT) {
        Map map = (Map)this.mOptions.get(option);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.mOptions.put(option, arrayMap);
            arrayMap.put(optionPriority, ValueT);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority)Collections.min(map.keySet());
        if (!map.get(optionPriority2).equals(ValueT) && Config._CC.hasConflict((Config.OptionPriority)optionPriority2, (Config.OptionPriority)optionPriority)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Option values conflicts: ");
            stringBuilder.append(option.getId());
            stringBuilder.append(", existing value (");
            stringBuilder.append(optionPriority2);
            stringBuilder.append(")=");
            stringBuilder.append(map.get(optionPriority2));
            stringBuilder.append(", conflicting (");
            stringBuilder.append(optionPriority);
            stringBuilder.append(")=");
            stringBuilder.append(ValueT);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        map.put(optionPriority, ValueT);
    }

    public <ValueT> void insertOption(Config.Option<ValueT> option, ValueT ValueT) {
        this.insertOption(option, DEFAULT_PRIORITY, ValueT);
    }

    public <ValueT> ValueT removeOption(Config.Option<ValueT> option) {
        return (ValueT)this.mOptions.remove(option);
    }
}
