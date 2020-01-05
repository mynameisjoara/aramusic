package aramusic.service;

import java.util.List;

import aramusic.dto.FreeboardDto;


public interface FreeboardService {

	List<FreeboardDto> selectBoardList() throws Exception;	//전체글 가져오기
	FreeboardDto selectFreeBoardCont(int idx) throws Exception;	//글번호에 맞는 글 1개 가져오기(cont)
	void updateFreeBoardHit(int idx) throws Exception;	//글번호에 해당하는 조회수 +1 증가
	void insertBoard(FreeboardDto dto) throws Exception;	//글쓰기 : 글작성내용 DB에 저장시키기
	
}
