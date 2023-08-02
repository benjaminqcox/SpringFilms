DROP TABLE IF EXISTS `film` CASCADE;
CREATE TABLE `film` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `release_year` INTEGER NOT NULL CHECK(release_year>=1850 AND release_year<=2100),
    `title` VARCHAR(32),
    `genre` VARCHAR(32) NOT NULL 
);