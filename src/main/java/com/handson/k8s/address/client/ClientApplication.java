package com.handson.k8s.address.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ClientApplication {

	private static Map<String, Address> addressMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}



	@PostMapping("/address")
	public Address saveAddress(@RequestBody Address address) {
		addressMap.put(address.stdId, address);
		return address;
	}

	@GetMapping("/address/{stdId}")
	public Address getAddressByStdId(@PathVariable String stdId) {
		return addressMap.get(stdId);
	}

	public record Address(String stdId, String city, String country) {}
}
