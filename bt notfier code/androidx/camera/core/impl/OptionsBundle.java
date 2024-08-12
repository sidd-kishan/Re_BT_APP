/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl._$$Lambda$OptionsBundle$eYBKifCst1_YbBGv195jrqZXdLA
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl._$;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class OptionsBundle
implements Config {
    private static final OptionsBundle EMPTY_BUNDLE;
    protected static final Comparator<Config.Option<?>> ID_COMPARE;
    protected final TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> mOptions;

    static {
        ID_COMPARE = _$.Lambda.OptionsBundle.eYBKifCst1_YbBGv195jrqZXdLA.INSTANCE;
        EMPTY_BUNDLE = new OptionsBundle(new TreeMap(ID_COMPARE));
    }

    OptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        this.mOptions = treeMap;
    }

    public static OptionsBundle emptyBundle() {
        return EMPTY_BUNDLE;
    }

    public static OptionsBundle from(Config config) {
        if (OptionsBundle.class.equals(config.getClass())) {
            return (OptionsBundle)config;
        }
        TreeMap treeMap = new TreeMap(ID_COMPARE);
        Iterator iterator = config.listOptions().iterator();
        while (iterator.hasNext()) {
            Config.Option option = (Config.Option)iterator.next();
            Object object = config.getPriorities(option);
            ArrayMap arrayMap = new ArrayMap();
            object = object.iterator();
            while (object.hasNext()) {
                Config.OptionPriority optionPriority = (Config.OptionPriority)object.next();
                arrayMap.put(optionPriority, config.retrieveOptionWithPriority(option, optionPriority));
            }
            treeMap.put(option, (Map<Config.OptionPriority, Object>)arrayMap);
        }
        return new OptionsBundle(treeMap);
    }

    static /* synthetic */ int lambda$static$0(Config.Option option, Config.Option option2) {
        return option.getId().compareTo(option2.getId());
    }

    public boolean containsOption(Config.Option<?> option) {
        return this.mOptions.containsKey(option);
    }

    public void findOptions(String string, Config.OptionMatcher optionMatcher) {
        Map.Entry entry;
        Object object = Config.Option.create((String)string, Void.class);
        object = this.mOptions.tailMap((Config.Option<?>)object).entrySet().iterator();
        do {
            if (!object.hasNext()) return;
        } while (((Config.Option)(entry = (Map.Entry)object.next()).getKey()).getId().startsWith(string) && optionMatcher.onOptionMatched((Config.Option)entry.getKey()));
    }

    public Config.OptionPriority getOptionPriority(Config.Option<?> option) {
        Map<Config.OptionPriority, Object> map = this.mOptions.get(option);
        if (map != null) {
            return Collections.min(map.keySet());
        }
        map = new StringBuilder();
        ((StringBuilder)((Object)map)).append("Option does not exist: ");
        ((StringBuilder)((Object)map)).append(option);
        throw new IllegalArgumentException(((StringBuilder)((Object)map)).toString());
    }

    public Set<Config.OptionPriority> getPriorities(Config.Option<?> object) {
        if ((object = this.mOptions.get(object)) != null) return Collections.unmodifiableSet(object.keySet());
        return Collections.emptySet();
    }

    public Set<Config.Option<?>> listOptions() {
        return Collections.unmodifiableSet(this.mOptions.keySet());
    }

    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> option) {
        Map<Config.OptionPriority, Object> map = this.mOptions.get(option);
        if (map != null) {
            return (ValueT)map.get(Collections.min(map.keySet()));
        }
        map = new StringBuilder();
        ((StringBuilder)((Object)map)).append("Option does not exist: ");
        ((StringBuilder)((Object)map)).append(option);
        throw new IllegalArgumentException(((StringBuilder)((Object)map)).toString());
    }

    public <ValueT> ValueT retrieveOption(Config.Option<ValueT> object, ValueT ValueT) {
        try {
            object = this.retrieveOption((Config.Option<ValueT>)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return ValueT;
        }
        return (ValueT)object;
    }

    public <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> option, Config.OptionPriority object) {
        Map<Config.OptionPriority, Object> map = this.mOptions.get(option);
        if (map == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Option does not exist: ");
            ((StringBuilder)object).append(option);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (map.containsKey(object)) {
            return (ValueT)map.get(object);
        }
        map = new StringBuilder();
        ((StringBuilder)((Object)map)).append("Option does not exist: ");
        ((StringBuilder)((Object)map)).append(option);
        ((StringBuilder)((Object)map)).append(" with priority=");
        ((StringBuilder)((Object)map)).append(object);
        throw new IllegalArgumentException(((StringBuilder)((Object)map)).toString());
    }
}
