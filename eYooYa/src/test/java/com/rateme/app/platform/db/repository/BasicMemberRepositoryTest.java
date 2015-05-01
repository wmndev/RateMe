package com.rateme.app.platform.db.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eyooya.app.platform.db.model.review.Review;
import com.eyooya.app.platform.db.repository.ReviewEntityRepository;
import com.eyooya.app.platform.db.service.sequence.SequenceService;
import com.eyooya.app.platform.type.StatusType;
import com.rateme.app.platform.db.prepare.PrepareMongoTest;

@ContextConfiguration(locations = {"test-root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicMemberRepositoryTest {
	
	@Autowired
	private ReviewEntityRepository reviewRepository;
	
	@Autowired
	private SequenceService seqService;
	
	@Before
	public void start(){
		PrepareMongoTest.prepareReviews(seqService);
	}
	
	@Test
	public void test1(){
		assertEquals(3, reviewRepository.findAll().size());
	}
	
	@Test
	public void test2(){
		Review rev = new Review();
		rev.setId(seqService.getNextSequence("reviews"));
		reviewRepository.insert(rev);
		assertEquals(4, reviewRepository.findAll().size());		
	}
	
	
	
	

}
