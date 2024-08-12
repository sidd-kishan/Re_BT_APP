/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.MediationServerParameters$MappingException
 *  com.google.ads.mediation.MediationServerParameters$Parameter
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.ads.mediation;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.internal.ads.zzcgt;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class MediationServerParameters {
    public void load(Map<String, String> object) throws MappingException {
        Object object322 = new HashMap<String, Field>();
        for (Field field : this.getClass().getFields()) {
            Parameter object22 = field.getAnnotation(Parameter.class);
            if (object22 == null) continue;
            object322.put(object22.name(), field);
        }
        if (object322.isEmpty()) {
            zzcgt.zzi((String)"No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry entry : object.entrySet()) {
            Object object5 = (Field)object322.remove(entry.getKey());
            if (object5 != null) {
                try {
                    ((Field)object5).set(this, entry.getValue());
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    String string = (String)entry.getKey();
                    object5 = new StringBuilder(String.valueOf(string).length() + 43);
                    ((StringBuilder)object5).append("Server option \"");
                    ((StringBuilder)object5).append(string);
                    ((StringBuilder)object5).append("\" could not be set: Bad Type");
                    zzcgt.zzi((String)((StringBuilder)object5).toString());
                }
                catch (IllegalAccessException illegalAccessException) {
                    String string = (String)entry.getKey();
                    object5 = new StringBuilder(String.valueOf(string).length() + 49);
                    ((StringBuilder)object5).append("Server option \"");
                    ((StringBuilder)object5).append(string);
                    ((StringBuilder)object5).append("\" could not be set: Illegal Access");
                    zzcgt.zzi((String)((StringBuilder)object5).toString());
                }
                continue;
            }
            object5 = (String)entry.getKey();
            String string = (String)entry.getValue();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(object5).length() + 31 + String.valueOf(string).length());
            stringBuilder.append("Unexpected server option: ");
            stringBuilder.append((String)object5);
            stringBuilder.append(" = \"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
            zzcgt.zzd((String)stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object322 : object322.values()) {
            if (!((Field)object322).getAnnotation(Parameter.class).required()) continue;
            object = String.valueOf(((Field)object322).getAnnotation(Parameter.class).name());
            object = ((String)object).length() != 0 ? "Required server option missing: ".concat((String)object) : new String("Required server option missing: ");
            zzcgt.zzi((String)object);
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(((Field)object322).getAnnotation(Parameter.class).name());
        }
        if (stringBuilder.length() <= 0) return;
        object = stringBuilder.toString();
        object = ((String)object).length() != 0 ? "Required server option(s) missing: ".concat((String)object) : new String("Required server option(s) missing: ");
        throw new MappingException((String)object);
    }
}
