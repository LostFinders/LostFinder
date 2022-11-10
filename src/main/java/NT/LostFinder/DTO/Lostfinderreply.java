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

public class Lostfinderreply {
	private String reply_uuid;
	private int board_no;
	@NonNull
	private String member_id;
	@NonNull
	private String reply_content;
	private Timestamp reply_createdate;
}
