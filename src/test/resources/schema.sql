DROP TABLE IF EXISTS visitor;
CREATE TABLE IF NOT EXISTS visitors
(
    ip         varchar(32) NOT NULL,
    visit_date timestamp   NOT NULL
);