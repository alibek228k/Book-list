package com.example.booklist;

import android.content.Context;
import android.content.AsyncTaskLoader;


import java.util.List;

public class BookListLoader extends AsyncTaskLoader<List<Book>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = BookListLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link BookListLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public BookListLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    public BookListLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of books.
        List<Book> books = QueryUtils.fetchBookListData(mUrl);
        return books;
    }
}
