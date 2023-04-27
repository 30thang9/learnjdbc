package com.learnjdbc.paging;

import com.learnjdbc.sort.Sorter;

public class PageRequest implements Page {
    private Integer page;
    private Integer pageSize;
    private Sorter sort;
    private String search;

    public PageRequest(int page, int pageSize, Sorter sort,String search) {
        this.page = page;
        this.pageSize = pageSize;
        this.sort = sort;
        this.search = search;
    }

    @Override
    public Integer getPage() {
        return this.page;
    }

    @Override
    public Integer getOffset() {
        return page<0||pageSize<0?-1:(this.page-1)*this.pageSize;
    }

    @Override
    public Integer getLimit() {
        return this.pageSize;
    }

    @Override
    public Sorter getSorter() {
        if(this.sort!=null){
            return this.sort;
        }
        return null;
    }

    @Override
    public String getSearch() {
        return this.search;
    }
}
