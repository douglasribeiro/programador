package com.example.programador.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.programador.entities.Item;
import com.example.programador.repositorio.ItemRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/item" })
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository  = itemRepository;
	}
	
	@GetMapping()
	public List<Item> getAllItem() {
		return (List<Item>) itemRepository.findAll();
	}  

	@PostMapping()
	public @Valid Item createItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}
	

}
