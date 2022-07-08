package Study.DBTest.dbCRUD.service;

import Study.DBTest.dbCRUD.domain.User;
import Study.DBTest.dbCRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public Long update(Long id, String newName, int newAge) {
        User updateUser = userRepository.findById(id);
        updateUser.setName(newName);
        updateUser.setAge(newAge);

        return updateUser.getId();
    }

    public User find(Long id) {
        return userRepository.findById(id);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public void remove(Long id) {
        userRepository.remove(id);
        return;
    }
}
