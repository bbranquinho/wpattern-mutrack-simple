-- Password: "admin".
INSERT INTO `mutrack_simple`.`tb_user` (`pk_id`, `name`, `email`, `password`) VALUES ('1', 'Admin', 'admin@admin.com', '9fe76e18dd29100230680fa6c812e26c4da4b3cf48a85850910e6f4400a6b3ff9ec05190c175f592');
-- Password: "user".
INSERT INTO `mutrack_simple`.`tb_user` (`pk_id`, `name`, `email`, `password`) VALUES ('2', 'User', 'user@user.com', '4a6e2c62e383f9c944f112388e5917caea81cecfef06cd2aa3af12d82f2dbe97ad56ea6934366ad3');

INSERT INTO `mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('1', 'Sensor de Temperatura', 'RE736868622SE', 'Compra realizada na Aliexpress.', '2015-05-28', '1');
INSERT INTO `mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('2', 'Livro Angularjs', 'DM567434841BR', 'Enviada pela submarino.', '2015-05-21', '2');
INSERT INTO `mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('3', 'Arduino Leonardo', 'RJ367374538CN', 'Compra da DX', '2015-04-01', '1');

INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '1');
INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '2');
