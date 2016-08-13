CREATE TABLE user (
  id         INT         NOT NULL AUTO_INCREMENT,
  name       VARCHAR(30) NOT NULL,
  idCard     VARCHAR(18),
  phone      VARCHAR(11),
  email      VARCHAR(30),
  gender     VARCHAR(10),
  used       BOOLEAN,
  createTime TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE build (
  id         INT          NOT NULL AUTO_INCREMENT,
  name       VARCHAR(30)  NOT NULL,
  code       INT UNSIGNED NOT NULL,
  createTime TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE unit (
  id         INT          NOT NULL AUTO_INCREMENT,
  buildId    INT          NOT NULL,
  name       VARCHAR(30)  NOT NULL,
  code       INT UNSIGNED NOT NULL,
  createTime TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE house (
  id         INT          NOT NULL AUTO_INCREMENT,
  unitId     INT          NOT NULL,
  name       VARCHAR(30)  NOT NULL,
  code       INT UNSIGNED NOT NULL,
  createTime TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE gateway (
  id         INT          NOT NULL AUTO_INCREMENT,
  unitId     INT          NOT NULL,
  uuid       VARCHAR(30)  NOT NULL,
  name       VARCHAR(30)  NOT NULL,
  /*coordinate VARCHAR(30) NOT NULL,*//*通过unit_id可追溯 build-unit*/
  ip         VARCHAR(40)  NOT NULL,
  port       INT UNSIGNED NOT NULL,
  remote     VARCHAR(30)  NOT NULL,
  version    VARCHAR(30),
  qrCode     VARCHAR(50),
  createTime TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;

CREATE TABLE locks (
  id         INT              NOT NULL AUTO_INCREMENT,
  houseId    INT              NOT NULL,
  uuid       VARCHAR(30)      NOT NULL,
  name       VARCHAR(30)      NOT NULL,
  areaNo     TINYINT UNSIGNED NOT NULL,
  devNo      TINYINT UNSIGNED NOT NULL,
  createTime TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updateTime TIMESTAMP,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = UTF8;


ALTER TABLE unit
  ADD CONSTRAINT fk_build FOREIGN KEY (buildId) REFERENCES build (id);
ALTER TABLE house
  ADD CONSTRAINT fk_unit FOREIGN KEY (unitId) REFERENCES unit (id);



