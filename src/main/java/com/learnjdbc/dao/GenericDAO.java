package com.learnjdbc.dao;

import com.learnjdbc.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T>List<T> query(String query, RowMapper<T> rowMapper, Object...parameter);
    boolean execute(String query, Object...parameter);
    int count(String query,Object...parameter);
    Long insertGetId(String query, Object...parameter);
}
