package com.example.hiberate.designPattern.Filter;

import com.example.hiberate.designPattern.Person;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
