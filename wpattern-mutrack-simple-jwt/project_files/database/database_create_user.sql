/*
 * CREATE A NEW USER ON MySQL.
 */
CREATE USER 'wpattern'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'wpattern'@'localhost' WITH GRANT OPTION;

/*
 * Your MySQL service is bound to serve localhost only (interface binding).
 * This is the default for security reasons. If you really need to access it directly
 * from other hosts, there is a nice How to enable remote access to MySQL on Ubuntu
 * which you could follow: as root, open your /etc/mysql/my.cnf with your favorite
 * editor look for the [mysqld] section, and in there for the bind-address keyword.
 * This usually is set to 127.0.0.1 -- change that to match your "normal" IP-address
 * save the file, and reload the service (e.g. using service mysql restart).
 * Remember you must enable your remote users to access their database(s) from remote,
 * by setting the appropriate GRANTs -- e.g.
 * GRANT ALL ON mydb.* TO remoteuser@'%' IDENTIFIED BY 'SomePASSWORD';
 */
