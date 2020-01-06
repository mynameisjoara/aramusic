package aramusic.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import aramusic.dto.FreeboardDto;

@Mapper
public interface FreeboardMapper {

	List<FreeboardDto> selectBoardList() throws Exception;
	FreeboardDto selectFreeBoardCont(@Param("idx") int idx) throws Exception;
	void updateFreeBoardHit(@Param("idx") int idx) throws Exception;
	void insertBoard(FreeboardDto dto) throws Exception;
	void updateBoard(FreeboardDto dto) throws Exception;
	void deleteBoard(FreeboardDto dto) throws Exception;
}


