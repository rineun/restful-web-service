
        package com.example.restfulwebservice.user;
        import com.fasterxml.jackson.annotation.JsonFilter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import io.swagger.annotations.ApiModel;
        import io.swagger.annotations.ApiModelProperty;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;
        import javax.persistence.OneToMany;
        import javax.validation.constraints.Past;
        import javax.validation.constraints.Size;
        import java.util.Date;
        import java.util.List;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})
@NoArgsConstructor
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객")
@Entity   //DB테이블 생김
public class User {
    @Id
    @GeneratedValue //DB테이블 생김
    private Integer id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요")
    @ApiModelProperty(notes = "사용자의 이름을 입력해 주세요")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자의 등록 입력해 주세요")
    private Date joinDate;

    //@JsonIgnore
    @ApiModelProperty(notes = "사용자의 비밀번 입력해 주세요")
    private String password;
    //@JsonIgnore
    @ApiModelProperty(notes = "사용자의 주민번호 입력해 주세요")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> post;


    public User(int i, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn =  ssn;
    }
}
