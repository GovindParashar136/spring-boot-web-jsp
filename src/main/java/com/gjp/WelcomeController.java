package com.gjp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {


	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	
	@GetMapping(value = "test", produces=MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> test(@RequestParam("filename") String filename) throws IOException {
	    String content = new String(Files.readAllBytes(Paths.get("/tmp/generated/" + filename)), "UTF-8");
	    return new ResponseEntity<String>(content, HttpStatus.OK);
	}


}