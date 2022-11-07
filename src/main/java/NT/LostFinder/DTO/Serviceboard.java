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
public class Serviceboard {
	private int service_no;
	@NonNull
	private String service_title;
	@NonNull
	private String member_id;
	@NonNull
	private String service_content;
	private Timestamp service_createdate;
	private int service_viewcount;
}