package com.edu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.ContactUs;
import com.edu.entity.Reply;
import com.edu.entity.ContactUs;
import com.edu.entity.ContactUs;
import com.edu.exception.CustomException;
import com.edu.exception.ResponseMessage;
import com.edu.service.ContactUsService;

@RestController
@RequestMapping("/contactus")
@CrossOrigin("*")
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@PostMapping("/save")
    public ResponseEntity<Object> addContactUs(@RequestBody ContactUs contactUs) {
        try {
        	
            boolean saved = this.contactUsService.saveContactUs(contactUs);
            if (saved) {
                return ResponseEntity.ok(new ResponseMessage(" thank you for contact us ......"));
            } else {
                throw new CustomException("Failed to save contactUs. Invalid data or duplicate entry.");
            }
        } 
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error saving contactUs: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error saving contactUs: " + e.getMessage()));
        }
    }

	@PostMapping("/reply")
	public ResponseEntity<Object> reply(@RequestBody Reply reply) {
		
	    try {
	    	System.err.println("----------------------------"+reply);
	    	if(this.contactUsService.reply(reply)) {
	    		return ResponseEntity.ok().body(new ResponseMessage("Reply successfully"));	    		
	    	}
	    } catch (CustomException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error  reply: " + e.getMessage()));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error  reply: " + e.getMessage()));
	    }
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error  reply: "));

	    
	}
	
	
	
	@GetMapping("/get")
	public ResponseEntity<List<ContactUs>> getAllContactUs(){
		List<ContactUs> ContactUslist = (List<ContactUs>) this.contactUsService.getAllContactUs();
		return ResponseEntity.ok().body(ContactUslist);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getOneContactUs(@PathVariable Integer id){
		ContactUs contactUs = null;
		if(id != null) {
			contactUs = this.contactUsService.getOneContactUs(id);
			if(contactUs != null) {
				return ResponseEntity.ok().body(contactUs);
			}else {
				return ResponseEntity.ok().body("contactUs is not exist of this id "+ id);
			}
		}
		return ResponseEntity.ok().body(" id is null ");
		
	}
	
	
	
}
