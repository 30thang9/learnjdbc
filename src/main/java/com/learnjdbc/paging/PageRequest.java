package com.learnjdbc.paging;

import com.learnjdbc.sort.Sorter;

public class PageRequest implements Page {
    private int page;
    private int pageSize;
    private Sorter sort;

    public PageRequest(int page, int pageSize, Sorter sort) {
        this.page = page;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    @Override
    public int getPage() {
        return this.page;
    }

    @Override
    public int getOffset() {
        return (this.page-1)*this.pageSize;
    }

    @Override
    public int getLimit() {
        return this.pageSize;
    }

    @Override
    public Sorter getSorter() {
        if(this.sort!=null){
            return this.sort;
        }
        return null;
    }
}
