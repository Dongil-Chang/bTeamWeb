package notice;

import java.util.List;

import manager.FaqVO;


public interface NoticeService {
	// CRUD
	void notice_insert(NoticeVO vo); 		// 공지글 신규 저장 (C)
	
	void notice_reply_insert(NoticeVO vo); 	// 공지글에 대한 답글 신규저장 (C)
	List<NoticeVO> notice_list();			// 공지글 목록조회  (R)
	NoticePage notice_list(NoticePage page);// 공지글 목록조회 - 페이지 처리된. (R)
	NoticeVO notice_detail(int board_num);			// 공지글 상세조회  (R)
	void notice_update(NoticeVO vo);		// 공지글 변경저장  (U)
	
	void notice_reply_update(NoticeVO vo);	// 공지글에 대한 답글 변경저장  (U)
	void notice_read(int id);				// 공지글 조회시 조회수 증가 처리 (U)
	void notice_delete(int id);				// 공지글 삭제      (D)
	
	
	List<NoticeVO> and_notice_list(); 		//안드로이드 - 공지글 조회
	List<FaqVO> and_faq_list();				//안드로이드 - FaQ 조회
}
