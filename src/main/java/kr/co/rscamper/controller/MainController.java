/**-----------------------------------------------------------------------
 * rscamper Project
 * ------------------------------------------------------------------------
 * @Class MainController.java
 * @Description 메인 페이지 실시간 댓글 요청에 대한 처리를 위한 Handler 클래스  
 * @author 김호동
 * @since 2016. 10. 15.
 */

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
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.SubwayVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.MainService;
import kr.co.rscamper.service.UserService;


@Controller
@RequestMapping("/main/*")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Inject
	private MainService mainService;
	@Inject
	private UserService userService;
//	@Inject
//	private BenefitService service;

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
	    ModelAndView mv = new ModelAndView("/main/main");
	    return mv;
	}
	
	/**
	 * @Description 메인 페이지 실시간 댓글 리스트 정보 요청에 대한 처리
	 * @param none
	 * @return List DB에 저장된 댓글 목록
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<MainVO> read(HttpServletResponse res) throws Exception {
		logger.info("/main > read");
		
		List<MainVO> list = new ArrayList<>();
		list = mainService.selectMainComment();
		
		for (MainVO val : list) {
			UserVO uVo = userService.selectMainByUidComment(val.getUserUid());
			val.setDisplayName(uVo.getDisplayName());
			val.setProviderPhotoUrl(uVo.getPhotoUrl());
		}
		return list;
	}
	
	
	/**
	 * @Description 메인 페이지 실시간 댓글 리스트 정보 요청에 대한 처리
	 * @param none
	 * @return List DB에 저장된 댓글 목록
	 */
	@RequestMapping(value = "/{uid}/{content}", method = RequestMethod.PUT)
	public @ResponseBody List<MainVO> insert(@PathVariable("uid") String uid, @PathVariable("content") String content, HttpServletResponse res) throws Exception {
		logger.info("/main > insert");
		
		MainVO mVo = new MainVO();
		mVo.setUserUid(uid);
		mVo.setMainContent(content);
		
		mainService.insertMainComment(mVo);
		
		List<MainVO> list = new ArrayList<>();
		list = mainService.selectMainComment();
		
		for (MainVO val : list) {
			UserVO uVo = userService.selectMainByUidComment(val.getUserUid());
			val.setDisplayName(uVo.getDisplayName());
			val.setProviderPhotoUrl(uVo.getPhotoUrl());
		}
		return list;
	}
	
	// 추천 콘텐츠 부분
	@RequestMapping(value="benefitList", method = RequestMethod.GET)
	public @ResponseBody List<BenefitVO> list()throws Exception {
		logger.info("/benefitList > list");

		List<BenefitVO> list = new ArrayList<>();
		list = mainService.list();
		return list;

	}
	// 메인 관광지 부분
	@RequestMapping(value="touristList", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanSpotVO> tourlist()throws Exception {
		logger.info("/touristList > tourlist");
		
		List<TourPlanSpotVO> result = new ArrayList<>();
		result = mainService.tourlist();
		return result;
	}
	
	// 메인 열차조회 부분
	@RequestMapping(value="mainTrainList", method = RequestMethod.GET)
	public @ResponseBody List<TrainVO> maintrainList()throws Exception {
		logger.info("/mainTrainList > maintrainList");
		
		List<TrainVO> result = new ArrayList<>();
		result = mainService.maintrainList();
		return result;
	}
	
	
	
	@RequestMapping(value="/mainTime", method = RequestMethod.GET)
	public @ResponseBody StringBuilder api(@RequestParam("depPlaceId") String deplaceId, @RequestParam("arrPlaceId") String arrPlaceId,
			@RequestParam("depPlandTime") String depPlandTime, @RequestParam("trainGradeCode") String trainGradeCode, @RequestParam("numOfRows") String numOfRows,
			@RequestParam("pageSize") String pageSize, @RequestParam("pageNo") String pageNo, @RequestParam("startPage") String startPage)throws Exception {
		
		logger.info("mainTrainTime > mainTime");
		
		List<SubwayVO> result = new ArrayList<>();
		result = mainService.mainTrainTimeList(deplaceId, arrPlaceId, depPlandTime, trainGradeCode, numOfRows, pageSize, pageNo, startPage);
		
		
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=XPIlh8%2Bq3M1vpyrwOfH512edOBZMsZD0%2F3xZvjEd42mwMNJqeouD9L6xCPpzyF70KYm078jOK%2FePGlyoXTbCDw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("depPlaceId","UTF-8") + "=" + deplaceId); 
        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","UTF-8") + "=" + arrPlaceId);
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + depPlandTime);
        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","UTF-8") + "=" + trainGradeCode); 
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + numOfRows); 
        urlBuilder.append("&" + URLEncoder.encode("pageSize","UTF-8") + "=" + pageSize); 
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + pageNo); 
        urlBuilder.append("&" + URLEncoder.encode("startPage","UTF-8") + "=" + startPage);
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
