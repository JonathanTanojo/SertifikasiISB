package be.sertifikasi.isb.list.controller;

import be.sertifikasi.isb.list.model.ListRequest;
import be.sertifikasi.isb.list.service.ListService;
import be.sertifikasi.isb.response.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping
    public ResponseEntity<Response> readList() {
        return listService.readLists();
    }

    @PostMapping
    public ResponseEntity<Response> createHistory(@RequestBody ListRequest listRequest) {
        return listService.createHistory(listRequest);
    }

}
