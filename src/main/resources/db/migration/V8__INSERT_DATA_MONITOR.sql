-- ============================================================================
-- V8__insert_test_users.sql
-- Description: Insert test users for all required functionalities
-- ============================================================================

-- MONITOR user (password: password123) -
INSERT INTO users (name, lastname, mother_last_name, age, dni, phone_number, email, password, enabled, role_id)
VALUES
    ('Carlos', 'Monitor', 'Test', 45, '88888888', '988888888', 'monitor@test.com',
     '$2a$12$gBpsIP1vjx4scbpkKgh8w.LA2n0zOie4S86mSJ6D/ByjKdAInZOG2',
     TRUE, 4);

-- Usuarios
INSERT INTO users (name, lastname, mother_last_name, age, dni, phone_number, email, password, enabled, role_id)
VALUES
    ('Ana', 'Lopez', 'Martinez', 17, '77777777', '977777777', 'ana@test.com', NULL, TRUE, 1),
    ('Sofia', 'Ramirez', 'Diaz', 16, '55544444', '955544444', 'sofia@test.com', NULL, TRUE, 1),
    ('Lucia', 'Gomez', 'Flores', 15, '44455555', '944455555', 'lucia@test.com', NULL, TRUE, 1);

INSERT INTO users (name, lastname, mother_last_name, age, dni, phone_number, email, password, enabled, role_id)
VALUES
    ('Luis', 'Torres', 'Gomez', 22, '66666666', '966666666', 'luis@test.com', NULL, TRUE, 1),
    ('Miguel', 'Fernandez', 'Castro', 19, '44433333', '944433333', 'miguel@test.com', NULL, TRUE, 1),
    ('Rosa', 'Sanchez', 'Vargas', 27, '33322222', '933322222', 'rosa@test.com', NULL, TRUE, 1);
