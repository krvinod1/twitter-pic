CREATE TABLE CONNECTIONS( follower varchar(20), followee varchar(20),  created_at date DEFAULT now());
CREATE INDEX CONNECTION_FOLLOWER ON CONNECTIONS(follower);
CREATE INDEX CONNECTION_FOLLOWEE ON CONNECTIONS(followee);
INSERT INTO CONNECTIONS(follower, followee) VALUES('foo', 'bar');
INSERT INTO CONNECTIONS(follower, followee) VALUES('foo', 'mike');
INSERT INTO CONNECTIONS(follower, followee) VALUES('bar', 'mike');
INSERT INTO CONNECTIONS(follower, followee) VALUES('joe', 'tom');
