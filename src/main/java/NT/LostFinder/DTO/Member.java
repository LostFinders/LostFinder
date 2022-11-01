package NT.LostFinder.DTO;

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
public class Member {
	@NonNull
	private String member_ID;
	@NonNull
	private String member_PW;
	private String member_name;
	private String member_phone;
	private String member_email;
	private String member_zipcode;
	private String member_address;
	private String member_building;
	private int member_level;
	private int PWquestion_no;
	private String member_PWanswer;
}