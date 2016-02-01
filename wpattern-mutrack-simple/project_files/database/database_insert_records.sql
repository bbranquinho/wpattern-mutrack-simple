INSERT INTO `mutrack_simple`.`tb_user` (`id`, `name`, `email`, `password`) VALUES ('1', 'admin', 'admin@admin.com', 'admin');
INSERT INTO `mutrack_simple`.`tb_user` (`id`, `name`, `email`, `password`) VALUES ('2', 'user', 'user@user.com', 'user');

INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '1');
INSERT INTO `mutrack_simple`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('2', '2');
