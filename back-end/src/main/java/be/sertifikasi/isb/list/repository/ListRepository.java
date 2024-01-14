package be.sertifikasi.isb.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ListRepository extends JpaRepository<List, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM list ls WHERE b_id = :BOOK_ID ORDER BY list_id DESC LIMIT 1;")
    List findListId(@Param("BOOK_ID") int bookId);

}
