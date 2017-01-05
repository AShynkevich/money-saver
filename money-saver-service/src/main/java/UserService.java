import com.deniel.ms.domain.user.IUser;
import com.deniel.ms.domain.user.User;
import com.deniel.ms.repository.sql.jdbc.user.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.create(user);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public IUser findUser(String login) {
        return userRepository.getUserRolesByLogin(login);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
