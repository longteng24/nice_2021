package com.teng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx(){

        bookService.checkout("zhangsan", 1);

        bookService.updatePrice(1,1800);
        int i = 1/0;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();
    }
}