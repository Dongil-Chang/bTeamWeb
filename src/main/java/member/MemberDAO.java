package member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iot.IoTVO;
import manager.ProvisionVO;

@Repository
public class MemberDAO implements MemberService {

	@Autowired private SqlSession sql;
	@Override
	public boolean member_join(MemberVO vo) {
		return sql.insert("member.mapper.join_insert", vo) == 1 ? true : false;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return sql.selectOne("member.mapper.login", map);
	}

	@Override
	   public boolean member_id_check(String id) {
	      return  (Integer) sql.selectOne("member.mapper.idchk", id) == 0 ? true : false;
	   }

	@Override
	public boolean member_update(MemberVO vo) {
		return sql.update("member.mapper.account_update", vo) == 1 ? true : false;
	}

	@Override
	public boolean member_delete(String id) {
		//int delete = sql.delete("member.mapper.delete", id);
		return (Integer)sql.delete("member.mapper.delete", id) == 1 ? true : false;
	}

	@Override
	public boolean member_social_email(MemberVO vo) {
		return (Integer) sql.selectOne("member.mapper.social_email", vo) == 0 ? false : true ;
	}

	@Override
	public boolean member_social_insert(MemberVO vo) {
		return sql.insert("member.mapper.social_insert", vo) == 0 ? false : true;
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		return sql.update("member.mapper.social_update", vo) == 0 ? false : true;
	}

	@Override
	public MemberVO member_pw_check(String pw) {
		return sql.selectOne("member.mapper.pwchk", pw);
	}

	@Override
	public ProvisionVO provision_list() {
		return sql.selectOne("member.mapper.provision_list");
	}

	@Override
	public ProvisionVO join_service_list() {
		return sql.selectOne("member.mapper.join_service_list");
	}

	@Override
	public List<MemberVO> mg_member_list() {
		return sql.selectList("member.mapper.mg_memberlist");
	}

	@Override
	public MemberVO loginMemberByGoogle(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void joinMemberByGoogle(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO member_pw_check(HashMap<String, String> map) {
		return sql.selectOne("member.mapper.pwchk", map);
	}

	@Override
	public boolean kakaoLogin_join(MemberVO vo) {
		return sql.insert("member.mapper.kakaoLogin_insert", vo) == 1 ? true : false;
	}

	@Override
	public ProvisionVO provision_select_2(String use_agreement) {
		return sql.selectOne("member.mapper.provision_select_2", use_agreement);
	}

	@Override
	public ProvisionVO provision_select_1(String person_information) {
		return sql.selectOne("member.mapper.provision_select_1", person_information);
	}

	@Override
	public boolean provi_agree_insert1(String id) {
		return sql.insert("member.mapper.provi_agree_insert1", id) == 1 ? true : false;
	}

	@Override
	public boolean provi_agree_insert2(String id) {
		return sql.insert("member.mapper.provi_agree_insert2", id) == 1 ? true : false;
	}

	@Override
	public IoTVO and_iot_select(String id) {
		return sql.selectOne("member.mapper.and_iot_select", id);
	}

}
