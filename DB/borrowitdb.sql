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
  `profile_image` VARCHAR(500) NULL,
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
  `image_url` VARCHAR(3000) NULL,
  `category_id` INT NOT NULL,
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
  `borrower_id` INT NOT NULL,
  `product_item_id` INT NOT NULL,
  `borrow_date` DATETIME NULL,
  `return_date` DATETIME NULL,
  `borrower_rating` INT NULL,
  `borrower_rating_comments` TEXT NULL,
  `lender_rating` INT NULL,
  `lender_rating_comments` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rental_user1_idx` (`borrower_id` ASC),
  INDEX `fk_rental_product_item1_idx` (`product_item_id` ASC),
  CONSTRAINT `fk_rental_user1`
    FOREIGN KEY (`borrower_id`)
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

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`, `create_date`, `address_id`, `enabled`, `role`, `profile_image`) VALUES (1, 'admin', 'admin', 'Ken', 'Hiveley', 'kenneth.hiveley@gmail.com', NULL, 1, 1, 'ROLE_ADMIN', 'https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg');

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
INSERT INTO `product` (`id`, `title`, `description`, `image_url`, `category_id`) VALUES (1, 'Monopoly', 'A family friendly game that most definitely won\'t end any friendships!', 'https://m.media-amazon.com/images/I/91RSg9MCGtL._AC_SY450_.jpg', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `product_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `borrowitdb`;
INSERT INTO `product_item` (`id`, `quality`, `product_id`, `user_id`, `version`) VALUES (1, 'Mint', 1, 1, 'Classic');

COMMIT;

