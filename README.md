## Итоговая контрольная работа
Информация о проекте
Необходимо организовать систему учета для питомника в котором живут домашние и вьючные животные.
Как сдавать проект
Для сдачи проекта необходимо создать отдельный общедоступный репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом репозитории, использовать пул реквесты на изменения. Программа должна запускаться и работать, ошибок при выполнении программы быть не должно. Программа, может использоваться в различных системах, поэтому необходимо разработать класс в виде конструктора.

# Задание

1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).
### Решение #1

    coldsan@coldsan:~$ cat > "Домашние животные"
    Собаки
    Кошки
    Хомяки
    ^C
    coldsan@coldsan:~$ cat > "Вьючные животные"
    Лошади
    Верблюды
    Ослы
    ^C
    coldsan@coldsan:~$ cat "Вьючные животные" "Домашние животные" > "Животные"
    coldsan@coldsan:~$ cat "Животные"
    Лошади
    Верблюды
    Ослы
    Собаки
    Кошки
    Хомяки
    coldsan@coldsan:~$ mv "Животные" "Друзья Человека"



2. Создать директорию, переместить файл туда.
### Решение #2

    coldsan@coldsan:~$ mkdir Animals
    coldsan@coldsan:~$ mv "Друзья Человека" Animals/
    coldsan@coldsan:~$ cd Animals
    coldsan@coldsan:~/Animals$ ls
    'Друзья Человека'


3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
### Решение #3

    coldsan@coldsan:~$ wget https://repo.mysql.com//mysql-apt-config_0.8.26-1_all.deb
    coldsan@coldsan:~$ sudo dpkg -i mysql-apt-config_0.8.26-1_all.deb
    coldsan@coldsan:~$ sudo apt-get update
    coldsan@coldsan:~$ sudo apt-get install mysql-server

4. Установить и удалить deb-пакет с помощью dpkg.
### Решение #4

    coldsan@coldsan:~$ sudo dpkg -i apache2_2.4.52-1ubuntu4.6_amd64.deb
    coldsan@coldsan:~$ sudo dpkg -r apache2

5. Выложить историю команд в терминале ubuntu.
### Решение #5

    coldsan@coldsan:~$ history
![Изображение](IMAGES/Commands.JPG "Команды")



6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы).
### Решение #6

    Human_Friends
    ├── Home_Animals
    │   ├── Dogs
    │   ├── Cats
    │   └── Hamsters
    └── Pack_Animals
        ├── Horses
        ├── Camels
        └── Donkeys

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”.
### Решение #7


8. Создать таблицы с иерархией из диаграммы в БД.
### Решение #8

    coldsun@ubuntu-home:~$ sudo docker exec -it some-mysql bash
    bash-4.4# mysql -u root -p
    mysql> CREATE DATABASE IF NOT EXISTS Human_Friends;
    mysql> USE Human_Friends;
    mysql> CREATE TABLE animals (
    -> id INT AUTO_INCREMENT PRIMARY KEY,
    -> class_name VARCHAR(20)
    -> );
    ...

    mysql> show tables;
    +-------------------------+
    | Tables_in_Human_Friends |
    +-------------------------+
    | animals                 |
    | camels                  |
    | cats                    |
    | dogs                    |
    | donkeys                 |
    | hamsters                |
    | home_animals            |
    | horses                  |
    | pack_animals            |
    +-------------------------+
    mysql>

Текст запроса sql: [SQL](sql/CREAT_TABLES.sql "CREATE DATABASE").

9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения.
### Решение #9

    mysql> INSERT INTO animals(class_name)
    VALUES('Вьючные'),('Домашние');
    ...
    mysql> SELECT * FROM animals;
    +----+------------+
    | id | class_name |
    +----+------------+
    |  1 | ???????    |
    |  2 | ????????   |
    +----+------------+

Текст запроса sql: [SQL](sql/INSER_TABLES.sql "INSERT INTO").

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
### Решение #10
```
mysql> SELECT * FROM camels;
+----+------+------------+---------------+--------+
| id | name | birthday   | commands      | gen_id |
+----+------+------------+---------------+--------+
|  1 | ???  | 2022-04-07 | ?????, ?????? |      2 |
|  2 | ???? | 2018-04-08 | ????          |      2 |
+----+------+------------+---------------+--------+
2 rows in set (0.00 sec)

mysql> DELETE FROM camels;
Query OK, 2 rows affected (0.01 sec)

mysql> SELECT * FROM camels;
Empty set (0.00 sec)
mysql> SELECT name, birthday, commands FROM horses
    -> UNION
    -> SELECT name, birthday, commands FROM donkeys;
+-------+------------+-----------------+
| name  | birthday   | commands        |
+-------+------------+-----------------+
| ????? | 2020-03-12 | ?????, ????     |
| ????? | 2017-04-11 | ?????, ???????? |
| ??    | 2018-03-12 | ????, ??????    |
| ????  | 2019-01-01 | ????, ?????     |
+-------+------------+-----------------+
4 rows in set (0.00 sec)
```

11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.
### Решение #11
```
mysql> CREATE TEMPORARY TABLE animals_temp AS
    -> SELECT *, 'Лошади' as gen FROM horses
    -> UNION SELECT *, 'Ослы' AS gen FROM donkeys
    -> UNION SELECT *, 'Собаки' AS gen FROM dogs
    -> UNION SELECT *, 'Кошки' AS gen FROM cats
    -> UNION SELECT *, 'Хомяки' AS gen FROM hamsters;

mysql> CREATE TABLE young_animals AS
    -> SELECT name, birthday, commands, gen, CONCAT(CAST(TIMESTAMPDIFF(YEAR, Birthday, NOW()) AS CHAR), " лет ",
    -> CAST(MOD(TIMESTAMPDIFF(MONTH, birthday, NOW()), 12) AS CHAR), " мес. ") AS age
    -> FROM animals_temp WHERE birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

mysql> SELECT * FROM young_animals;
+----------+------------+----------------+--------+---------------+
| name     | birthday   | commands       | gen    | age           |
+----------+------------+----------------+--------+---------------+
| ?????    | 2021-01-01 | ??????, ?????  | ?????? | 2 ??? 7 ???.  |
| ?????    | 2022-02-04 | ???-???, ????? | ?????  | 1 ??? 6 ???.  |
| ???????? | 2021-03-05 | ????           | ?????? | 2 ??? 5 ???.  |
| ?????    | 2022-03-06 | ??????? ?????? | ?????? | 1 ??? 4 ???.  |
+----------+------------+----------------+--------+---------------+
4 rows in set (0.00 sec)

```

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
### Решение #12
```
USE
    Human_Friends;
    
SELECT h.Name, h.Birthday, h.Commands, pa.Gen_name, yo.Age
FROM horses h
LEFT JOIN young_animals yo ON yo.Name = h.Name
LEFT JOIN pack_animals pa ON pa.Id = h.Gen_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.Gen_name, yo.Age 
FROM donkeys d 
LEFT JOIN pack_animals pa ON pa.Id = d.Gen_id
LEFT JOIN young_animals yo ON yo.Name = d.Name
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Gen_name, yo.Age 
FROM hamsters hm
LEFT JOIN young_animals yo ON yo.Name = hm.Name
LEFT JOIN home_animals ha ON ha.Id = hm.Gen_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Gen_name, yo.Age 
FROM cats c
LEFT JOIN young_animals yo ON yo.Name = c.Name
LEFT JOIN home_animals ha ON ha.Id = c.Gen_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Gen_name, yo.Age 
FROM dogs d
LEFT JOIN young_animals yo ON yo.Name = d.Name
LEFT JOIN home_animals ha ON ha.Id = d.Gen_id;
```
![Изображение](IMAGES/ALL_TABLES.JPG "Таблица")

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
### Решение #13

14. Написать программу, имитирующую работу реестра домашних животных.
В программе должен быть реализован следующий функционал:
    -   14.1. Завести новое животное
    -   14.2 определять животное в правильный класс
    -   14.3 увидеть список команд, которое выполняет животное
    -   14.4 обучить животное новым командам
    -   14.5 Реализовать навигацию по меню
### Решение #14


15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆ int переменной̆на 1 при нажатие “Завести новое животное” Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
считать в ресурсе try, если при заведения животного заполнены все поля.
### Решение #15

