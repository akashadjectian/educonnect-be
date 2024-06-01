package com.edu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.EmailService;
import com.edu.dao.ContactUsRepository;
import com.edu.dao.ReplyRepository;
import com.edu.entity.ContactUs;
import com.edu.entity.Reply;
import com.edu.entity.ContactUs;
import com.edu.entity.ContactUs;

@Service
public class ContactUsService {
	
	@Autowired
	private ContactUsRepository contactUsRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private EmailService emailService;

	public boolean saveContactUs(ContactUs contactUs) {
		if(contactUs != null) {
			contactUs.setDate(new Date());
			String subject = "New Contact Us Submission from " + contactUs.getName();
	        String text = "Name: " + contactUs.getName() + "\n" +
	                      "Email: " + contactUs.getEmail() + "\n" +
	                      "Phone Number: " + contactUs.getPhoneNumber() + "\n" +
	                      "Message: " + contactUs.getMessage();
	        emailService.sendSimpleMessage("akashsagar8775@gmail.com", subject, text);
			
			
			
			
			this.contactUsRepository.save(contactUs);
			return true;
			
		}
		return false;
	}
	
	
	//for getting all contactUslist 
	public List<ContactUs> getAllContactUs(){		
		List<ContactUs> contactUslist = (List<ContactUs>)contactUsRepository.findAll(); 
		return contactUslist;
	}
	
	
	//for getting a single course
	public ContactUs getOneContactUs(Integer id) {
			ContactUs contactUs = contactUsRepository.findById(id).get();
			if(contactUs!=null) {
				return contactUs;
			}
			return null;
	}
	
	public boolean reply(Reply reply) {
		System.err.println(reply);
		if(reply != null){
			System.err.println(reply);
			reply.setDate(new Date());
			reply.setContactId(reply.getContactId());
			this.replyRepository.save(reply);
			this.emailService.sendSimpleMessage(reply.getEmail(), "Reply ", reply.getReply());
			return true;
			
		}
		
		return false;
	}


}
