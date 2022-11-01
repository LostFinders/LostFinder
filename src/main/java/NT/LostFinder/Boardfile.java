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

public class Boardfile {
	@NonNull
	private String boardfile_uuid;
	private int board_no;
	private String member_id;
	@NonNull
	private String boardfile_name;
	private Timestamp boardfile_createdate;
}
