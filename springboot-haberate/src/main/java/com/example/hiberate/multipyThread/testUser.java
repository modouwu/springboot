package com.example.hiberate.multipyThread;

import com.example.hiberate.openSessionInView.entity.User;
import net.sf.ehcache.search.aggregator.Count;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class testUser {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 15, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(500));
    private static Semaphore semaphore = new Semaphore(50);
    private static AtomicInteger success =  new AtomicInteger(0);
    private static AtomicInteger failed =  new AtomicInteger(0);
    private static List<User> userOfReList = new ArrayList<>();
    private static int ssssss=2;
    private static void postList(List<User> list, CountDownLatch countDownLatch) throws InterruptedException {

        for (User user : list) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("jid=" + user.getJid() + ",thread=" + Thread.currentThread().getName());
                    //System.out.println(user.getJid());
                    Integer jid=null;
                    try {
                        jid=Integer.valueOf(user.getJid());
                        if (jid!=0&&jid%ssssss>0){
                            userOfReList.add(user);
                        }
                        success.incrementAndGet();
                    }catch (Exception e){
                        System.out.println(jid);
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
//        System.out.println("await list size:" + list.size());

    }

    public static void main(String[] args) throws InterruptedException {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setJid(String.valueOf(i));
            list.add(user);
        }
        for (int j = 0; j < 100; j++) {
            List<User> list2 = list.subList(j * 50, (j + 1) * 50);
            CountDownLatch count = new CountDownLatch(list2.size());
            postList(list2, count);
//            Thread.sleep(30);
            count.await();
        }
        int pageSize=100;
        int count=5000;
        System.out.println("end"+success.get());
        List<User> userOfReListCopy=new ArrayList<>(userOfReList.size());
        userOfReListCopy.addAll(userOfReList);
        userOfReList.clear();
        while(userOfReListCopy.size()>=count*0.4){
            for (int i=0;i<userOfReListCopy.size();i=i+pageSize){
                CountDownLatch countDownLatch;
                if (i+pageSize>userOfReListCopy.size()){
                    countDownLatch = new CountDownLatch(userOfReListCopy.size()-i);
                    postList(userOfReListCopy.subList(i,userOfReListCopy.size()),countDownLatch);
                }else {
                    countDownLatch = new CountDownLatch(pageSize);
                    postList(userOfReListCopy.subList(i,i+pageSize),countDownLatch);
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    System.out.println("countDownLatch.await()执行失败");
                }
            }
            ssssss++;
            userOfReListCopy=new ArrayList<>(userOfReList.size());
            userOfReListCopy.addAll(userOfReList);
            userOfReList.clear();
        }
        System.out.println("总数="+count+",成功="+(count-userOfReList.size())+",失败="+userOfReList.size());
    }
}
