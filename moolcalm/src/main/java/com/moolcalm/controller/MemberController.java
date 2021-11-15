package com.moolcalm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moolcalm.domain.InfoVO;
import com.moolcalm.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {
	JavaMailSender mailSender;     //메일 서비스를 사용하기 위해 의존성을 주입함.
	private MemberService service;
	
	//세션로그인테스트
	@GetMapping("sessionLogin")
	public void sessionLoginGet() {
		log.info("로그인화면으로 이동");
	}
	//세션로그인실행테스트
	@PostMapping("sessionLogin")
	public String sessionLoginPost(InfoVO member, HttpSession session,HttpServletRequest request) {	
		log.info("로그인서비스처리");
		
		//20211027�߰� - yuj
		 String yuj_email = request.getParameter("email");
        session.setAttribute("email", yuj_email); 
        log.info("yuj_email : "+session.getAttribute("email"));
        //20211027�߰� end
		
		
		//변수 선언
		InfoVO info=service.login(member);
		//service.login에 member라는 매개변수(infoVO의 내용)를 저장하는 info라는 변수
		session.setAttribute("ssn", info); //세션의 ssn라는 변수에 info를 저장
		if(session.getAttribute("ssn")!=null) { // ssn가 null이 아니면
			InfoVO ssn = ((InfoVO) session.getAttribute("ssn"));
			service.dailycheck(ssn.getEmail());
			log.info("출석체크 포인트"+ssn.getPoint()+", 로그인 횟수: "+ssn.getLogin_count()+", 현재 날짜: "+ssn.getNow_date());
			return "redirect:/"; // main화면으로 이동
		}else {
			return "redirect:/member/sessionLogin"; //null이면 다시 로그인화면으로 이동ㄴ
		}
		
	}// session로그인 끝
	
/*	@PostMapping("dailycheck")// 좀 더 고쳐보기?
	public String dailycheck(String email, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String ml = ((InfoVO) session.getAttribute("ssn")).getEmail();
		service.dailycheck(ml);
		InfoVO ssn = ((InfoVO) session.getAttribute("ssn"));
		log.info("출석체크 후 포인트"+ssn.getPoint()+", 출석체크 후 로그인 횟수: "+ssn.getLogin_count()+", 오늘의 날짜: "+ssn.getNow_date());
		return "redirect:/"; // main화면으로 이동
	}*/
	
	//로그아웃
	@PostMapping("logout")
	public void logoutPost(HttpSession session) {
		log.info("로그아웃");
		session.removeAttribute("ssn");
		// 또는, session.invalidate(); -> 모든 속성 제거
	}
	
    //member_info.jsp
    @GetMapping("member_info")
	public void member_info() {
		log.info("open member_info");
	}
	
	@GetMapping("email_check")
	public void email_check_view() {
		log.info("email_check_view");
	}
    
	 // mailSending �ڵ�
    // mailSending �ڵ�
    @PostMapping("join_check")
    public ModelAndView mailSending( HttpServletRequest request, String email, HttpServletResponse response_email, HttpSession session) throws IOException {

        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //�̸��Ϸ� �޴� �����ڵ� �κ� (����)
        
        String setfrom = "moolcalm.manage5555@gamil.com";
        String tomail = request.getParameter("email"); // �޴� ��� �̸���
                        
        String title = "회원가입 인증 이메일 입니다."; // ����
        String content =
        
        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // ����

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
            
            
            messageHelper.setTo(tomail); // �޴»�� �̸���
            
            
            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
            messageHelper.setText(content); // ���� ����
            
            mailSender.send(message);
        } catch (Exception e) {
           log.info(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView�� ���� �������� �����ϰ�, ���� ���� �����Ѵ�.
        mv.setViewName("/member/email_injeung");     //�����̸�
        mv.addObject("dice", dice);
        mv.addObject("email", email);
        
        log.info("mv : "+mv);
        session.setAttribute("email", tomail);
        
       
        log.info("���ǿ� ����Ǿ� �ִ� �̸��� : "+session.getAttribute("email"));
        
        response_email.setContentType("text/html; charset=UTF-8");
        // e-mail�� ������(ȸ���̶�� ���)
        // �α��� ȭ������ �̵�
        if(service.email_check(tomail)==1) {
        	response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_email.getWriter();
        out_equals.println("<script>alert('다시 한 번 더 시도해주세요.'); history.go(-1);</script>");
        out_equals.flush();
        }else { // e-mail�� ������(ȸ���� �ƴ϶�� ���) ������ȣ �߼� Ȯ���� �� ȸ������ ȭ�鿡�� ��й�ȣ �Է�
            PrintWriter out_email = response_email.getWriter();
            out_email.println("<script>alert('인증번호가 발송되었습니다.');</script>");
            out_email.flush();
        }
             
        
        return mv;
        
    }
    
	//�̸��� ���� ������ ���� �޼ҵ�
	//@GetMapping("/member/join_check")  //email_injeung
	//public String email() {
	//    return "member/email";
	//}


//�̸��Ϸ� ���� ������ȣ�� �Է��ϰ� ���� ��ư�� ������ ���εǴ� �޼ҵ�.
//���� �Է��� ������ȣ�� ���Ϸ� �Է��� ������ȣ�� �´��� Ȯ���ؼ� ������ ȸ������ �������� �Ѿ��,
//Ʋ���� �ٽ� ���� �������� ���ƿ��� �޼ҵ�
@PostMapping("join_injeung{dice}")
public ModelAndView join_injeung(String email_injeung, @PathVariable String dice, HttpServletResponse response_equals, HttpSession session) throws IOException {

        
    log.info("������ : email : "+session.getAttribute("email"));
    
    log.info("������ : dice : "+dice);
    log.info("������ : email_injeung : "+email_injeung);
    
    //�������̵��� �ڷḦ ���ÿ� �ϱ����� ModelAndView�� ����ؼ� �̵��� �������� �ڷḦ ����
     
    ModelAndView mv = new ModelAndView();
    
    mv.setViewName("/member/join");
    
    //mv.addObject("email",email);
    
    if (email_injeung.equals(dice)) {
        
        //������ȣ�� ��ġ�� ��� ������ȣ�� �´ٴ� â�� ����ϰ� ȸ������â���� �̵���
        
        
        
        mv.setViewName("member/join");
        
       // mv.addObject("email",email);
        
        //���� ������ȣ�� ���ٸ� �̸����� ȸ������ �������� ���� �Ѱܼ� �̸�����
        //�ѹ��� �Է��� �ʿ䰡 ���� �Ѵ�.
        
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

		//ȸ������ get
			@GetMapping("join")
			public void getRegister() throws Exception {
				log.info("get register");
			}
			
			// ȸ������ post
			@PostMapping("join")
			public String postRegister(InfoVO vo, Model model) throws Exception {
				
		        String result = "";
		        try {
		        	log.info("/member/join ��û");
		        	log.info("EMAIL: " + vo.getEmail());
		        	log.info("PW: " + vo.getPassword());
		        	log.info("PW2: " + vo.getPassword_again());
		            
		            if(vo.getPassword().equals(vo.getPassword_again())){
		            	service.join(vo);
		            	log.info("finish register");
		                result = "redirect:/";
		            }
		            else {
		                result = "/member/join";
		            }
		        } catch (Exception e) {
		        	log.info(e.getMessage());
		        }
		        return result;
		    }


			
		//��й�ȣã��
			@GetMapping("find_password")
			public void view_find_password() throws Exception {
				log.info("find_password");
			}

			 // mailSending �ڵ�
		    // mailSending �ڵ�
		    @PostMapping("find_password")
		    public ModelAndView find_password(HttpServletRequest request, String email, HttpServletResponse response_email, HttpSession session) throws IOException {

		        Random r = new Random();
		        int dice = r.nextInt(4589362) + 49311; //�̸��Ϸ� �޴� �����ڵ� �κ� (����)
		        
		        String setfrom = "moolcalm.manage5555@gamil.com";
		        String tomail = request.getParameter("email"); // �޴� ��� �̸���
		        String title = "비밀번호를 찾기 위한 인증이메일입니다."; // ����
		        String content =
		        
		        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
		        
		        System.getProperty("line.separator")+
		                
		        "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
		        
		        +System.getProperty("line.separator")+
		        
		        System.getProperty("line.separator")+

		        " 인증번호는 " +dice+ " 입니다. "
		        
		        +System.getProperty("line.separator")+
		        
		        System.getProperty("line.separator")+
		        
		        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // ����
		        
		        
		        try {
		            MimeMessage message = mailSender.createMimeMessage();
		            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
		                    true, "UTF-8");

		            messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
		            messageHelper.setTo(tomail); // �޴»�� �̸���
		            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
		            messageHelper.setText(content); // ���� ����
		            
		            mailSender.send(message);
		        } catch (Exception e) {
		           log.info(e);
		        }
		        
		        ModelAndView mv = new ModelAndView();    //ModelAndView�� ���� �������� �����ϰ�, ���� ���� �����Ѵ�.
		        mv.setViewName("member/pw_email_injeung");     //�����̸�
		        mv.addObject("dice", dice);
		        
		        log.info("mv : "+mv);
		        
		        session.setAttribute("email", tomail);
		        log.info("���ǿ� ����Ǿ� �ִ� �̸��� : "+session.getAttribute("email"));
		        
		        		        
		        response_email.setContentType("text/html; charset=UTF-8");
		        PrintWriter out_email = response_email.getWriter();
		        out_email.println("<script>alert('인증번호가 발송되었습니다.');</script>");
		        out_email.flush();
		        
		        
		        return mv;
		        
		        
		        
		    }

			//�̸��� ���� ������ ���� �޼ҵ�
			@GetMapping("pw_email_injeung")
			public String pw_email() {
			    return "member/pw_email_injeung";
			}


		//�̸��Ϸ� ���� ������ȣ�� �Է��ϰ� ���� ��ư�� ������ ���εǴ� �޼ҵ�.
		//���� �Է��� ������ȣ�� ���Ϸ� �Է��� ������ȣ�� �´��� Ȯ���ؼ� ������ ȸ������ �������� �Ѿ��,
		//Ʋ���� �ٽ� ���� �������� ���ƿ��� �޼ҵ�
		@PostMapping("pw_email_injeung{dice}")
		public ModelAndView pw_email_injeung(String pw_email_injeung, @PathVariable String dice, HttpServletResponse response_equals, HttpSession session) throws IOException {

		    
		    
		    
		    log.info("������ : email : "+session.getAttribute("email"));
		    
		    log.info("������ : dice : "+dice);
		    
		    
		    //�������̵��� �ڷḦ ���ÿ� �ϱ����� ModelAndView�� ����ؼ� �̵��� �������� �ڷḦ ����
		     
		    ModelAndView mv = new ModelAndView();
		    
		    mv.setViewName("member/new_password");
		    
		   // mv.addObject("email",pw_email_injeung);
		    
		    if (pw_email_injeung.equals(dice)) {
		        
		        //������ȣ�� ��ġ�� ��� ������ȣ�� �´ٴ� â�� ����ϰ� ���ο� ��й�ȣ �Է�â���� �̵���
		        
		        
		        
		        mv.setViewName("member/new_password");
		        
		        //mv.addObject("email",pw_email_injeung);
		        
		        //���� ������ȣ�� ���ٸ� �̸����� ȸ������ �������� ���� �Ѱܼ� �̸�����
		        //�ѹ��� �Է��� �ʿ䰡 ���� �Ѵ�.
		        
		        response_equals.setContentType("text/html; charset=UTF-8");
		        PrintWriter out_equals = response_equals.getWriter();
		        out_equals.println("<script>alert('인증번호가 일치하였습니다. 비밀번호 변경창으로 이동합니다.');</script>");
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
		
		//���ο� ��й�ȣ �Է� ������ ���� �޼ҵ�
		@GetMapping("new_password")
		public void pw_new_password()  throws Exception{
			log.info("new_password");
		} 
		// ���ο� ��й�ȣ �Է�
		@PostMapping("new_password")
		public String pass_change(InfoVO vo) throws Exception {
			log.info("pass_change");
			
			service.pass_change(vo);
			
			return "redirect:/member/sessionLogin";
		}
		
		//*********************************************************
		//ȸ������ ���ο� ��й�ȣ �Է� ������ ���� �޼ҵ�
		@GetMapping("info_new_password")
		public void info_pw_new_password()  throws Exception{
			log.info("info_new_password");
		} 
				
		// ���ο� ��й�ȣ �Է�
		@PostMapping("info_new_password")
		public String info_pass_change(InfoVO vo) throws Exception {
			log.info("info_pass_change");
			
			service.pass_change(vo);
			
			return "redirect:/member/member_info";
		}
		
		
		
		//ȸ��Ż��
		@PostMapping("info_delete")
		public String info_delete(HttpServletRequest request, HttpSession session,  HttpServletResponse response) throws IOException, ServletException {			 			
	        	
			try {
				response.setContentType("text/html; charset=UTF-8");
	        	PrintWriter All_removed = response.getWriter();
	        	All_removed.println("<script>alert('탈퇴되었습니다. ')</script> </script>");	        	
	        	//;history.forward(); location.replace=('http://localhost:8080/');
	        	All_removed.flush();

	        	
				log.info("login email="+(String)session.getAttribute("email"));			
				service.info_delete((String)session.getAttribute("email"));
				session.removeAttribute("email");
				session.removeAttribute("ssn");
				
				log.info("bye");
				
			} catch (Exception e) {
		           log.info(e);
			}
			
			return "main";
	    
		}
			
		
	
}
