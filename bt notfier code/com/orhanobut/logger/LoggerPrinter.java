/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.LogAdapter
 *  com.orhanobut.logger.Printer
 *  com.orhanobut.logger.Utils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.orhanobut.logger;

import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.Printer;
import com.orhanobut.logger.Utils;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LoggerPrinter
implements Printer {
    private static final int JSON_INDENT = 2;
    private final ThreadLocal<String> localTag = new ThreadLocal();
    private final List<LogAdapter> logAdapters = new ArrayList<LogAdapter>();

    LoggerPrinter() {
    }

    private String createMessage(String string, Object ... objectArray) {
        String string2 = string;
        if (objectArray == null) return string2;
        string2 = objectArray.length == 0 ? string : String.format(string, objectArray);
        return string2;
    }

    private String getTag() {
        String string = this.localTag.get();
        if (string == null) return null;
        this.localTag.remove();
        return string;
    }

    private void log(int n, Throwable throwable, String string, Object ... objectArray) {
        synchronized (this) {
            Utils.checkNotNull((Object)string);
            this.log(n, this.getTag(), this.createMessage(string, objectArray), throwable);
            return;
        }
    }

    public void addAdapter(LogAdapter logAdapter) {
        this.logAdapters.add((LogAdapter)Utils.checkNotNull((Object)logAdapter));
    }

    public void clearLogAdapters() {
        this.logAdapters.clear();
    }

    public void d(Object object) {
        this.log(3, null, Utils.toString((Object)object), new Object[0]);
    }

    public void d(String string, Object ... objectArray) {
        this.log(3, null, string, objectArray);
    }

    public void e(String string, Object ... objectArray) {
        this.e(null, string, objectArray);
    }

    public void e(Throwable throwable, String string, Object ... objectArray) {
        this.log(6, throwable, string, objectArray);
    }

    public void i(String string, Object ... objectArray) {
        this.log(4, null, string, objectArray);
    }

    public void json(String string) {
        if (Utils.isEmpty((CharSequence)string)) {
            this.d("Empty/Null json content");
            return;
        }
        try {
            string = string.trim();
            if (string.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(string);
                this.d(jSONObject.toString(2));
                return;
            }
            if (string.startsWith("[")) {
                JSONArray jSONArray = new JSONArray(string);
                this.d(jSONArray.toString(2));
                return;
            }
            this.e("Invalid Json", new Object[0]);
        }
        catch (JSONException jSONException) {
            this.e("Invalid Json", new Object[0]);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void log(int var1_1, String var2_2, String var3_4, Throwable var4_5) {
        synchronized (this) {
            var5_6 = var3_4;
            if (var4_5 == null) ** GOTO lbl15
            var5_6 = var3_4;
            if (var3_4 == null) ** GOTO lbl15
            try {
                var5_6 = new StringBuilder();
                var5_6.append((String)var3_4);
                var5_6.append(" : ");
                var5_6.append(Utils.getStackTraceString((Throwable)var4_5));
                var5_6 = var5_6.toString();
lbl15:
                // 3 sources

                var3_4 = var5_6;
                if (var4_5 != null) {
                    var3_4 = var5_6;
                    if (var5_6 == null) {
                        var3_4 = Utils.getStackTraceString((Throwable)var4_5);
                    }
                }
                var4_5 = var3_4;
                if (Utils.isEmpty((CharSequence)var3_4)) {
                    var4_5 = "Empty/NULL log message";
                }
                var3_4 = this.logAdapters.iterator();
                while (var3_4.hasNext() != false) {
                    var5_6 = (LogAdapter)var3_4.next();
                    if (!var5_6.isLoggable(var1_1, var2_2)) continue;
                    var5_6.log(var1_1, var2_2, (String)var4_5);
                }
                return;
            }
            catch (Throwable var2_3) {
                throw var2_3;
            }
        }
    }

    public Printer t(String string) {
        if (string == null) return this;
        this.localTag.set(string);
        return this;
    }

    public void v(String string, Object ... objectArray) {
        this.log(2, null, string, objectArray);
    }

    public void w(String string, Object ... objectArray) {
        this.log(5, null, string, objectArray);
    }

    public void wtf(String string, Object ... objectArray) {
        this.log(7, null, string, objectArray);
    }

    public void xml(String object) {
        if (Utils.isEmpty((CharSequence)object)) {
            this.d("Empty/Null xml content");
            return;
        }
        try {
            Object object2 = new StringReader((String)object);
            StreamSource streamSource = new StreamSource((Reader)object2);
            object2 = new StringWriter();
            object = new StreamResult((Writer)object2);
            object2 = TransformerFactory.newInstance().newTransformer();
            ((Transformer)object2).setOutputProperty("indent", "yes");
            ((Transformer)object2).setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            ((Transformer)object2).transform(streamSource, (Result)object);
            this.d(((StreamResult)object).getWriter().toString().replaceFirst(">", ">\n"));
        }
        catch (TransformerException transformerException) {
            this.e("Invalid xml", new Object[0]);
        }
    }
}
