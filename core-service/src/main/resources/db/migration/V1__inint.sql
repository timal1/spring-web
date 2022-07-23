create table if not exists categories (
    id                  bigserial primary key,
    title               varchar(255)
);

create table if not exists products (
    id                  bigserial primary key,
    title               varchar(255),
    price               numeric(8, 2) not null,
    category_id         bigint references categories (id),
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp

);

create table if not exists users (
    id                  bigserial primary key,
    username            varchar(50) not null ,
    password            varchar(255),
    email               varchar(50) unique,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

create table if not exists roles (
    id                  serial primary key,
    name                varchar(50) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

create table if not exists users_roles (
    user_id             bigint not null,
    role_id             int not null,
                        primary key (user_id, role_id)
);

create table orders (
    id                  bigserial primary key,
    username            varchar(255) not null,
    total_price         numeric(8, 2) not null,
    address             varchar(255),
    phone               varchar(255),
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

create table order_items (
    id                  bigserial primary key,
    product_id          bigint references products (id),
    order_id            bigint references orders (id),
    quantity            int,
    price_per_product   numeric(8, 2) not null,
    price               numeric(8, 2) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

insert into categories(title) values ('верхняя одежда'),
                                     ('легкая одежда'),
                                     ('нижняя одежда'),
                                     ('обувь'),
                                     ('головной убор'),
                                     ('аксессуары');

insert into products (title, price, category_id) values ('пальто', 200.00, 1), ('брюки', 50.00, 2),
                                           ('ботинки', 100.00, 4), ('куртка', 150.00, 1),
                                           ('рубашка', 40.00, 2), ('платье', 75.00, 2),
                                           ('туфли', 80.00, 4), ('носки', 5.00, 3),
                                           ('кофта', 35.00, 2), ('шарф', 10.00, 6),
                                           ('футболка', 20.00, 2), ('шапка', 25.00, 5),
                                           ('плащ', 170.00, 1), ('майка', 10.00, 3),
                                           ('перчатки', 15.00, 6), ('шорты', 20.00, 2),
                                           ('галстук', 10.00, 6), ('сапоги', 60.00, 4),
                                           ('юбка', 55.00, 2), ('блузка', 45.00, 2);

insert into users (username, password, email) values ('Maks', '$2a$12$bxsUv8diiUMbh6v9kteb4eU5wHDwfiZCinje0/lsumm3opjEzLqNO', 'max@gmail.com'),
--                                                              password 100
                                                     ('Ivan', '$2a$12$D09ANPAG9LHiY.Wz98ExLem.UV4a4CShTsjgMuKGLJE68cT36VKFK', 'ivan@gmail.com'),
--                                                              password 200
                                                     ('Anna', '$2a$12$2vd4Q0KOzW00offp1l/pueV2A1x5Q2FPqG3sn4kOx4pxrjKpOs9Pe', 'anna@gmail.com'),
--                                                              password 300
                                                     ('Egor', '$2a$12$8E2Ol6kZEtarGmx1.LXQ1ubb.uQ5/B7vtcmIJa8UsIA8.I/oZI/Ma', 'egor@gmail.com');
--                                                              password 400

insert into roles (name) values ('ROLE_SUPERADMIN'), ('ROLE_ADMIN'), ('ROLE_MANAGER'), ('ROLE_USER');

insert into users_roles (user_id, role_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4);







