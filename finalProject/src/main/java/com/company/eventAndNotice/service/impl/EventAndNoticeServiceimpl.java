package com.company.eventAndNotice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.eventAndNotice.service.EventAndNoticeService;
import com.company.eventAndNotice.service.EventAndNoticeVO;

@Service
public class EventAndNoticeServiceimpl implements EventAndNoticeService{
	
	@Autowired EventAndNoticeMapper EventAndNoticeMapper;
	//등록
	@Override
	public int insertEventAndNotice(EventAndNoticeVO vo) {
		return EventAndNoticeMapper.insertEventAndNotice(vo);
	}
	//단건조회
	@Override
	public EventAndNoticeVO getEventAndNotice(EventAndNoticeVO vo) {
		return EventAndNoticeMapper.getEventAndNotice(vo);
	}
	
	//전체조회
	@Override
	public List<EventAndNoticeVO> getSearchEventAndNotice(EventAndNoticeVO vo) {
		// TODO Auto-generated method stub
		return EventAndNoticeMapper.getSearchEventAndNotice(vo);
	}
	@Override //이벤트 혹은 공지사항인지 선택.
	public List<EventAndNoticeVO> getSearchEventAndNoticeSelect(EventAndNoticeVO vo) {
		// TODO Auto-generated method stub
		return EventAndNoticeMapper.getSearchEventAndNoticeSelect(vo);
	}
	//수정
	@Override
	public int updateEventAndNotice(EventAndNoticeVO vo) {
		return EventAndNoticeMapper.updateEventAndNotice(vo);
	}
	
	//탈퇴
	@Override
	public int deleteEventAndNotice(EventAndNoticeVO vo) {
		return EventAndNoticeMapper.deleteEventAndNotice(vo);
	}


}
