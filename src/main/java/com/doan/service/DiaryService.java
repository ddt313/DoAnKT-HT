package com.doan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.model.Diary;
import com.doan.repository.DiaryRepository;

@Service
public class DiaryService {
	
	@Autowired
	private DiaryRepository diaryRepository;

	public List<Diary> getAllDiary(String username) {
		return diaryRepository.getAllDiary(username);
	}

	public boolean postDiary(String username, int mu_type) {
		return diaryRepository.postDiary(username, mu_type);
	}

}
