/*
 ** Insert end_user data
 */

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'JohnDoe',
        'password123',
        'johndoe@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'JaneSmith',
        'password456',
        'janesmith@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'AliceBrown',
        'password789',
        'alicebrown@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'BobJohnson',
        'password111',
        'bobjohnson@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'CharlieMiller',
        'password222',
        'charliemiller@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'DavidLee',
        'password333',
        'davidlee@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'EveWilliams',
        'password444',
        'evewilliams@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'FrankTaylor',
        'password555',
        'franktaylor@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'GraceAnderson',
        'password666',
        'graceanderson@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'HankThomas',
        'password777',
        'hankthomas@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'IvyJackson',
        'password888',
        'ivyjackson@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'JackWhite',
        'password999',
        'jackwhite@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'KateHarris',
        'password101',
        'kateharris@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'LukeMartin',
        'password202',
        'lukemartin@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'MiaClark',
        'password303',
        'miaclark@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'NathanLewis',
        'password404',
        'nathanlewis@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'OliviaYoung',
        'password505',
        'oliviayoung@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'PeterHall',
        'password606',
        'peterhall@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'QuincyKing',
        'password707',
        'quincyking@example.com'
    );

INSERT INTO
    `mydb`.`end_user` (`name`, `password`, `email`)
VALUES (
        'RitaTurner',
        'password808',
        'ritaturner@example.com'
    );

/*
 ** Insert question data
 */

-- Question 1 with answer

INSERT INTO
    `mydb`.`question` (
        `idUser`,
        `questionTitle`,
        `question`,
        `answerTitle`,
        `answer`
    )
VALUES (
        1,
        'How to place a bid?',
        'I am new to this platform, how can I place a bid on an item?',
        'Placing a bid',
        'To place a bid, go to the item page, enter your bid amount.'
    );

-- Question 2 with answer

INSERT INTO
    `mydb`.`question` (
        `idUser`,
        `questionTitle`,
        `question`,
        `answerTitle`,
        `answer`
    )
VALUES (
        2,
        'Payment methods',
        'What payment methods are accepted on this platform?',
        'Accepted payment methods',
        'We accept credit cards, debit cards, and PayPal for payments.'
    );

-- Question 3 with answer

INSERT INTO
    `mydb`.`question` (
        `idUser`,
        `questionTitle`,
        `question`,
        `answerTitle`,
        `answer`
    )
VALUES (
        3,
        'Shipping and handling',
        'How are items shipped, and how much does shipping cost?',
        'Shipping information',
        'Shipping costs vary depending on the item and your location. You can find shipping information on the item page.'
    );

-- Question 4 without answer

INSERT INTO
    `mydb`.`question` (
        `idUser`,
        `questionTitle`,
        `question`
    )
VALUES (
        4,
        'Refund policy',
        'What is the refund policy for items purchased on this platform?'
    );

-- Question 5 without answer

INSERT INTO
    `mydb`.`question` (
        `idUser`,
        `questionTitle`,
        `question`
    )
VALUES (
        5,
        'Auction duration',
        'How long do auctions usually last?'
    );

/*
 ** Insert representative data
 */

INSERT INTO
    `mydb`.`representatives` (
        `username`,
        `email`,
        `password`
    )
VALUES (
        'Rep1',
        'rep1@example.com',
        'rep1_password'
    );

INSERT INTO
    `mydb`.`representatives` (
        `username`,
        `email`,
        `password`
    )
VALUES (
        'Rep2',
        'rep2@example.com',
        'rep2_password'
    );

INSERT INTO
    `mydb`.`representatives` (
        `username`,
        `email`,
        `password`
    )
VALUES (
        'Rep3',
        'rep3@example.com',
        'rep3_password'
    );

INSERT INTO
    `mydb`.`representatives` (
        `username`,
        `email`,
        `password`
    )
VALUES (
        'Rep4',
        'rep4@example.com',
        'rep4_password'
    );

INSERT INTO
    `mydb`.`representatives` (
        `username`,
        `email`,
        `password`
    )
VALUES (
        'Rep5',
        'rep5@example.com',
        'rep5_password'
    );

/*
 ** Insert representative data
 */

-- 6-25. Other Auctions

INSERT INTO
    `mydb`.`auction` (
        `name`,
        `enddate`,
        `initialprice`,
        `increment`,
        `minimumprice`,
        `description`,
        `seller`,
        `type`,
        `currentPrice`
    )
VALUES (
        'Laptop',
        '2023-04-24 20:00:00',
        500,
        10,
        550,
        'A brand new laptop with great specifications.',
        1,
        'Electronics',
        500
    ), (
        'Bicycle',
        '2023-04-24 18:00:00',
        200,
        5,
        220,
        'A lightweight and durable bicycle for daily use.',
        2,
        'Sports',
        200
    ), (
        'Guitar',
        '2023-04-24 21:30:00',
        150,
        3,
        170,
        'An acoustic guitar in excellent condition.',
        3,
        'Musical Instruments',
        150
    ), (
        'Smartphone',
        '2023-04-24 19:00:00',
        300,
        8,
        330,
        'A brand new smartphone with the latest features.',
        4,
        'Electronics',
        300
    ), (
        'Blender',
        '2023-04-24 22:00:00',
        50,
        2,
        60,
        'A powerful blender, perfect for smoothies and soups.',
        5,
        'Home Appliances',
        50
    ), (
        'Laptop',
        '2023-05-01 20:00:00',
        600,
        15,
        650,
        'A high-performance laptop with the latest features.',
        6,
        'Electronics',
        600
    ), (
        'Smartphone',
        '2023-05-02 18:00:00',
        350,
        10,
        400,
        'An advanced smartphone with a sleek design.',
        7,
        'Electronics',
        350
    ), (
        'Bicycle',
        '2023-05-03 19:00:00',
        250,
        5,
        275,
        'A mountain bike with comfortable suspension.',
        8,
        'Sports',
        250
    ), (
        'Blender',
        '2023-05-05 22:00:00',
        70,
        2,
        80,
        'A versatile blender with multiple speed settings.',
        10,
        'Home Appliances',
        70
    ), (
        'Headphones',
        '2023-05-06 20:00:00',
        100,
        3,
        120,
        'A pair of noise-canceling headphones with excellent sound quality.',
        11,
        'Electronics',
        100
    ), (
        'Camera',
        '2023-05-07 18:00:00',
        800,
        20,
        900,
        'A professional DSLR camera with a high-quality lens.',
        12,
        'Photography',
        800
    ), (
        'Watch',
        '2023-05-08 19:00:00',
        200,
        10,
        250,
        'An elegant wristwatch with a stainless steel band.',
        13,
        'Fashion',
        200
    ), (
        'Microwave',
        '2023-05-09 21:00:00',
        120,
        4,
        130,
        'A compact microwave with various cooking options.',
        14,
        'Home Appliances',
        120
    ), (
        'Sneakers',
        '2023-05-10 22:00:00',
        80,
        3,
        100,
        'A pair of stylish sneakers for casual wear.',
        15,
        'Fashion',
        80
    ), (
        'Laptop',
        '2023-05-11 20:00:00',
        650,
        15,
        700,
        'A gaming laptop with high-quality graphics.',
        16,
        'Electronics',
        650
    ), (
        'Smartphone',
        '2023-05-12 18:00:00',
        400,
        10,
        450,
        'A smartphone with a large display and long battery life.',
        17,
        'Electronics',
        400
    ), (
        'Bicycle',
        '2023-05-13 19:00:00',
        300,
        5,
        325,
        'A road bike with a lightweight frame.',
        18,
        'Sports',
        300
    ), (
        'Guitar',
        '2023-05-14 21:00:00',
        200,
        5,
        230,
        'A classical guitar with a solid wood top.',
        19,
        'Musical Instruments',
        200
    ), (
        'Blender',
        '2023-05-15 22:00:00',
        60,
        2,
        70,
        'An immersion blender for easy blending and mixing.',
        20,
        'Home Appliances',
        60
    ), (
        'Headphones',
        '2023-05-16 20:00:00',
        120,
        3,
        140,
        'A pair of wireless headphones with a long battery life.',
        1,
        'Electronics',
        120
    ), (
        'Camera',
        '2023-05-17 18:00:00',
        900,
        20,
        1000,
        'A mirrorless camera with a high-resolution sensor.',
        2,
        'Photography',
        900
    ), (
        'Watch',
        '2023-05-18 19:00:00',
        250,
        10,
        300,
        'A luxury wristwatch with a leather strap.',
        3,
        'Fashion',
        250
    ), (
        'Microwave',
        '2023-05-19 21:00:00',
        150,
        4,
        160,
        'A large microwave with a spacious interior.',
        4,
        'Home Appliances',
        150
    ), (
        'Sneakers',
        '2023-05-20 22:00:00',
        90,
        3,
        110,
        'A pair of running shoes with great support.',
        5,
        'Fashion',
        90
    );

/*
 ** Insert bids
 */

-- User 1 places a bid on Auction 1

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (1, 1, 510);

-- User 2 places a bid on Auction 1

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (1, 2, 520);

-- User 3 places a bid on Auction 2

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (2, 3, 225);

-- User 4 places a bid on Auction 3

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (3, 4, 180);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (1, 2, 510);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (3, 4, 153);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (4, 5, 308);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (5, 6, 62);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (6, 7, 615);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (7, 8, 360);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (8, 9, 255);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (9, 10, 72);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (10, 11, 103);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (11, 12, 820);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (12, 13, 210);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (13, 14, 124);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (14, 15, 83);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (15, 16, 665);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (16, 17, 410);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (17, 18, 305);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (18, 19, 205);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (19, 20, 62);

INSERT INTO
    `mydb`.`bid` (`idItem`, `idUser`, `price`)
VALUES (20, 1, 123);

INSERT INTO
    `mydb`.`property` (`idproperty`, `name`, `type`)
VALUES (1, 'Red', 'Electronics');

INSERT INTO
    `mydb`.`property`(`idproperty`, `name`, `type`)
VALUES (2, 'Blue', 'Sports');

INSERT INTO
    `mydb`.`property`(`idproperty`, `name`, `type`)
VALUES (
        3,
        'Green',
        'Musical Instruments'
    );

INSERT INTO
    `mydb`.`property` (`idproperty`, `name`, `type`)
VALUES (4, 'New', 'Electronics');

INSERT INTO
    `mydb`.`itemProperty` (
        `idItem`,
        `idproperty`,
        `description`
    )
VALUES (1, 1, 'Red');

INSERT INTO
    `mydb`.`itemProperty` (
        `idItem`,
        `idproperty`,
        `description`
    )
VALUES (2, 2, 'Blue');

INSERT INTO
    `mydb`.`itemProperty` (
        `idItem`,
        `idproperty`,
        `description`
    )
VALUES (3, 3, 'Green');

INSERT INTO
    `mydb`.`itemProperty` (
        `idItem`,
        `idproperty`,
        `description`
    )
VALUES (4, 4, 'New');