package com.ware.group.qna;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ware.group.board.BoardFileVO;
import com.ware.group.member.MemberVO;
import com.ware.group.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	@ModelAttribute("board")
	public String getQna() {
		return "qna";
	}
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		
		return mv;
}
		@GetMapping("add")
		public ModelAndView setInsert(@ModelAttribute QnaVO qnaVO,HttpSession session) throws Exception {
			ModelAndView mv = new ModelAndView();
			
			Object obj =session.getAttribute("SPRING_SECURITY_CONTEXT");
			SecurityContextImpl contextImpl = (SecurityContextImpl)obj;
		    MemberVO memberVO = (MemberVO)contextImpl.getAuthentication().getPrincipal();
				
			qnaVO.setWriter(memberVO.getAccountId());
			
			
			
			mv.setViewName("qna/add");
			
			return mv;
		}
		
//		@PostMapping("add")
//		public ModelAndView setInsert(@Valid NoticeVO noticeVO, BindingResult bindingResult, MultipartFile [] files,HttpSession session) throws Exception {
//			ModelAndView mv = new ModelAndView();
//			
//			if(bindingResult.hasErrors()) {
//				log.warn("================ 검증 실패 ================");
//				mv.setViewName("notice/add");
//				System.out.println("여긴가지냐?");
//				return mv;
//			}
//			System.out.println(files[0].getName());
//			System.out.println(files[0].getOriginalFilename());
//			for(MultipartFile multipartFile : files) {
//				log.error("{} ::",multipartFile.getOriginalFilename());
//				}
//			int result = noticeService.setInsert(noticeVO, files);
//			
//			mv.setViewName("redirect:./list");
//			
//			return mv;
//		}
		
		  @PostMapping("add") 
		  public ModelAndView setInsert(@Valid QnaVO qnaVO,BindingResult bindingResult, MultipartFile [] files,HttpSession session) throws Exception {
		  
	      ModelAndView mv = new ModelAndView();
		  
			/*
			 * MemberVO memberVO = (MemberVO)session.getAttribute("member");
			 * 
			 * qnaVO.setMemberId(memberVO.getId()); qnaVO.setWriter(memberVO.getName());
			 */
		  
		  if(bindingResult.hasErrors()) {
		  
		  mv.setViewName("qna/add");
		  
		  return mv; 
		  
		  }
		  
		  for(MultipartFile multipartFile : files) {
		  log.error("{} ::",multipartFile.getOriginalFilename()); 
		} 
		  int result = qnaService.setInsert(qnaVO, files);
		  
		  mv.setViewName("redirect:./list");
		  
		  return mv; 
		  
		  }
		 
		
		
		@GetMapping("detail")
		public ModelAndView getDetail(QnaVO qnaVO) throws Exception {
			ModelAndView mv = new ModelAndView();
			
			qnaVO = (QnaVO)qnaService.getDetail(qnaVO);
			
			int result = qnaService.setQnaHit(qnaVO);
		
			mv.addObject("qnaVO", qnaVO);
			mv.setViewName("qna/detail");
			
			return mv;
		}
		
		
		  @GetMapping("fileDown") 
		  public ModelAndView getFileDown(BoardFileVO boardFileVO) throws Exception { 
			  
		  ModelAndView mv = new ModelAndView();
		  
		  boardFileVO = qnaService.getFileDetail(boardFileVO);
		  
		  mv.addObject("boardFileVO", boardFileVO); 
		  mv.setViewName("fileManager");
		  
		  return mv; 
		  }
		  
		 
		
		@GetMapping("delete")
		public ModelAndView setDelete(QnaVO qnaVO) throws Exception {
			ModelAndView mv = new ModelAndView();
			
			int result = qnaService.setDelete(qnaVO);
			
			mv.setViewName("redirect:./list");
			
			return mv;
		}
		
		@GetMapping("update")
		public ModelAndView setUpdate(QnaVO qnaVO) throws Exception{
			ModelAndView mv = new ModelAndView();
			
			
			 
			
			mv.setViewName("qna/update");
			
			return mv;
		}
		@PostMapping("update")
		public ModelAndView setUpdate(QnaVO qnaVO,MultipartFile multipartFiles)throws Exception{
			ModelAndView mv = new ModelAndView();
			
			int result = qnaService.setUpdate(qnaVO,multipartFiles);
			
			mv.setViewName("redirect:./list");
			
			return mv;
			
		}
		
		/*
		 * @GetMapping("reply") public ModelAndView setReplyAdd(QnaVO qnaVO,ModelAndView
		 * modelAndView)throws Exception{
		 * 
		 * System.out.println("들어감?"); System.out.println("들어감?");
		 * System.out.println("들어감?");
		 * 
		 * modelAndView.setViewName("qna/reply"); return modelAndView; }
		 * 
		 * @PostMapping("reply") public ModelAndView setReplyAdd(QnaVO qnaVO)throws
		 * Exception{
		 * 
		 * ModelAndView mv = new ModelAndView();
		 * 
		 * int result= qnaService.setReplyAdd(qnaVO);
		 * 
		 * String message="등록 실패";
		 * 
		 * if(result>0) { message = "글이 등록 되었습니다"; }
		 * 
		 * 
		 * mv.setViewName("common/result"); mv.addObject("result", message);
		 * mv.addObject("url","./detail?id="+qnaVO.getId()); return mv; }
		 */
		 
}