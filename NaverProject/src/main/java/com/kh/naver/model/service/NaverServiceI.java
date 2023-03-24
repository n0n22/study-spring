package com.kh.naver.model.service;

import com.kh.naver.model.vo.NaverVO;

public interface NaverServiceI {
	
	public NaverVO loginNaver(String email);
	
	public int naverInsert(NaverVO naver);
	
	public int emailCheck(String email);

}
