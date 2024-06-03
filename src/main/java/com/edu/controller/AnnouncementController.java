package com.edu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.entity.Announcement;
import com.edu.entity.Course;
import com.edu.entity.Reply;
import com.edu.exception.CustomException;
import com.edu.exception.ResponseMessage;
import com.edu.service.AnnouncementService;

@RestController
@RequestMapping("/announcement")
@CrossOrigin("*")
public class AnnouncementController {

	
	@Autowired
	private AnnouncementService announcementService;
	
	//for save Announcement
		@PostMapping("/save")
	    public ResponseEntity<Object> addAnnouncement(@RequestBody Announcement announcement) {
	        try {
	        	announcement.setCreatedDate(new Date());
	        	announcement.setLastDate(new Date());
	        	announcement.setStatus(true);
	            boolean saved = this.announcementService.saveAnnouncement(announcement);
	            if (saved) {
	                return ResponseEntity.ok(new ResponseMessage(announcement.getId() +" New announcement saved successfully"));
	            } else {
	                throw new CustomException("Failed to save announcement. Invalid data or duplicate entry.");
	            }
	        } 
	        catch (CustomException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error saving announcement: " + e.getMessage()));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error saving announcement: " + e.getMessage()));
	        }
	    }

		@PostMapping("/update")
		public ResponseEntity<Object> updateAnnouncement(@RequestBody Announcement announcement) {
			
		    try {
		         this.announcementService.updateAnnouncement(announcement);
		        return ResponseEntity.ok().body(new ResponseMessage("Announcement updated successfully"));
		    } catch (CustomException e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error updating announcement: " + e.getMessage()));
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Error updating announcement: " + e.getMessage()));
		    }
		    
		}

	

		
		@GetMapping("/get")
		public ResponseEntity<List<Announcement>> getAllAnnouncement(){
			List<Announcement> Announcementlist = (List<Announcement>) this.announcementService.getAllAnnouncement();
			return ResponseEntity.ok().body(Announcementlist);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteAnnouncement(@PathVariable Integer id){
			if(id != null) {
				if(announcementService.deleteAnnouncement(id)) {
					return ResponseEntity.ok().body("announcement is deleted successfully ");
				}else {
					return ResponseEntity.ok().body("announcement is not exist ");
				}
			}
	    	return ResponseEntity.ok().body("deleted");
	    }
		
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Object> getOneAnnouncement(@PathVariable Integer id){
			Announcement announcement = null;
			if(id != null) {
				announcement = this.announcementService.getOneAnnouncement(id);
				if(announcement != null) {
					return ResponseEntity.ok().body(announcement);
				}else {
					return ResponseEntity.ok().body("announcement is not exist of this id "+ id);
				}
			}
			return ResponseEntity.ok().body(" id is null ");
			
		}
		
		
		@GetMapping("/get-by-institute/{id}")
		public ResponseEntity<List<Announcement>> getAnnouncmentByInstitute(@PathVariable Integer id){
			List<Announcement> Announcementlist = (List<Announcement>) this.announcementService.getAnnouncmentByInstitute(id);
			return ResponseEntity.ok().body(Announcementlist);
			
		}
		
		@GetMapping("/get-by-instituteID/{username}")
		public ResponseEntity<List<Announcement>> getAllAnnouncementByInstitute(@PathVariable String username){
			List<Announcement> announcementlist = (List<Announcement>) this.announcementService.getAnnouncmentByInstituteUsername(username);
			return ResponseEntity.ok().body(announcementlist);
		}
		
		
		
	
}
