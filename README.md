# Лабораторная работа №3 - REST API, Gateway и синхронный обмен между микросервисами
Цель:

Изучение шаблона проектирования gateway, построения синхронного обмена между микросервисами и архитектурного стиля RESTful API.

Задачи:

Создать 2 микросервиса, реализующих CRUD на связанных сущностях. Реализовать механизм синхронного обмена сообщениями между микросервисами. Реализовать шлюз на основе прозрачного прокси-сервера nginx.

## Демонстрация работы программы
### Сервис Aggregator
<u>POST-метод для создания вакансии</u>

![1.png](screenshots%2F1.png)

<u>GET-метод для получения вакансии по id</u>

![2.png](screenshots%2F2.png)

<u>GET-метод для получения списка вакансий</u>

![3.png](screenshots%2F3.png)

<u>PUT-метод для обновления вакансии</u>

![4.png](screenshots%2F4.png)

<u>DELETE-метод для удаления вакансии</u>

![5.png](screenshots%2F5.png)

### Метод, связывающий оба микросервиса
<u>Демонстрация работы:</u>

![img_12.png](screenshots%2Fimg_12.png)

### Сущности
Page -> Jobs (One-to-Many)

![img.png](screenshots/test/img.png)

![img_1.png](screenshots/test/img_1.png)

### Dockerfile (aggregator-api)

![img_2.png](screenshots/test/img_2.png)

### Dockerfile (parser-api)

![img_3.png](screenshots/test/img_3.png)

### Docker compose

![img_4.png](screenshots/test/img_4.png)

![img_5.png](screenshots/test/img_5.png)

![img_6.png](screenshots/test/img_6.png)

![img_7.png](screenshots/test/img_7.png)

### Nginx
![img_8.png](screenshots%2Ftest%2Fimg_8.png)

## Ссылка на видео:
https://youtu.be/oPLQxyRDlXw