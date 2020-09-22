package me.doflamingo.webservice.user;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Account {

    @Id
    @Setter
    @NonNull
    private String userId;

    @Setter
    @NonNull
    private String password;

    @Setter
    @NonNull
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

}
