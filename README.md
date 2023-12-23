# Лабораторная работа №3 - REST API, Gateway и синхронный обмен между микросервисами
Цель:

Изучение шаблона проектирования gateway, построения синхронного обмена между микросервисами и архитектурного стиля RESTful API.

Задачи:

Создать 2 микросервиса, реализующих CRUD на связанных сущностях. Реализовать механизм синхронного обмена сообщениями между микросервисами. Реализовать шлюз на основе прозрачного прокси-сервера nginx.

## Демонстрация работы программы
### Сервис Aggregator
<u>POST-метод для создания вакансии</u>

![img.png](screenshots/img.png)

<u>GET-метод для получения вакансии по id</u>

![img_3.png](screenshots/img_3.png)

<u>GET-метод для получения списка вакансий</u>

![img_2.png](screenshots/img_2.png)

<u>PUT-метод для обновления вакансии</u>

![img_4.png](screenshots/img_4.png)

<u>DELETE-метод для удаления вакансии</u>

![img_5.png](screenshots/img_5.png)

### Метод, связывающий оба микросервиса
<u>В контроллере:</u>
![img.png](screenshots/img.png)

<u>В сервисе:</u>

![img_1.png](screenshots/img_1.png)

![img_2.png](screenshots/img_2.png)

<u>Демонстрация работы:</u>

![img.png](screenshots/img_12.png)

### Сущности
Page -> Jobs (One-to-Many)

![img.png](screenshots/img.png)

![img_1.png](screenshots/img_1.png)

### Dockerfile (aggregator-api)

![img_2.png](screenshots/img_2.png)

### Dockerfile (parser-api)

![img_3.png](screenshots/img_3.png)

### Docker compose

![img_4.png](screenshots/img_4.png)

![img_5.png](screenshots/img_5.png)

![img_6.png](screenshots/img_6.png)

![img_7.png](screenshots/img_7.png)

### Nginx

![img_8.png](screenshots/img_8.png)