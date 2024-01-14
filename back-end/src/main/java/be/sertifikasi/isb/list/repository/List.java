package be.sertifikasi.isb.list.repository;

import be.sertifikasi.isb.book.repository.Book;
import be.sertifikasi.isb.user.repository.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "list")
@Getter
@Setter
@EnableAutoConfiguration
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class List {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "list_id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "u_id", referencedColumnName = "u_id")
  private User user;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "b_id", referencedColumnName = "b_id")
  private Book book;

  @Column(name = "start_date", nullable = false)
  private Date startDate;

  @Column(name = "end_date", nullable = false)
  private Date endDate;

  @Column(name = "actual_return_date")
  private Date actualReturnDate;

}
