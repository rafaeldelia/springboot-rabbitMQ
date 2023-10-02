package br.com.arphoenix.apis.msrab.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.arphoenix.apis.msrab.model.Registry;
import br.com.arphoenix.apis.msrab.service.ApiBaseService;
import br.com.arphoenix.apis.msrab.service.RegistryService;

@RestController
public class ApiBaseController {

	@Autowired
	private ApiBaseService service;

	@Autowired
	private RegistryService jpaService;

	@GetMapping("/hello")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<>(service.hello(), HttpStatus.OK);
	}

	@GetMapping(path = "/date-now")
	public ResponseEntity<String> localDateNow() {
		return new ResponseEntity<>(service.localDate(), HttpStatus.OK);
	}

	@PostMapping(path = "/rabbit/send")
	@ResponseBody
	public ResponseEntity<Object> sendMessageToRabbit() {
		service.sendMessageToRabbit();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "/registry/list-all")
	public ResponseEntity<List<Registry>> listAllRegistries() {
		return new ResponseEntity<>(jpaService.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/registry/save")
	public ResponseEntity<Registry> saveRegistry(@RequestBody Registry registry) {
		Registry reg = jpaService.save(registry);
		return new ResponseEntity<>(reg, HttpStatus.OK);
	}

	@PutMapping(path = "/registry/update")
	public ResponseEntity<Registry> updateRegistry(@RequestBody Registry registry) {
		Registry reg = jpaService.update(registry);
		return new ResponseEntity<>(reg, HttpStatus.OK);
	}

	@DeleteMapping(path = "registry/remove/{id}")
	public ResponseEntity<String> deleteRegistry(@PathVariable("id") Long id) {
		jpaService.delete(id);
		return new ResponseEntity<>("Registry deleted", HttpStatus.OK);
	}

}
