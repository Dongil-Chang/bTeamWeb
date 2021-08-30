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


	
	
	
}
