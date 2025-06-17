package mybatis;

import java.util.List;
import java.util.Map;

public interface Mapper {
    List<Student> selectStudent();
    List<Map> selectStudentToMap();
}
