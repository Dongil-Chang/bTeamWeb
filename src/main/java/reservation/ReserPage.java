package reservation;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class ReserPage extends PageVO {
	private List<ReserVO> list;

	public List<ReserVO> getList() {
		return list;
	}

	public void setList(List<ReserVO> list) {
		this.list = list;
	}
	
	
}
