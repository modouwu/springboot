package com.example.hiberate.multipyThread;

import com.example.hiberate.openSessionInView.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class testUser2 {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 15, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(500));

    private static void postList(List<User> list,Semaphore semaphore) throws InterruptedException {

        for (User user : list) {
            semaphore.acquire(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("jid=" + user.getJid() + ",thread=" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(user.getJid());
                    semaphore.release(1);
                }
            });
        }

    }

    public static void main(String[] args) throws InterruptedException {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            User user = new User();
            user.setJid("jid" + String.valueOf(i));
            list.add(user);
        }
//        CountDownLatch man = new CountDownLatch()
        Semaphore semaphore = new Semaphore(50);
        postList(list,semaphore);
        executorService.shutdown();
        System.out.println("end");
    }
}
