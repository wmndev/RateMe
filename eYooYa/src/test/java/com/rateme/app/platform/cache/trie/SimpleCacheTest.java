package com.rateme.app.platform.cache.trie;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eyooya.app.platform.cache.trie.TrieCacheManager;


@ContextConfiguration(locations = {"test-root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCacheTest {
	
	@Autowired
	private TrieCacheManager cacheManager;

	@Before
	public void fillCache(){
		cacheManager.addEntityName("Java");
		cacheManager.addEntityName("JavaOne");
		cacheManager.addEntityName("JavaTwo");
		cacheManager.addEntityName("JavaThree");
		cacheManager.addEntityName("JavaFour");
		cacheManager.addEntityName("JavaFive");
		cacheManager.addEntityName("JavaSix");
	}
	
	@Test
	public void test() {
		List<String> actual = cacheManager.search("JavaT");
		List<String> expexted = new ArrayList<String>();
		expexted.add("JavaTwo");
		expexted.add("JavaThree");
		
		assertEquals(expexted, actual);
		
	}

}
