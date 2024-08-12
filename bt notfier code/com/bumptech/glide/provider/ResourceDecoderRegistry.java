/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.provider.ResourceDecoderRegistry$Entry
 */
package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {
    private final List<String> bucketPriorityList = new ArrayList<String>();
    private final Map<String, List<Entry<?, ?>>> decoders = new HashMap();

    private List<Entry<?, ?>> getOrAddEntryList(String string) {
        synchronized (this) {
            ArrayList arrayList;
            if (!this.bucketPriorityList.contains(string)) {
                this.bucketPriorityList.add(string);
            }
            ArrayList arrayList2 = arrayList = this.decoders.get(string);
            if (arrayList != null) return arrayList2;
            arrayList2 = new ArrayList();
            this.decoders.put(string, arrayList2);
            return arrayList2;
        }
    }

    public <T, R> void append(String string, ResourceDecoder<T, R> resourceDecoder, Class<T> clazz, Class<R> clazz2) {
        synchronized (this) {
            List<Entry<?, ?>> list = this.getOrAddEntryList(string);
            string = new Entry(clazz, clazz2, resourceDecoder);
            list.add((Entry<?, ?>)string);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public <T, R> List<ResourceDecoder<T, R>> getDecoders(Class<T> var1_1, Class<R> var2_3) {
        synchronized (this) {
            try {
                var3_4 = new ArrayList<ResourceDecoder<T, R>>();
                var4_5 = this.bucketPriorityList.iterator();
                block3: while (true) {
                    if (var4_5.hasNext() == false) return var3_4;
                    var5_6 = var4_5.next();
                    if ((var5_6 = this.decoders.get(var5_6)) == null) continue;
                    var5_6 = var5_6.iterator();
                    while (true) {
                        if (var5_6.hasNext()) ** break;
                        continue block3;
                        var6_7 = (Entry)var5_6.next();
                        if (!var6_7.handles(var1_1, var2_3)) continue;
                        var3_4.add(var6_7.decoder);
                    }
                    break;
                }
            }
            catch (Throwable var1_2) {
                throw var1_2;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public <T, R> List<Class<R>> getResourceClasses(Class<T> var1_1, Class<R> var2_3) {
        synchronized (this) {
            try {
                var3_4 = new ArrayList<Class<R>>();
                var4_5 = this.bucketPriorityList.iterator();
                block3: while (true) {
                    if (var4_5.hasNext() == false) return var3_4;
                    var5_6 = var4_5.next();
                    if ((var5_6 = this.decoders.get(var5_6)) == null) continue;
                    var6_7 = var5_6.iterator();
                    while (true) {
                        if (var6_7.hasNext()) ** break;
                        continue block3;
                        var5_6 = (Entry)var6_7.next();
                        if (!var5_6.handles(var1_1, var2_3)) continue;
                        var3_4.add(var5_6.resourceClass);
                    }
                    break;
                }
            }
            catch (Throwable var1_2) {
                throw var1_2;
            }
        }
    }

    public <T, R> void prepend(String object, ResourceDecoder<T, R> resourceDecoder, Class<T> clazz, Class<R> clazz2) {
        synchronized (this) {
            object = this.getOrAddEntryList((String)object);
            Entry entry = new Entry(clazz, clazz2, resourceDecoder);
            object.add(0, entry);
            return;
        }
    }

    public void setBucketPriorityList(List<String> list) {
        synchronized (this) {
            try {
                Object object = new ArrayList(this.bucketPriorityList);
                this.bucketPriorityList.clear();
                this.bucketPriorityList.addAll(list);
                object = object.iterator();
                while (object.hasNext()) {
                    String string = (String)object.next();
                    if (list.contains(string)) continue;
                    this.bucketPriorityList.add(string);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
