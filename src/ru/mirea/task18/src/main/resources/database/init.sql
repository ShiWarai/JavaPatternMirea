--DROP TABLE IF EXISTS address_relationship;
--DROP TABLE IF EXISTS building_relationship;

CREATE TABLE IF NOT EXISTS address_relationship
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    text  VARCHAR(256) NOT NULL ,
    zip  VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS building_relationship
(
    id    SERIAL NOT NULL PRIMARY KEY ,
    date  VARCHAR(256) NOT NULL ,
    type  VARCHAR(256) NOT NULL,
    id_address INT REFERENCES address_relationship ON DELETE CASCADE,
    CONSTRAINT fk_address FOREIGN KEY (id_address) REFERENCES address_relationship(id)
);