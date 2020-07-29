package Base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class test3 {
    public static void main(String[] args){

    }
}

class book{
    public int id;
    public String Name;
    public book(int id, String name){
        this.id = id;
        this.Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        book book = (book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}