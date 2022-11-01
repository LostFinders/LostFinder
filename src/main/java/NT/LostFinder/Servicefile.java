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

public class Servicefile {
	@NonNull
	private String servicefile_uuid;
	private int service_no;
	private String member_id;
	@NonNull
	private String servicefile_name;
	private Timestamp servicefile_createdate;
}
