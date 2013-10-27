package com.binarytenshi.fundamentals.core.helper;

import java.util.ArrayList;
import java.util.Arrays;

import com.binarytenshi.fundamentals.core.IContent;

/**
 * Handles all registered {@link IContent} objects which can be stored inside
 * vials.
 * 
 * @author BinaryTENSHi
 */

public class ContentHelper {

    private static ArrayList<IContent> contentList = new ArrayList<IContent>();

    /**
     * Returns all registered {@link IContent}s
     * 
     * @return registered {@link IContent}s
     */
    public static ArrayList<IContent> getAllContents() {
        return contentList;
    }

    /**
     * Returns the {@link IContent} with the given id
     * 
     * @param id
     *            id of the {@link IContent}
     * @return {@link IContent} with the given id <br/>
     *         null if not found
     */
    public static IContent getContent(String id) {
        for (IContent entry : contentList) {
            if (entry.getId().equals(id)) {
                return entry;
            }
        }

        return null;
    }

    /**
     * Register a collection of {@link IContent}
     * 
     * @param contents
     *            {@link IContent}s to register
     */
    public static void registerContent(IContent... contents) {
        contentList.addAll(Arrays.asList(contents));
    }
}
