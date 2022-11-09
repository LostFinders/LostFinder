package NT.LostFinder.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Lostfinderboard {
	private int board_no;
	@NonNull
	private String board_title;
	@NonNull
	private String member_id;
	private String board_tag;
	private int location_no;
	@NonNull
	private String board_content;
	private Timestamp board_createdate;
	private int board_viewcount;
}