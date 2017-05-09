package kr.co.rscamper.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.ScheduleLikeVO;
import kr.co.rscamper.domain.ScheduleMemoVO;
import kr.co.rscamper.domain.TourPlanBudgetForChartVO;
import kr.co.rscamper.domain.TourPlanCommentVO;
import kr.co.rscamper.domain.TourPlanCoverVO;
import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanScheduleVO;
import kr.co.rscamper.domain.TourPlanSpotMemoVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TourScheduleVO;
import kr.co.rscamper.domain.TravelPriceVO;
import kr.co.rscamper.service.TourPlanService;
import kr.co.rscamper.service.TourScheduleService;

@Controller
@RequestMapping("/tourPlan")
public class TourPlanController {

	private static final Logger logger = LoggerFactory.getLogger(TourPlanController.class);
	
	@Inject
	private TourPlanService tourPlanService;
	
	@Inject
	private TourScheduleService tourScheduleService;
	
	@Inject
	private ServletContext servletContext;
	
	
	@RequestMapping(value = "/delete/tourSpotMemo", method = RequestMethod.DELETE)
	public @ResponseBody void deleteTourSpotMemoBylocationMemoNo(int scheduleMemoNo) throws Exception {
		tourPlanService.deleteTourSpotMemoBylocationMemoNo(scheduleMemoNo);
	}
	
	@RequestMapping(value = "/insert/tourSpotMemo", method = RequestMethod.POST)
	public @ResponseBody void insertTourSpotMemo(TourPlanSpotMemoVO tourPlanSpotMemo) throws Exception {
		tourPlanService.insertTourSpotMemo(tourPlanSpotMemo);
	}
	
	@RequestMapping(value = "/select/tourSpotMemoList", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanSpotMemoVO> selectTourSpotMemoList(int recordNo) throws Exception {
		return tourPlanService.selectTourSpotMemoList(recordNo);
	}
	
	@RequestMapping(value = "/insert/tourPlan/comment", method = RequestMethod.POST)
	public @ResponseBody void insertTourPlanComment(TourPlanCommentVO tourPlanComment) throws Exception {
		tourPlanService.insertTourPlanComment(tourPlanComment);
	}
	
	@RequestMapping(value = "/delete/tourPlan/comment", method = RequestMethod.GET)
	public @ResponseBody void deleteTourPlanCommentByCommentNo(int commentNo) throws Exception {
		tourPlanService.deleteTourPlanCommentByCommentNo(commentNo);
	}
	
	@RequestMapping(value = "/select/tourPlan/commentList", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanCommentVO> selectTourPlanCommentListByRecordNo(int recordNo) throws Exception {
		return tourPlanService.selectTourPlanCommentListByRecordNo(recordNo);
	}

	@RequestMapping(value = "/select/tourPlanList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selectTourPlanList(TourPlanParamVO tourPlanParam) throws Exception {
		return tourPlanService.selectTourPlanList(tourPlanParam);
	}
	
	@RequestMapping(value = "/select/tourPlanList/likeCnt", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanVO> selectTourPlanListByLikeCnt() throws Exception {
		return tourPlanService.selectTourPlanListByLikeCnt();
	}
	
	@RequestMapping(value = "/select/myTourPlanList", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanVO> selectMyTourPlanList(String userUid) throws Exception {
		return tourPlanService.selectMyTourPlanList(userUid);
	}
	
	@RequestMapping(value = "/select/bookmarkTourPlanList", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanVO> selectBookmarkTourPlanList(String userUid) throws Exception {
		return tourPlanService.selectBookmarkTourPlanList(userUid);
	}
	
	@RequestMapping(value = "/insert/tourPlan", method = RequestMethod.POST)
	public @ResponseBody int insertTourPlan(TourPlanVO tourPlan) throws Exception {
		return tourPlanService.insertTourPlan(tourPlan);
	}
	
	@RequestMapping(value = "/delete/tourPlan", method = RequestMethod.GET)
	public @ResponseBody void deleteTourPlanByRecordNo(int recordNo) throws Exception {
		tourPlanService.deleteTourPlanByRecordNo(recordNo);
	}
	
	@RequestMapping(value = "/update/tourPlan", method = RequestMethod.POST)
	public @ResponseBody void updateTourPlan(TourPlanVO tourPlan) throws Exception {
		System.out.println(tourPlan.toString());
		tourPlanService.updateTourPlan(tourPlan);
	}
	
	@RequestMapping(value = "/select/tourPlanScheduleByRecordNo", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanScheduleVO> selectTourPlanScheduleListByRecordNo(int recordNo) throws Exception {
		return tourPlanService.selectTourPlanScheduleListByRecordNo(recordNo);
	}
	
	@RequestMapping(value = "/insert/tourPlanSchedule", method = RequestMethod.POST)
	public @ResponseBody void insertTourPlanSchedule(TourPlanScheduleVO tourPlanSchedule) throws Exception {
		tourPlanService.insertTourPlanSchedule(tourPlanSchedule);
	}
	
	@RequestMapping(value = "/delete/tourPlanScheduleByRecordNo", method = RequestMethod.GET)
	public @ResponseBody void deleteTourPlanScheduleByRecordNo(int recordNo) throws Exception {
		tourPlanService.deleteTourPlanScheduleByRecordNo(recordNo);
	}
	
	@RequestMapping(value = "/select/spotList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectSpotList(TourPlanSpotParamVO tourPlanSpotParam) throws Exception {
		return tourPlanService.selectSpotList(tourPlanSpotParam);
	}
	
	@RequestMapping(value = "/select/spotList/bookmark", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectBookmarkSpotList(TourPlanSpotParamVO tourPlanSpotParam) throws Exception {
		System.out.println(tourPlanSpotParam.toString());
		return tourPlanService.selectBookmarkSpotList(tourPlanSpotParam);
	}
	
	@RequestMapping(value = "/select/spotDetail", method = RequestMethod.GET)
	public @ResponseBody TourPlanSpotVO selectSpotDetail(int contentid) throws Exception {
		return tourPlanService.selectSpotDetail(contentid);
	}
	
	@RequestMapping(value = "/select/oneTourPlan", method = RequestMethod.GET)
	public @ResponseBody TourPlanVO selectTourPlan(int recordNo) throws Exception {
		return tourPlanService.selectTourPlan(recordNo);
	}
	
	@RequestMapping(value = "/update/coverImage", method = RequestMethod.POST)
	public @ResponseBody void updateCoverImage(TourPlanCoverVO tourPlanCover) throws Exception {
		tourPlanService.updateCoverImage(tourPlanCover);
	}
	
	@RequestMapping(value = "/update/tourPlanTitle", method = RequestMethod.POST)
	public @ResponseBody void updateTourPlanTitle(TourPlanVO tourPlan) throws Exception {
		tourPlanService.updateTourPlanTitle(tourPlan);
	}
	
	@RequestMapping(value = "/upload/coverImage", method = RequestMethod.POST)
	public @ResponseBody TourPlanCoverVO coverImageUpload(MultipartHttpServletRequest mRequest) throws Exception {

		TourPlanCoverVO tourPlanCover = new TourPlanCoverVO();
		
		String path = "";
		Long size = (long) 0;
		String saveFileName = "";
		String oriFileName = "";
		
		// c:\\\\\
		String uploadDir = servletContext.getRealPath("/upload/images/tourPlan/cover");

		File f = new File(uploadDir);
		if (!f.exists())
			f.mkdirs();

		Iterator<String> iter = mRequest.getFileNames();
		while (iter.hasNext()) {
			String formFileName = iter.next();
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mRequest.getFile(formFileName);

			// 원본 파일명
			oriFileName = mFile.getOriginalFilename();
			
			// 확장자는 무조건 jpg
			if (oriFileName != null && !oriFileName.equals("")) {

				// 확장자 처리
				String ext = ".jpg";
				
				// 뒤쪽에 있는 . 의 위치
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
				}
				
				// 파일 사이즈
				size = mFile.getSize();
				// TODO: 10메가 넘으면 실패 반환

				// 고유한 파일명 만들기
				saveFileName = "cover-" + UUID.randomUUID().toString() + ext;
				
				
				// 임시저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(uploadDir + "/" + saveFileName));
				path = uploadDir + "/" + saveFileName;
			}
		}
		
		String filePath = "http://14.32.66.104:8081" + servletContext.getContextPath() + "/images?path=" + path.substring(path.lastIndexOf("upload")).replaceAll("\\\\","/");
//		String filePath = "http://192.168.0.9:8081" + servletContext.getContextPath() + "/images?path=" + path.substring(path.lastIndexOf("upload")).replaceAll("\\\\","/");
		
		tourPlanCover.setOriName(oriFileName);
		tourPlanCover.setFileName(saveFileName);
		tourPlanCover.setRealPath(path);
		tourPlanCover.setFilePath(filePath);
		tourPlanCover.setFileSize(size);
	
		return tourPlanCover;
	}
	
	@RequestMapping(value = "/update/tourPlanOpen", method = RequestMethod.GET)
	public @ResponseBody int updateTourPlanOpen(TourPlanVO tourPlan) throws Exception {
		System.out.println(tourPlan.getIsOpen());
		return tourPlanService.updateTourPlanOpen(tourPlan);
	}
	
	@RequestMapping("/addScheduleLike")
	@ResponseBody
	public int addScheduleLike(ScheduleLikeVO sl) throws Exception {
		return tourScheduleService.addScheduleLike(sl);
	}
	
	@RequestMapping("/cancelScheduleLike")
	@ResponseBody
	public int cancelScheduleLike(ScheduleLikeVO sl) throws Exception {
		return tourScheduleService.cancelScheduleLike(sl);
	}
	
	@RequestMapping("/addCustomizing")
	@ResponseBody
	public int addCustomizing(TourScheduleVO tv) throws Exception {
		return tourScheduleService.addCustomizing(tv);
	}
	
	@RequestMapping("/cancelCustomizing")
	@ResponseBody
	public int cancelCustomizing(ScheduleLikeVO sl) throws Exception {
		System.out.println(sl.toString());
		return tourScheduleService.cancelCustomizing(sl);
	}
	
	@RequestMapping("/addScheduleBookmark")
	@ResponseBody
	public int addScheduleBookmark(BoardBookMarkVO bbv) throws Exception {
		return tourScheduleService.addScheduleBookmark(bbv);
	}
	
	@RequestMapping("/cancelScheduleBookMark")
	@ResponseBody
	public int cancelScheduleBookMark(BoardBookMarkVO bbv) throws Exception {
		System.out.println(bbv.toString());
		return tourScheduleService.cancelScheduleBookMark(bbv);
	}
	
	@RequestMapping("/checkScheduleSet")
	@ResponseBody
	public Map<String, Boolean> checkScheduleSet(ScheduleLikeVO sl, int targetType) throws Exception {
		return tourScheduleService.checkScheduleSet(sl, targetType);
	}
	
	
	
	
	
	/** 
	 * 메모
	 * */
	@RequestMapping("/getDetailPost")
	@ResponseBody
	public ScheduleMemoVO getDetailPost(ScheduleMemoVO sm) throws Exception {
		return tourScheduleService.getDetailPost(sm);
	}
	
	@RequestMapping("/getScheduleMemo")
	@ResponseBody
	public List<ScheduleMemoVO> getScheduleMemo(ScheduleMemoVO sm) throws Exception {
		return tourScheduleService.getScheduleMemo(sm);
	}
	
	@RequestMapping("/getLocationMemo")
	@ResponseBody
	public List<ScheduleMemoVO> getLocationMemo(int contentId) throws Exception {
		return tourScheduleService.getLocationMemo(contentId);
	}
	
	@RequestMapping("/addScheduleMemo")
	@ResponseBody
	public Map<String,Object> addScheduleMemo(ScheduleMemoVO sm) throws Exception {
		return tourScheduleService.addScheduleMemo(sm);
	}
	
	@RequestMapping("/delScheduleMemo")
	@ResponseBody
	public void delScheduleMemo(int scheduleMemoNo) throws Exception {
		tourScheduleService.delScheduleMemo(scheduleMemoNo);
	}

	
	/** 
	 *  예산
	 * */
	// 예산 리스트 가져오기
	@RequestMapping("/select/budgetListByRecordNo")
	@ResponseBody
	public List<TravelPriceVO> getScheduleTravelPrice(int recordNo) throws Exception {
		return tourScheduleService.getScheduleTravelPrice(recordNo);
	}
	
	// 예산 등록하기
	@RequestMapping(value = "/insert/budget", method = RequestMethod.POST)
	public @ResponseBody void insertTourPlanBudget(TravelPriceVO travelPrice) throws Exception {
		tourPlanService.insertTourPlanBudget(travelPrice);
	}
	
	// 예산 삭제하기
	@RequestMapping(value = "/delete/budgetByTravelPriceNo", method = RequestMethod.DELETE)
	public @ResponseBody void deleteTourPlanBudgetByTravelPriceNo(int travelPriceNo) throws Exception {
		tourPlanService.deleteTourPlanBudgetByTravelPriceNo(travelPriceNo);
	}
	
	// 예산 리스트 가져오기(차트용)
	@RequestMapping(value = "/select/budgetListForChartByRecordNo", method = RequestMethod.GET)
	public @ResponseBody List<TourPlanBudgetForChartVO> selectBudgetListForChartByRecordNo(int recordNo) throws Exception {
		return tourPlanService.selectBudgetListForChartByRecordNo(recordNo);
	}
	

}