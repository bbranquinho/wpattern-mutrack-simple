-- Password: "admin".
INSERT INTO `mutrack_simple`.`tb_user` (`pk_id`, `name`, `email`, `password`) VALUES ('1', 'admin', 'admin@admin.com', '$2a$10$Dqm7/mMwCE6xkrHjp/fU8eThnTTGf/cMquAZG2xq/HXuN2gGwzT7y');
-- Password: "user".
INSERT INTO `mutrack_simple`.`tb_user` (`pk_id`, `name`, `email`, `password`) VALUES ('2', 'user', 'user@user.com', '$2a$10$ODVok0lPgmhjQeqwQX484ODMfDTNbbdq5PV0Mj9AlRLikemd0bMdq');

INSERT INTO `mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('1', 'Sensor de Temperatura', 'RE736868622SE', 'Compra realizada na Aliexpress.', '2015-05-28', '1');
INSERT INTO `mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('2', 'Livro Angularjs', 'DM567434841BR', 'Enviada pela submarino.', '2015-05-21', '2');
INSERT INTO `mutrack_simple`.`tb_package` (`pk_id`, `name`, `code`, `description`, `register_date`, `owner_id`) VALUES ('3', 'Arduino Leonardo', 'RJ367374538CN', 'Compra da DX', '2015-04-01', '1');

INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '1');
INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '2');
