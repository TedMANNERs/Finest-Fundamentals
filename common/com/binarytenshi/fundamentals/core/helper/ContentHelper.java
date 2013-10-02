package com.binarytenshi.fundamentals.core.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.binarytenshi.fundamentals.core.IContent;
import com.binarytenshi.fundamentals.lib.Strings;

/**
 * Handles all registered {@link IContent} objects which can be stored inside vials.
 * 
 * @author BinaryTENSHi
 *
 */
public class ContentHelper {

    private static ArrayList<IContent> contentList = new ArrayList<IContent>();

    public static void registerContent(IContent... contents) {
        contentList.addAll(Arrays.asList(contents));
    }

    public static IContent getContent(String id) {
        for (IContent entry : contentList) {
            if (entry.getId().equals(id))
                return entry;
        }

        return null;
    }

    public static ArrayList<IContent> getAllContents() {
        return contentList;
    }
}
