CREATE TABLE IF NOT EXISTS `task_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(80) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `task_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(80) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `task_priority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `mossad_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  `surname` text,
  `email` text NOT NULL,  
  `password` text NOT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=1 ;

insert into `mossad_user` values (1,'user1name','user1surname','user1email@wp.pl','user1password');


CREATE TABLE IF NOT EXISTS `mossad_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text ,
  `description` text ,
  `priority` int(11) , 
  `user` int(11) ,
  `status` int(11) ,
  `type` int(11) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `priority_fk` FOREIGN KEY (`priority`) REFERENCES `task_priority` (`id`),
  CONSTRAINT `status_fk` FOREIGN KEY (`status`) REFERENCES `task_status` (`id`), 
  CONSTRAINT `type_fk` FOREIGN KEY (`type`) REFERENCES `task_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=1 ;


insert into `task_status` values (1,'Not started');
insert into `task_status` values (2,'Ongoing');
insert into `task_status` values (3,'Finished');
insert into `task_status` values (4,'Paused');


insert into `task_type` values (1,'Private');
insert into `task_type` values (2,'Home');
insert into `task_type` values (3,'Work');
insert into `task_type` values (4,'Friends');
insert into `task_type` values (5,'Hobby');
insert into `task_type` values (6,'None');


insert into `task_priority` values (1,'High');
insert into `task_priority` values (2,'Medium');
insert into `task_priority` values (3,'Low');
insert into `task_priority` values (4,'Not specified');

--//TODO to add to task table
--due time
--repetition
--estimation how long
--location 
--URL
--postpone counter


-- --
--TODO

--Task repetition
--Note
--Tag
--Sharing Task




