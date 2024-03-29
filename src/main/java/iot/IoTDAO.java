package iot;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IoTDAO implements IoTService {

	@Autowired private SqlSession sql;
	
	@Override
	public int IoT_insert_TemHum(HashMap<String, Object> map) {
		return sql.insert("iot.mapper.temhumInsert", map);
	}

	@Override
	public IoTVO IoT_list(String id) {
		return sql.selectOne("iot.mapper.values", id);
	}

	@Override
	public int IoT_insert_Press(HashMap<String, Object> map) {
		return sql.insert("iot.mapper.pressInsert", map);
	}

	
}