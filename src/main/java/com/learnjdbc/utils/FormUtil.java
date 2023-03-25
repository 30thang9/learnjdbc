package com.learnjdbc.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

public class FormUtil {

    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> clazz, HttpServletRequest request){
        T object =null;
        try {
            object=clazz.newInstance();
            BeanUtils.populate(object,request.getParameterMap());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
