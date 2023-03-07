# Дипломный проект по тестированию свободного API сервиса [Reqres.in](https://reqres.in/)

## :open_book: Содержание:

- [Технологии и инструменты](#gear-технологии-и-инструменты)
- [Тест кейсы](#heavy_check_mark-Тест-кейсы)
- [Запуск тестов](#computer-запуск-тестов-из-терминала)
- [Примеры использования](#примеры-использования)
- [Запуск тестов в Jenkins](#-запуск-тестов-из-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)

## :gear: Технологии и инструменты

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/icons/IDEA-logo.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/icons/java-logo.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/icons/git-logo.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media/icons/junit5-logo.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/icons/gradle-logo.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://rest-assured.io/"><img src="media/icons/rest-assured-logo.svg" width="50" height="50" alt="Rest Assured" title="Rest Assured"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/icons/allure-Report-logo.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="media/icons/jenkins-logo.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="media/icons/Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://qameta.io/"><img src="media/icons/allure-ee-logo.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
</p>

В данном проекте для написания автотестов на **Java** использовался фреймворк **Rest Assured**. Для сборки проекта в среде **IntelliJ IDEA** использовался **Gradle**.
Применены аннотации **JUnit5** для параметризованных тестов.

**Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.

## :heavy_check_mark: Тест кейсы

- Проверка авторизации с логином и паролем
- Проверка авторизации без пароля
- Проверка регистрации с логином и паролем
- Проверка регистрации без пароля
- Проверка получения пользовательских данных
- Проверка удаления пользователя

## :computer: Запуск тестов

Локально и удаленно тесты запускаются одной командой:

```bash
./gradlew clean test -Dthreads=${threads_count}"
```

## Примеры использования

### Для запуска необходимо передать значение:

* threads (количество потоков для параллельного запуска, по умолчанию 1)

## <img width="4%" title="Jenkins" src="media/icons/jenkins-logo.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/aka-diplom-api/)
Для запуска сборки необходимо перейти в раздел <code><strong>*Собрать с параметрами*</strong></code> и нажать кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="media/screen/jenkins_job_launch_ui.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report* и *Allure TestOps* кликнув по которому, откроется страница с сформированным html-отчетом и тестовой документацией.

## <img width="4%" title="Allure Report" src="media/icons/allure-Report-logo.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/aka-diplom-api/4/allure/)

<p align="center">
  <img src="media/screen/allure_dashboard_ui.png" alt="allure-report" width="900">
</p>

<p align="center">
  <img src="media/screen/allure_behaviors_ui.png" alt="allure-report_1" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="media/icons/allure-ee-logo.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/20153)

### Основной дашборд

<p align="center">
  <img src="media/screen/testops_dashboard_ui.png" alt="dashboard" width="900">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="media/screen/testops_tree_ui.png" alt="dashboard" width="900">
</p>

### Тест-кейсы

<p align="center">
  <img src="media/screen/testops_cases_ui.png" alt="testcase" width="900">
</p>

## <img width="4%" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screen/allure_notif_ui.jpg">
