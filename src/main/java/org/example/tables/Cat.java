package org.example.tables;

import org.example.annotations.MyColumn;
import org.example.annotations.MyTable;

@MyTable
public class Cat {
    @MyColumn
    private int id;
    @MyColumn
    private String name;
    @MyColumn
    private int age;
}
