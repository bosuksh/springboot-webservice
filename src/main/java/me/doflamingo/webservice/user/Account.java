package me.doflamingo.webservice.user;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String userId;

    @Setter
    private String password;

    @Setter
    private String name;

    @Lob
    @Setter
    private String description;

    @Enumerated(EnumType.STRING)
    @Setter
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    @Setter
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Setter
    private Date lastModifiedDate;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
