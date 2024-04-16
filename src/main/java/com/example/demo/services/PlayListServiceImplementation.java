package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;
import com.example.demo.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService{
	@Autowired
	PlayListRepository prepo;
	
	@Autowired
	SongsService sserv;
	@GetMapping("/createplaylist")
	public String createPlayList(Model model) {
		
		//fetching the song using song service
		List<Songs> songsList=sserv.fetchAllSongs();
		
		//adding songs in the model
		model.addAttribute("songsList",songsList);
		
		//sending createplaylist
		
		return "createplaylist";
	}
	@Override
	public void addPlayList(PlayList playlist) {
		prepo.save(playlist);
		
	}
	@Override
	public List<PlayList> fetchplaylists() {
		
		return prepo.findAll();
	}

}
