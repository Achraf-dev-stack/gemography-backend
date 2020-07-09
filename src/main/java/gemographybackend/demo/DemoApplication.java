package gemographybackend.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String url="https://api.github.com/search/repositories?q=\"09-06-2020\"&sort=stars&order=desc";
		RestTemplate restTemplate = new RestTemplate();
		repos x = restTemplate.getForObject(url, repos.class);
		System.out.println("-----------------------------");
		System.out.println("total_count : "+x.getTotal_count());
		System.out.println("incomplete_results : "+x.isIncomplete_results());
		System.out.println("-----------------------------");
		
		Map<String,LanguageStats> map = new HashMap<String,LanguageStats>();
		for(item i : x.getItems())
		{
			if(!map.containsKey(i.getLanguage()))
			{
				map.put(i.getLanguage(),new LanguageStats());
			}
				map.get(i.getLanguage()).addItem(i);
		}
		for (Map.Entry<String, LanguageStats> entry : map.entrySet()) {
		    System.out.println("Language : "+entry.getKey() + ":\n " + entry.getValue().toString());
		}	
		}

}
