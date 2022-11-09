package NT.LostFinder.DTO;

import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilePart {
	private String UUID;
	private String filePart;
	private String fileName;
	private Part part;
}
