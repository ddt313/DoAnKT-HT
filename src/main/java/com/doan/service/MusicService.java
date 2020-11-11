package com.doan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.model.Music;
import com.doan.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;

	public List<Music> getAllMusic() {
		return musicRepository.getAllMusic();
	}

	public boolean postMusic(Music music) {		
		return musicRepository.postMusic(music);
	}

	public String getLastMusic(String username) {
		return musicRepository.getLastMusic(username);
	}

}
