package aramusic.dto;

import lombok.Data;

@Data
public class FreeboardDto {

	private int idx;
	private String title;
	private String contents;
	private int hit;
	private String createdDatetime;
	private String creatorId;
	private String updatedDatetime;
	private String deletedYn;
	
	
}
