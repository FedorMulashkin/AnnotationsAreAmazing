package org.example.processing;

import org.example.annotations.MyColumn;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public abstract class BuildTableFromClass {
    public static void buildTable(Class table){
        try(Connection connection = DriverManager
                .getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\SQLiteStudio\\main.db")){
            Statement statement = connection.createStatement();
            Map<Class, String> types = new HashMap<>();
            types.put(int.class, "INTEGER");
            types.put(String.class, "TEXT");
            StringBuilder sb = new StringBuilder("CREATE TABLE ").append(table.getSimpleName()).append(" (");
            Field[] fields = table.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MyColumn.class)){
                    sb.append(field.getName()).append(" ").append(types.get(field.getType())).append(", ");
                }
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(");");
            statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
