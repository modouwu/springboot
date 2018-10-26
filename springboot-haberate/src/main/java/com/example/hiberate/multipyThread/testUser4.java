package com.example.hiberate.multipyThread;

import com.example.hiberate.openSessionInView.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class testUser4 {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 15, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(500));
    private static Semaphore semaphore = new Semaphore(50);

    static AtomicInteger success =  new AtomicInteger(0);
    static AtomicInteger failed =  new AtomicInteger(0);
    private static void postList(List<User> list) throws InterruptedException {

        for (User user : list) {
            try {
                semaphore.acquire(1);
                executorService.execute(() -> {
                    System.out.println("jid=" + user.getJid() + ",thread=" + Thread.currentThread().getName());
                    success.incrementAndGet();

                    semaphore.release(1);
                });
            } catch (InterruptedException e) {
                System.out.println("semaphore.acquire失败,jid="+user.getJid());
                failed.incrementAndGet();
            }
        }
        System.out.println("本次执行条数为"+list.size()+",成功条数为"+ success.get()+"failed: " + failed.get());
        success.set(0);
        failed.set(0);
    }

    public static void main(String[] args) throws InterruptedException {

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setJid("jid" + String.valueOf(i));
            list.add(user);
        }
//        CountDownLatch man = new CountDownLatch()

        postList(list);
        executorService.shutdown();
        System.out.println("end");
    }
}
