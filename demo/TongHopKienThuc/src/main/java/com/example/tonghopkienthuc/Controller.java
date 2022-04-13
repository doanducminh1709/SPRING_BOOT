package com.example.tonghopkienthuc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private List<Todo> todolist = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init(){
        // Thêm null vào List để bỏ qua vị trí số 0;
        todolist.add(null);
    }

    //lay ra tat ca cac todo
    @GetMapping("/todo")
    public List<Todo> getTodolist(){
        return todolist;
    }
    //lay ra toi tuong todo list theo id
    @GetMapping("/todo/{todoId}")
    public Todo getTodoById(@PathVariable("todoId") Integer todoId){
        return todolist.get(todoId);
    }

    //sua 1 doi tuong todoList theo id
    //@RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
    //thành đối tượng Todo
    @PatchMapping("/todo/{todoId}")
    public Todo editTodoById(@PathVariable("todoId") Integer todoId , @RequestBody Todo todo){
      todolist.set(todoId , todo);
      return todolist.get(todoId);
    }

    //xóa một đối tượng todo theo id
    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<?> deleteTodoById(@PathVariable("todoId") Integer todoId){
        todolist.remove(todoId);
        return ResponseEntity.status(200).body("Delete successful");
    }

    //them moi mot doi tuong todo
    @PostMapping("/todo")
    public ResponseEntity<?> addNewTodo(@RequestBody Todo todo){
        todolist.add(todo);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
        return ResponseEntity.status(200).body(todo);
    }

}
