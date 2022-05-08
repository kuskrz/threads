package kus.krzysztof.threads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kus.krzysztof.threads.service.KnumbersService;

@RestController
public class KnumbersController {
	@Autowired
	KnumbersService ns;
	
	@GetMapping(value = "/number/{number}")
	public void selectNumber(@PathVariable Integer number) {
		Integer i = ns.selectNumber(number);
		if (number != i) System.out.println("NOK n:" + number + " db:" + i);
		else System.out.println("OK");
	}
}
