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

	@Override
	public FreeboardDto selectFreeBoardCont(int idx) throws Exception {
		return freeboardMapper.selectFreeBoardCont(idx);
	}

	@Override
	public void updateFreeBoardHit(int idx) throws Exception {
		freeboardMapper.updateFreeBoardHit(idx);
	}

	@Override
	public void insertBoard(FreeboardDto dto) throws Exception {
		freeboardMapper.insertBoard(dto);
	}

	@Override
	public void updateBoard(FreeboardDto dto) throws Exception {
		freeboardMapper.updateBoard(dto);
	}

	@Override
	public void deleteBoard(FreeboardDto dto) throws Exception {
		freeboardMapper.deleteBoard(dto);
		
	}
	

}
