
        package com.example.restfulwebservice.user;
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
//@JsonIgnoreProperties(value={"password"})
@NoArgsConstructor
//@JsonFilter("UserInfo")

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2)
    private String name;

    @Past
    private Date joinDate;


}
