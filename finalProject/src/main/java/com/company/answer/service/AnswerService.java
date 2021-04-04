package com.company.answer.service;

import java.util.List;

public interface AnswerService {

	public int insertAnswer(AnswerVO vo);	//화원탈퇴
	public int insertAnswerCr4(AnswerVO vo);	//관리자의 신고하기 답장
	public AnswerVO getAnswer(AnswerVO vo);	//단건조회						
	public List<AnswerVO> getSearchAnswer(AnswerVO vo);	//전체조회
	public int updateAnswer(AnswerVO vo);	//회원수정
	public int deleteAnswer(AnswerVO vo);	//화원탈퇴
}
