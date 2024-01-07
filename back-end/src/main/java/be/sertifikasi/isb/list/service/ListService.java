package be.sertifikasi.isb.list.service;

import be.sertifikasi.isb.book.repository.Book;
import be.sertifikasi.isb.book.repository.BookRepository;
import be.sertifikasi.isb.exception.DataDoesNotExistException;
import be.sertifikasi.isb.list.model.ListRequest;
import be.sertifikasi.isb.list.model.ListResponse;
import be.sertifikasi.isb.list.repository.ListRepository;
import be.sertifikasi.isb.response.model.Response;
import be.sertifikasi.isb.response.util.ResponseUtil;
import be.sertifikasi.isb.user.repository.User;
import be.sertifikasi.isb.user.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ListService {
    private final ListRepository listRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    private final ListMapper mapper = Mappers.getMapper(ListMapper.class);
//    private final Logger logger = LogManager.getLogger();
    private final Logger logger = LogManager.getLogger("be.sertifikasi.isb");


    public ListService(ListRepository listRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.listRepository = listRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Response> readLists() {

        System.out.println("=== DEBUG === START readLists");
        List<ListResponse> listResponses = null;

        try {
            List<be.sertifikasi.isb.list.repository.List> lists = listRepository.findAll();
            listResponses = new ArrayList<>();
            for (be.sertifikasi.isb.list.repository.List list : lists) {
                ListResponse listResponse = mapper.toResponse(list);
                listResponses.add(listResponse);
            }

        } catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

        System.out.println("=== DEBUG === finish readLists");

        return ResponseUtil.ok(listResponses);
    }

    public ResponseEntity<Response> createHistory(ListRequest listRequest) {
        System.out.println("=== DEBUG === START readLists");
        be.sertifikasi.isb.list.repository.List list = null;
        String validation = "Create";
        try{
            list = mapper.fromRequest(listRequest);
            setForeignKeys(list, listRequest,validation);
            listRepository.save(list);

        }catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

        logger.debug("finish createCampaign");
        return ResponseUtil.ok(mapper.toResponse(list));
    }

    private void setForeignKeys(be.sertifikasi.isb.list.repository.List list, ListRequest listRequest, String validation) {
        try {
            if (Objects.equals(validation, "Create")) {
                Book book = bookRepository.findById(listRequest.getBookId())
                        .orElseThrow(() -> new DataDoesNotExistException("book", listRequest.getBookId()));
                book.setBookBorrowed(1);
                list.setBook(book);

                User user = userRepository.findById(listRequest.getUserId())
                        .orElseThrow(() -> new DataDoesNotExistException("user", listRequest.getUserId()));
                list.setUser(user);
            } else if (Objects.equals(validation, "Update")) {
                Book book = bookRepository.findById(listRequest.getBookId())
                        .orElseThrow(() -> new DataDoesNotExistException("book", listRequest.getBookId()));
                book.setBookBorrowed(0);
            }


        } catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

    }

}
