package com.moolcalm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {

    JavaMailSender mailSender;     //메일 서비스를 사용하기 위해 의존성을 주입함.
    private MemberService service;
    
    
    //member_info.jsp
    @GetMapping("member_info")
	public void member_info() {
		log.info("open member_info");
	}

	@GetMapping("login")
	public void login() {
		log.info("HELLO login");
	}
	
	@GetMapping("email_check")
	public void email_check_view() {
		log.info("email_check_view");
	}
    
	 // mailSending 코드
    // mailSending 코드
    @PostMapping("join_check")
    public ModelAndView mailSending( HttpServletRequest request, String email, HttpServletResponse response_email, HttpSession session) throws IOException {

        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        
        String setfrom = "moolcalm.manage5555@gamil.com";
        String tomail = request.getParameter("email"); // 받는 사람 이메일
                        
        String title = "회원가입 인증 이메일 입니다."; // 제목
        String content =
        
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            
            
            messageHelper.setTo(tomail); // 받는사람 이메일
            
            
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
        } catch (Exception e) {
           log.info(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/member/email_injeung");     //뷰의이름
        mv.addObject("dice", dice);
        mv.addObject("email", email);
        
        log.info("mv : "+mv);
        session.setAttribute("email", tomail);
        
       
        log.info("세션에 저장되어 있는 이메일 : "+session.getAttribute("email"));
        
        response_email.setContentType("text/html; charset=UTF-8");
        // e-mail이 있으면(회원이라는 얘기)
        // 로그인 화면으로 이동
        if(service.email_check(tomail)==1) {
        	response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_email.getWriter();
        out_equals.println("<script>alert('사용할 수 없는 이메일 입니다. 다른 이메일을 입력해주세요.'); history.go(-1);</script>");
        out_equals.flush();
        }else { // e-mail이 없으면(회원이 아니라는 얘기) 인증번호 발송 확인한 후 회원가입 화면에서 비밀번호 입력
            PrintWriter out_email = response_email.getWriter();
            out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
            out_email.flush();
        }
        
        
        

        
        
        
        
        
        return mv;
        
    }
    
	//이메일 인증 페이지 맵핑 메소드
	//@GetMapping("/member/join_check")  //email_injeung
	//public String email() {
	//    return "member/email";
	//}


//이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
//내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
//틀리면 다시 원래 페이지로 돌아오는 메소드
@PostMapping("join_injeung{dice}")
public ModelAndView join_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals, HttpSession session) throws IOException {

        
    log.info("마지막 : email : "+session.getAttribute("email"));
    
    log.info("마지막 : dice : "+dice);
    log.info("마지막 : email_injeung : "+email_injeung);
    
    //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
     
    ModelAndView mv = new ModelAndView();
    
    mv.setViewName("/member/join");
    
    //mv.addObject("email",email);
    
    if (email_injeung.equals(dice)) {
        
        //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
        
        
        
        mv.setViewName("member/join");
        
       // mv.addObject("email",email);
        
        //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
        //한번더 입력할 필요가 없게 한다.
        
        response_equals.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_equals.getWriter();
        out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.');</script>");
        out_equals.flush();

        return mv;
        
        
    }else if (email_injeung != dice) {
        
        
        ModelAndView mv2 = new ModelAndView(); 
        
        mv2.setViewName("member/email_injeung");
        
        response_equals.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_equals.getWriter();
        out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
        out_equals.flush();
        

        return mv2;
        
    }    

    return mv;
    
}

		//회원가입 get
			@GetMapping("join")
			public void getRegister() throws Exception {
				log.info("get register");
			}
			
			// 회원가입 post
			@PostMapping("join")
			public String postRegister(InfoVO vo) throws Exception {
				log.info("post register");
				
				service.join(vo);
				
				return "redirect:/";
			}
			
		//비밀번호찾기
			@GetMapping("find_password")
			public void view_find_password() throws Exception {
				log.info("find_password");
			}

			 // mailSending 코드
		    // mailSending 코드
		    @PostMapping("find_password")
		    public ModelAndView find_password(HttpServletRequest request, String email, HttpServletResponse response_email, HttpSession session) throws IOException {

		        Random r = new Random();
		        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
		        
		        String setfrom = "moolcalm.manage5555@gamil.com";
		        String tomail = request.getParameter("email"); // 받는 사람 이메일
		        String title = "비밀번호찾기 인증 이메일 입니다."; // 제목
		        String content =
		        
		        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
		        
		        System.getProperty("line.separator")+
		                
		        "안녕하세요 회원님 비밀번호를 찾기 위해 아래의 인증번호를 안내해드립니다"
		        
		        +System.getProperty("line.separator")+
		        
		        System.getProperty("line.separator")+

		        " 인증번호는 " +dice+ " 입니다. "
		        
		        +System.getProperty("line.separator")+
		        
		        System.getProperty("line.separator")+
		        
		        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
		        
		        
		        try {
		            MimeMessage message = mailSender.createMimeMessage();
		            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
		                    true, "UTF-8");

		            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
		            messageHelper.setTo(tomail); // 받는사람 이메일
		            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
		            messageHelper.setText(content); // 메일 내용
		            
		            mailSender.send(message);
		        } catch (Exception e) {
		           log.info(e);
		        }
		        
		        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
		        mv.setViewName("member/pw_email_injeung");     //뷰의이름
		        mv.addObject("dice", dice);
		        
		        log.info("mv : "+mv);
		        
		        session.setAttribute("email", tomail);
		        log.info("세션에 저장되어 있는 이메일 : "+session.getAttribute("email"));
		        
		        

		        
		        response_email.setContentType("text/html; charset=UTF-8");
		        PrintWriter out_email = response_email.getWriter();
		        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
		        out_email.flush();
		        
		        
		        return mv;
		        
		        
		        
		    }

			//이메일 인증 페이지 맵핑 메소드
			@GetMapping("pw_email_injeung")
			public String pw_email() {
			    return "member/pw_email_injeung";
			}


		//이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
		//내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
		//틀리면 다시 원래 페이지로 돌아오는 메소드
		@PostMapping("pw_email_injeung{dice}")
		public ModelAndView pw_email_injeung(String pw_email_injeung, @PathVariable String dice, HttpServletResponse response_equals, HttpSession session) throws IOException {

		    
		    
		    
		    log.info("마지막 : email : "+session.getAttribute("email"));
		    
		    log.info("마지막 : dice : "+dice);
		    
		    
		    //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
		     
		    ModelAndView mv = new ModelAndView();
		    
		    mv.setViewName("member/new_password");
		    
		   // mv.addObject("email",pw_email_injeung);
		    
		    if (pw_email_injeung.equals(dice)) {
		        
		        //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 새로운 비밀번호 입력창으로 이동함
		        
		        
		        
		        mv.setViewName("member/new_password");
		        
		        //mv.addObject("email",pw_email_injeung);
		        
		        //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
		        //한번더 입력할 필요가 없게 한다.
		        
		        response_equals.setContentType("text/html; charset=UTF-8");
		        PrintWriter out_equals = response_equals.getWriter();
		        out_equals.println("<script>alert('인증번호가 일치하였습니다. 입력창으로 이동합니다.');</script>");
		        out_equals.flush();

		        return mv;
		        
		        
		    }else if (pw_email_injeung != dice) {
		        
		        
		        ModelAndView mv2 = new ModelAndView(); 
		        
		        mv2.setViewName("member/pw_email_injeung");
		        
		        response_equals.setContentType("text/html; charset=UTF-8");
		        PrintWriter out_equals = response_equals.getWriter();
		        out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
		        out_equals.flush();
		        

		        return mv2;
		        
		    }    

		    return mv;
		    
		}
		
		//새로운 비밀번호 입력 페이지 맵핑 메소드
		@GetMapping("new_password")
		public void pw_new_password()  throws Exception{
			log.info("new_password");
		} 
		
		// 새로운 비밀번호 입력
		@PostMapping("new_password")
		public String pass_change(InfoVO vo) throws Exception {
			log.info("pass_change");
			
			service.pass_change(vo);
			
			return "redirect:/member/login";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}