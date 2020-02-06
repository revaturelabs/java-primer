package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;

@Controller("heroController")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroControllerAlpha implements HeroController {
	
	@Autowired
	private HeroService heroService;
	
	/**
	 * @RequestMapping(value="/register.app", method=RequestMethod.POST)
	 * Is the same as we have downstairs.
	 * 
	 * @ResponseBody marshal our POJOS into JSON with Jackson (because we have the dependency).
	 * 
	 * @RequestBody unmarshals JSON available in the request body into our POJO.
	 */
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {
		return (heroService.registerHero(hero)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/findHero")
	public @ResponseBody Hero findHero(@RequestBody Hero hero, HttpServletRequest request) {
		request.getSession();
		return heroService.getHero(hero.getName());
	}

	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Hero> findAllHeroes() {
		return heroService.getAllHeroes();
	}
	
}
