SELECT * FROM app_controle_vencimentos.motorista_veiculo;

INSERT INTO motorista_veiculo (motorista_id,veiculo_id,data_inicial,ativo,usuario_id)
values
(1,1,'2020-01-01','Sim',1),
(2,2,'2021-03-01','Sim',1),
(3,3,'2022-05-01','Sim',1),
(4,4,'2020-10-15','Sim',1);

select 
mt.nome as Motorista,
vei.placa as Veículo
from motorista mt 
join motorista_veiculo mv on mv.motorista_id = mt.id
join veiculo vei on mv.veiculo_id = vei.id
-- where vei.id = 2