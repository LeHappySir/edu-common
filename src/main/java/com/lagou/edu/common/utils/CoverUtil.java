package com.lagou.edu.common.utils;

import net.sf.cglib.beans.BeanCopier;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ConverUtil
 *
 * @author xianhongle
 * @data 2022/1/5 12:00 上午
 **/
public class CoverUtil {

    public static <S,T> T cover(S source, T target) {
        if(source == null || target == null){
            return null;
        }
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        T result = target;
        copier.copy(source,result,null);
        return result;
    }

    public static <S,T> T cover(S source, Class<T> targetClass){
        try {
            return cover(source,targetClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <S,T> List<T> coverList(List<S> source, final Class<T> targetClass){
        if(source == null){
            return null;
        }
        return source.stream().map(item -> {
            T result = null;
            try {
                result = targetClass.newInstance();
                cover(item,result);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return result;
        }).collect(Collectors.toList());
    }

}
