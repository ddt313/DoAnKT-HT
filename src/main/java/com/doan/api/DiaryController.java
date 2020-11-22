package com.doan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doan.model.Diary;
import com.doan.service.DiaryService;

@RestController
@RequestMapping("diary")

@CrossOrigin(origins = "*")
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
	@GetMapping("{username}")
	public List<Diary> getAllDiary(@PathVariable String username) {
		return diaryService.getAllDiary(username);
	}
	
	@PostMapping("{username}/{mu_type}")
	public boolean postDiary(@PathVariable String username, @PathVariable int mu_type) {
		return diaryService.postDiary(username, mu_type);
	}
}