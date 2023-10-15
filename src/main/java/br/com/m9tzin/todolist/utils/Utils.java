package br.com.m9tzin.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {
    
    public static void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }


    /* pegar todas as propriedades que forem null e realizar a conversao (c o beanutils) para obter a mescla das infos */
    public static String[] getNullPropertyNames(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source); /* Acessar as propriedades de um objeto no Java */
        
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for(PropertyDescriptor pd: pds){
            
           Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null){
            emptyNames.add(pd.getName());
             }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}