package com.example.hiberate.openSessionInView.service;

import com.example.hiberate.openSessionInView.dao.LinkNoInterestDao;
import com.example.hiberate.openSessionInView.entity.LinkNoInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LinkNoInterestService {
    @Autowired
    LinkNoInterestDao linkNoInterestDao;
    public LinkNoInterest getModel(Long id){
        return linkNoInterestDao.getModel(id);
    }
}
