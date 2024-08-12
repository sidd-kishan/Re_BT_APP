/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.Parser
 *  net.sourceforge.pinyin4j.GwoyeuRomatzyhResource$GwoyeuRomatzyhSystemResourceHolder
 *  net.sourceforge.pinyin4j.ResourceHelper
 */
package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import net.sourceforge.pinyin4j.GwoyeuRomatzyhResource;
import net.sourceforge.pinyin4j.ResourceHelper;

class GwoyeuRomatzyhResource {
    private Document pinyinToGwoyeuMappingDoc;

    private GwoyeuRomatzyhResource() {
        this.initializeResource();
    }

    static GwoyeuRomatzyhResource getInstance() {
        return GwoyeuRomatzyhSystemResourceHolder.theInstance;
    }

    private void initializeResource() {
        try {
            this.setPinyinToGwoyeuMappingDoc(Parser.parse((String)"", (InputStream)ResourceHelper.getResourceInputStream((String)"/pinyindb/pinyin_gwoyeu_mapping.xml")));
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void setPinyinToGwoyeuMappingDoc(Document document) {
        this.pinyinToGwoyeuMappingDoc = document;
    }

    Document getPinyinToGwoyeuMappingDoc() {
        return this.pinyinToGwoyeuMappingDoc;
    }
}
