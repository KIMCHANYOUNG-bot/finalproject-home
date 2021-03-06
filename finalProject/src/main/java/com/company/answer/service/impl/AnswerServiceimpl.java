package com.company.answer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.answer.service.AnswerService;
import com.company.answer.service.AnswerVO;

@Service
public class AnswerServiceimpl implements AnswerService{
	
	@Autowired AnswerMapper AnswerMapper;
	//등록
	@Override
	public int insertAnswer(AnswerVO vo) {
		return AnswerMapper.insertAnswer(vo);
	}
	
	
	
	//고객센터 2문의하기 답장등록
	@Override
	public int insertAnswer2Cr4(AnswerVO vo) {
		return AnswerMapper.insertAnswer2Cr4(vo);
	}
	
	//고객센터 3신고하기 답장등록
	@Override
	public int insertAnswerCr4(AnswerVO vo) {
		return AnswerMapper.insertAnswerCr4(vo);
	}
	//단건조회
	@Override
	public AnswerVO getAnswer(AnswerVO vo) {
		return AnswerMapper.getAnswer(vo);
	}
	//전체조회
	@Override
	public List<AnswerVO> getSearchAnswer(AnswerVO vo) {
		return AnswerMapper.getSearchAnswer(vo);
	}
	//전체조회(찬영)
	@Override
	public List<AnswerVO> getSearchAnswerCr4(AnswerVO vo) {
		return AnswerMapper.getSearchAnswerCr4(vo);
		}
	
	@Override
	public List<AnswerVO> getSearchAnswer2Cr4(AnswerVO vo) {
		return AnswerMapper.getSearchAnswer2Cr4(vo);
		}
	
	//수정
	@Override
	public int updateAnswer(AnswerVO vo) {
		return AnswerMapper.updateAnswer(vo);
	}
	
	//탈퇴
	@Override
	public int deleteAnswer(AnswerVO vo) {
		return AnswerMapper.deleteAnswer(vo);
	}


}
