/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) != 0) {
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)DocumentsContractApi19.getRawType(context, uri))) return true;
        return false;
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String string = DocumentsContractApi19.getRawType(context, uri);
        int n = DocumentsContractApi19.queryForInt(context, uri, "flags", 0);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return false;
        }
        if ((n & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(string) && (n & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty((CharSequence)string)) return false;
        if ((n & 2) == 0) return false;
        return true;
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable == null) return;
        try {
            autoCloseable.close();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static boolean exists(Context context, Uri uri) {
        Throwable throwable2222222;
        block5: {
            Object object = context.getContentResolver();
            boolean bl = false;
            Uri uri2 = null;
            context = null;
            uri = object.query(uri, new String[]{"document_id"}, null, null, null);
            context = uri;
            uri2 = uri;
            int n = uri.getCount();
            if (n > 0) {
                bl = true;
            }
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (Exception exception) {}
                context = uri2;
                {
                    context = uri2;
                    object = new StringBuilder();
                    context = uri2;
                    ((StringBuilder)object).append("Failed query: ");
                    context = uri2;
                    ((StringBuilder)object).append(exception);
                    context = uri2;
                    Log.w((String)TAG, (String)((StringBuilder)object).toString());
                }
                DocumentsContractApi19.closeQuietly((AutoCloseable)uri2);
                return false;
            }
            DocumentsContractApi19.closeQuietly((AutoCloseable)uri);
            return bl;
        }
        DocumentsContractApi19.closeQuietly((AutoCloseable)context);
        throw throwable2222222;
    }

    public static long getFlags(Context context, Uri uri) {
        return DocumentsContractApi19.queryForLong(context, uri, "flags", 0L);
    }

    public static String getName(Context context, Uri uri) {
        return DocumentsContractApi19.queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return DocumentsContractApi19.queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri object) {
        object = DocumentsContractApi19.getRawType(context, object);
        context = object;
        if (!"vnd.android.document/directory".equals(object)) return context;
        context = null;
        return context;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(DocumentsContractApi19.getRawType(context, uri));
    }

    public static boolean isFile(Context object, Uri uri) {
        if ("vnd.android.document/directory".equals(object = DocumentsContractApi19.getRawType(object, uri))) return false;
        if (!TextUtils.isEmpty((CharSequence)object)) return true;
        return false;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        boolean bl = DocumentsContract.isDocumentUri((Context)context, (Uri)uri);
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if ((DocumentsContractApi19.getFlags(context, uri) & 0x200L) == 0L) return bl2;
        bl2 = true;
        return bl2;
    }

    public static long lastModified(Context context, Uri uri) {
        return DocumentsContractApi19.queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return DocumentsContractApi19.queryForLong(context, uri, "_size", 0L);
    }

    private static int queryForInt(Context context, Uri uri, String string, int n) {
        return (int)DocumentsContractApi19.queryForLong(context, uri, string, n);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static long queryForLong(Context context, Uri uri, String charSequence, long l) {
        Throwable throwable2222222;
        block5: {
            block4: {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri2 = null;
                context = null;
                uri = contentResolver.query(uri, new String[]{charSequence}, null, null, null);
                context = uri;
                uri2 = uri;
                if (!uri.moveToFirst()) break block4;
                context = uri;
                uri2 = uri;
                if (uri.isNull(0)) break block4;
                context = uri;
                uri2 = uri;
                long l2 = uri.getLong(0);
                {
                    catch (Throwable throwable2222222) {
                        break block5;
                    }
                    catch (Exception exception) {}
                    context = uri2;
                    {
                        context = uri2;
                        charSequence = new StringBuilder();
                        context = uri2;
                        ((StringBuilder)charSequence).append("Failed query: ");
                        context = uri2;
                        ((StringBuilder)charSequence).append(exception);
                        context = uri2;
                        Log.w((String)TAG, (String)((StringBuilder)charSequence).toString());
                    }
                    DocumentsContractApi19.closeQuietly((AutoCloseable)uri2);
                    return l;
                }
                DocumentsContractApi19.closeQuietly((AutoCloseable)uri);
                return l2;
            }
            DocumentsContractApi19.closeQuietly((AutoCloseable)uri);
            return l;
        }
        DocumentsContractApi19.closeQuietly((AutoCloseable)context);
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private static String queryForString(Context context, Uri uri, String charSequence, String string) {
        Throwable throwable2222222;
        block5: {
            block4: {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri2 = null;
                context = null;
                uri = contentResolver.query(uri, new String[]{charSequence}, null, null, null);
                context = uri;
                uri2 = uri;
                if (!uri.moveToFirst()) break block4;
                context = uri;
                uri2 = uri;
                if (uri.isNull(0)) break block4;
                context = uri;
                uri2 = uri;
                charSequence = uri.getString(0);
                {
                    catch (Throwable throwable2222222) {
                        break block5;
                    }
                    catch (Exception exception) {}
                    context = uri2;
                    {
                        context = uri2;
                        charSequence = new StringBuilder();
                        context = uri2;
                        ((StringBuilder)charSequence).append("Failed query: ");
                        context = uri2;
                        ((StringBuilder)charSequence).append(exception);
                        context = uri2;
                        Log.w((String)TAG, (String)((StringBuilder)charSequence).toString());
                    }
                    DocumentsContractApi19.closeQuietly((AutoCloseable)uri2);
                    return string;
                }
                DocumentsContractApi19.closeQuietly((AutoCloseable)uri);
                return charSequence;
            }
            DocumentsContractApi19.closeQuietly((AutoCloseable)uri);
            return string;
        }
        DocumentsContractApi19.closeQuietly((AutoCloseable)context);
        throw throwable2222222;
    }
}
