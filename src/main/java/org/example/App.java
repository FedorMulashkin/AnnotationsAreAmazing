package org.example;

import org.example.processing.BuildTableFromClass;
import org.example.tables.Cat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BuildTableFromClass.buildTable(Cat.class);
    }
}
