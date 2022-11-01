package NT.LostFinder;

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
	private String member_ID;
	private String board_tag;
	private int location_no;
	@NonNull
	private String board_content;
	@NonNull
	private Timestamp board_createdate;
	private int board_viewcount;
}