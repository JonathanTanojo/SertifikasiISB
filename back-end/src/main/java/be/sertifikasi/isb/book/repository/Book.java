package be.sertifikasi.isb.book.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Year;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "book")
@Getter
@Setter
@EnableAutoConfiguration
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Book {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "b_id", nullable = false)
  private Integer id;

  @Column(name = "book_name", nullable = false)
  private String bookName;

  @Column(name = "book_description", nullable = false)
  private String bookDescription;

  @Column(name = "book_year", nullable = false)
  private Year bookYear;

  @Column(name = "book_image", nullable = false)
  private String bookImage;

  @Column(name = "book_borrowed", nullable = false)
  private Integer bookBorrowed;

}
