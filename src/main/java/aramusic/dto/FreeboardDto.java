package aramusic.dto;

import lombok.Data;

@Data
public class FreeboardDto {

	private int idx;
	private String title;
	private String contents;
	private int hit;
	private String createdDatetime;
	private String creator;
	private String updatedDatetime;
	private String deletedYn;
	private String writepwd;
	private String checkpwd;
	
}
