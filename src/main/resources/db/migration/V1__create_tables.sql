create table test_entity(
    ID INT PRIMARY KEY
);

create table employee(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(50),
    ADDRESS_ID INT
);

create table ADDRESS(
    ID SERIAL PRIMARY KEY,
    CITY VARCHAR(50)
);
