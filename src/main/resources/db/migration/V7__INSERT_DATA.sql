-- ============================================================================
-- V7__INSERT_DATA.sql
-- Description: Insert initial seed data for development and testing
-- ============================================================================

-- Insert admin user with hashed password (admin123)
INSERT INTO users (name, lastname, mother_last_name, age, dni, phone_number, email, password, enabled, role_id)
VALUES
    ('Admin', 'User', 'System', 40, '99999999', '999999999', 'admin@hexagonal-demo.com',
     '$2a$12$gBpsIP1vjx4scbpkKgh8w.LA2n0zOie4S86mSJ6D/ByjKdAInZOG2',
     TRUE, 2);

-- Insert sample users with USER role
INSERT INTO users (name, lastname, mother_last_name, age, dni, phone_number, email, password, enabled, role_id)
VALUES
    ('David', 'Galvez', 'Perez', 28, '11111111', '999111111', 'david.galvez@example.com', NULL, TRUE, 1),
    ('Rocio', 'Chavez', 'Lopez', 32, '22222222', '999222222', 'rocio.chavez@example.com', NULL, TRUE, 1),
    ('Pedro', 'Acosta', 'Martinez', 25, '33333333', '999333333', 'pedro.acosta@example.com', NULL, TRUE, 1),
    ('Marisol', 'Ugarte', 'Torres', 29, '44444444', '999444444', 'marisol.ugarte@example.com', NULL, TRUE, 1),
    ('Juan', 'Diaz', 'Garcia', 35, '55555555', '999555555', 'juan.diaz@example.com', NULL, TRUE, 1);