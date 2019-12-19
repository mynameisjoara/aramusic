package aramusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aramusic.dto.FreeboardDto;
import aramusic.mapper.FreeboardMapper;


@Service
public class FreeboardServiceImpl implements FreeboardService {

	@Autowired
	private FreeboardMapper freeboardMapper;
	
	@Override
	public List<FreeboardDto> selectBoardList() throws Exception {
		return freeboardMapper.selectBoardList();
	}

}
