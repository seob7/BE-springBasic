package fx.studentManagement.entity;

/*
*   이름, 학번, 학년, 전공
*/

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Student {

    private String stuName;
    private Long stuNum;
    private int stuGrade;
    private String stuMajor; //ENUM처리 고려

}
