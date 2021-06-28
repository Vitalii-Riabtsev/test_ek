INSERT INTO functional_flag (flag_id, flag_name)
VALUES (1, 'WORKOUT');

INSERT INTO iso_dow_week_days (day_id, day_name)
VALUES (1, 'MONDAY')
     , (2, 'TUESDAY')
     , (3, 'WEDNESDAY')
     , (4, 'THURSDAY')
     , (5, 'FRIDAY')
     , (6, 'SATURDAY')
     , (7, 'SUNDAY');

INSERT INTO meals (meal_id, meal_type, functional_flag_mask)
VALUES (1, 'BREAKFAST', 0)
     , (2, 'LUNCH', 0)
     , (3, 'DINNER', 0)
     , (4, 'WORKOUT_SNACK', 1);

INSERT INTO nutrition (nutrition_id, nutrition_type)
VALUES (1, 'CARBOHYDRATES')
     , (2, 'FATS')
     , (3, 'PROTEINS');

insert into customers (customer_id, first_name, last_name, date_birth) values (1, 'Kayle', 'Ternouth', '1989-10-17');
insert into customers (customer_id, first_name, last_name, date_birth) values (2, 'Eada', 'Mateiko', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (3, 'Maurise', 'Shearman', '1987-02-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (4, 'Cybill', 'Jacques', '1996-03-08');
insert into customers (customer_id, first_name, last_name, date_birth) values (5, 'Michaella', null, '1948-09-29');
insert into customers (customer_id, first_name, last_name, date_birth) values (6, 'Early', 'Ends', '1946-01-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (7, 'Meghan', 'Grubbe', '1970-06-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (8, 'Urbain', 'Gorey', '1998-06-10');
insert into customers (customer_id, first_name, last_name, date_birth) values (9, 'Hermia', 'Siret', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (10, 'Kevina', 'Kerridge', '1969-11-07');
insert into customers (customer_id, first_name, last_name, date_birth) values (11, 'Barbey', 'Blaker', '1971-02-14');
insert into customers (customer_id, first_name, last_name, date_birth) values (12, 'Lovell', 'Addekin', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (13, 'Emlyn', 'Wickson', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (14, 'Gene', 'Philcox', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (15, 'Ferrell', 'Schade', '1964-01-29');
insert into customers (customer_id, first_name, last_name, date_birth) values (16, 'Janos', 'Croshaw', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (17, 'Olympia', 'Urch', '1997-02-17');
insert into customers (customer_id, first_name, last_name, date_birth) values (18, 'Adena', 'Makiver', '2009-11-29');
insert into customers (customer_id, first_name, last_name, date_birth) values (19, 'Holly', 'McTeague', '2003-11-21');
insert into customers (customer_id, first_name, last_name, date_birth) values (20, 'Amalie', 'Grima', '1948-10-04');
insert into customers (customer_id, first_name, last_name, date_birth) values (21, 'Gianni', null, '1997-02-15');
insert into customers (customer_id, first_name, last_name, date_birth) values (22, 'Ramon', 'Gascoyne', '1966-07-15');
insert into customers (customer_id, first_name, last_name, date_birth) values (23, 'Kerrill', 'Dahlen', '1961-09-05');
insert into customers (customer_id, first_name, last_name, date_birth) values (24, 'Rudolf', 'Brazier', '2010-01-04');
insert into customers (customer_id, first_name, last_name, date_birth) values (25, 'Maudie', 'Renzo', '1989-10-26');
insert into customers (customer_id, first_name, last_name, date_birth) values (26, 'Stevena', 'Senner', '2007-07-20');
insert into customers (customer_id, first_name, last_name, date_birth) values (27, 'Kim', 'Worman', '1959-12-27');
insert into customers (customer_id, first_name, last_name, date_birth) values (28, 'Edgardo', 'Gosalvez', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (29, 'Evangelina', 'Breming', '1991-07-25');
insert into customers (customer_id, first_name, last_name, date_birth) values (30, 'Gunther', 'Swadon', '1997-08-03');
insert into customers (customer_id, first_name, last_name, date_birth) values (31, 'Doro', 'Mayger', '2015-01-13');
insert into customers (customer_id, first_name, last_name, date_birth) values (32, 'Margo', 'Roos', '1955-07-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (33, 'Berget', 'Hynard', '2003-09-15');
insert into customers (customer_id, first_name, last_name, date_birth) values (34, 'Wileen', 'Maleham', '1945-01-25');
insert into customers (customer_id, first_name, last_name, date_birth) values (35, 'Stafford', 'Reicherz', '1963-02-09');
insert into customers (customer_id, first_name, last_name, date_birth) values (36, 'Theodore', 'Lathee', '2019-07-19');
insert into customers (customer_id, first_name, last_name, date_birth) values (37, 'Charisse', 'Lindenboim', '2020-05-12');
insert into customers (customer_id, first_name, last_name, date_birth) values (38, 'Kizzee', 'Bugden', '1954-09-15');
insert into customers (customer_id, first_name, last_name, date_birth) values (39, 'Rhodia', 'Davidwitz', '1959-10-07');
insert into customers (customer_id, first_name, last_name, date_birth) values (40, 'Alicia', 'Blaxall', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (41, 'Wilmer', 'Hickford', '2003-07-11');
insert into customers (customer_id, first_name, last_name, date_birth) values (42, 'Kandy', 'Loisi', '1959-12-22');
insert into customers (customer_id, first_name, last_name, date_birth) values (43, 'Basilio', null, '1968-08-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (44, 'Violante', 'Ambroix', '1955-06-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (45, 'Luise', 'Anthonies', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (46, 'Garold', 'Wadham', '1945-10-29');
insert into customers (customer_id, first_name, last_name, date_birth) values (47, 'Tabitha', 'O''Hickey', '1973-04-25');
insert into customers (customer_id, first_name, last_name, date_birth) values (48, 'Alejoa', 'Pountain', '1996-03-16');
insert into customers (customer_id, first_name, last_name, date_birth) values (49, 'Hymie', null, null);
insert into customers (customer_id, first_name, last_name, date_birth) values (50, 'Beverley', 'Vennings', '2005-11-29');
insert into customers (customer_id, first_name, last_name, date_birth) values (51, 'Renate', 'Tordoff', '2017-07-05');
insert into customers (customer_id, first_name, last_name, date_birth) values (52, 'Candis', 'Hakey', '1953-07-18');
insert into customers (customer_id, first_name, last_name, date_birth) values (53, 'Guglielma', 'Sprionghall', '1952-06-19');
insert into customers (customer_id, first_name, last_name, date_birth) values (54, 'Terrye', 'Clucas', '2007-01-05');
insert into customers (customer_id, first_name, last_name, date_birth) values (55, 'Mendie', 'Thain', '1962-03-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (56, 'Joshuah', 'Cankett', '2015-09-02');
insert into customers (customer_id, first_name, last_name, date_birth) values (57, 'Jayson', null, '2007-01-31');
insert into customers (customer_id, first_name, last_name, date_birth) values (58, 'Perle', 'Halbeard', '1996-08-08');
insert into customers (customer_id, first_name, last_name, date_birth) values (59, 'Elladine', 'Guare', '1995-12-04');
insert into customers (customer_id, first_name, last_name, date_birth) values (60, 'Jacqui', 'Downes', '1995-12-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (61, 'Beatriz', 'Brazelton', '1965-10-26');
insert into customers (customer_id, first_name, last_name, date_birth) values (62, 'Toiboid', 'Du Plantier', '2016-04-11');
insert into customers (customer_id, first_name, last_name, date_birth) values (63, 'Marlene', 'Leward', '1990-04-29');
insert into customers (customer_id, first_name, last_name, date_birth) values (64, 'Ettie', 'Deble', '1976-06-18');
insert into customers (customer_id, first_name, last_name, date_birth) values (65, 'Candie', 'Cleghorn', '2005-03-11');
insert into customers (customer_id, first_name, last_name, date_birth) values (66, 'Claudia', 'Willis', '1972-08-25');
insert into customers (customer_id, first_name, last_name, date_birth) values (67, 'Idalia', 'Harden', '1943-03-26');
insert into customers (customer_id, first_name, last_name, date_birth) values (68, 'Joela', 'Garrique', '1958-05-16');
insert into customers (customer_id, first_name, last_name, date_birth) values (69, 'Kliment', 'Surmon', '1947-09-11');
insert into customers (customer_id, first_name, last_name, date_birth) values (70, 'Caryl', 'Urrey', '2002-03-18');
insert into customers (customer_id, first_name, last_name, date_birth) values (71, 'Quill', 'Swaite', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (72, 'Lancelot', 'Twiggins', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (73, 'Clayborne', 'Ibert', '1986-10-22');
insert into customers (customer_id, first_name, last_name, date_birth) values (74, 'Ambrosius', 'Sanson', '1971-08-30');
insert into customers (customer_id, first_name, last_name, date_birth) values (75, 'Flory', 'Redgrove', '1985-12-10');
insert into customers (customer_id, first_name, last_name, date_birth) values (76, 'Shay', 'Sawart', '1977-10-17');
insert into customers (customer_id, first_name, last_name, date_birth) values (77, 'Kylie', 'Tremethack', '1992-08-12');
insert into customers (customer_id, first_name, last_name, date_birth) values (78, 'Byrann', 'Nardoni', '2005-06-30');
insert into customers (customer_id, first_name, last_name, date_birth) values (79, 'Imogene', 'Wiggans', '1964-04-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (80, 'Tiphani', 'Semmens', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (81, 'Bucky', null, '1948-02-06');
insert into customers (customer_id, first_name, last_name, date_birth) values (82, 'Teddie', 'Milton', '2004-10-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (83, 'Jo', 'Sumption', '1992-02-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (84, 'Rebekah', 'Whitmell', '1987-07-08');
insert into customers (customer_id, first_name, last_name, date_birth) values (85, 'Mirelle', 'Sazio', '1989-07-30');
insert into customers (customer_id, first_name, last_name, date_birth) values (86, 'Lia', 'Pashen', '1974-11-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (87, 'Frederique', 'Antonellini', '1975-06-16');
insert into customers (customer_id, first_name, last_name, date_birth) values (88, 'Amalia', 'Audas', '1994-04-24');
insert into customers (customer_id, first_name, last_name, date_birth) values (89, 'Joeann', 'Roskam', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (90, 'Allissa', 'Queyos', '1994-10-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (91, 'Maude', null, null);
insert into customers (customer_id, first_name, last_name, date_birth) values (92, 'Hort', 'Brislane', '1990-06-04');
insert into customers (customer_id, first_name, last_name, date_birth) values (93, 'Brina', 'Lanphere', '1999-08-28');
insert into customers (customer_id, first_name, last_name, date_birth) values (94, 'Mace', 'McGready', null);
insert into customers (customer_id, first_name, last_name, date_birth) values (95, 'Cory', 'Sorrell', '2010-04-20');
insert into customers (customer_id, first_name, last_name, date_birth) values (96, 'Pat', 'Matveyev', '1960-10-31');
insert into customers (customer_id, first_name, last_name, date_birth) values (97, 'Brita', 'Zavattieri', '1984-02-23');
insert into customers (customer_id, first_name, last_name, date_birth) values (98, 'Andriette', 'Corwin', '2016-04-10');
insert into customers (customer_id, first_name, last_name, date_birth) values (99, 'Marv', 'Blaisdell', '2016-07-19');
insert into customers (customer_id, first_name, last_name, date_birth) values (100, 'Jacques', 'Hammerson', '1948-04-15');