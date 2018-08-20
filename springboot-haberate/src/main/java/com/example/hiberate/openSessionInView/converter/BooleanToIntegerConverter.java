package com.example.hiberate.openSessionInView.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Boolean aBoolean) {
        if (aBoolean==null){
            return null;
        }
        if (aBoolean.equals(Boolean.TRUE)){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public Boolean convertToEntityAttribute(Integer integer) {
        if (integer==null){
            return null;
        }
        if (integer ==1){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
}
