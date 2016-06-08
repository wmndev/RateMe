package com.eyooya.app.web.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyooya.app.platform.utils.upload.UploadService;

import au.com.bytecode.opencsv.CSVReader;

@Controller
@RequestMapping(value="/actions")
public class ActionsController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	private UploadService uploadService;
	
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String gotoActionsPage(){
		return "actions";
	}
	

	
	@RequestMapping(value="/{mode}", method = RequestMethod.GET)
	public String uploadBusinessGET(@PathVariable String mode){
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(servletContext.getRealPath("/WEB-INF")+"/business.csv"));
		
        String [] nextLine;
        int idx = 0;
        while ((nextLine = reader.readNext()) != null) {
        	if (++idx == 0) continue;
        	uploadService.uploadData("business", nextLine);
            if (idx == 3) break;
        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}

}
