package member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iot.IoTVO;
import manager.ProvisionVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired private MemberDAO dao;
	
	@Override
	public boolean member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return dao.member_login(map);
	}

	@Override
	public boolean member_id_check(String id) {
		return dao.member_id_check(id);
	}

	@Override
	public boolean member_update(MemberVO vo) {
		return dao.member_update(vo);
	}

	@Override
	public boolean member_delete(String id) {
		return dao.member_delete(id);
	}

	@Override
	public boolean member_social_email(MemberVO vo) {
		return dao.member_social_email(vo);
	}

	@Override
	public boolean member_social_insert(MemberVO vo) {
		return dao.member_social_insert(vo);
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		return dao.member_social_update(vo);
	}

	@Override
	public MemberVO member_pw_check(String pw) {
		return dao.member_pw_check(pw);
	}

	@Override
	public ProvisionVO provision_list() {
		return dao.provision_list();
	}

	@Override
	public ProvisionVO join_service_list() {
		return dao.join_service_list();
	}

	@Override
	public List<MemberVO> mg_member_list() {
		return dao.mg_member_list();
	}

	@Override
	public MemberVO loginMemberByGoogle(MemberVO vo) {
		return dao.loginMemberByGoogle(vo);
	}

	@Override
	public void joinMemberByGoogle(MemberVO vo) {
		dao.joinMemberByGoogle(vo);
		
	}

	@Override
	public MemberVO member_pw_check(HashMap<String, String> map) {
		return dao.member_pw_check(map);
	}

	@Override
	public boolean kakaoLogin_join(MemberVO vo) {
		return dao.kakaoLogin_join(vo);
	}

	@Override
	public ProvisionVO provision_select_2(String use_agreement) {
		return dao.provision_select_2(use_agreement);
	}

	@Override
	public ProvisionVO provision_select_1(String person_information) {
		return dao.provision_select_1(person_information);
	}

	@Override
	public boolean provi_agree_insert1(String id) {
		return dao.provi_agree_insert1(id);
	}

	@Override
	public boolean provi_agree_insert2(String id) {
		return dao.provi_agree_insert2(id);
	}

	@Override
	public IoTVO and_iot_select(String id) {
		return dao.and_iot_select(id);
	}

}
