package com.example.hiberate.multipyThread;

import com.example.hiberate.openSessionInView.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class testUser3 {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 15, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(500));
    private static Semaphore semaphore = new Semaphore(50);

    private static void postList(List<User> list, Semaphore semaphore) throws InterruptedException {

        for (User user : list) {
            semaphore.acquire(1);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("jid=" + user.getJid() + ",thread=" + Thread.currentThread().getName());
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
        for (int j = 0; j < 100; j++) {
            List<User> list2 = list.subList(j * 50, (j + 1) * 50);
            postList(list2,semaphore);
        }
        executorService.shutdown();
        System.out.println("end");
    }
}
