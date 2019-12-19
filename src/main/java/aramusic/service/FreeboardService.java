package aramusic.service;

import java.util.List;

import aramusic.dto.FreeboardDto;


public interface FreeboardService {

	List<FreeboardDto> selectBoardList() throws Exception;
}
