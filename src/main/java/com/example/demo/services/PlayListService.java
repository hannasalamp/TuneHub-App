package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playlist);

	public List<PlayList> fetchplaylists();
	

}