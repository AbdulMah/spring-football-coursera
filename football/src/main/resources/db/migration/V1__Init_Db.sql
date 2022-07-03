CREATE SEQUENCE fc_tournament_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_tournament (
  id int8 NOT NULL DEFAULT nextval('fc_tournament_id_seq'),
  country VARCHAR (255),
  name VARCHAR (255),
  PRIMARY KEY (id));


CREATE SEQUENCE fc_team_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_team (
  id int8 NOT NULL DEFAULT nextval('fc_team_id_seq'),
  name VARCHAR(255),
  players int4,
  PRIMARY KEY(id));


CREATE TABLE fc_tournament_team (
  id_tournament int8 NOT NULL ,
  id_team int8 NOT NULL ,
  PRIMARY KEY (id_team, id_tournament));


CREATE SEQUENCE fc_match_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_match (
  id int8 NOT NULL DEFAULT nextval('fc_match_id_seq'),
  match_date TIMESTAMP,
  score_guests int4,
  score_owners int4,
  id_guests int8 NOT NULL,
  id_owners int8 NOT NULL,
  id_tournament int8 NOT NULL,
  PRIMARY KEY (id));


CREATE SEQUENCE fc_coach_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_coach (
  id int8 NOT NULL DEFAULT nextval('fc_coach_id_seq'),
  age int4,
  experience int4,
  name VARCHAR(255),
  surname VARCHAR(255),
  id_team int8,
  PRIMARY KEY (id));


CREATE SEQUENCE fc_news_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_news (
  id int8 NOT NULL DEFAULT nextval('fc_news_id_seq'),
  content TEXT,
  name VARCHAR(255),
  PRIMARY KEY (id));


CREATE TABLE fc_team_news (
  id_news int8 NOT NULL,
  id_team int8 NOT NULL,
  PRIMARY KEY (id_news, id_team));


CREATE SEQUENCE fc_player_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_player (
  id int8 NOT NULL DEFAULT nextval('fc_player_id_seq'),
  age int4,
  height int4,
  name VARCHAR(255),
  surname VARCHAR(255),
  weight int4,
  PRIMARY KEY (id));


CREATE TABLE fc_player_team (
  id_player int8 NOT NULL,
  id_team int8 NOT NULL,
  PRIMARY KEY (id_player, id_team));


CREATE SEQUENCE fc_event_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_event (
  id int8 NOT NULL DEFAULT nextval('fc_event_id_seq'),
  content TEXT,
  name VARCHAR(255),
  PRIMARY KEY (id));


CREATE TABLE fc_player_event (
  id_event int8 NOT NULL,
  id_player int8 NOT NULL,
  PRIMARY KEY (id_event, id_player));


CREATE SEQUENCE fc_tournament_result_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_tournament_result (
  id int8 NOT NULL DEFAULT nextval('fc_tournament_result_id_seq'),
  draw int4,
  goals int4,
  goals_missed int4,
  loses int4,
  missed int4,
  place int4,
  points int4,
  wins int4,
  id_team int8,
  id_tournament int8,
  PRIMARY KEY (id));

ALTER TABLE if EXISTS fc_tournament_team
ADD CONSTRAINT fc_team_fk
FOREIGN KEY (id_team) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_tournament_team
ADD CONSTRAINT fc_tournament_fk
FOREIGN KEY (id_tournament) REFERENCES fc_tournament;

ALTER TABLE if EXISTS fc_match
ADD CONSTRAINT fc_guest_fk
FOREIGN KEY (id_guests) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_match
ADD CONSTRAINT fc_owner_fk
FOREIGN KEY(id_owners) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_match
ADD CONSTRAINT  fc_tournament_fk
FOREIGN KEY (id_tournament) REFERENCES fc_tournament;

ALTER TABLE if EXISTS fc_coach
ADD CONSTRAINT  fc_coach_fk
FOREIGN KEY (id_team) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_team_news
ADD CONSTRAINT  fc_team_fk
FOREIGN KEY (id_team) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_team_news
ADD CONSTRAINT  fc_news_fk
FOREIGN KEY (id_news) REFERENCES fc_news;

ALTER TABLE if EXISTS fc_player_team
ADD CONSTRAINT  fc_team_fk
FOREIGN KEY (id_team) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_player_team
ADD CONSTRAINT  fc_player_fk
FOREIGN KEY (id_player) REFERENCES fc_player;

ALTER TABLE if EXISTS fc_tournament_result
ADD CONSTRAINT  fc_team_fk
FOREIGN KEY (id_team) REFERENCES fc_team;

ALTER TABLE if EXISTS fc_tournament_result
ADD CONSTRAINT  fc_tournament_fk
FOREIGN KEY (id_tournament) REFERENCES fc_tournament;

ALTER TABLE if EXISTS fc_tournament_result
ADD CONSTRAINT fc_tournament_team_u
 UNIQUE (id_tournament,id_team);