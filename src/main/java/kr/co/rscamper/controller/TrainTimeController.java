package kr.co.rscamper.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.SubwayVO;
import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.service.TrainService;

@Controller
@RequestMapping("/trainTime/*")
public class TrainTimeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainTimeController.class);
	
	@Inject
	private TrainService service;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String trainTime() {
		logger.info("/trainTime > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/train/trainTimeList.jsp";
	}
	
	
	/**
	 * 열차 시간정보 목록
	 */
	
	@RequestMapping(value="/trainTimeList", method = RequestMethod.GET)
	public @ResponseBody List<TrainVO> list() throws Exception {
		logger.info("trainTime");

		List<TrainVO> list = new ArrayList<>();
		list = service.list();
		return list;
	}
	
	@RequestMapping(value="/trainSearch", method = RequestMethod.GET)
	public @ResponseBody List<TrainVO> trainList(@RequestParam("data") String data) throws Exception {
		logger.info("trainSearch");
		System.out.println(data);
		List<TrainVO> list = new ArrayList<>();
		list = service.trainSearch(data);
		return list;
	}
	
	@RequestMapping(value="/time", method = RequestMethod.GET)
	public @ResponseBody StringBuilder api(SubwayVO sub)throws Exception {
		
		System.out.println("trainTime > time");
		System.out.println("rrrrrr");
		System.out.println(sub.toString());
		
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=XPIlh8%2Bq3M1vpyrwOfH512edOBZMsZD0%2F3xZvjEd42mwMNJqeouD9L6xCPpzyF70KYm078jOK%2FePGlyoXTbCDw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("depPlaceId","UTF-8") + "=" + service.selectDepPlaceId(sub.getDepPlaceId())); 
        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","UTF-8") + "=" + service.selectArrPlaceId(sub.getArrPlaceId()));
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + sub.getDepPlandTime());
        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","UTF-8") + "=" + sub.getTrainGradeCode()); 
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + sub.getNumOfRows()); 
        urlBuilder.append("&" + URLEncoder.encode("pageSize","UTF-8") + "=" + sub.getPageSize()); 
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + sub.getPageNo()); 
        urlBuilder.append("&" + URLEncoder.encode("startPage","UTF-8") + "=" + sub.getStartPage());
    	urlBuilder.append("&_type=json");
    	URL url = new URL(urlBuilder.toString());
    	System.out.println(url);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		
		
		return sb;
		
	}
	
	
}
