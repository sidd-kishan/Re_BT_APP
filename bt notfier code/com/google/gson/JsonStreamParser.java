/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser
implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader closeable) {
        closeable = new JsonReader((Reader)closeable);
        this.parser = closeable;
        ((JsonReader)closeable).setLenient(true);
        this.lock = new Object();
    }

    public JsonStreamParser(String string) {
        this(new StringReader(string));
    }

    @Override
    public boolean hasNext() {
        Object object = this.lock;
        synchronized (object) {
            Throwable throwable2;
            block6: {
                boolean bl;
                try {
                    JsonToken jsonToken = this.parser.peek();
                    JsonToken jsonToken2 = JsonToken.END_DOCUMENT;
                    bl = jsonToken != jsonToken2;
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                catch (IOException iOException) {
                    JsonIOException jsonIOException = new JsonIOException(iOException);
                    throw jsonIOException;
                }
                catch (MalformedJsonException malformedJsonException) {
                    JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(malformedJsonException);
                    throw jsonSyntaxException;
                }
                return bl;
            }
            throw throwable2;
        }
    }

    @Override
    public JsonElement next() throws JsonParseException {
        if (!this.hasNext()) throw new NoSuchElementException();
        try {
            JsonElement jsonElement = Streams.parse(this.parser);
            return jsonElement;
        }
        catch (JsonParseException jsonParseException) {
            RuntimeException runtimeException = jsonParseException;
            if (!(jsonParseException.getCause() instanceof EOFException)) throw runtimeException;
            runtimeException = new NoSuchElementException();
            throw runtimeException;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            throw new JsonParseException("Failed parsing JSON source to Json", outOfMemoryError);
        }
        catch (StackOverflowError stackOverflowError) {
            throw new JsonParseException("Failed parsing JSON source to Json", stackOverflowError);
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
