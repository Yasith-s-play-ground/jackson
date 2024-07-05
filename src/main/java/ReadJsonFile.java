import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadJsonFile {
    public static void main(String[] args) throws IOException {
        InputStream is = ReadJsonFile.class.getResourceAsStream("/todos.json");
        ObjectMapper mapper = new ObjectMapper();
//        TodoItem[] todoItems = mapper.readValue(is, TodoItem[].class);
//        for (TodoItem todoItem : todoItems) {
//            System.out.println(todoItem);
//        }

        //get as an array list

        /* this will be taken as a Linked hash map list, java doesn't know what type of ArrayList we need */
//        ArrayList<TodoItem> todoItems = mapper.readValue(is, ArrayList.class);
        /* this syntax is also not valid */
//        ArrayList<TodoItem> todoItems = mapper.readValue(is, ArrayList<TodoItem>.class);

        /* even though this can be erased in type erasure process, it will not be erased if it is extended */
        /* Here we are using an anonymous inner class extended from class TypeReference
        * Therefore the subclass cannot be removed */
        ArrayList<TodoItem> todoItems = mapper.readValue(is, new TypeReference<ArrayList<TodoItem>>() {});

        for (TodoItem todoItem : todoItems) {
            System.out.println(todoItem);
        }
    }
}
