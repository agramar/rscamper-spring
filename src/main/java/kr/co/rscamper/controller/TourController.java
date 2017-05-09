package kr.co.rscamper.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.TourCommentVO;
import kr.co.rscamper.domain.TourVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.TourService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/tour/*")
public class TourController {

	@Inject
	TourService service;
	@Inject 
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(TourController.class);

	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String tourAll() {
		logger.info("/tour > all");

		return "redirect:http://localhost:80/rscamper-web/views/tour-all/list.jsp";
	};
	
	
	@RequestMapping(value = "/destination", method = RequestMethod.GET)
	public String tourDestination() {
		logger.info("/tour > destination");
		
		return "redirect:http://localhost:80/rscamper-web/views/tour-destination/list.jsp";
	};
	
	
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public String tourFood() {
		logger.info("/tour > food");
		
		return "redirect:http://localhost:80/rscamper-web/views/tour-food/list.jsp";
	};
	
	
	@RequestMapping(value = "/lodge", method = RequestMethod.GET)
	public String tourLodge() {
		logger.info("/tour > lodge");
		
		return "redirect:http://localhost:80/rscamper-web/views/tour-lodge/list.jsp";
	};
	
	
	@RequestMapping(value = "/api/list", method = RequestMethod.GET)
	public @ResponseBody StringBuilder apiAjax(TourVO vo) throws Exception {
		logger.info("/tour > api");
		System.out.println(vo.toString());

		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /* URL */
		urlBuilder.append("?ServiceKey=5AkDpDktcQsMsol9FxLRPbpAhj6M8yO5aRfb9BVCvD76mDEAgwOfEjNcJ3Kcd07t8tXGEmhr%2BCAOvNJv%2FyYivA%3D%3D"); // Service Key
		urlBuilder.append("&contentTypeId=" + (vo.getContentTypeId() == null ? "" : vo.getContentTypeId()));
		urlBuilder.append("&areaCode=" + (vo.getAreaCode() == null ? "" : vo.getAreaCode()));
		urlBuilder.append("&sigunguCode=" + (vo.getSigunguCode() == null ? "" : vo.getSigunguCode()));
		urlBuilder.append("&cat1=" + (vo.getCat1() == null ? "" : vo.getCat1()));
		urlBuilder.append("&cat2=" + (vo.getCat2() == null ? "" : vo.getCat2()));
		urlBuilder.append("&cat3=" + (vo.getCat3() == null ? "" : vo.getCat3()));
		urlBuilder.append("&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=B");
		urlBuilder.append("&numOfRows=" + (vo.getNumOfRows() == null ? "" : vo.getNumOfRows())); 	/* 검색건수 */
		urlBuilder.append("&pageNo=" + (vo.getPageNo() == null ? "" : vo.getPageNo())); 		 	/* 페이지 번호 */
		urlBuilder.append("&_type=json");												 			/* JSON 타입 지정  */
		URL url = new URL(urlBuilder.toString());

		logger.info("url : " + url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		logger.info("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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

		return sb;
	}
	
	
	@RequestMapping(value = "/api/detail", method = RequestMethod.GET)
	public @ResponseBody String apiDetailAjax(@RequestParam("contentid") String contentid, @RequestParam("contenttypeid") String contenttypeid) throws Exception {
		logger.info("/tour > detail");
		
		String s1 = apiDetailExecute(contentid, contenttypeid, "detailCommon", "&defaultYN=Y&addrinfoYN=Y&overviewYN=Y");
		String s2 = apiDetailExecute(contentid, contenttypeid, "detailIntro", "");
		String s3 = apiDetailExecute(contentid, contenttypeid, "detailInfo", "");
		String s4 = apiDetailExecute(contentid, contenttypeid, "detailImage", "&imageYN=Y");
		
		logger.info("api1 : " + s1);
		logger.info("api2 : " + s2);
		logger.info("api3 : " + s3);
		logger.info("api4 : " + s4);
		
		JSONObject obj = new JSONObject();
		obj.put("api1", s1);
		obj.put("api2", s2);
		obj.put("api3", s3);
		obj.put("api4", s4);
		
		System.out.println(obj.toString());
		
		JSONArray array = new JSONArray();
		array.put(0, s1);
		array.put(1, s2);
		array.put(2, s3);
		array.put(3, s4);
		
		return array.toString();
	}
	
	
	public String apiDetailExecute(String contentId, String contenttypeId, String a, String b) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/" + a); /* URL */
		urlBuilder.append("?ServiceKey=5AkDpDktcQsMsol9FxLRPbpAhj6M8yO5aRfb9BVCvD76mDEAgwOfEjNcJ3Kcd07t8tXGEmhr%2BCAOvNJv%2FyYivA%3D%3D"); // Service Key
		urlBuilder.append("&contentId=" + contentId);
		if (b == "") {	
			urlBuilder.append("&contentTypeId=" + contenttypeId);
		}
		urlBuilder.append(b + "&MobileOS=ETC&MobileApp=AppTesting");
		urlBuilder.append("&_type=json"); 
		URL url = new URL(urlBuilder.toString());

		logger.info("url : " + url);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		logger.info("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
		return sb.toString();
	}
	
	
	@RequestMapping(value = "/comment/insert", method = RequestMethod.POST)
	public @ResponseBody void commentInsert(TourCommentVO vo) throws Exception {
		logger.info("/tour > comment > insert");
		
		System.out.println(vo.toString());
		
		service.commentInsert(vo);
	}
	
	
	@RequestMapping(value = "/comment/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> commentList(TourCommentVO vo) throws Exception {
		logger.info("/tour > comment > list");
		
		System.out.println("contentid : " + vo.getContentid());
		System.out.println("userUid : " + vo.getUserUid());
		
		List<TourCommentVO> clist = new ArrayList<>();
		
		clist = service.commentList(vo.getContentid());
		System.out.println(clist.size());
		
		
		for (TourCommentVO tVo : clist) {
			UserVO uVo = userService.selectUserByUid(vo.getUserUid());
			tVo.setDisplayName(uVo.getDisplayName());
			tVo.setPhotoUrl(uVo.getPhotoUrl());
		}
		
		
		int likeCnt = service.likeCnt(vo.getContentid());
		System.out.println("likeCnt : " + likeCnt);
		
		
		int bookmarkCnt = service.bookmarkCnt(vo.getContentid());
		System.out.println("bookmarkCnt : " + bookmarkCnt);
		
		
		String likeStatus = service.likeStatus(vo);
		System.out.println("likeStatus : " + likeStatus);
		String bookmarkStatus = service.bookmarkStatus(vo);
		System.out.println("bookmarkStatus : " + bookmarkStatus);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("list", clist);
		map.put("commentCnt", clist.size());
		map.put("likeCnt", likeCnt);
		map.put("likeStatus", likeStatus);
		map.put("bookmarkCnt", bookmarkCnt);
		map.put("bookmarkStatus", bookmarkStatus);
		
		return map;
	}
	
	
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public @ResponseBody void likeInsert(TourCommentVO vo) throws Exception {
		logger.info("/tour > comment > like");
	
		System.out.println(vo.toString());
		
		service.likeInsert(vo);
	}
	
	
	@RequestMapping(value = "/bookmark", method = RequestMethod.POST)
	public @ResponseBody void bookmarkInsert(TourCommentVO vo) throws Exception {
		logger.info("/tour > comment > bookmark");
	
		System.out.println(vo.toString());
		
		service.bookmarkInsert(vo);
		
	}
}
