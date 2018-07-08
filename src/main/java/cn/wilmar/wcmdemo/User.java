package cn.wilmar.wcmdemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 创建 by 殷国伟 于 2017/9/15.
 */
@Entity
@Data
@ToString
@NoArgsConstructor // for jpa
@AllArgsConstructor
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    public boolean isNew() {
        return id == null;
    }

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NonNull
    @Column(unique = true)
    private String username;
    @NotNull
    @NonNull
    @JsonIgnore
    private String password;
    @NonNull
    private String fullname;

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private LocalDateTime createdDate;
    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime lastModifiedDate;
}
