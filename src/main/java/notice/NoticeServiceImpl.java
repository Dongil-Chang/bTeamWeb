package notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.FaqVO;


@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired private NoticeDAO dao;
	
	@Override
	public void notice_insert(NoticeVO vo) {
		dao.notice_insert(vo);
	}

	@Override
	public List<NoticeVO> notice_list() {
		return dao.notice_list();
	}

	@Override
	public NoticeVO notice_detail(int board_num) {
		return dao.notice_detail(board_num);
	}

	@Override
	public void notice_update(NoticeVO vo) {
		dao.notice_update(vo);
	}

	@Override
	public void notice_delete(int id) {
		dao.notice_delete(id);
	}

	@Override
	public void notice_read(int id) {
		dao.notice_read(id);
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		return dao.notice_list(page);
	}

	@Override
	public void notice_reply_insert(NoticeVO vo) {
		dao.notice_reply_insert(vo);
	}

	@Override
	public void notice_reply_update(NoticeVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoticeVO> and_notice_list() {
		return dao.and_notice_list();
	}

	@Override
	public List<FaqVO> and_faq_list() {
		return dao.and_faq_list();
	}

	

}
