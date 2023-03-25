package com.learnjdbc.paging;

import com.learnjdbc.sort.Sorter;

public interface Page {
    public int getPage();
    public int getOffset();
    public int getLimit();
    public Sorter getSorter();
}
