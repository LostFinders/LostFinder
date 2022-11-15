package NT.LostFinder;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlManager{
	private static SqlSessionFactory ssf=null;
	public static SqlSessionFactory getInstance() {
		String resource="NT/LostFinder/config-mybatis.xml";
		if(ssf==null) {
			try {
				InputStream is = Resources.getResourceAsStream(resource);
				ssf=new SqlSessionFactoryBuilder().build(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ssf;
	}
}
