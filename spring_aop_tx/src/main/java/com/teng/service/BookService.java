package com.teng.service;

import com.teng.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /*
    * propagation:传播特性：表示不同的事务之间执行的关系
    * isolation:隔离级别：4种隔离级别，会引发不同的数据错乱问题
    * timeout：超时时间,
    * readonly：只读事务:如果配置了只读事务，那么在事务运行期间，不允许对数据进行修改，否则抛出异常
    *
    * 设置哪些异常不会回滚数据
    * noRollBackfor: noRollbackFor = {ArithmeticException.class}
    * noRollbackForClassName:
    *
    * 设置哪些异常回滚
    * rollBackfor:
    * rollbackForClassName
    * */
  //  @Transactional(isolation = Isolation.SERIALIZABLE)
    public void buyBook() throws FileNotFoundException {
        //获取编号为1的书价格
        bookDao.getPrice(1);

        //买一本书，减去100
        bookDao.updateBalance("zhangsan", 100);
        int i = 1/0;
        //书的数量减100
        bookDao.updateStock(1);
     //

      //  new FileInputStream("aaa.txt");
    }

    public void buyBook01() throws FileNotFoundException  {
        bookDao.getPrice(1);
        bookDao.updateBalance("zhangsan", 100);
        bookDao.updateStock(1);
    }



    /**
     * 结账：传入哪个用户买了哪本书
     * @param username
     * @param id
     */
    @Transactional(propagation = Propagation.NESTED)
    public void checkout(String username,int id) {

        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        //扣费
        bookDao.updateBalance(username,price);

    }

    @Transactional
    public void updatePrice(int id,int price){
        //修改书价格
        bookDao.updatePrice(id,price);
     //   int i = 1/0;
    }

    @Transactional
    public void mulTx(){
        try {
           checkout("zhangsan", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("...................");
       updatePrice(1,1200);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.mulTx();
    }
}
