package cz.sarrakas.traskdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TraskDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraskDemoApplication.class, args);
	}

	@GetMapping("/")
	public String header(){
		return  "<h3>Trask demo</h3>"+
				"<p>Basic info:<br>"+
				"  -API is located in /api/*<br>" +
				"  -There is 'user', 'knowledge', 'tech' and 'certification!<br>"+
				"  -All should be able to answer GET, POST, PUT and DELETE Rest requests<br><br>"+
				"Testing db credentials: NO LONGER AVALIBLE<br>" +
				"Only temp db for testing and showcase<br>It will be disabled after presentation is over</p>";
	}
}
