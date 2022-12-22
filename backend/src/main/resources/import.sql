INSERT INTO tb_conta (nome_responsavel) VALUES ('FULANO');
INSERT INTO tb_conta (nome_responsavel) VALUES ('Silva');
INSERT INTO tb_conta (nome_responsavel) VALUES ('Luno');


INSERT INTO tb_transferencia (DATA_TRANSFERENCIA,NOME_OPERADOR_TRANSACAO,TIPO,VALOR) VALUES ('2020-07-13','Junior','SAQUE',-350.00)
INSERT INTO tb_transferencia (DATA_TRANSFERENCIA,NOME_OPERADOR_TRANSACAO,TIPO,VALOR) VALUES ('2020-07-14','Silva','DEPOSITO',350.00)
INSERT INTO tb_transferencia (DATA_TRANSFERENCIA,NOME_OPERADOR_TRANSACAO,TIPO,VALOR) VALUES ('2020-07-15','MAGO','SAQUE',750.00)


INSERT INTO tb_movimentos_conta (transferencia_id, conta_id) VALUES (1, 1);
INSERT INTO tb_movimentos_conta (transferencia_id, conta_id) VALUES (2, 2);
INSERT INTO tb_movimentos_conta (transferencia_id, conta_id) VALUES (3, 3);
INSERT INTO tb_movimentos_conta (transferencia_id, conta_id) VALUES (1, 2);