insert into usuarios (user_name, user_password, enabled, nombre, apellidos, email) values ('robinare', 'abc123', 1, 'Robin', 'Arellano', 'robinare@gmail.com');
insert into usuarios (user_name, user_password, enabled, nombre, apellidos, email) values ('aregnitare', 'abc123', 1, 'Argenit', 'Arellano', 'argenitare@gmail.com');

insert into roles (role_name) values ('ROLE_ADMIN');
insert into roles (role_name) values ('ROLE_USER');

insert into usuarios_roles (usuario_id, role_id) values (1, 1);
insert into usuarios_roles (usuario_id, role_id) values (1, 2);
insert into usuarios_roles (usuario_id, role_id) values (2, 2);