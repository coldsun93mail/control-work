USE
    Human_Friends;
    
    -- Table animal_classes
INSERT INTO animals(class_name)
VALUES('Вьючные'),('Домашние');

-- Table packed_animals
INSERT INTO pack_animals(gen_name, class_id)
VALUES('Лошади', 1),('Верблюды', 1),('Ослы', 1);

-- Table home_animals    
INSERT INTO home_animals(gen_name, class_id)
VALUES('Собаки', 2),('Кошки', 2),('Хомяки', 2);

-- Table dogs 
INSERT INTO dogs(
    NAME,
    birthday,
    commands,
    gen_id
)
VALUES(
    'Бобик',
    '2021-01-01',
    'лежать, голос',
    1
),(
    'Шарик',
    '2015-01-02',
    'след, фас',
    1
);

-- Table cats
INSERT INTO cats(
    NAME,
    birthday,
    commands,
    gen_id
)
VALUES(
    'Барсик',
    '2023-02-03',
    'кыскыс, брысь',
    2
),(
    'Мурка',
    '2022-02-04',
    'кыс-кыс, брысь',
    2
);

-- Table hamsters 
INSERT INTO hamsters(
    NAME,
    birthday,
    commands,
    gen_id
)
VALUES('Круассан', 
       '2021-03-05',
       'есть',
       3
),(
    'Хиппи',
    '2022-03-06',
    "крутить колесо",
    3
);

-- Table camels 
INSERT INTO camels(
    NAME,
    birthday,
    commands,
    gen_id
)
VALUES(
    'Алл',
    '2022-04-07',
    'Отдых, хипхип',
    2
),(
    'Стиф',
    '2018-04-08',
    "стоп",
    2
);

-- Table horses
INSERT INTO horses(
    NAME,
    birthday,
    commands,
    gen_id
)
VALUES(
    'Бурый',
    '2020-03-12',
    'бегом, стой',
    1
),(
    'Смерч',
    '2017-04-11',
    'бегом, прпрпрпр',
    1
);

-- Table donkeys
INSERT INTO donkeys(
    NAME,
    birthday,
    commands,
    gen_id
)
VALUES(
    'Иа',
    '2018-03-12',
    'стоп, вперед',
    3
),(
    'Осел',
    '2019-01-01',
    'шрек, пошел',
    3
);