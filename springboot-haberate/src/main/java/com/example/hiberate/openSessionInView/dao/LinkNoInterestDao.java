package com.example.hiberate.openSessionInView.dao;

import com.example.hiberate.openSessionInView.entity.LinkNoInterest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Repository
public class LinkNoInterestDao {

    //private final LinkNoInterestRepository linkNoInterestRepository;
    //private SessionFactory sessionFactory;


    /*@Autowired
    public LinkNoInterestDao(LinkNoInterestRepository linkNoInterestRepository
                             , EntityManagerFactory factory
                             ) {
        this.linkNoInterestRepository = linkNoInterestRepository;
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }*/

    /*@Transactional(readOnly = true)
    public LinkNoInterest getModel(Long id){
        LinkNoInterest test =  sessionFactory.getCurrentSession().get(LinkNoInterest.class, 1L);

        return linkNoInterestRepository.findById(id).get();
    }*/
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    /*@Autowired
    private SessionFactory sessionFactory;直接注入 有问题*/
    @Autowired
    private EntityManager entityManager;
    //@Transactional

    public LinkNoInterest getModel(Long id){
        LinkNoInterest model=entityManagerFactory.createEntityManager().find(LinkNoInterest.class,id);
        System.out.println(model.toString());
        LinkNoInterest model2=entityManager.find(LinkNoInterest.class,id);//jpa方式
        System.out.println(model2.toString());
        LinkNoInterest model3=entityManager.unwrap(Session.class).find(LinkNoInterest.class,id);
        System.out.println(model3.toString());
        //hibernate方式　　　　　　　　　　　　　　　　　　　　　
        LinkNoInterest model4=entityManagerFactory.unwrap(SessionFactory.class).openSession().find(LinkNoInterest.class,id);
        System.out.println(model4.toString());//这里 getCurrentSession会报错,openSession不报错
        /*LinkNoInterest model5=entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession().find(LinkNoInterest.class,id);
        System.out.println(model5.toString());//这里 getCurrentSession会报错,加上Transactional还是报错no transaction is in progress*/
        //哈哈哈
        //哈哈2
        return model;
    }
}
