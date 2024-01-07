package be.sertifikasi.isb.user.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "user")
@Getter
@Setter
@EnableAutoConfiguration
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class User {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "u_id", nullable = false)
  private Integer id;

  @Column(name = "user_name", nullable = false)
  private String userName;

  @Column(name = "user_email", nullable = false)
  private String userEmail;

}
