package be.sertifikasi.isb.user.service;

import be.sertifikasi.isb.response.model.Response;
import be.sertifikasi.isb.response.util.ResponseUtil;
import be.sertifikasi.isb.user.model.UserResponse;
import be.sertifikasi.isb.user.repository.User;
import be.sertifikasi.isb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);
    private final Logger logger = LogManager.getLogger();

    public ResponseEntity<Response> readUsers() {
        System.out.println("=== DEBUG === START readUsers");
        List<UserResponse> userResponses = null;

        try {
            List<User> users = userRepository.findAll();
            userResponses = new ArrayList<>();
            for (User user : users) {
                UserResponse userResponse = mapper.toResponse(user);
                userResponses.add(userResponse);
            }

        } catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

        System.out.println("=== DEBUG === START readUsers");
        return ResponseUtil.ok(userResponses);
    }

    public ResponseEntity<Response> readUsersById(Long id) {
        System.out.println("=== DEBUG === START readUsersById");
        List<UserResponse> userResponses = null;

        try {
            List<User> users = userRepository.findAllById(id);
            userResponses = new ArrayList<>();
            for (User user : users) {
                UserResponse userResponse = mapper.toResponse(user);
                userResponses.add(userResponse);
            }

        } catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

        System.out.println("=== DEBUG === START readUsers");
        return ResponseUtil.ok(userResponses);
    }
}
