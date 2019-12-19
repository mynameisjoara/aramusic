package aramusic.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aramusic.dto.FreeboardDto;

@Mapper
public interface FreeboardMapper {

	List<FreeboardDto> selectBoardList() throws Exception;
}


