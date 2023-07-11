package com.learnjdbc.dao.impl;

import com.learnjdbc.dao.GenericDAO;
import com.learnjdbc.mapper.RowMapper;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/ogani4?useSSL=false";
            String user="root";
            String passWord="123456";
            return DriverManager.getConnection(url,user,passWord);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    @Override
    public <T> List<T> query(String query, RowMapper<T> rowMapper, Object... parameter) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<T> listModel=new ArrayList<T>();
        ResultSet resultSet=null;
        try {
            connection=getConnection();
            preparedStatement=connection.prepareStatement(query);
            setParameter(preparedStatement,parameter);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                listModel.add(rowMapper.mapRow(resultSet));
            }
            return  listModel;
        } catch (SQLException e) {
            return null;
        }finally {
            try {
                if(connection!=null){
                    connection.close();
                }
                if(preparedStatement!=null){
                    preparedStatement.close();
                }if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean execute(String query, Object... parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            setParameter(preparedStatement, parameter);
            int result = preparedStatement.executeUpdate();
            connection.commit();
            return result > 0;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public Long insertGetId(String query, Object... parameter) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Long id=null;
        try {
            connection=getConnection();
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            setParameter(preparedStatement,parameter);
            preparedStatement.executeUpdate();
            resultSet= preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                id= resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            try {
                if(connection!=null){
                    connection.close();
                }
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int count(String query, Object... parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            setParameter(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null){
                    connection.close();
                }
                if(preparedStatement!=null){
                    preparedStatement.close();
                }if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public void setParameter(PreparedStatement preparedStatement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object param = parameters[i];
                int index = i + 1;
                if (param == null) {
                    preparedStatement.setNull(index, Types.NULL);
                } else if (param instanceof String) {
                    preparedStatement.setString(index, (String) param);
                } else if (param instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) param);
                } else if (param instanceof Long) {
                    preparedStatement.setLong(index, (Long) param);
                } else if (param instanceof Double) {
                    preparedStatement.setDouble(index, (Double) param);
                } else if (param instanceof Float) {
                    preparedStatement.setFloat(index, (Float) param);
                } else if (param instanceof Boolean) {
                    preparedStatement.setBoolean(index, (Boolean) param);
                } else if (param instanceof Byte) {
                    preparedStatement.setByte(index, (Byte) param);
                } else if (param instanceof Short) {
                    preparedStatement.setShort(index, (Short) param);
                } else if (param instanceof BigDecimal) {
                    preparedStatement.setBigDecimal(index, (BigDecimal) param);
                } else if (param instanceof Date) {
                    preparedStatement.setDate(index, (Date) param);
                } else if (param instanceof Time) {
                    preparedStatement.setTime(index, (Time) param);
                } else if (param instanceof Timestamp) {
                    preparedStatement.setTimestamp(index, (Timestamp) param);
                } else if (param instanceof Blob) {
                    preparedStatement.setBlob(index, (Blob) param);
                } else if (param instanceof Clob) {
                    preparedStatement.setClob(index, (Clob) param);
                } else if (param instanceof Array) {
                    preparedStatement.setArray(index, (Array) param);
                } else if (param instanceof Ref) {
                    preparedStatement.setRef(index, (Ref) param);
                } else {
                    throw new IllegalArgumentException("Unsupported parameter type: " + param.getClass().getSimpleName());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error setting parameters on prepared statement: " + e.getMessage(), e);
        }
    }

}
