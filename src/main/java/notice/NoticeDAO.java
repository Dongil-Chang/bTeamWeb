package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import manager.FaqVO;


@Repository
public class NoticeDAO implements NoticeService {

	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	
	@Override
	public void notice_insert(NoticeVO vo) {
		sql.insert("notice.mapper.insert", vo);
	}

	@Override
	public List<NoticeVO> notice_list() {
		return sql.selectList("notice.mapper.list");
	}

	@Override
	public NoticeVO notice_detail(int id) {
		return sql.selectOne("notice.mapper.detail", id);
	}

	@Override
	public void notice_update(NoticeVO vo) {
		sql.update("notice.mapper.update", vo);
	}

	@Override
	public void notice_delete(int id) {
		sql.delete("notice.mapper.delete", id);
	}

	@Override
	public void notice_read(int id) {
		sql.update("notice.mapper.read", id);
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		page.setTotalList(sql.selectOne("notice.mapper.totalList", page) );  
		page.setList( sql.selectList("notice.mapper.list", page) );
		return page;
	}

	@Override
	public void notice_reply_insert(NoticeVO vo) {
		sql.insert("notice.mapper.reply_insert", vo);
	}

	@Override
	public List<NoticeVO> and_notice_list() {
		return sql.selectList("notice.mapper.and_notice_list");
	}
	@Override
	public List<FaqVO> and_faq_list() {
		return sql.selectList("notice.mapper.and_faq_list");
	}
	@Override
	public void notice_reply_update(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public void notice_reply_insert(NoticeVO vo) {
	 * sql.insert("notice.mapper.reply_insert", vo); }
	 * 
	 * @Override public void notice_reply_update(NoticeVO vo) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */
}