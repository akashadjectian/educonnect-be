package com.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.AnnouncementRepository;
import com.edu.dao.InstituteRepository;
import com.edu.entity.Announcement;
import com.edu.entity.Institute;

@Service
public class AnnouncementService {

	
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	// for saving the Announcement
	public boolean saveAnnouncement(Announcement announcement) {	
		if(announcement != null) {
			announcementRepository.save(announcement);
			return true;
		}
		return false;
	}

	//for getting a single announcement
	public Announcement getOneAnnouncement(Integer id) {
			Announcement announcement = announcementRepository.findById(id).get();
			if(announcement!=null) {
				return announcement;
			}
			return null;
	}

	//for getting all announcementlist 
	public List<Announcement> getAllAnnouncement(){		
		List<Announcement> announcementlist = (List<Announcement>)announcementRepository.findAll(); 
		return announcementlist;
	}

	//for delete the announcement
	public boolean deleteAnnouncement(Integer id) {
		if(id!=null) {
			this.announcementRepository.deleteById(id);
			return true;
		}
		return false;
	}

	//for update the announcement
	public Boolean updateAnnouncement(Announcement announcement) {
		if(announcement != null) {
			announcementRepository.save(announcement);
			return true;
		}
		return false;
	}

	
	
	//for getting all announcementlist 
		public List<Announcement> getAnnouncmentByInstitute(Integer id){
			Institute institute = this.instituteRepository.findById(id).get();
			List<Announcement> announcementlist = (List<Announcement>)announcementRepository.findByInstitute(institute); 
			return announcementlist;
		}
}
