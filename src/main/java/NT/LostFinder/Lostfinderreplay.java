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

public class Lostfinderreplay {
	private String replay_uuid;
	private int board_no;
	@NonNull
	private String member_ID;
	@NonNull
	private String replay_content;
	private Timestamp replay_createdate;
}
