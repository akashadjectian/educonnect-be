package com.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.entity.Announcement;
import com.edu.entity.Institute;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

	List<Announcement> findByInstitute(Institute institute);
}
