package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.answer.service.AnswerService;
import com.company.answer.service.AnswerVO;
import com.company.bCart.service.BCartService;
import com.company.bCart.service.BCartVO;
import com.company.business.service.BusinessService;
import com.company.business.service.BusinessVO;
import com.company.hotel.service.HotelService;
import com.company.hotel.service.HotelVO;
import com.company.question.service.QuestionService;
import com.company.question.service.QuestionVO;

/*
 * @author 박세민
 * 21.03.29 마이페이지-사업자(Business,Question,Answer)
 * 21.03.30 장바구니 1차 수정/택시 API대용으로 T map API or Kakao map API 사용 생각중
 * 21.03.31 마이페이지-사업자-3차 수정
 * 21.04.01 마이페이지-사업자(본인정보,문의,답변 마무리)
 */
@Controller
public class Controller5 {

	// start of beans
	@Autowired
	BusinessService businessService;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerService answerService;

	@Autowired
	HotelService hotelService;

	@Autowired
	BCartService bCartService;
	// end of beans

	// start of business
	// 마이페이지-사업자-본인정보
	@RequestMapping("/getBusiness")
	public String getBusiness(BusinessVO vo, Model model, HttpSession session) {
		// session값 조회
		vo.setBusinessId((String) session.getAttribute("loginID"));
		// 본인정보조회
		vo = businessService.getBusiness(vo);
		model.addAttribute("vo", vo);
		return "business/getBusiness";
	}// end of getBusiness

	// 마이페이지-사업자-본인정보수정 페이지 호출
	@PostMapping("/updateBusiness")
	public String updateBusiness(BusinessVO vo, Model model, HttpSession session) {
		// session값 조회
		vo.setBusinessId((String) session.getAttribute("loginID"));
		// 본인정보조회
		vo = businessService.getBusiness(vo);
		model.addAttribute("vo", vo);
		return "business/updateBusiness";
	}// end of updateBusiness

	// 마이페이지-사업자-본인정보수정 기능
	@GetMapping("/updateBusiness")
	public String updateBusinessProc(BusinessVO vo, Model model, HttpServletResponse response) throws IOException {
		// 결과값이 1이면 업데이트 된 것
		businessService.updateBusiness(vo);
		model.addAttribute("vo", vo);
		// alert박스 뜨게 하기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('수정되었습니다')</script>");
		return "redirect:/";
	}// end of updateBusiness
		// 마이페이지-사업자-문의내역 리스트

	@GetMapping("/getSearchQuestion")
	public String getSearchQuestion(BusinessVO vo) {// 사업자 아이디로 조회해야해서 BusinessVO를 사용
		return "question/getSearchQuestion";
	}

	// 마이페이지-사업자-문의내역 리스트 ajax
	@PostMapping("/getSearchQuestion")
	@ResponseBody
	public List<QuestionVO> getSearchQuestionProc(QuestionVO vo, Model model, HttpSession session) {// 사업자 아이디로 조회
		// toPerson=사업자아이디를 의미함
		vo.setToPerson((String) session.getAttribute("loginID"));
		// 조회한 값 list형태로
		List<QuestionVO> list = questionService.getSearchQuestion(vo);
		model.addAttribute("list", list);
		return list;
	}// end of getSearchQuestion
		// end of business

	// start of question
	// 마이페이지-사업자-문의내역 단건조회
	@RequestMapping("/getQuestion")
	public String getQuestion(QuestionVO vo, Model model) {
		// 조회결과 vo에 담기
		vo = questionService.getQuestion(vo);
		// model객체 사용하여 값 전달
		model.addAttribute("vo", vo);
		return "question/getQuestion";
	}// end of getQuestion
		// end of question

	// start of answer
	// 마이페이지-사업자-답변 등록 페이지
	@GetMapping("/insertAnswer")
	public String insertAnswer(QuestionVO vo, Model model) {
		vo = questionService.getQuestion(vo);
		// questionNumber,memberId가져와야함
		model.addAttribute("vo", vo);
		return "answer/insertAnswer";
	}// end of insertAnswer

	// 마이페이지-사업자-답변 등록 기능
	@PostMapping("/insertAnswer")
	public void insertAnswerProc(AnswerVO vo, HttpSession session, HttpServletResponse response) throws IOException {
		// 작성자만 vo에 담기
		String id = session.getAttribute("loginID").toString();
		vo.setWriter(id);
		answerService.insertAnswer(vo);
		// alert
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('답변이 등록되었습니다');window.close();</script>");
		writer.close();
	}// end of insertAnswerProc

	// 마이페이지-사업자-답변 수정
	@PostMapping("/updateAnswer")
	public void updateAnswer(AnswerVO vo) {
		answerService.updateAnswer(vo);
		// 기능 처리 후 alert 박스 뜨게 하기

	}// end of updateAnswer

	// 마이페이지-사업자-답변 삭제
	@PostMapping("/deleteAnswer")
	public void deleteAnswer(AnswerVO vo) {
		answerService.deleteAnswer(vo);
		// 기능 처리 후 alert 박스 뜨게 하기
	}// end of deleteAnswer

	// 마이페이지-사업자-답변 단건조회
	@RequestMapping("/getAnswer")
	public String getAnswer(AnswerVO vo, Model model) {
		vo = answerService.getAnswer(vo);
		model.addAttribute("vo", vo);
		return "answer/getAnswer";
	}// end of getAnswer

	// 마이페이지-사업자-답변리스트
	@RequestMapping("/getSearchAnswer")
	public String getSearchAnswer(AnswerVO vo, Model model, HttpSession session) {
		// 세션 ID 값
		String id = session.getAttribute("loginID").toString();
		vo.setWriter(id);
		// 값 조회 후 list에 담기
		List<AnswerVO> list = answerService.getSearchAnswer(vo);
		model.addAttribute("list", list);
		return "answer/getSearchAnswer";
	}// end of getSearchAnswer
		// end of answer

	// start of hotel
	// 사업자-전체리스트(호텔)
	@RequestMapping("/getSearchHotel")
	public String getSearchHotel(HotelVO vo, Model model) {
		List<HotelVO> list = hotelService.getSearchHotel(vo);
		model.addAttribute("list", list);
		return "hotel/getSearchHotel";
	}// end of getSearchHotel

	// 사업자-상세리스트
	@RequestMapping("/getHotel")
	public String getHotel(HotelVO vo, Model model) {
		// 결과 vo
		vo = hotelService.getHotel(vo);
		// 페이지에 전달
		model.addAttribute("vo", vo);
		return "hotel/getHotel";
	}// end of getHotel

	// 사업자-호텔제품등록 페이지
	@GetMapping("/insertHotel")
	public String insertHotel(HotelVO vo) {
		return "hotel/insertHotel";
	}// end of insertHotel

	// 사업자-호텔제품등록 기능
	@PostMapping("/insertHotel")
	public String insertHotelProc(HotelVO vo) {
		hotelService.insertHotel(vo);
		return "redirect:/";
		// 기능 처리 후 등록여부 alert로 알려주기
	}// end of insertHotelProc
		// end of hotel

	// start of bCart
	// 장바구니-페이지 호출
	@GetMapping("/getSearchBCart")
	public String getSearchBCart(BCartVO vo) {
		return "bCart/getSearchBCart";
	}

	// 장바구니-페이지 기능
	@PostMapping("/getSearchBCart")
	@ResponseBody
	public List<BCartVO> getSearchBCartProc(BCartVO vo) {
		List<BCartVO> list = bCartService.getSearchBCart(vo);
		return list;
	}

	// 장바구니-등록
	@RequestMapping("/insertBCart")
	public void insertBCart(BCartVO vo) {
		bCartService.insertBCart(vo);
	}

	// 장바구니-삭제
	@RequestMapping("/deleteBCart")
	public void deleteBCart(BCartVO vo) {
		bCartService.deleteBCart(vo);
	}

	// 지도-샘플페이지
	@RequestMapping("/map")
	public String map() {
		return "map/map";
	}

	// end of bCart
	// 나중에
	// 마이페이지-사업자-통계현황
	// 마이페이지-사업자-예약내역조회
	// 마이페이지-사업자-실시간화장진료 페이지
	// 동물정보-샘플페이지
}