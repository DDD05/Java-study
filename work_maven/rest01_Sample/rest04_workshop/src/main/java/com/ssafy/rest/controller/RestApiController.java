package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.BookVO;
import com.ssafy.service.BookService;

@RestController
//@RequestMapping("book")
public class RestApiController {

	@Autowired
	BookService service;
	
	@GetMapping("/findAllBook")
	public ResponseEntity<List<BookVO>> findAllBook() throws Exception
	{
		List<BookVO> list = service.findAllBook();
		if(list.isEmpty())
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(list,HttpStatus.OK);
	}
	@GetMapping("findBookByTitle/{name}")
	public ResponseEntity<List<BookVO>> findBookByTitle(@PathVariable String name) throws Exception
	{
		List<BookVO> list = service.findBookByTitle(name);
		if(list.isEmpty())
		{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(list,HttpStatus.OK);
	}
	@PostMapping("/addBook")
	public ResponseEntity<List<BookVO>> addBook(@RequestBody BookVO book) throws Exception
	{
		System.out.println("bool : " + book);
		service.addBook(book);
		return new ResponseEntity(HttpStatus.OK);
	}
	@PutMapping("updateBook")
	public ResponseEntity<List<BookVO>> updateBook(@RequestBody BookVO book) throws Exception
	{
		System.out.println("book : " + book);
		service.updateBook(book);
		return new ResponseEntity(HttpStatus.OK);
	
	}
	@DeleteMapping("deleteBook/{isbn}")
	public ResponseEntity<List<BookVO>> deleteBook(@PathVariable String isbn) throws Exception
	{
		System.out.println("isbn : " + isbn);
		service.deleteBook(isbn);
		return new ResponseEntity(HttpStatus.OK);
	}
}
