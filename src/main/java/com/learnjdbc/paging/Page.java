package com.learnjdbc.paging;

import com.learnjdbc.sort.Sorter;

public interface Page {
    public Integer getPage();
    public Integer getOffset();
    public Integer getLimit();
    public Sorter getSorter();
    public String getSearch();
}
