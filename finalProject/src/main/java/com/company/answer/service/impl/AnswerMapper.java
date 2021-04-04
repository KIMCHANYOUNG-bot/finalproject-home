package com.company.answer.service.impl;

import java.util.List;

import com.company.answer.service.AnswerVO;

public interface AnswerMapper {
	public int insertAnswer(AnswerVO vo);
	public int insertAnswerCr4(AnswerVO vo);	//관리자의 신고하기 답장
	public int insertAnswer2Cr4(AnswerVO vo);	//관리자의 고객센터문의하기 답장
	public AnswerVO getAnswer(AnswerVO vo);
	public List<AnswerVO> getSearchAnswer(AnswerVO vo);
	public List<AnswerVO> getSearchAnswer2Cr4(AnswerVO vo);	///전체조회 문의하기(찬)	
	public List<AnswerVO> getSearchAnswerCr4(AnswerVO vo);	//전체조회(찬영)
	public int updateAnswer(AnswerVO vo);
	public int deleteAnswer(AnswerVO vo);
}
