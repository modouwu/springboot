package com.example.hiberate.jdk8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class testList {
    public static void main(String[] args){
        List<Integer> list1= Arrays.asList(1,2,3);
        Set<Integer> set1=list1.stream().collect(Collectors.toSet());
        List<Integer> list2= Arrays.asList(1,3,5,7);
        Set<Integer> set2=list2.stream().collect(Collectors.toSet());
        set1.addAll(set2);
        set1.stream().forEach(integer -> System.out.println(integer));
    }
}
