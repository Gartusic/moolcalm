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

    JavaMailSender mailSender;     //���� ���񽺸� ����ϱ� ���� �������� ������.
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
    
	 // mailSending �ڵ�
    // mailSending �ڵ�
    @PostMapping("join_check")
    public ModelAndView mailSending( HttpServletRequest request, String email, HttpServletResponse response_email, HttpSession session) throws IOException {

        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //�̸��Ϸ� �޴� �����ڵ� �κ� (����)
        
        String setfrom = "moolcalm.manage5555@gamil.com";
        String tomail = request.getParameter("email"); // �޴� ��� �̸���
                        
        String title = "ȸ������ ���� �̸��� �Դϴ�."; // ����
        String content =
        
        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
        
        System.getProperty("line.separator")+
                
        "�ȳ��ϼ��� ȸ���� ���� Ȩ�������� ã���ּż� �����մϴ�"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " ������ȣ�� " +dice+ " �Դϴ�. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�."; // ����

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
        out_equals.println("<script>alert('����� �� ���� �̸��� �Դϴ�. �ٸ� �̸����� �Է����ּ���.'); history.go(-1);</script>");
        out_equals.flush();
        }else { // e-mail�� ������(ȸ���� �ƴ϶�� ���) ������ȣ �߼� Ȯ���� �� ȸ������ ȭ�鿡�� ��й�ȣ �Է�
            PrintWriter out_email = response_email.getWriter();
            out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
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
        out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. ȸ������â���� �̵��մϴ�.');</script>");
        out_equals.flush();

        return mv;
        
        
    }else if (email_injeung != dice) {
        
        
        ModelAndView mv2 = new ModelAndView(); 
        
        mv2.setViewName("member/email_injeung");
        
        response_equals.setContentType("text/html; charset=UTF-8");
        PrintWriter out_equals = response_equals.getWriter();
        out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
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
			public String postRegister(InfoVO vo) throws Exception {
				log.info("post register");
				
				service.join(vo);
				
				return "redirect:/";
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
		        String title = "��й�ȣã�� ���� �̸��� �Դϴ�."; // ����
		        String content =
		        
		        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
		        
		        System.getProperty("line.separator")+
		                
		        "�ȳ��ϼ��� ȸ���� ��й�ȣ�� ã�� ���� �Ʒ��� ������ȣ�� �ȳ��ص帳�ϴ�"
		        
		        +System.getProperty("line.separator")+
		        
		        System.getProperty("line.separator")+

		        " ������ȣ�� " +dice+ " �Դϴ�. "
		        
		        +System.getProperty("line.separator")+
		        
		        System.getProperty("line.separator")+
		        
		        "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�."; // ����
		        
		        
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
		        out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
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
		        out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. �Է�â���� �̵��մϴ�.');</script>");
		        out_equals.flush();

		        return mv;
		        
		        
		    }else if (pw_email_injeung != dice) {
		        
		        
		        ModelAndView mv2 = new ModelAndView(); 
		        
		        mv2.setViewName("member/pw_email_injeung");
		        
		        response_equals.setContentType("text/html; charset=UTF-8");
		        PrintWriter out_equals = response_equals.getWriter();
		        out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
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
			
			return "redirect:/member/login";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}