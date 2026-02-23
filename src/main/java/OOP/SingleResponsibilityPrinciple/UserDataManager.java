package OOP.SingleResponsibilityPrinciple;
/*

In this file you can find violation of Single Responsibility Principle.
You should refactor this file.
You can remove this file completely, because it will not be used during the evaluation of the solution.

*/

/*
* Название упражнения: Упражнение по рефакторингу на основе принципа единственной ответственности (SRP)

Цель: В этом упражнении вы попрактикуетесь в применении принципа единственной ответственности (SRP) для рефакторинга заданного кода.
* Принцип единственной ответственности гласит, что у класса должна быть только одна причина для изменения, то есть каждый класс должен иметь одну,
*  четко определенную обязанность. Вы улучшите модульность, читаемость и удобство сопровождения кода, разделив различные обязанности на отдельные классы.

Инструкции:

Проверка предоставленного кода: Начните с изучения исходного кода — класса UserDataManager.
* Выявите области, где код нарушает принцип единственной ответственности, поскольку классы отвечают за выполнение нескольких задач.

Определение обязанностей: Проанализируйте код, чтобы определить отдельные обязанности или функции, которые можно разделить на отдельные классы.
*  Сосредоточьтесь на таких областях, как регистрация пользователей, вход в систему, обработка данных или любые другие отдельные задачи.

Рефакторинг кода: Рефакторизуйте код, создав отдельные классы для каждой из указанных задач (UserValidator, UserRegistration, UserAuthenticator).
*  Убедитесь, что каждый класс имеет четкое и единственное назначение, например, регистрация пользователя, аутентификация или обработка данных.

Тестирование решения: Предусмотрены тесты для положительных и отрицательных сценариев, которые должны пройти успешно.

Проверка качества кода: Просмотрите рефакторизованный код, чтобы убедиться в его соответствии принципам единой ответственности (SRP).
*  Убедитесь, что каждый класс имеет единственную задачу, а код является модульным, читаемым и поддерживаемым.

Примечание: Для обеспечения работы систем авторизации и регистрации мы не будем использовать хранилище данных в оперативной памяти или внешнее хранилище.
*  Вы можете максимально использовать бизнес-логику из класса UserDataManager. Основное внимание уделяется не бизнес-логике, а рефакторингу.
* */

public class UserDataManager {
    private String username;
    private String password;

    public UserDataManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void registerUser() {
        // Validate username and password
        if (validateUsername(username) && validatePassword(password)) {
            // Register user in the database
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void loginUser() {
        // Validate username and password
        if (validateUsername(username) && validatePassword(password)) {
            // Authenticate user
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private boolean validateUsername(String username) {
        // Validate username (e.g., length, characters allowed)
        return username.length() >= 5 && username.matches("[a-zA-Z_0-9]+");
    }

    private boolean validatePassword(String password) {
        // Validate password (e.g., length, complexity)
        return password.length() >= 8 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }

    public static void main(String[] args) {
        UserDataManager userManager = new UserDataManager("john_doe", "Password123");
        userManager.registerUser();
        userManager.loginUser();
    }
}
