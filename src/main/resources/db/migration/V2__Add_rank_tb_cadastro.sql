--Migration para adicionar a coluna de rank na tabela de cadastro

ALTER TABLE TB_CADASTRO
ADD COLUMN rank VARCHAR(255);