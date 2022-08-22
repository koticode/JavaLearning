
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * В тестовом классе показано несколько возможных вариантов тестирования работы с пользователями
 * При составлении тестов применялась техника TDD (Test Driven Development):
 * т.е. сначала писались тесты, а затем - основной функционал, который подлежит тестированию.
 * Алгоритм:
 * 1) Добавляем тест на новую функциональность (которая будет написана в дальнейшем)
 * 2) Убеждаемся, что тест не прошел
 * 3) Пишем код для новой функциональности, чтобы тест прошел
 * 4) Проверяем, что все ранее созданные тесты прошли (регрессия)
 * 5) Рефакторинг кода (улучшение структуры кода по возможности)
 */
class UserServiceTest {

    private static final User IVAN = User.of(1, "Ivan", "123"); // пользователи вынесены в поля для удобства, т.к. используются в нескольких тестах
    private static final User PETR = User.of(2, "Petr", "111");

    private UserService userService;

    @BeforeEach
    void prepare() {
        System.out.println("Before each: создаем экземпляр класса UserService перед прохождением каждого теста" );
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded() {  // проверка того, что список пользователей изначально пуст
        var users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "Список пользователей должен быть пуст!");
    }

    @Test
    void usersSizeIfUserAdded() { // размер списка users должен соответствовать кол-ву добавленных в него пользователей
        userService.add(IVAN);
        userService.add(PETR);

        var users = userService.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void loginSuccessIfUserExists() { // метод для проверки, существует ли пользователь
        userService.add(IVAN); // добавляются данные для проверки

        Optional<User> maybeUser = userService.login(IVAN.getUsername(), IVAN.getPassword()); // метод Login, который требуется проверить

        assertTrue(maybeUser.isPresent()); // проверка, сущетсвует ли пользователь
        maybeUser.ifPresent(user -> assertEquals(IVAN, user)); // проверка, совпадает ли user с IVAN
    }

    @Test
    void loginFailIfPasswordIsNotCorrect() { // метод, проверяющий корректность введенного пароля
        userService.add(IVAN);

        var maybeUser = userService.login(IVAN.getUsername(), "dummy"); // в логин передается заведомо неверный пароль

        assertTrue(maybeUser.isEmpty()); // isEmpty должен вернуть true, т.к. пользователя с заведомо неверным паролем не существует
    }

    @Test
    void loginFailIfUserDoesNotExist() { // метод для проверки, существует ли логин
        userService.add(IVAN);

        var maybeUser = userService.login("dummy", IVAN.getPassword()); // в качестве логина передается несуществующее имя пользователя

        assertTrue(maybeUser.isEmpty()); // isEmpty должен вернуть true, т.к. пользователя с таким именем не существует
    }
}