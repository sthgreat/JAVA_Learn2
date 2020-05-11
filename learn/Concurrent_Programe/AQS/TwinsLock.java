package Concurrent_Programe.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {
    static class sync extends AbstractQueuedLongSynchronizer{
        sync(int count){
            if(count <= 0){
                throw new IllegalArgumentException();
            }
            setState(count);
        }

        @Override
        protected long tryAcquireShared(long arg) {
            for(;;){
                long current = getState();
                long newCount = current - arg;
                if(newCount < 0 || compareAndSetState(current, newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(long arg) {
            for(;;){
                long current = getState();
                long newCount = current + arg;
                if(compareAndSetState(current, newCount)){
                    return true;
                }
            }
        }
    }


    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
