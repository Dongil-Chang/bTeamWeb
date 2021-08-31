package reservation;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserServiceImpl implements ReserService {
	
	@Autowired private ReserDAO dao;

	// 관리자용 예약목록 조회(안드로이드)
	@Override
	public List<ReserVO> mg_reser_list() {
		return dao.mg_reser_list();
	}

	@Override
	public List<ReserVO> reser_list() {
		return dao.reser_list();
	}

	@Override
	public boolean reser_insert(ReserVO vo) {
		return dao.reser_insert(vo);
	}
	
	@Override
	public List<ReserVO> reser_productCode(HashMap<String, String> map) {
		return dao.reser_productCode(map);
	}

	@Override
	public List<ReserVO> user_reser_list(String id) {
		return dao.user_reser_list(id);
	}
	
	@Override
	public boolean user_reser_cancel(HashMap<String, String> map) {
		return dao.user_reser_cancel(map);
	}


	
	
	
	// 예약 가능 상품 목록 조회(Web)
	@Override
	public List<ReserVO> reserv_list(ReserVO vo) {
		return dao.reserv_list(vo);
	}
	
	// 관리자 예약 목록 조회(Web)
	@Override
	public ReserPage mg_reser_list(ReserPage page) {
		return dao.mg_reser_list(page);
	}
	
	// 마이페이지 예약 목록 조회 (Web)
	@Override
	public ReserPage my_reser_list(HashMap<String, Object> map) {
		return dao.my_reser_list(map);
	}

	@Override
	   public boolean reser_using_update(ReserVO vo) {
	      return dao.reser_using_update(vo);
	   }

	@Override
	public boolean reser_reserved_update(ReserVO vo) {
	      return dao.reser_reserved_update(vo);
	}
	
}
