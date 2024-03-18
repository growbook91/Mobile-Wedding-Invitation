package leefamily.mobileweddinginvitation.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Attendance {
    private Long id;
    private String side;
    private String name;
    private String companionName;
    private String food;
    private Integer totalNum;

}
