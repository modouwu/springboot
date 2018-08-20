package com.example.hiberate.querydsl;

import com.example.hiberate.openSessionInView.entity.QUser;
import com.example.hiberate.openSessionInView.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao2 {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    private QUser qUser=QUser.user;
    public User getUser(){
        JPAQuery<User> query=jpaQueryFactory.select(qUser)
                .from(qUser);
        return query.fetchOne();
    }
}
