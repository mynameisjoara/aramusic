package aramusic.service;

import java.util.List;

import aramusic.dto.FreeboardDto;


public interface FreeboardService {

	List<FreeboardDto> selectBoardList() throws Exception;	//전체글 가져오기
	FreeboardDto selectFreeBoardCont(int idx) throws Exception;	//글번호에 맞는 글 1개 가져오기(cont)
	void updateFreeBoardHit(int idx) throws Exception;	//글번호에 해당하는 조회수 +1 증가
	void insertBoard(FreeboardDto dto) throws Exception;	//글쓰기 : 글작성내용 DB에 저장시키기
	void updateBoard(FreeboardDto dto) throws Exception;	//글수정 : 수정된내용으로 DB update 시키기
	void deleteBoard(FreeboardDto dto) throws Exception;	//글삭제 : deleted_yn을 y로 변경하는 update
	
}
