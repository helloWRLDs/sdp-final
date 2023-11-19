package com.bookStore.patterns.Observer;


import com.bookStore.entity.Book;

import java.util.List;

public class Subscriber implements Observer{
    private String name;
    private String email;

    @Override
    public void handleEvent(List<Book> bookList) {
        MailNotification mailNotification = new MailNotification();
        String subject = String.format("Hello, %s. We have updated our storage!", this.name);
        String text = "";
        for (Book book : bookList) {
            text += book.toString() + "\n";
        }
        mailNotification.sendMessage(mailNotification.session, this.email, subject, text);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
