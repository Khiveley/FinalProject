-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema borrowitdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `borrowitdb` ;

-- -----------------------------------------------------
-- Schema borrowitdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `borrowitdb` DEFAULT CHARACTER SET utf8 ;
USE `borrowitdb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(50) NULL,
  `state` VARCHAR(45) NULL,
  `zip` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `address_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `role` VARCHAR(45) NULL,
  `profile_image` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address_idx` (`address_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL,
  `description` TEXT NULL,
  `image_url` TEXT NULL,
  `category_id` INT NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_product_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rating` ;

CREATE TABLE IF NOT EXISTS `rating` (
  `rating` INT NULL,
  `rating_comment` VARCHAR(500) NULL,
  `user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  INDEX `fk_rating_user1_idx` (`user_id` ASC),
  INDEX `fk_rating_product1_idx` (`product_id` ASC),
  PRIMARY KEY (`product_id`, `user_id`),
  CONSTRAINT `fk_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rating_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product_item` ;

CREATE TABLE IF NOT EXISTS `product_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quality` VARCHAR(45) NULL,
  `product_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `version` VARCHAR(500) NULL,
  `available` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_product_item_product1_idx` (`product_id` ASC),
  INDEX `fk_product_item_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_product_item_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_item_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `borrow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `borrow` ;

CREATE TABLE IF NOT EXISTS `borrow` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lender_id` INT NOT NULL,
  `product_item_id` INT NOT NULL,
  `borrow_date` DATETIME NULL,
  `return_date` DATETIME NULL,
  `borrower_rating` INT NULL,
  `borrower_rating_comments` TEXT NULL,
  `lender_rating` INT NULL,
  `lender_rating_comments` TEXT NULL,
  `borrower_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rental_user1_idx` (`lender_id` ASC),
  INDEX `fk_rental_product_item1_idx` (`product_item_id` ASC),
  CONSTRAINT `fk_rental_user1`
    FOREIGN KEY (`lender_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_product_item1`
    FOREIGN KEY (`product_item_id`)
    REFERENCES `product_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS admin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'admin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (1, 'Denver', 'CO', 80249);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (2, 'Philadelphia', 'PA', 19112);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (3, 'Monterey', 'CA', 93940);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (4, 'El Paso', 'TX', 79835);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (5, 'Aurora', 'CO', 80013);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (6, 'Salinas', 'CA', 93907);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (1, 'admin', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Ken', 'Hiveley', 'kenneth.hiveley@gmail.com', NULL, 1, true, 'ROLE_ADMIN', 'https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg');
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (2, 'guest', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Sally', 'Smith', 'ssmith@gmail.com', NULL, 3, true, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (3, 'BigFrank', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Frank', 'Reynolds', 'frankreynolds@gmail.com', NULL, 2, true, NULL, 'data:image/jpeg;base64,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');
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (4, 'imcharlie', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Charlie', 'Kelly', 'charliemail@gmail.com', NULL, 2, true, NULL, 'https://upload.wikimedia.org/wikipedia/en/0/0f/Charlie_Kelly.png');
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (5, 'thelegend27', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Legend', '27', 'legend29@gmail.com', NULL, 4, true, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (6, 'KarlzSr', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Nott', 'Reel', 'NottR@gmail.com', NULL, 5, true, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (7, 'bookworm45', '$2a$10$gAmEOD.fVzfs3RiFR3vRluAEvk0X1GyMsx/UvvPOeWxc/cCaCyAFm', 'Steve', 'Gallagher', 'SG@gmail.com', NULL, 6, true, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `category` (`id`, `category`) VALUES (1, 'Board Game');
INSERT INTO `category` (`id`, `category`) VALUES (2, 'Movie');
INSERT INTO `category` (`id`, `category`) VALUES (3, 'Book');
INSERT INTO `category` (`id`, `category`) VALUES (4, 'Video Game');
INSERT INTO `category` (`id`, `category`) VALUES (5, 'Televison Series');

COMMIT;


-- -----------------------------------------------------
-- Data for table `product`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (1, 'Monopoly', 'A family friendly game that most definitely won\'t end any friendships!', 'https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg', 1, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (2, 'John Wick', 'From Summit Entertainment and the producer of CLASH OF THE TITANS and THE TOWN comes a tale of adrenaline-fueled revenge and redemption. When a retired hit man is forced back into action by a sadistic young thug, he hunts down his adversaries with the skill and ruthlessness that made him an underworld legend.', 'https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_.jpg', 2, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (3, 'Mario Party', '(Nintendo Switch) Outwit friends and family as you race across the board; whoever gets the most stars wins!', 'https://m.media-amazon.com/images/I/91DTMquoGiS._SY445_.jpg', 4, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (4, 'Mario Kart 8', '(Nintendo Switch) Hit the road with the definitive version of Mario Kart 8 and play anytime, anywhere. Race your friends or battle them in a revised battle mode for new and returning battle courses.', 'https://m.media-amazon.com/images/I/71pPBrKODxL._AC_SY879_.jpg', 4, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (5, 'Connect 4', 'Classic Connect 4 game is disc dropping fun\nChoose yellow or red discs. For 2 players\nWhen you get 4 discs in a row you win.', 'https://target.scene7.com/is/image/Target/GUEST_d86c944e-f500-4967-8810-4bec7d71df86?wid=488&hei=488&fmt=pjpeg', 1, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (6, 'Settlers of Catan', 'Get all the resources, except sheep.  They may be fluffy but sheep are baaaaaad.  While you\'re at it build a reaaally long road and build a big army.', 'https://www.boardgamequest.com/wp-content/uploads/2013/04/Settlers-of-Catan-300x243.jpg', 1, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (7, 'Harry Potter and the Deathly Hallows - Part 1', 'Harry, Ron and Hermione set out to track down and destroy the secret to Voldemort’s power – the Horcruxes. On their own and on the run, the three must rely on one another more than ever…but Dark Forces threaten to tear them apart.', 'https://m.media-amazon.com/images/I/51hId6TXbFL.jpg', 2, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (8, 'Harry Potter and the Deathly Hallows - Part 2', 'In the epic finale, the battle between the good and evil forces of the wizarding world escalates into an all-out war. The stakes have never been higher and no one is safe. But it is Harry who may be called upon to make the ultimate sacrifice as he draws closer to the climactic showdown with Lord Voldemort. It all ends here.', 'https://m.media-amazon.com/images/I/51iWChrnwIL.jpg', 2, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (9, 'Star Wars: Darth Plagueis', 'Darth Plagueis: one of the most brilliant Sith Lords who ever lived. Possessing power is all he desires. Losing it is the only thing he fears. As an apprentice, he embraces the ruthless ways of the Sith. And when the time is right, he destroys his Master - but vows never to suffer the same fate. For like no other disciple of the dark side, Darth Plagueis learns to command the ultimate power...over life and death.', 'https://m.media-amazon.com/images/I/51NJOD0ItCL.jpg', 3, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (10, 'The Pillars of The Earth', 'The Pillars of the Earth tells the story of Philip, prior of Kingsbridge, a devout and resourceful monk driven to build the greatest Gothic cathedral the world has known...of Tom, the mason who becomes his architect - a man divided in his soul...of the beautiful, elusive Lady Aliena, haunted by a secret shame...and of a struggle between good and evil that will turn church against state, and brother against brother.  ', 'https://m.media-amazon.com/images/I/51PgXXjpb5L._SY346_.jpg', 3, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (11, 'The Big Bang Theory: The Complete Ninth Season', 'Prepare to enter phase nine of television’s perpetual laughter experiment as THE BIG BANG THEORY successfully fuses the elements of science and sitcom. Our two genius roommates – Leonard and Sheldon ¬– and their friends are back once again (smarter, but no wiser). Last season, Sheldon went soul-searching (on a train, of course) and was prepared to make some substantial revisions on his Relationship Agreement with Amy, when everything changed. Leonard, meanwhile, was off to Vegas with Penny to finally tie the knot in the season finale. Howard finds himself alone with Bernadette after the sudden passing of his mother; while Raj is not only talking to women – he’s getting exclusive with Emily (Laura Spencer). Together, they will all learn that life is far more complicated outside of the lab as love and friendship never produce predictable results!', 'https://m.media-amazon.com/images/I/81ksNXITStL._SX342_.jpg', 5, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (12, 'Risk', 'Take over the world in this game of strategy conquest, now with updated figures and improved Mission cards. In the Risk game, the goal is simple: players aim to conquer their enemies’ territories by building an army, moving their troops in, and engaging in battle. Depending on the roll of the dice, a player will either defeat the enemy or be defeated. This exciting game is filled with betrayal, alliances, and surprise attacks. On the battlefield, anything goes!', 'https://m.media-amazon.com/images/I/91jsvpbPP3L._AC_SL1500_.jpg', 1, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (13, 'Star Wars Visions: Ronin: A Visions Novel', 'A mysterious former Sith wanders the galaxy in this stunning Star Wars tale, an original novel inspired by the world of The Duel from the Star Wars Visions animated anthology.\n', 'https://m.media-amazon.com/images/I/51WEG6IgXaL._SY346_.jpg', 3, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (14, 'It\'s Always Sunny in Philadelphia: The Complete Season 7', 'Join the dysfunctional gang at Paddy\'s Pub For another outrageously raunchy season of scheming; scamming; backstabbing; and all-around inappropriateness! Whether they\'re giving a hooker an image makeover; hitting the beach at the Jersey Shore; preparing For the apocalypse; or simply engaging in a little good old-fashioned cyber-stalking; the gang delivers more trash-talking; half-baked insanity than ever before. Now; get ready to get fat with Mac and indulge in Season Seven of It\'s Always Sunny in Philadelphia; stuffed with uproarious extras.', 'https://m.media-amazon.com/images/I/91zdZAy8FOL._SY445_.jpg', 5, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (15, 'The Matrix', 'Set in the 22nd century, The Matrix tells of a computer hacker (Reeves) who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth. The computers are powered by human beings...', 'https://m.media-amazon.com/images/I/51EG732BV3L._SY445_.jpg', 2, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (16, 'Hyperion', 'On the world called Hyperion, beyond the reach of galactic law, waits a creature called the Shrike. There are those who worship it. There are those who fear it. And there are those who have vowed to destroy it. In the Valley of the Time Tombs, where huge, brooding structures move backward through time, the Shrike waits for them all.\n\nOn the eve of Armageddon, with the entire galaxy at war, seven pilgrims set forth on a final voyage to Hyperion seeking the answers to the unsolved riddles of their lives. Each carries a desperate hope—and a terrible secret. And one may hold the fate of humanity in his hands.', 'https://m.media-amazon.com/images/I/517wRHsyf6L.jpg', 3, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (17, 'Dragon Ball Xenoverse 2', '(Xbox One) Developed to fully utilize the power of current generation gaming consoles, Dragon Ball Xenoverse 2 builds upon the highly popular Dragon Ball Xenoverse with enhanced graphics that will further immerse players into the largest and most detailed Dragon Ball world ever developed. Dragon Ball Xenoverse 2 will deliver a new hub city and the most character customization choices to date among a multitude of new features and special upgrades.', 'https://media.gamestop.com/i/gamestop/10132203/Dragon-Ball-Xenoverse-2---Xbox-One?$pdp$', 4, true);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `rating` (`rating`, `rating_comment`, `user_id`, `product_id`) VALUES (7, NULL, 1, 1);
INSERT INTO `rating` (`rating`, `rating_comment`, `user_id`, `product_id`) VALUES (4, 'This game showed me how fragile alliances can be.', 2, 12);
INSERT INTO `rating` (`rating`, `rating_comment`, `user_id`, `product_id`) VALUES (10, 'It\'s a masterpiece.', 3, 2);
INSERT INTO `rating` (`rating`, `rating_comment`, `user_id`, `product_id`) VALUES (8, NULL, 1, 10);

COMMIT;


-- -----------------------------------------------------
-- Data for table `product_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (1, 'Mint', 1, 1, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (2, 'Used', 2, 3, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (3, 'Used', 3, 4, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (4, 'New', 4, 4, 'Deluxe Edition', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (5, 'Used', 5, 3, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (6, 'Used', 6, 1, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (7, 'New', 7, 2, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (8, 'New', 8, 2, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (9, 'Used', 9, 4, 'Paperback', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (10, 'New', 10, 1, 'Paperback', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (11, 'Used', 11, 3, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (12, 'Used', 12, 2, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (13, 'Used', 1, 2, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (14, 'New', 2, 1, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (15, 'New', 2, 2, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (16, 'Used', 2, 4, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (17, 'Used', 9, 7, 'Hardcover', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (18, 'New', 10, 7, 'Hardcover', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (19, 'Used', 3, 5, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (20, 'Used', 4, 5, 'Deluxe Edition', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (21, 'Used', 5, 6, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (22, 'Used', 7, 6, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (23, 'New', 8, 6, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (24, 'Used', 13, 4, 'Paperback', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (25, 'Used', 13, 7, 'Hardcover', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (26, 'Good', 13, 5, 'Paperback', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (27, 'New', 6, 4, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (28, 'Used', 11, 4, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (29, 'Used', 11, 6, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (30, 'Used', 14, 3, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (31, 'Used', 14, 4, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (32, 'Used', 14, 6, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (33, 'Used', 12, 5, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (34, 'New', 12, 3, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (35, 'Used', 5, 4, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (36, 'Used', 15, 1, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (37, 'Used', 15, 2, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (38, 'Used', 15, 5, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (39, 'Used', 15, 6, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (40, 'Used', 1, 4, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (41, 'Used', 6, 2, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (42, 'Used', 6, 5, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (43, 'Used', 16, 2, 'Paperback', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (44, 'Used', 16, 3, 'Hardcover', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (45, 'Used', 16, 7, 'Hardcover', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (46, 'Used', 16, 5, 'Hardcover', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (47, 'Used', 3, 1, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (48, 'Used', 4, 1, 'Deluxed Edition', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (49, 'Used', 3, 6, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (50, 'Used', 4, 6, 'Deluxe Edition', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (51, 'Used', 17, 2, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (52, 'Used', 17, 4, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (53, 'Used', 17, 5, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `available`) VALUES (54, 'Used', 17, 6, 'Standard', true);

COMMIT;


-- -----------------------------------------------------
-- Data for table `borrow`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `borrow` (`id`, `lender_id`, `product_item_id`, `borrow_date`, `return_date`, `borrower_rating`, `borrower_rating_comments`, `lender_rating`, `lender_rating_comments`, `borrower_id`) VALUES (1, 1, 1, '2021-10-27 00:00:00', '2021-11-03 00:00:00', 3, NULL, 5, NULL, 2);

COMMIT;

