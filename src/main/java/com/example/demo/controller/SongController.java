package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongsService;

@Controller
public class SongController {
	
	@Autowired
	SongsService songserv;
	
	@PostMapping("/addSongs")
	public String addSongs(@ModelAttribute Songs songs) {
		boolean status=songserv.songsExists(songs.getName());
		if(status==false) {
		songserv.addSongs(songs);
		return "songsuccess";
		}
		else {
			return "songfail";
		}
	}
	
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
		List<Songs> songsList=songserv.fetchAllSongs();
		model.addAttribute("songsList",songsList);
		return "displaysongs";
		
	}
	
	@GetMapping("/viewsongs")
	public String viewCustomerSongs(Model model) {
		boolean primeCustomerStatus=false;
		if(primeCustomerStatus==true) {
			List<Songs> songsList=songserv.fetchAllSongs();
			model.addAttribute("songsList",songsList);
			return "displaysongs";
			
		}
		else {
			return "makepayment";
			
		}
		
	}

}
