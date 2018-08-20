package com.example.hiberate.openSessionInView.dao;

import com.example.hiberate.openSessionInView.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class UserDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public User getUser(String jid){
        return entityManagerFactory.createEntityManager().find(User.class,jid);
    }
}
