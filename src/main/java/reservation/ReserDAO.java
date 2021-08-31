package reservation;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import contactus.ContactUsPage;

@Repository
public class ReserDAO implements ReserService {

	@Autowired private SqlSession sql;

	@Override
	public List<ReserVO> mg_reser_list() {
		return sql.selectList("reser.mapper.mg_reserlist");
	}

	@Override
	public List<ReserVO> reser_list() {
		return sql.selectList("reser.mapper.reserlist");
	}

	@Override
	public boolean reser_insert(ReserVO vo) {
		return sql.insert("reser.mapper.reser_insert", vo) == 1 ? true : false;
	}

	@Override
	public List<ReserVO> reser_productCode(HashMap<String, String> map) {
		return sql.selectList("reser.mapper.reser_productcode", map);
	}
	
	

	// 예약 가능 상품 목록 조회(Web)
	@Override
	public List<ReserVO> reserv_list(ReserVO vo) {
		sql.update("reser.mapper.using_update", vo);
		sql.update("reser.mapper.reserved_update", vo);
		return sql.selectList("reser.mapper.code_list", vo);
	}

	// 관리자 예약 내역 조회
	@Override
	public ReserPage mg_reser_list(ReserPage page) {
		sql.update("reser.mapper.using_update", page);
		sql.update("reser.mapper.reserved_update", page);

		
		page.setTotalList(sql.selectOne("reser.mapper.r_mg_totalList", page));
		page.setList(sql.selectList("reser.mapper.r_mg_list", page));
		return page;
	}
	
	// 마이페이지 예약 내역 조회
	@Override
	public ReserPage my_reser_list(HashMap<String, Object> map) {
		ReserPage page = (ReserPage) map.get("page");
		page.setTotalList(sql.selectOne("reser.mapper.r_my_totalList", map) );  
		page.setList( sql.selectList("reser.mapper.r_my_list", map) );
		return page;
	}

	@Override
	public List<ReserVO> user_reser_list(String id) {
		return sql.selectList("reser.mapper.user_reserlist", id);
	}

	@Override
	public boolean user_reser_cancel(HashMap<String, String> map) {
		return (Integer)sql.delete("reser.mapper.user_reser_cancel",map) == 1 ? true : false;
	}

	@Override
	   public boolean reser_using_update(ReserVO vo) {
	      return sql.update("reser.mapper.reser_using_update", vo) == 1 ? true : false;
	   }

	   @Override
	   public boolean reser_reserved_update(ReserVO vo) {
	      return sql.update("reser.mapper.reser_reserved_update", vo) == 1 ? true : false;
	   }

	

}
