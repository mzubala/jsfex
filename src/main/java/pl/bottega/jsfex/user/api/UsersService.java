package pl.bottega.jsfex.user.api;

import pl.bottega.jsfex.user.model.User;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by maciuch on 29.09.16.
 */
public class UsersService {

    private static final List<User> USERS = new LinkedList<User>();

    static {
        USERS.add(new User("http://findicons.com/files/icons/1072/face_avatars/300/a03.png", "John", "Doe", "joe"));
        USERS.add(new User("http://findicons.com/files/icons/1072/face_avatars/300/fh04.png", "Jane", "Doe", "admin"));
        for (int i = 0; i < 1000; i++) {
            USERS.add(new User("http://findicons.com/files/icons/1072/face_avatars/300/a03.png", "John", "Doe" + i, "joe" + i));
            USERS.add(new User("http://findicons.com/files/icons/1072/face_avatars/300/fh04.png", "Jane", "Doe" + i, "jane" + i));
        }
    }

    public UserSearchResults searchUsers(UserQuery query) {
        Supplier<Stream<User>> sup = () -> USERS.stream().
                filter((u) -> u.getFirstName().startsWith(query.getQuery()) || u.getLastName().startsWith(query.getQuery()));
        UserSearchResults results = new UserSearchResults();
        results.setTotalCount((int) sup.get().count());
        Stream<User> userStream = sup.get()
                .sorted(comparator(query))
                .skip(query.getOffset()).limit(query.getPerPage());
        results.setUsers(userStream.collect(Collectors.toList()));
        results.setPerPage(query.getPerPage());
        results.setPageNumber(query.getPageNumber());
        return results;
    }

    private Comparator<User> comparator(UserQuery query) {
        Comparator<User> cmp = baseComparator(query);
        if (query.getSortOrder() == SortOrder.ASC)
            return cmp;
        else
            return cmp.reversed();
    }

    private Comparator<User> baseComparator(UserQuery query) {
        if ("last_name".equals(query.getSortBy()))
            return (User u1, User u2) -> u1.getLastName().compareTo(u2.getLastName());
        if ("login".equals(query.getSortBy()))
            return (User u1, User u2) -> u1.getLogin().compareTo(u2.getLogin());
        throw new IllegalArgumentException("Unknown sort field: " + query.getSortBy());
    }

    public Optional<User> findByLoginAndPassword(String login, final String password) {
        return USERS.stream().filter((u) -> u.sameCredentials(login, password)).findFirst();
    }

    public void delete(User user) {
        USERS.remove(user);
    }

    public User findByLogin(String userLogin) {
        return USERS.stream().filter((u) -> u.getLogin().equals(userLogin)).findFirst().get();
    }

    public void add(User user) {
        USERS.add(user);
    }
}
