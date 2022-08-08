package com.Tutor;

import java.util.concurrent.Semaphore;

public class Foo {
        private Semaphore sem1 = new Semaphore(0);
        private Semaphore sem2 = new Semaphore(0);

        public Foo(){
        }

        public void first(Runnable r) {
            r.run();
            sem1.release();
        }
        public void second(Runnable r) {
            try{
            sem1.acquire();
            r.run();
            sem2.release();
            }catch (InterruptedException e){

            }

    }
        public void third(Runnable r) {
            try {
                sem2.acquire();
                r.run();
            }catch (InterruptedException e){

            }
    }
}
