USE mydb;
INSERT INTO `end_user` (`idUser`,`name`,`password`,`email`)
VALUES
  (1,"Maia Orr","Nullam enim. Sed,","neque@aol.edu"),
  (2,"Madison Cummings","turpis vita","erat@icloud.ca"),
  (3,"Noelle Cortez","torquent per","aenean@outlook.ca"),
  (4,"Gareth Bruce","nibh lacinia","dolor.elit.pellentesque@icloud.couk"),
  (5,"Candice Oneal","vel arcu. Curab","mauris.vel@outlook.edu");

INSERT INTO `auction` (`name`,`enddate`,`initialprice`,`increment`,`minimumprice`,`description`,`seller`,`type`)
VALUES
  ("diam at","2024-02-04",105.39,1.15,709,"tellus. Nunc lectus pede, ultrices a, auctor non, feugiat nec, diam. Duis mi enim, condimentum eget, volutpat ornare,",2,"desserts"),
  ("convallis convallis","2024-03-04",94.92,1.37,174,"Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In",2,"soups"),
  ("dolor, nonummy ac","2023-05-15",98.35,0.73,255,"magna. Phasellus dolor",1,"desserts"),
  ("egestas. Duis ac","2023-10-04",103.06,1.07,605,"cursus non, egestas a, dui.",5,"sandwiches"),
  ("non quam.","2024-04-12",100.32,0.48,358,"sit amet lorem semper auctor.",3,"desserts");

INSERT INTO `property` (`name`,`type`)
VALUES
  ("sandwiches","Glipizide"),
  ("pasta","Loestrin 24 Fe"),
  ("sandwiches","Allopurinol"),
  ("cereals","Vitamin D (Rx)"),
  ("pasta","Sertraline HCl");

INSERT INTO `alert` (`idUser`,`ItemName`)
VALUES
  (1,"stews"),
  (4,"pies"),
  (4,"seafood"),
  (2,"noodles"),
  (1,"seafood");

INSERT INTO `itemProperty` (`idItem`,`idproperty`,`describtion`)
VALUES
  (1,3,"erat nonummy ultricies"),
  (4,1,"erat nonummy ultricies ornare,"),
  (4,4,"nisi. Cum sociis natoque penatibus"),
  (2,4,"Integer vulputate,"),
  (1,4,"massa non");

INSERT INTO `autobid` (`idItem`,`idUser`,`upperlimit`)
VALUES
  (1,3,"328.79"),
  (4,1,"286.72"),
  (4,2,"268.74"),
  (2,4,"285.27"),
  (1,4,"315.33");

INSERT INTO `bid` (`idItem`,`idUser`,`price`)
VALUES
  (4,3,"149.62"),
  (1,4,"214.61"),
  (3,5,"234.86"),
  (2,5,"192.66"),
  (1,4,"195.11");

