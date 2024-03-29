package reservation;

import java.util.HashMap;
import java.util.List;
import common.PageVO;



public interface ReserService {
	
	// 상품코드 조회 (안드로이드)
	List<ReserVO>  reser_productCode(HashMap<String, String> map); 
	List<ReserVO> mg_reser_list();    // 관리자용 예약목록 조회(안드로이드)
	List<ReserVO> reser_list();  	  // 예약목록 조회(안드로이드)
	boolean reser_insert(ReserVO vo); // 예약추가
	List<ReserVO> user_reser_list(String id);  // 사용자용 예약목록 조회(안드로이드)
	
	boolean user_reser_cancel(HashMap<String, String> map); //예약내역 삭제
	
	boolean reser_using_update(ReserVO vo); //예약상태 변경저장 (Web)
	boolean reser_reserved_update(ReserVO vo); //예약상태 변경저장 (Web)
	
	
	// 페이지 처리된 관리자용 예약목록 조회(Web)
	ReserPage mg_reser_list(ReserPage page);	
	// 페이지 처리된 마이페이지 예약목록 조회(Web)
	ReserPage my_reser_list(HashMap<String, Object> map);	

	
	
	List<ReserVO> reserv_list(ReserVO vo);	// 예약 가능 상품 목록 조회(Web)
}
