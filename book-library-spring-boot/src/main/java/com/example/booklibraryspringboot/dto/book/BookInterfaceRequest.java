package com.example.booklibraryspringboot.dto.book;

import java.io.Serializable;

public interface BookInterfaceRequest {
    String getBookName ();
    String getCategoryName ();
    int getTotal ();

    }
