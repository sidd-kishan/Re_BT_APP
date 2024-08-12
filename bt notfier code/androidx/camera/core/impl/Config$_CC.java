/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.OptionsBundle
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Iterator;

public final class Config$_CC {
    public static boolean hasConflict(Config.OptionPriority optionPriority, Config.OptionPriority optionPriority2) {
        if (optionPriority == Config.OptionPriority.ALWAYS_OVERRIDE && optionPriority2 == Config.OptionPriority.ALWAYS_OVERRIDE) {
            return true;
        }
        if (optionPriority != Config.OptionPriority.REQUIRED) return false;
        if (optionPriority2 != Config.OptionPriority.REQUIRED) return false;
        return true;
    }

    public static Config mergeConfigs(Config config, Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        config2 = config2 != null ? MutableOptionsBundle.from((Config)config2) : MutableOptionsBundle.create();
        if (config == null) return OptionsBundle.from((Config)config2);
        Iterator iterator = config.listOptions().iterator();
        while (iterator.hasNext()) {
            Config.Option option = (Config.Option)iterator.next();
            config2.insertOption(option, config.getOptionPriority(option), config.retrieveOption(option));
        }
        return OptionsBundle.from((Config)config2);
    }
}
