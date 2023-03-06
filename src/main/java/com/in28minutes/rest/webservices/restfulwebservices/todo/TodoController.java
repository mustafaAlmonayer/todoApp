package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@GetMapping("/username/{username}/todos")
	public ResponseEntity<List<Todo>> getTodosForUser(@PathVariable String username) {
		System.out.println(todoService.findByUsername(username));
		return new ResponseEntity<>(todoService.findByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}/todos/{todo}")
	public ResponseEntity<Todo> getTodoForUser(@PathVariable String username, @PathVariable int todo) {
		 return new ResponseEntity<>(todoService.findById(todo), HttpStatus.OK);
	}
	
	@DeleteMapping("/username/{username}/todos/{todo}")
	public ResponseEntity<Void> deleteTodoForUser(@PathVariable String username, @PathVariable int todo) {
		todoService.deleteById(todo);
		return ResponseEntity.noContent().build();
	}
	
}
