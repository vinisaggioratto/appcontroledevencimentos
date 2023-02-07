use app_controle_vencimentos;
SELECT * FROM app_controle_vencimentos.perfil;

INSERT INTO PERFIL 
VALUES
(DEFAULT, 'gestor','Perfil com todos os acessos liberados.'),
(DEFAULT,'Operacional I','Perfil com todos os acessos liberados, menos a criação de usuários.'),
(DEFAULT,'Operacional II','Perfil sem acesso a cadastros. Somente lança as informações e consulta relatórios.');