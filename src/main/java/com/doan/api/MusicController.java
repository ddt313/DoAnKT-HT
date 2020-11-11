package com.doan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doan.model.Music;
import com.doan.service.MusicService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MusicController {

	@Autowired
	private MusicService musicService;
	
	@GetMapping("music")
	public List<Music> getAllMusic() {
		return musicService.getAllMusic();
	}
	
	@PostMapping("music")
	public boolean postMusic(@RequestBody Music music) {
		return musicService.postMusic(music);
	}
	
	@GetMapping("last-music/{username}")
	public String getLastMusic(@PathVariable String username) {
		return musicService.getLastMusic(username);
	}
}
