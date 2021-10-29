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
  `id` INT NOT NULL,
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
  `enabled` TINYINT NULL,
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
  `id` INT NOT NULL,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(1000) NULL,
  `image_url` TEXT NULL,
  `category_id` INT NOT NULL,
  `enabled` TINYINT NULL,
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
  `rating_comment` VARCHAR(45) NULL,
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
  `avalible` TINYINT NULL,
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
  `id` INT NOT NULL,
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
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (1, 'Whereever', 'CO', 00000);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (2, 'Philadelphia', 'PA', 19112);
INSERT INTO `address` (`id`, `city`, `state`, `zip`) VALUES (3, 'Monterey', 'CA', 93940);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (1, 'admin', 'admin', 'Ken', 'Hiveley', 'kenneth.hiveley@gmail.com', NULL, 1, 1, 'ROLE_ADMIN', 'https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg');
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (2, 'guest', 'guest', NULL, NULL, NULL, NULL, 3, 1, NULL, NULL);
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (3, 'BigFrank', 'trashman', 'Frank', 'Reynolds', 'frankreynolds@gmail.com', NULL, 2, 1, NULL, 'data:image/jpeg;base64,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');
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (4, 'imcharlie', 'paddys', 'Charlie', 'Kelly', NULL, NULL, 2, 1, NULL, 'https://upload.wikimedia.org/wikipedia/en/0/0f/Charlie_Kelly.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `category` (`id`, `category`) VALUES (1, 'Board Game');
INSERT INTO `category` (`id`, `category`) VALUES (2, 'Movie');
INSERT INTO `category` (`id`, `category`) VALUES (3, 'Book');
INSERT INTO `category` (`id`, `category`) VALUES (4, 'VideoGame');
INSERT INTO `category` (`id`, `category`) VALUES (5, 'Televison');

COMMIT;


-- -----------------------------------------------------
-- Data for table `product`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (1, 'Monopoly', 'A family friendly game that most definitely won\'t end any friendships!', 'https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg', 1, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (2, 'John Wick', 'Best \"you messed with the wrong guy\" story I ever saw.', 'https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_.jpg', 2, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (3, 'Mario Party', 'A videogame of a board game!', 'https://m.media-amazon.com/images/I/91DTMquoGiS._SY445_.jpg', 3, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (4, 'Mario Kart 8', 'A fun racing game!', 'https://m.media-amazon.com/images/I/71pPBrKODxL._AC_SY879_.jpg', 3, true);
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`, `enabled`) VALUES (5, 'Connect 4', 'A two player board game', 'https://target.scene7.com/is/image/Target/GUEST_d86c944e-f500-4967-8810-4bec7d71df86?wid=488&hei=488&fmt=pjpeg', 1, true);

COMMIT;


-- -----------------------------------------------------
-- Data for table `rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `rating` (`rating`, `rating_comment`, `user_id`, `product_id`) VALUES (4, NULL, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `product_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `avalible`) VALUES (1, 'Mint', 1, 1, 'Classic', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `avalible`) VALUES (2, 'Used', 2, 3, 'DVD', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `avalible`) VALUES (3, 'Used', 3, 4, 'Standard', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `avalible`) VALUES (4, 'New', 4, 4, 'Deluxe Edition', true);
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`, `avalible`) VALUES (5, 'Used', 5, 3, 'Classic', true);

COMMIT;


-- -----------------------------------------------------
-- Data for table `borrow`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `borrow` (`id`, `lender_id`, `product_item_id`, `borrow_date`, `return_date`, `borrower_rating`, `borrower_rating_comments`, `lender_rating`, `lender_rating_comments`, `borrower_id`) VALUES (1, 1, 1, '2021-10-27 00:00:00', '2021-11-03 00:00:00', 3, NULL, 5, NULL, 2);

COMMIT;

