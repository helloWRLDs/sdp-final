package com.bookStore;

import com.bookStore.entity.Book;
import com.bookStore.patterns.Decorator.DetectiveTag;
import com.bookStore.patterns.Decorator.DramaTag;
import com.bookStore.patterns.Decorator.MysteryTag;
import com.bookStore.patterns.Observer.MailNotification;
import com.bookStore.patterns.Observer.Subscriber;
import com.bookStore.patterns.Singleton.BookRepository;
import com.bookStore.patterns.Singleton.Database;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
